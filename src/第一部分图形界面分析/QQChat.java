package 第一部分图形界面分析;

import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.AbstractListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;

public class QQChat extends JFrame {

	private JTextField jtf;
	private JList jlt;  //下拉列表 JTextArea
	private JButton jb;
	private JPanel jp;
	private JScrollPane jsp;  //带滚动条的面板
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public QQChat() {
		

		jtf=new JTextField(15);
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
		
		//加入事件的处理
		jb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				  send(arg0);
				
			}
			
			
		});
		
		jp=new JPanel();
		
		jp.add(jtf);     //组件放入面板
		jp.add(jb);
		
		this.add(jlt,"Center");
		this.add(jp,"South");
		this.setIconImage(new ImageIcon("images/qq.gif").getImage());
		this.setSize(300,200);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	    
	}
	  protected void send(ActionEvent arg0) {
		// TODO Auto-generated method stub
		  if(jtf.getText().trim().equals("")) {
			  
			  JOptionPane.showMessageDialog(this, "消息不能为空!");
			  return;
		  }else {
			  
			  String info="发送的消息是:"+jtf.getText()+"\r\n";
				//定义Vector集合
				Vector<String> list=new Vector<String>();
				//把Jlist中的元素得到加入集合
				for(int i=0;i<jlt.getModel().getSize();i++) {

				    list.add(jlt.getModel().getElementAt(i).toString());
				    
				}
				//再把后面新的字符串内容加入集合
				 list.add(info);
			     jlt.setListData(list);  //填充jlist文本框 
				 jlt.repaint();  //刷新jlist数据
		  }
		
	}
	public void show1() {
		String info="发送的消息是:"+"\n";
		//定义Vector集合
		Vector<String> list=new Vector<String>();
		//把Jlist中的元素得到加入集合
		for(int i=0;i<list.size();i++) {
			info+=this.jlt.getModel().getElementAt(i).toString();
		    list.add(info);
		    
		}
		//再把后面新的字符串内容加入集合
		 list.add(info);
	     jlt.setListData(list);  //填充jlist文本框 
		 jlt.repaint();  //刷新jlist数据
		
	
	}
	  
	  public static void main(String[] args) {
		
		  new QQChat();
	}
}
