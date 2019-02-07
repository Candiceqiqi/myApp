package 第一部分图形界面分析;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class Back extends JFrame  {

	
	 private JPanel jpl;
	   
	 public Back() {
		 Image image=new ImageIcon("images/background.jpg").getImage();
		 BackgroundPanel bkp=new BackgroundPanel(image);
		 
		 this.add(bkp);
		 this.setSize(300,350);
		 this.setVisible(true);
	 }
	 public static void main(String[] args) {
		
		 new Back();
	}
	 

	
}
