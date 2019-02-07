package 第一部分图形界面分析;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class QQFileChooser extends JFrame {

	private JTextField jtf;
	private JList jlt;  //下拉列表
	private JButton jb,jb1;
	private JPanel jp;
	private JScrollPane jsp;  //带滚动条的面板
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public QQFileChooser() {
		

		jtf=new JTextField(10);
		jlt=new JList();
		//jList需要设置setModel方法，以方便往其中添加数据
		jlt.setModel(new javax.swing.AbstractListModel() {
			String[] strings={""};
            
			@Override
			public Object getElementAt(int i) {
				// TODO Auto-generated method stub
				return strings[i];
			}

			@Override
			public int getSize() {
				// TODO Auto-generated method stub
				return strings.length;
			}
			
			
		});
		jsp=new JScrollPane();  //初始化滚动面板
		
		jsp.setViewportView(jlt);  //把Jlist放入滚动面板
		
		jb=new JButton("发送");
		jb1=new JButton("选择文件");
		
		
		//加入事件的处理
	    jb1.addMouseListener(new MouseAdapter() {
	    	
	    	public void mouseClicked(MouseEvent e) {
	    		
	    		JFileChooser fileChooser = new JFileChooser();
	    		int a = fileChooser.showOpenDialog(null);
	    		if (a == JFileChooser.APPROVE_OPTION) {
	    			
	    			JOptionPane.showMessageDialog(null, "正在上传...");
	    			JOptionPane.showMessageDialog(null, "ok,传输完毕");
	    		}
	    		
	    	}
	    });
		
		jp=new JPanel();
		
		jp.add(jtf);     //组件放入面板
		jp.add(jb);
		jp.add(jb1);	
		this.add(jlt,"Center");
		this.add(jp,"South");
		this.setIconImage(new ImageIcon("images/qq.gif").getImage());
		this.setSize(300,200);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	    
	}
	
	public static void main(String[] args) {
		
		new QQFileChooser();
	}
	  
}
