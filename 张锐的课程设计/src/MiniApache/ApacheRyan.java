package MiniApache;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

//import MiniApache.Browsebase;
import MiniApache.getHtmlName;
@SuppressWarnings("serial")
public class ApacheRyan extends JFrame{
	private JMenuBar menuBar;
	private JButton controlButton;
	private JTextArea displayWindow;
	private JLabel statusBar;
	public ApacheRyan(){
		setPreferredSize(new Dimension(600,480));
		setBounds(200,100,600,480);
		setTitle("迷你服务器");
		setLayout(new BorderLayout(5,5));
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/**************************************************************/
		GridLayout gridLayout=new GridLayout(2,1);
		gridLayout.setVgap(5);
		JPanel topPanel=new JPanel(gridLayout);
		menuBar=new JMenuBar();
		topPanel.add(menuBar);
		/**************************************************************/
		JMenu fileMenu=new JMenu("文件");
		JMenuItem saveHistory=new JMenuItem("保存历史记录");
		saveHistory.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				statusBar.setText("保存历史记录");
				ServerNetworkTool.saveHistory();
				statusBar.setText("保存完毕");
			}
		});
		fileMenu.add(saveHistory);
		menuBar.add(fileMenu);
		/**************************************************************/
		JMenu htmlMenu = new JMenu("Html");
		JMenuItem creatNewHtml = new JMenuItem("创建新文档");
		creatNewHtml.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				//create html
				String newHtmlName ="";
				getHtmlName ghn = new getHtmlName();
				//relocation the frame
				ghn.setLocation(500, 300);
				ghn.setLocation_x(400);
				ghn.setLocation_y(200);				
				ghn.show();
				
				//getHtmlName.dispose();	
				
			}
		
		});
		
		htmlMenu.add(creatNewHtml);
		menuBar.add(htmlMenu);
		/***************************************************************/
		JMenu helpMenu=new JMenu("帮助");
		JMenuItem about=new JMenuItem("关于");
		about.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				JDialog aboutDialog=new JDialog(ApacheRyan.this,"关于");
				aboutDialog.setVisible(true);
				aboutDialog.setBounds( ApacheRyan.this.getX()
						+ApacheRyan.this.getWidth()/2-aboutDialog.getWidth()/2,
						ApacheRyan.this.getY()+ApacheRyan.this.getHeight()/3
						-aboutDialog.getHeight()/2,80,80);
				aboutDialog.setLayout(new FlowLayout());
				JLabel label=new JLabel("java迷你服务器");
				aboutDialog.add(label);
			}
		});
		helpMenu.add(about);
		menuBar.add(helpMenu);
		/**************************************************************/
		JPanel buttonPanel=new JPanel(new BorderLayout());
		controlButton=new JButton("start");
		controlButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(e.getActionCommand().equals("start")){
					if(ServerNetworkTool.startServer()){
						statusBar.setText("启动服务器");
						controlButton.setActionCommand("stop");
						controlButton.setText("stop");
					}
				}else{
					ServerNetworkTool.stopServer();
					statusBar.setText("关闭服务器");
					controlButton.setActionCommand("start");
					controlButton.setText("start");
				}
			}
		});
		buttonPanel.add(controlButton,BorderLayout.EAST);
		topPanel.add(buttonPanel);
		add(topPanel,BorderLayout.NORTH);
		/**************************************************************/
		JScrollPane scrollPane=new JScrollPane();
		displayWindow=new JTextArea();
		displayWindow.setEditable(false);
		scrollPane.setViewportView(displayWindow);
		ServerNetworkTool.setHistory(displayWindow);
		add(scrollPane,BorderLayout.CENTER);
		/**************************************************************/
		statusBar=new JLabel();
		add(statusBar,BorderLayout.SOUTH);
		/**************************************************************/
	}
	public static void main(String[] args){
		new ApacheRyan();
	}

}
