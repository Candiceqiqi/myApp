package ��һ����ͼ�ν������;

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
	private JList jlt;  //�����б�
	private JButton jb,jb1;
	private JPanel jp;
	private JScrollPane jsp;  //�������������
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public QQFileChooser() {
		

		jtf=new JTextField(10);
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
		jb1=new JButton("ѡ���ļ�");
		
		
		//�����¼��Ĵ���
	    jb1.addMouseListener(new MouseAdapter() {
	    	
	    	public void mouseClicked(MouseEvent e) {
	    		
	    		JFileChooser fileChooser = new JFileChooser();
	    		int a = fileChooser.showOpenDialog(null);
	    		if (a == JFileChooser.APPROVE_OPTION) {
	    			
	    			JOptionPane.showMessageDialog(null, "�����ϴ�...");
	    			JOptionPane.showMessageDialog(null, "ok,�������");
	    		}
	    		
	    	}
	    });
		
		jp=new JPanel();
		
		jp.add(jtf);     //����������
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
