package MiniIE;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.io.*;
import javax.swing.*;
import MiniIE.ClientNetworkTool;
@SuppressWarnings("serial")
public class ReadHtmlPanel extends JPanel{
	private String head;
	private String content;
	private Status HTMLStatus=new Status();
	public ReadHtmlPanel(){
		head="";
		setBackground(Color.WHITE);
		setLayout(null);
	}
	public ReadHtmlPanel(String webAddress){
		this();
		setPage(webAddress);
	}
	public void setPage(String webAddress){
		ClientNetworkTool cnt=new ClientNetworkTool(webAddress);
		String localFile=cnt.getHTMLFile();
		displayHTML(localFile);
	}
	private void displayHTML(String localFile){
		File HTMLfile=new File(localFile);
		/*************加载文件到内存中**************************************************/
		StringBuffer buf=null;
	    BufferedReader fileReader=null;
	    try{
	    	fileReader=new BufferedReader(
	        		 new InputStreamReader(
	        				 new FileInputStream((HTMLfile))));
	        buf=new StringBuffer();
	        while(fileReader.ready()){
	        	buf.append((char)fileReader.read());
	        }
	        fileReader.close();
	    }catch(Exception e){
	        e.printStackTrace();
	    }
	    content=buf.toString();
	    /*************解析文件*********************************************************/
	    int contentLength=content.length();
		int index=0;
		while(index<contentLength){
			char a=content.charAt(index++);
			if(a=='<'){
				String keywordtemp="<";
				do{
					a=content.charAt(index++);
					keywordtemp+=a;
				}while(a!='>');
				index=readToPanel(keywordtemp,index);
			}
		}
	}
	private int readToPanel(String keyWordTemp,int index){
		String keyword="";
		int j=1;
		char charInKeyWord;
		charInKeyWord=keyWordTemp.charAt(j);
		while(charInKeyWord!=' '&&charInKeyWord!='>'){
			keyword+=charInKeyWord;
			charInKeyWord=keyWordTemp.charAt(++j);			
		}
		if(keyword.equals("居中对齐")){
			HTMLStatus.location="center";
			return index;
		}else if(keyword.equals("/居中对齐")){
			HTMLStatus.location="null";
			return index;
		}else if(keyword.equals("标题")){
			char headChar;
			while((headChar=content.charAt(index++))!='<')
				head+=headChar;
			return index;
		}else if(keyword.equals("标签")){
			LabelSet labelSet=new LabelSet();
			String text="";
			char temp2;
			if(charInKeyWord==' '){
				while((charInKeyWord=keyWordTemp.charAt(j++))!='>')
					text+=charInKeyWord;
				text+=charInKeyWord;
				labelSet.readSet(text);
				text="";
			}
			while((temp2=content.charAt(index++))!='<')
				text+=temp2;
			labelSet.displayLabel(text);
			return index-1;
		}else{
			return index;
		}
	}
	public String getHead(){
		return head;
	}
	private class LabelSet{
		private int x;
		private int y;
		private String color;
		private int fontSize;
		public LabelSet(){
			fontSize=10;
		}
		public void readSet(String text){
			char a;
			String temp="";
			String attr="";
			int index=0;
			a=text.charAt(index);
			while(a!='>'){
				a=text.charAt(index++);
				if(a=='='){
					char b;
					while((b=text.charAt(index++))==' ');
					while(b!=' '&&b!='>'){
						attr+=b;
						b=text.charAt(index++);						
					}
					if(b=='>')
						index--;
					if(temp.equals("字号")){
						fontSize=Integer.parseInt(attr);
						temp="";
						attr="";
						a=text.charAt(index);
					}else if(temp.equals("颜色")){
						color=attr;
						temp="";	
						attr="";
						a=text.charAt(index);
					}else if(temp.equals("位置x")){
						x=Integer.parseInt(attr);
						temp="";	
						attr="";
						a=text.charAt(index);
					}else if(temp.equals("位置y")){
						y=Integer.parseInt(attr);
						temp="";	
						attr="";
						a=text.charAt(index);
					}else{}
				}else if(a!=' '){
					temp+=a;
				}
			}
		}
		public void displayLabel(String text){
			JLabel label=new JLabel(text);
			label.setFont(new Font("宋体",Font.PLAIN,fontSize));
			if(color.equals("red"));
				label.setForeground(Color.RED);
			label.setAlignmentY(Component.TOP_ALIGNMENT);
			label.setAlignmentX(Component.CENTER_ALIGNMENT);
			label.setPreferredSize(new Dimension(100, 100));
			if(HTMLStatus.location.equals("center"))
			{
				int width=text.length()*fontSize/20*25;
				int heigth=fontSize/20*25;			
				label.setBounds(x,y,x+width,y+heigth);
			}
			add(label);
		}
	}
	private class Status{
		public String location="null";
	}
}