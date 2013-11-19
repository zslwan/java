package MiniIE;
import java.net.*;
import java.io.*;
public class ClientNetworkTool{
	private final int PORT=8080;
	private Socket socket;
	private DataInputStream in;
	private DataOutputStream out;
	private String fileAddress;
	private String webAddress;
	public ClientNetworkTool(String webAddress){
		System.out.println("client start:");
		fileAddress="./webs/unfind/unfind.html";
		InetAddress address=addressAnalysis(webAddress);
		this.webAddress=webAddress;
		if(address!=null){
			try{
				socket=new Socket(address,PORT);
				try{
					in=new DataInputStream(socket.getInputStream());
					out=new DataOutputStream(socket.getOutputStream());
				}catch(IOException e1){
					System.err.println("IO failed");
					try{
						socket.close();
					}catch(IOException e2){
						System.err.println("socket not closed");
					}
				}
				storeData();
			}catch(IOException e){
				System.err.println("socket failed");
			}
		}
	}
	private void storeData(){
		try{
			out.writeUTF("start");
			InetAddress addr = InetAddress.getLocalHost();
			out.writeUTF(addr.getHostAddress().toString());
			String fileName=webAddress.substring(10);
			System.out.println(fileName);
			out.writeUTF(fileName);
			String status=in.readUTF();
			if(status.equals("yes")){
				String filePath=".\\webs\\"+fileName;
				File folder=new File(filePath);
				folder.mkdirs();
				fileAddress=filePath+"\\"+fileName+".html";
				File HTMLFile=new File(fileAddress);
				RandomAccessFile raf = new RandomAccessFile(HTMLFile,"rw");	
				byte[] buf=new byte[2048];
				DataInputStream fin=new DataInputStream(
						new BufferedInputStream(
								socket.getInputStream()));
				int num=fin.read(buf);
				while(num!=(-1)){
					raf.write(buf,0,num);
					raf.skipBytes(num);
					if(num<2048)
					{
						break;
					}
					num=fin.read(buf);
				}
				raf.close();
				out.writeUTF("end");
			}else{
				fileAddress="./webs/unfind/unfind.html";
			}	
		}catch(IOException e){
			System.err.println("err in ConnectSever.run");
		}
	}
	public String getHTMLFile(){
		return fileAddress;
	}
	private InetAddress addressAnalysis(String addr){
		InetAddress address=null;
		if(addr.startsWith("092.0.0.1/")){
			try{
				address=InetAddress.getByName(null);
			}catch (UnknownHostException e) {
				e.printStackTrace();
			}
		}
		return address;
	}
}