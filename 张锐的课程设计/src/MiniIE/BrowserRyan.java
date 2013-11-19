package MiniIE;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JToolBar;


//import miniIE.HTMLAnalysisPanel;
//import miniIE.MiniIEGUI.BookMarkListener;

import MiniIE.ReadHtmlPanel;


//import miniIE.HTMLAnalysisPanel;

//import MiniIE.ReadHtmlsPanel;




 public class BrowserRyan extends JFrame {
	    private JButton gobutton;
		private JButton backbutton;
		private JButton refresh;
		private JButton home;
		private JButton enter;
		private JLabel label1;
		private JTextField address;
		private JToolBar mytoolbar;
		private JPanel panel1;
		private JPanel panel2;
		private JTabbedPane tabbedpane;
		private JLabel status;
		
	 public static void main(String[] args) {
			
		 new BrowserRyan();
		

	}
	
	public BrowserRyan(){
		setTitle("迷你浏览器");
		setPreferredSize(new Dimension(600,600));
		setBounds(200,50,600,480);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		//--------------------------------------------------------------------------------------------------
		//panel1中的各种按钮
		//--------------------------------------------------------------------------------------------------
		panel1 = new JPanel();
		panel1.setPreferredSize(new Dimension(600,100));
		//*******************后退按钮*****************************************************
				backbutton = new JButton(new ImageIcon(".\\image\\back.jpg"));
				backbutton.setPreferredSize(new Dimension(30, 30));
				backbutton.addActionListener(new ActionListener(){
					
					public void actionPerformed(ActionEvent e){
						status.setText("后退");
						
						
					}
					
					
					
				});
				
		//*******************前进按钮****************************************************
		gobutton = new JButton(new ImageIcon(".\\image\\go.jpg"));
		gobutton.setPreferredSize(new Dimension(30, 30));
		gobutton.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e){
				status.setText("前进");
				
				
			}
			
			
			
		});
		
		//*******************刷新按钮*******************************************************
		refresh = new JButton(new ImageIcon(".\\image\\refresh.jpg"));
		refresh.setPreferredSize(new Dimension(30, 30));
		refresh.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent arg0) {
				status.setText("刷新");
				ReadHtmlPanel panel=(ReadHtmlPanel)tabbedpane.getSelectedComponent();
				panel.removeAll();
				panel.setPage(address.getText());
				panel.updateUI();
			}
		});
		//********************主页按钮*******************************************************
		home = new JButton(new ImageIcon(".\\image\\home.jpg"));
		home.setPreferredSize(new Dimension(30, 30));
		home.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				status.setText("转到主页");
                ReadHtmlPanel panel=new ReadHtmlPanel(address.getText());
				tabbedpane.addTab(panel.getHead(),panel);
				tabbedpane.setSelectedIndex(tabbedpane.getSelectedIndex()+1);
				
			}
		});
		//*********************标签URL*******************************************************
		label1 = new JLabel("URL");
		label1.setPreferredSize(new Dimension(30, 30));
		address = new JTextField(32);
		address.addActionListener(new ActionListener(){

			
			public void actionPerformed(ActionEvent e) {
		
				ReadHtmlPanel panel=new ReadHtmlPanel(address.getText());
				tabbedpane.addTab(panel.getHead(),panel);
				tabbedpane.setSelectedIndex(tabbedpane.getSelectedIndex()+1);
			}
			
		});
		
		//*********************转到按钮******************************************************
	    enter = new JButton(new ImageIcon(".\\image\\enter.jpg"));
		enter.setPreferredSize(new Dimension(30, 30));
		enter.addActionListener(new ActionListener(){

			
			public void actionPerformed(ActionEvent e) {
				status.setText("打开网页");
				ReadHtmlPanel panel=new ReadHtmlPanel(address.getText());
				tabbedpane.addTab(panel.getHead(),panel);
				tabbedpane.setSelectedIndex(tabbedpane.getSelectedIndex()+1);
				
			}
			
		
		});
		//*********************将各个按钮加到panel1中*****************************************

		panel1.add(backbutton);
		panel1.add(gobutton);
		panel1.add(refresh);
		panel1.add(home);
		panel1.add(label1);
		panel1.add(address);
		panel1.add(enter);
		add(panel1,BorderLayout.NORTH);
		//----------------------------------------------------------------------------------------
		//panel2中的各种按钮
		//--------------------------------------------------------------------------------------
		panel2 = new JPanel();
		panel2.setLayout(new FlowLayout());
		
		//********************打开新的选项卡***************************************************
		
		JButton open = new JButton("打开新的选项卡");
		open.setPreferredSize(new Dimension(120, 40));
		open.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				address.setText("about:blank");
				tabbedpane.addTab("空白网页"+(tabbedpane.getSelectedIndex()+1),new ReadHtmlPanel());
				tabbedpane.setSelectedIndex(tabbedpane.getSelectedIndex()+1);
				status.setText("打开新的选项卡");
			}
		});
		//********************关闭选项卡***************************************************
		JButton close = new JButton("关闭选项卡");
		close.setPreferredSize(new Dimension(120, 40));
		close.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				status.setText("关闭当前选项卡");
				int index=tabbedpane.getSelectedIndex();
				if(tabbedpane.getTabCount()!=1)
					tabbedpane.remove(index);
				else
					System.exit(0);
			}
		});
		
			
		//********************收藏网页***************************************************
	
		JButton store = new JButton("收藏");
		store.setPreferredSize(new Dimension(60, 40));
		store.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				status.setText("收藏此网页");
				File floder=new File(".\\config");
				floder.mkdirs();
				File bookmark=new File(".\\config\\bookmarks.cfg");
				try{
					PrintWriter pw=new PrintWriter(
							new BufferedWriter(
									new FileWriter(bookmark,true)));
					String text=tabbedpane.getTitleAt(tabbedpane.getSelectedIndex());
					String webAddress=address.getText();
					JButton button=new JButton(text);
					button.addActionListener(new BookMarkListener(webAddress));
					mytoolbar.add(button);
					pw.append(webAddress);
					pw.append(text+"\n");
					pw.close();
				}catch(IOException e1){
					e1.printStackTrace();
				}
			}
		});
		//*************************设置成主页******************************************************
		JButton setHome = new JButton("设置成主页");
		setHome.setPreferredSize(new Dimension(60,40));
		setHome.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				status.setText("将当前网页设置成主页");
				File floder=new File(".\\config");
				floder.mkdirs();
				File bookmark=new File(".\\config\\home.cfg");
				try{
					PrintWriter pw=new PrintWriter(
							new BufferedWriter(
									new FileWriter(bookmark)));
					String webAddress=address.getText();
					ActionListener[] homeAL=home.getActionListeners();
					if(homeAL.length>0)
						home.removeActionListener(homeAL[0]);
					home.addActionListener(new BookMarkListener(webAddress));
					pw.append(webAddress+"\n");
					pw.close();
				}catch(IOException e1){
					e1.printStackTrace();
				}
			}
		});
		//**************************将各个按钮加到Panel2中**************************************************
		mytoolbar = new JToolBar();
		mytoolbar.setPreferredSize(new Dimension(580,40));
		mytoolbar.setFloatable(false);
			
		mytoolbar.add(open);
		mytoolbar.add(close);
		mytoolbar.add(store);
		mytoolbar.add(setHome);
		panel2.add(mytoolbar);
		panel1.add(panel2);
		//--------------------------------------------------------------------
		//首先新建一个显示界面
		//--------------------------------------------------------------------
		tabbedpane = new JTabbedPane(JTabbedPane.TOP);
		ReadHtmlPanel panel=new ReadHtmlPanel();
		tabbedpane.addTab("welcome", panel);
		add(tabbedpane,BorderLayout.CENTER);
		
		pack();
		setVisible(true);
		//----------------------------------------------------------------------------
		//浏览器的状态栏
		//--------------------------------------------------------------------------
		status = new JLabel("status");
		add(status,BorderLayout.SOUTH);
		//----------------------------------------------------------------------------
		//
		//--------------------------------------------------------------------------
		readConfigFile("bookmarks.cfg",mytoolbar);
		readConfigFile("home.cfg",panel2);
	}
	private boolean readConfigFile(String fileName,JComponent component){
		boolean b=true;
		File bookmark=new File(".\\config\\"+fileName);
		if(bookmark.exists()){
			try{
				BufferedReader configReader=new BufferedReader(
						new FileReader(bookmark));
				try{
					String s;
					while((s=configReader.readLine())!=null){
						Scanner scan=new Scanner(s);
						String webAddress=scan.next();
						JButton button;
						if(!scan.hasNext()){
							button=home;
							ReadHtmlPanel panel=(ReadHtmlPanel)tabbedpane.getSelectedComponent();
							address.setText(webAddress);
							panel.setPage(webAddress);
							tabbedpane.setTitleAt(0,panel.getHead());
						}else{
							String text=scan.next();
							button=new JButton(text);
							component.add(button);
						}
						button.addActionListener(new BookMarkListener(webAddress));
				    }
				}catch(IOException e){
					b=false;
					e.printStackTrace();
				}
				configReader.close();
			}catch(FileNotFoundException e){
				b=false;
				e.printStackTrace();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		return b;
	}
	private class BookMarkListener implements ActionListener{
		private String webAddress;
		public BookMarkListener(String webAddress){
			this.webAddress=webAddress;
		}
		public void actionPerformed(ActionEvent e){
			ReadHtmlPanel panel=new ReadHtmlPanel(webAddress);
			address.setText(webAddress);
			tabbedpane.addTab(panel.getHead(),panel);
			tabbedpane.setSelectedIndex(tabbedpane.getSelectedIndex()+1);
		}
	}}	
	
	
	


