import java.awt.*;

import javax.swing.*;
public class CenterFrameTest  {
	   public static void main(String[] args)   {  
		      CenteredFrame frame = new CenteredFrame();
		      frame.setBackground(Color.RED);
//		     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);���Ӵξ䣬���˳���ť��������ȫ�˳����ں�̨�����п��Կ��������Ϻ�����ȫ�˳���
		      frame.setVisible(true);  
		   }
		}

class CenteredFrame extends JFrame{
	public CenteredFrame(){
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		
		setSize(screenWidth/4,screenHeight/4);
		setLocation(screenWidth/4,screenHeight/4);
		
		setTitle("centerFrame");
		
		
	}
}
