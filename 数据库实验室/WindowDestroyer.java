package WindowDestroyer;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;
public class WindowDestroyer extends WindowAdapter {

	/**
	 * @param args
	 */
	public  void windowClosing(WindowEvent e) {
		System.exit(0);//���1���ĳ��������֣����ٰ��˳���ťʱ�����ִ��󣬵��²����˳���

	}

}
