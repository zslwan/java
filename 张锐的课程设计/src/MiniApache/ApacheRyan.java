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
		setTitle("���������");
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
		JMenu fileMenu=new JMenu("�ļ�");
		JMenuItem saveHistory=new JMenuItem("������ʷ��¼");
		saveHistory.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				statusBar.setText("������ʷ��¼");
				ServerNetworkTool.saveHistory();
				statusBar.setText("�������");
			}
		});
		fileMenu.add(saveHistory);
		menuBar.add(fileMenu);
		/**************************************************************/
		JMenu htmlMenu = new JMenu("Html");
		JMenuItem creatNewHtml = new JMenuItem("�������ĵ�");
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
		JMenu helpMenu=new JMenu("����");
		JMenuItem about=new JMenuItem("����");
		about.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				JDialog aboutDialog=new JDialog(ApacheRyan.this,"����");
				aboutDialog.setVisible(true);
				aboutDialog.setBounds( ApacheRyan.this.getX()
						+ApacheRyan.this.getWidth()/2-aboutDialog.getWidth()/2,
						ApacheRyan.this.getY()+ApacheRyan.this.getHeight()/3
						-aboutDialog.getHeight()/2,80,80);
				aboutDialog.setLayout(new FlowLayout());
				JLabel label=new JLabel("java���������");
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
						statusBar.setText("����������");
						controlButton.setActionCommand("stop");
						controlButton.setText("stop");
					}
				}else{
					ServerNetworkTool.stopServer();
					statusBar.setText("�رշ�����");
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
