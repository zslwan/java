package MiniApache;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/*********************************************************/
//			2012-4-7 tangke @SDU tangkejob@gmail.com      /
/*********************************************************/
public class getHtmlName extends JFrame {

	private JPanel contentPane;
	private JTextField textName;
	private String htmlName;
	private int location_x;
	private int location_y;		
	private JFrame selfFrame;
	public JFrame getSelfFrame() {
		return selfFrame;
	}

	public void setSelfFrame(JFrame selfFrame) {
		this.selfFrame = selfFrame;
	}

	public int getLocation_x() {
		return location_x;
	}

	public void setLocation_x(int location_x) {
		this.location_x = location_x;
	}

	public int getLocation_y() {
		return location_y;
	}

	public void setLocation_y(int location_y) {
		this.location_y = location_y;
	}

	public String getHtmlName() {
		return htmlName;
	}

	public void setHtmlName(String htmlName) {
		this.htmlName = htmlName;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					getHtmlName frame = new getHtmlName();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public getHtmlName() {
		setSelfFrame(this);
		setLocation(new Point(200, 500));
		setPreferredSize(new Dimension(600, 400));
		setTitle("新建文档");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 200, 100);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setBounds(10, 10, 54, 15);
		panel.add(lblNewLabel);
		
		textName = new JTextField();
		textName.setText("new html1");
		textName.setBounds(70, 4, 102, 21);
		panel.add(textName);
		textName.setColumns(10);
		
		JButton btnConfirm = new JButton("confirm");
		btnConfirm.setFont(new Font("宋体", Font.PLAIN, 11));
		btnConfirm.setBounds(10, 38, 77, 25);
		panel.add(btnConfirm);
		
		JButton btnCancel = new JButton("cancel");
		btnCancel.setFont(new Font("宋体", Font.PLAIN, 11));
		btnCancel.setBounds(99, 38, 73, 25);
		panel.add(btnCancel);
		
		//for confirm 
		ActionListener alConfirm;
		alConfirm = new ActionListener()
			{
				public void actionPerformed(ActionEvent ae)
				{
					//create html
					if(!textName.getText().equals("")){
						setHtmlName(textName.getText());
					}else{

						setEnabled(false);
					}
					//getHtmlName.dispose();	
				}
			};
			btnConfirm.addActionListener(alConfirm);			
	}
}
