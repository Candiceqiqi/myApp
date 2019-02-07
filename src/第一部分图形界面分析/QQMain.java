package 第一部分图形界面分析;

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
	 private JScrollPane jsp1;  //滚动条面板
	 private JTree jtr;  //树形结构
	 
	 public QQMain() {
		 
		
		 jp1=new JPanel(new BorderLayout());
		 jp2=new JPanel(new GridLayout(20,1,4,4));
		
		 //树形结构初始化
		/* DefaultMutableTreeNode root = new DefaultMutableTreeNode("我的好友");  //构建树的根节点
		 //循环加入用户
		 String[] str={"1001","1002","1003"};
		 for(String s:str) {
		 DefaultMutableTreeNode no = new DefaultMutableTreeNode(s);
	     root.add(no);   
		 }*/
		 
		//带图标的树形结构
		 IconNode root1=new IconNode(new ImageIcon("images/1.jpg"),"高中好友");
		 IconNode root2=new IconNode(new ImageIcon("images/2.jpg"),"初中好友");
		 root1.add(new IconNode(new ImageIcon("images/3.jpg"),"雅君"));
		 root1.add(new IconNode(new ImageIcon("images/4.jpg"),"伟旭"));
		 root2.add(new IconNode(new ImageIcon("images/5.jpg"),"彬强"));
		 root2.add(new IconNode(new ImageIcon("images/6.jpg"),"小强"));
		 IconNode Root=new IconNode(null,"好友列表");  //定义根节点
		 Root.add(root1); //定义二级节点
		 Root.add(root2);
		 
	     //构建树形结构
		// jtr=new JTree(root);
	     jtr=new JTree(Root);  //放入Root
	     jtr.setCellRenderer(new IconNodeRenderer()); //设置单元格信息
	     jtr.setToggleClickCount(1);  //设置单击一次打开节点
	     jtr.repaint(); //刷新
	     
         //树加入JScrollPane
		 jsp1=new JScrollPane();
		 jsp1.setViewportView(jtr); //树加入滚动条
		
		 //设置树的事件
		 jtr.addMouseListener(new MouseAdapter() {
			 
			 public void mouseClicked(MouseEvent e) {
				 
				 jtree_clicked(e);
			 }
		 });
		 jb1=new JButton("我的好友");
		 
		 //添加到面板
		 jp1.add(jb1,"North");
		 jp1.add(jsp1,"Center");
		 
		 //加入窗体
		 this.add(jp1);
		 this.setSize(140,400);
		 this.setVisible(true);
		 
	 }
	 
	protected void jtree_clicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getClickCount()==2) {
		TreePath path=jtr.getSelectionPath();//获取节点路径
		IconNode node=(IconNode)path.getLastPathComponent(); //通过路径将指针指到改节点
		if(node.isLeaf()) {  //判断是否是叶子
			
			
			JOptionPane.showMessageDialog(this, "恭喜你讲打开聊天窗口");
			
		}
		}
		
	}

	public static void main(String[] args) {
		
		new QQMain();
	}
}
