import javax.swing.*;

import WindowDestroyer.WindowDestroyer;
public class window {

	/**
	 * @param args
	 */
	
		// TODO Auto-generated method stub
		
	
		
		  public static final int WIDTH = 300;
		  public static final int HEIGHT = 200;

		  public static void main(String[] args)
		  {
		    JFrame myWindow = new JFrame();
		    myWindow.setSize(WIDTH, HEIGHT);
		    JLabel myLabel = new JLabel("Please don¡¯t¡­");
		    myWindow.add(myLabel);
		    myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    WindowDestroyer myListener = new WindowDestroyer();
		    myWindow.addWindowListener(myListener);
		    myWindow.setVisible(true);
		  }
		}


	


