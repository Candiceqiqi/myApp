package ��һ����ͼ�ν������;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.*;

/**
 * ����ͼ�ν�������˽��������� ��
 * 1.��ʲô���ɣ�������ؼ�   �������:1.JLabel, 2. JTextField 3.JPasswordField
 *   4.JRadioButton 5.JCheckBox  6. JButton 7.JPanel ���
 * 2.�Ű沼��  :1.FlowLayout(��ʽ����):�������� 2.BorderLayout(�߽粼��)����λ�������м䣬�ϱ� 3.CardLayout(��Ƭ����)
 *   4. GridLayout(���񲼾�) 
 * @author Administrator
 *
 */
public class Login extends JFrame {
	
  
	//1.�ȼ̳�JFrame��Ϊ������
	//2.��ʼ�������
	private JLabel label1,label2,label3,label4,label5;
	private JTextField jtf;
	private JPasswordField jpf;
	private JCheckBox jcb1,jcb2;
	private JButton jb1,jb2,jb3;
	private JPanel jp1,jp2,jp3,jp4;
	private JPanel jp5,jp6,jp7;
	//...
	//3.�������췽����Ϊ�����ֵ
	public Login() {
		//��������
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
		//4.��ʼ��ʼ��
		//ͼƬ��: ImageIcon
		//���沿��
		
		
		label1=new JLabel(new ImageIcon("images/tou.gif"));
		//�м䲿��
		label2=new JLabel("QQ����:",JLabel.CENTER);
		//������ɫ
		label2.setForeground(Color.RED);
		label3=new JLabel("QQ����:",JLabel.CENTER);
		label2.setForeground(Color.RED);
		label4=new JLabel("ע��");
		label4.setForeground(Color.BLUE);
		label5=new JLabel("��������");
		label5.setForeground(Color.BLUE);
		
		jtf=new JTextField();
		jtf.setColumns(15);
		jpf=new JPasswordField();
		jpf.setColumns(28);
		jcb1=new JCheckBox("�����½");
		jcb2=new JCheckBox("��ס����");
		jb1=new JButton("��½");
		//�����¼� Ϊ��ť            
		jb1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					//д���� Ҫִ�еķ���
					
					btn_loginActionPerformed(evt);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		jb2=new JButton("ע��");
		jb3=new JButton("ȡ��");
		
		
		//�����淹��������Ԫ��
		jp1=new JPanel();  //���벼��
		jp5=new JPanel();
		jp7=new JPanel();
		jp6=new JPanel(new GridLayout(3,1));
		//��label����jp1���
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
				
		//����jp2���밴ť
		jp2=new JPanel();
		jp2.add(jb1);
		jp2.add(jb2);
		jp2.add(jb3);
		
	
		JTabbedPane jtp=new JTabbedPane();
		jtp.add("��½����",jp6);
		
		//��JLabel���봰��

		this.add(label1,"North");
		//�������jp1
		this.add(jtp,"Center");  //����ָ���ķ�λ���м�
		//��ť����
		this.add(jp2,"South");
		
		//�Դ������һЩ����,���ô���Ĵ�С�����ô�����ιرգ����ô����
		//�ɼ��� 
		this.setTitle("QQ2013");
		//�������Ͻ�ͼ��
		ImageIcon image1=new ImageIcon("images/qq.png");
		this.setIconImage(image1.getImage());
		this.setSize(350,250); //��С����
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //�����˳�����
		this.setVisible(true); //����ɼ�
		
	}
	protected void btn_loginActionPerformed(ActionEvent evt) throws IOException {
		// TODO Auto-generated method stub
		//�ж�ѡ��İ�ť
		if(evt.getSource()==jb1) {
			//��������ͼ�ν���ִ����Ӧ����
			QQClientUser qqClientUser=new QQClientUser();
			User u=new User();
			u.setCount(jtf.getText().trim());
			u.setPassword(new String(jpf.getPassword()));
			
			if(qqClientUser.checkUser(u)) {
				//��������
				QQMain qqlist=new QQMain(u.getCount());
				ManageQqFriendList.addQqFriendList(u.getCount(), qqlist);
				
				ObjectOutputStream oos=new ObjectOutputStream(ManageClientConServer.getClientConnectServerThread(u.getCount()).getS().getOutputStream());
				
				Message m=new Message();
				m.setMesType(MessageType.message_get_onLineFriend);
				m.setFromqq(u.getCount());
				oos.writeObject(m);
				
			    this.dispose();
			    
			    
			
		}else {
			
			JOptionPane.showMessageDialog(this, "�û����������");
			
			
		}
		     }
		if(evt.getSource()==jb2){
			
			//...
		}
		}
		

		
	//9.����
	public static void main(String[] args) {
		
		new Login();
	}
	
}