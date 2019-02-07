package ��һ����ͼ�ν������;

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
 * ������QQ��½�ֹ�����ʵ��
 * @author Administrator
 *
 */
public class QQLogin extends JFrame {
	
	 /**
	  * ���������
	  */
	private JTextField jtf1,jtf2; //�����ı��� JTextArea
    private JLabel jl1,jl2,jl3,jl4; //��ǩ
    private JButton jb1,jb2,jb3;  //��ť
    private JTabbedPane jtp;  //ѡ�
    private JComboBox jcb;  //�����б��
    private JPanel jp1,jp2,jp3;  //���
    /**
     * ���췽����ʼ�����
     * @throws UnsupportedLookAndFeelException 
     * @throws IllegalAccessException 
     * @throws InstantiationException 
     * @throws ClassNotFoundException 
     */
    public QQLogin() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
    	
    	//ͼ���Ż���
    	UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
    	
    	jl1=new JLabel("QQ�ţ�",JLabel.CENTER);
    	jl2=new JLabel("���룺",JLabel.CENTER);
    	jtf1=new JTextField();
    	jtf2=new JPasswordField();
    	jcb=new JComboBox();   
    	jcb.addItem("����");
    	jcb.addItem("����");
    	jb1=new JButton("ע��");
    	jb2=new JButton("��½");
    	//Ϊ��½��ť����¼�
    	jb2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				//д��������ʾ��������
				login(arg0);
				
			}
    		
    		
    	});
    	jb3=new JButton("�˳�");
    	jp1=new JPanel();
    	jp2=new JPanel();
    	jp3=new JPanel();
    	
    	jl3=new JLabel(new ImageIcon("images/tou.gif"));  //����ͼƬ
    	jp1.add(jl3);  //ͼƬ�������jp1,�ڱ���
        
    	jp2.setLayout(new GridLayout(3,1,3,3));  //����jp2�Ĳ��ַ�ʽ
    	jp2.add(jl1);
    	jp2.add(jtf1);
    	jp2.add(jl2);
    	jp2.add(jtf2);
    	
    	jl4=new JLabel("����״̬��",JLabel.CENTER);
    	jp2.add(jl4);
    	jp2.add(jcb);
    	
    	
    	//jp3������
    	jp3.add(jb1);
    	jp3.add(jb2);
    	jp3.add(jb3);
    	
    	//ѡ���ʹ��
    	jtp=new JTabbedPane();
    	jtp.add("QQ��½",jp2);
    	
    	
    	
    	
    	//��������  BorderLayout()
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
    	//�жϰ�ť�Ƿ��Ѿ���� getsourceΪȡ�ö��������
    	if(arg0.getSource()==jb2) {
    		
    		//�ж��ı�������û������
    		if(jtf1.getText().trim().equals("")||jtf2.getText().trim().equals("")) {
    			
    			//������ʾ�������Ի���
    			JOptionPane.showMessageDialog(this, "�������û��������룡");
    			return;
    		}else {
    			
    			this.setVisible(false);
    			JOptionPane.showMessageDialog(this, "���ڽ��������棬���Ժ󡣡���");
    			
    		}
    	}
		
	}

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		
    	new QQLogin();
	}
    
    
}
