package 第一部分图形界面分析;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class BackgroundPanel extends JPanel {

	 private Image image=null;
	 
	 public BackgroundPanel(Image image) {
		 
		 this.image=image;
	 }
	 public void paintComponent(Graphics g) {
		 
		 g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
	 }
	 
}
