package 第一部分图形界面分析;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.*;

/**
 * 掌握图形界面必须了解如下两块 ：
 * 1.由什么构成：组件，控件   常见组件:1.JLabel, 2. JTextField 3.JPasswordField
 *   4.JRadioButton 5.JCheckBox  6. JButton 7.JPanel 面板
 * 2.排版布局  :1.FlowLayout(流式布局):由左至右 2.BorderLayout(边界布局)：方位：北，中间，南边 3.CardLayout(卡片布局)
 *   4. GridLayout(网格布局) 
 * @author Administrator
 *
 */
public class Login extends JFrame {
	
  
	//1.先继承JFrame成为窗体类
	//2.开始声明组件
	private JLabel label1,label2,label3,label4,label5;
	private JTextField jtf;
	private JPasswordField jpf;
	private JCheckBox jcb1,jcb2;
	private JButton jb1,jb2,jb3;
	private JPanel jp1,jp2,jp3,jp4;
	private JPanel jp5,jp6,jp7;
	//...
	//3.创建构造方法，为组件赋值
	public Login() {
		//界面修饰
		try {
			UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//4.开始初始化
		//图片类: ImageIcon
		//上面部分
		
		
		label1=new JLabel(new ImageIcon("images/tou.gif"));
		//中间部分
		label2=new JLabel("QQ号码:",JLabel.CENTER);
		//加入颜色
		label2.setForeground(Color.RED);
		label3=new JLabel("QQ密码:",JLabel.CENTER);
		label2.setForeground(Color.RED);
		label4=new JLabel("注册");
		label4.setForeground(Color.BLUE);
		label5=new JLabel("忘记密码");
		label5.setForeground(Color.BLUE);
		
		jtf=new JTextField();
		jtf.setColumns(15);
		jpf=new JPasswordField();
		jpf.setColumns(28);
		jcb1=new JCheckBox("隐身登陆");
		jcb2=new JCheckBox("记住密码");
		jb1=new JButton("登陆");
		//加入事件 为按钮            
		jb1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					//写出你 要执行的方法
					
					btn_loginActionPerformed(evt);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		jb2=new JButton("注册");
		jb3=new JButton("取消");
		
		
		//定义面饭放入所需元素
		jp1=new JPanel();  //加入布局
		jp5=new JPanel();
		jp7=new JPanel();
		jp6=new JPanel(new GridLayout(3,1));
		//把label放入jp1面板
				jp1.add(label2);	
				jp1.add(jtf);
			//	jp1.add(label4);
				jp5.add(label3);
				jp5.add(jpf);
			//	jp1.add(label5);
			//	jp1.add(jcb1);
			//	jp1.add(jcb2);
				jp7.add(jcb1);
				jp7.add(jcb2);
				
				jp6.add(jp1);
				jp6.add(jp5);
				jp6.add(jp7);
				
		//定义jp2放入按钮
		jp2=new JPanel();
		jp2.add(jb1);
		jp2.add(jb2);
		jp2.add(jb3);
		
	
		JTabbedPane jtp=new JTabbedPane();
		jtp.add("登陆界面",jp6);
		
		//把JLabel放入窗体

		this.add(label1,"North");
		//窗体添加jp1
		this.add(jtp,"Center");  //放入指定的方位，中间
		//按钮加入
		this.add(jp2,"South");
		
		//对窗体进行一些修饰,设置窗体的大小，设置窗体如何关闭，设置窗体的
		//可见性 
		this.setTitle("QQ2013");
		//设置左上角图标
		ImageIcon image1=new ImageIcon("images/qq.png");
		this.setIconImage(image1.getImage());
		this.setSize(350,250); //大小设置
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //窗体退出设置
		this.setVisible(true); //窗体可见
		
	}
	protected void btn_loginActionPerformed(ActionEvent evt) throws IOException {
		// TODO Auto-generated method stub
		//判断选择的按钮
		if(evt.getSource()==jb1) {
			//打开其他的图形界面执行相应功能
			QQClientUser qqClientUser=new QQClientUser();
			User u=new User();
			u.setCount(jtf.getText().trim());
			u.setPassword(new String(jpf.getPassword()));
			
			if(qqClientUser.checkUser(u)) {
				//创建好友
				QQMain qqlist=new QQMain(u.getCount());
				ManageQqFriendList.addQqFriendList(u.getCount(), qqlist);
				
				ObjectOutputStream oos=new ObjectOutputStream(ManageClientConServer.getClientConnectServerThread(u.getCount()).getS().getOutputStream());
				
				Message m=new Message();
				m.setMesType(MessageType.message_get_onLineFriend);
				m.setFromqq(u.getCount());
				oos.writeObject(m);
				
			    this.dispose();
			    
			    
			
		}else {
			
			JOptionPane.showMessageDialog(this, "用户名密码错误！");
			
			
		}
		     }
		if(evt.getSource()==jb2){
			
			//...
		}
		}
		

		
	//9.运行
	public static void main(String[] args) {
		
		new Login();
	}
	
}