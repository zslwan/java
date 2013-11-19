package MiniApache;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.*;

import javax.swing.JTextArea;
public abstract class ServerNetworkTool extends Thread{
	private static final int PORT=8080;
	private static boolean serverStatus;
	private static ServerSocket serverSocket;
	private static JTextArea history;
	public static boolean startServer(){
		serverStatus=true;
		try{
			serverSocket=new ServerSocket(PORT);
			Accepter accepter=new Accepter();
			accepter.start();
		}catch(IOException e){
			history.append(getTime()+"     服务器启动失败\n\n");
			return false;
		}
		history.append(getTime()+"    启动服务器\n");
		return true;
	}
	public static void stopServer(){
		serverStatus=false;
		try{
			serverSocket.close();
		}catch(Exception e){
		}
		history.append(getTime()+"    关闭服务器\n");
	}
	public static void saveHistory(){
		File floder=new File(".\\data");
		if(!floder.exists())
			floder.mkdirs();
		Date date =new Date();
		SimpleDateFormat sdf =new SimpleDateFormat("yyyyMMdd_HH_mm_ss");
		try{
			PrintWriter historyWriter=new PrintWriter(".\\data\\"+sdf.format(date));
			historyWriter.append(history.getText());
			historyWriter.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	public static void setHistory(JTextArea history){
		ServerNetworkTool.history=history;
	}
	private static class Accepter extends Thread{
		public void run(){
			while(serverStatus){
				try{
					Socket socket=serverSocket.accept();
					new ServerStart(socket).start();
				}catch(IOException e){
					System.out.println("serverSocket stop");
				}
				System.out.println("socket accept");
			}
			try{
				serverSocket.close();
			}catch(IOException e) {
			} 
		}
		private class ServerStart extends Thread{
			private Socket socket;
			public ServerStart(Socket socket){
				this.socket=socket;
			}
			public void run(){
				try{
					DataInputStream in=new DataInputStream(socket.getInputStream());
					DataOutputStream out=new DataOutputStream(socket.getOutputStream());
					System.out.println("Apache Start");
					String start=in.readUTF();
					System.out.println(start);
					String clientIP=in.readUTF();
					history.append(getTime()+"\n");
					history.append("客户端IP："+clientIP+"\n");
					String fileName=in.readUTF();
					String filePath=".\\webs1\\"+fileName+"\\"+fileName+".html";
					File file=new File(filePath);
					history.append(getTime()+"\n");
					history.append("("+clientIP+")     ");
					if(file.exists()){
						history.append("传输文件："+filePath+"\n");
						out.writeUTF("yes");
						FileInputStream fos=new FileInputStream(filePath);
						OutputStream netOut=socket.getOutputStream();
						OutputStream doc=new DataOutputStream(new BufferedOutputStream(netOut));
						byte[] buf=new byte[2048];
						int num=fos.read(buf);
						while(num!=(-1)){
							doc.write(buf,0,num);
							doc.flush();
							num=fos.read(buf);
						}
						fos.close();
						String end=in.readUTF();
						System.out.println(end);
						history.append(getTime()+"\n");
						history.append("("+clientIP+")     ");
						history.append("传输完毕\n\n");
					}else{
						history.append("访问文件不存在\n\n");
						out.writeUTF("no");
					}
				}catch(IOException e) {
					e.printStackTrace();
				}finally{
					try{ 
						socket.close();
				    }catch(IOException e){
				        System.err.println("Socket not closed");
				    }
				}
			}	
		}
	}
	private static String getTime(){
		Date date =new Date();
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=sdf.format(date); 
		return time;
	}
}