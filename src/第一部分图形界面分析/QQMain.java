package ��һ����ͼ�ν������;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

import tree.*;
public class QQMain extends JFrame  {

	 private JPanel jp1,jp2;
	 private JButton jb1;
	 private JScrollPane jsp1;  //���������
	 private JTree jtr;  //���νṹ
	 
	 public QQMain() {
		 
		
		 jp1=new JPanel(new BorderLayout());
		 jp2=new JPanel(new GridLayout(20,1,4,4));
		
		 //���νṹ��ʼ��
		/* DefaultMutableTreeNode root = new DefaultMutableTreeNode("�ҵĺ���");  //�������ĸ��ڵ�
		 //ѭ�������û�
		 String[] str={"1001","1002","1003"};
		 for(String s:str) {
		 DefaultMutableTreeNode no = new DefaultMutableTreeNode(s);
	     root.add(no);   
		 }*/
		 
		//��ͼ������νṹ
		 IconNode root1=new IconNode(new ImageIcon("images/1.jpg"),"���к���");
		 IconNode root2=new IconNode(new ImageIcon("images/2.jpg"),"���к���");
		 root1.add(new IconNode(new ImageIcon("images/3.jpg"),"�ž�"));
		 root1.add(new IconNode(new ImageIcon("images/4.jpg"),"ΰ��"));
		 root2.add(new IconNode(new ImageIcon("images/5.jpg"),"��ǿ"));
		 root2.add(new IconNode(new ImageIcon("images/6.jpg"),"Сǿ"));
		 IconNode Root=new IconNode(null,"�����б�");  //������ڵ�
		 Root.add(root1); //��������ڵ�
		 Root.add(root2);
		 
	     //�������νṹ
		// jtr=new JTree(root);
	     jtr=new JTree(Root);  //����Root
	     jtr.setCellRenderer(new IconNodeRenderer()); //���õ�Ԫ����Ϣ
	     jtr.setToggleClickCount(1);  //���õ���һ�δ򿪽ڵ�
	     jtr.repaint(); //ˢ��
	     
         //������JScrollPane
		 jsp1=new JScrollPane();
		 jsp1.setViewportView(jtr); //�����������
		
		 //���������¼�
		 jtr.addMouseListener(new MouseAdapter() {
			 
			 public void mouseClicked(MouseEvent e) {
				 
				 jtree_clicked(e);
			 }
		 });
		 jb1=new JButton("�ҵĺ���");
		 
		 //��ӵ����
		 jp1.add(jb1,"North");
		 jp1.add(jsp1,"Center");
		 
		 //���봰��
		 this.add(jp1);
		 this.setSize(140,400);
		 this.setVisible(true);
		 
	 }
	 
	protected void jtree_clicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getClickCount()==2) {
		TreePath path=jtr.getSelectionPath();//��ȡ�ڵ�·��
		IconNode node=(IconNode)path.getLastPathComponent(); //ͨ��·����ָ��ָ���Ľڵ�
		if(node.isLeaf()) {  //�ж��Ƿ���Ҷ��
			
			
			JOptionPane.showMessageDialog(this, "��ϲ�㽲�����촰��");
			
		}
		}
		
	}

	public static void main(String[] args) {
		
		new QQMain();
	}
}
