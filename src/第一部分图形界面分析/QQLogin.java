package 第一部分图形界面分析;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
/**
 * 举例：QQ登陆手工代码实现
 * @author Administrator
 *
 */
public class QQLogin extends JFrame {
	
	 /**
	  * 组件定义区
	  */
	private JTextField jtf1,jtf2; //单行文本框 JTextArea
    private JLabel jl1,jl2,jl3,jl4; //标签
    private JButton jb1,jb2,jb3;  //按钮
    private JTabbedPane jtp;  //选项卡
    private JComboBox jcb;  //下拉列表框
    private JPanel jp1,jp2,jp3;  //面板
    /**
     * 构造方法初始化组件
     * @throws UnsupportedLookAndFeelException 
     * @throws IllegalAccessException 
     * @throws InstantiationException 
     * @throws ClassNotFoundException 
     */
    public QQLogin() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
    	
    	//图形优化：
    	UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
    	
    	jl1=new JLabel("QQ号：",JLabel.CENTER);
    	jl2=new JLabel("密码：",JLabel.CENTER);
    	jtf1=new JTextField();
    	jtf2=new JPasswordField();
    	jcb=new JComboBox();   
    	jcb.addItem("在线");
    	jcb.addItem("隐身");
    	jb1=new JButton("注册");
    	jb2=new JButton("登陆");
    	//为登陆按钮添加事件
    	jb2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				//写个方法标示它的作用
				login(arg0);
				
			}
    		
    		
    	});
    	jb3=new JButton("退出");
    	jp1=new JPanel();
    	jp2=new JPanel();
    	jp3=new JPanel();
    	
    	jl3=new JLabel(new ImageIcon("images/tou.gif"));  //加入图片
    	jp1.add(jl3);  //图片放入面板jp1,在北边
        
    	jp2.setLayout(new GridLayout(3,1,3,3));  //设置jp2的布局方式
    	jp2.add(jl1);
    	jp2.add(jtf1);
    	jp2.add(jl2);
    	jp2.add(jtf2);
    	
    	jl4=new JLabel("在线状态：",JLabel.CENTER);
    	jp2.add(jl4);
    	jp2.add(jcb);
    	
    	
    	//jp3组件添加
    	jp3.add(jb1);
    	jp3.add(jb2);
    	jp3.add(jb3);
    	
    	//选项卡的使用
    	jtp=new JTabbedPane();
    	jtp.add("QQ登陆",jp2);
    	
    	
    	
    	
    	//窗体设置  BorderLayout()
    	this.add(jp1,"North");
    	this.add(jtp,"Center");
    	this.add(jp3,"South");
    	this.setIconImage(new ImageIcon("images/mm.jpg").getImage());
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	this.setResizable(false);
    	this.setSize(350,250);
    	this.setLocationRelativeTo(null);
    	this.setTitle("QQ2013");
    	this.setVisible(true);
    	
    	
    }
    
    protected void login(ActionEvent arg0) {
		// TODO Auto-generated method stub
    	//判断按钮是否已经点击 getsource为取得对象的名字
    	if(arg0.getSource()==jb2) {
    		
    		//判断文本框中有没有内容
    		if(jtf1.getText().trim().equals("")||jtf2.getText().trim().equals("")) {
    			
    			//给出提示，弹出对话框
    			JOptionPane.showMessageDialog(this, "请输入用户名和密码！");
    			return;
    		}else {
    			
    			this.setVisible(false);
    			JOptionPane.showMessageDialog(this, "正在进入主界面，请稍后。。。");
    			
    		}
    	}
		
	}

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		
    	new QQLogin();
	}
    
    
}
