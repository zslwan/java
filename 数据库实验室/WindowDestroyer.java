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
		System.exit(0);//如果1被改成其他数字，当再按退出按钮时将出现错误，导致不能退出。

	}

}
