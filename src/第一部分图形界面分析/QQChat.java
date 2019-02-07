package ��һ����ͼ�ν������;

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
	private JList jlt;  //�����б� JTextArea
	private JButton jb;
	private JPanel jp;
	private JScrollPane jsp;  //�������������
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public QQChat() {
		

		jtf=new JTextField(15);
		jlt=new JList();
		//jList��Ҫ����setModel�������Է����������������
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
		jsp=new JScrollPane();  //��ʼ���������
		
		jsp.setViewportView(jlt);  //��Jlist����������
		
		jb=new JButton("����");
		
		//�����¼��Ĵ���
		jb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				  send(arg0);
				
			}
			
			
		});
		
		jp=new JPanel();
		
		jp.add(jtf);     //����������
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
			  
			  JOptionPane.showMessageDialog(this, "��Ϣ����Ϊ��!");
			  return;
		  }else {
			  
			  String info="���͵���Ϣ��:"+jtf.getText()+"\r\n";
				//����Vector����
				Vector<String> list=new Vector<String>();
				//��Jlist�е�Ԫ�صõ����뼯��
				for(int i=0;i<jlt.getModel().getSize();i++) {

				    list.add(jlt.getModel().getElementAt(i).toString());
				    
				}
				//�ٰѺ����µ��ַ������ݼ��뼯��
				 list.add(info);
			     jlt.setListData(list);  //���jlist�ı��� 
				 jlt.repaint();  //ˢ��jlist����
		  }
		
	}
	public void show1() {
		String info="���͵���Ϣ��:"+"\n";
		//����Vector����
		Vector<String> list=new Vector<String>();
		//��Jlist�е�Ԫ�صõ����뼯��
		for(int i=0;i<list.size();i++) {
			info+=this.jlt.getModel().getElementAt(i).toString();
		    list.add(info);
		    
		}
		//�ٰѺ����µ��ַ������ݼ��뼯��
		 list.add(info);
	     jlt.setListData(list);  //���jlist�ı��� 
		 jlt.repaint();  //ˢ��jlist����
		
	
	}
	  
	  public static void main(String[] args) {
		
		  new QQChat();
	}
}
