package logintest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * 服务器线程
 * @author zhangsan
 * @version 1.0 ServerThread.java
 * @date 上午10:14:23u
 *
 */
public class ServerThread extends Thread {
	
	private Socket socket;
	
	public ServerThread(Socket socket){
		
		this.socket=socket;
	}
	
	public void run() {
		
		//定义对象输入输出流
		ObjectInputStream ois=null;
		ObjectOutputStream oos=null;
		try {
			ois=new ObjectInputStream(socket.getInputStream());
			oos=new ObjectOutputStream(socket.getOutputStream());
			//服务器先得到客户机发过来的用户对象
			User u=(User)ois.readObject();
			//到文件中去查找指定的用户是否存在
			//建立文件
			File file=new File(Gloables.FILE);
			if(!file.exists()){
				file.createNewFile();
			}
			boolean flag=false;  //判断用户是否相等的标志位
			//若文件存在，拿当前客户机传入的客户与文件中的客户去比较
			//判断文件的长度是否大于0，建立输入节点流读取文件内容
			List<Object> allObject=new ArrayList<Object>();
			if(file.length()>0){
			   FileInputStream fis=new FileInputStream(file);
			   //然后把输入的节点流包装成对象输入流
			   ObjectInputStream ois1=new ObjectInputStream(fis);
			   //循环比较当前用户与文件对象流中的用户
			   //循环条件为节点流中是否有数据
			   while(fis.available()>0){
			      Object o=ois1.readObject();
			      //把当前从文件中读出的对象先放入集合
			      allObject.add(o);
			      //把o对象转成User类型
			      User user=(User)o;
			      //开始判断
			      if(user.getUsername().equals(u.getUsername())&&user.getPassword().equals(u.getPassword())){
			    	  
			    	  //设置标志状态为真
			    	  flag=true;
			    	  //把文件中的对象赋予当前从客户端获取的用户
			    	  u=user;
			    	  break;
			      }
			   }
			   //关闭节点流
			   fis.close();
			}
			//把从客户端读取来的对象加入集合
			allObject.add(u);
			//产生对象输出流保存存入的文件
			ObjectOutputStream fileOutput=new ObjectOutputStream(new FileOutputStream(Gloables.FILE));
			//遍历集合中的对象写入文件
			for(Object o: allObject){
				
				fileOutput.writeObject(o);
			}
			//关闭对象流
			fileOutput.close();
			
			//如果标志位为真，代表用户存在，执行相应的操作
			if(flag){
				System.out.println("登陆操作成功执行！");
				oos.writeObject(u);
			}
			else {
				
				//返回给客户端一个空对象
				oos.writeObject(null);
			}
			//清空oos缓冲
			oos.flush();
			
		}catch(IOException e){
			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally {
			
			if(oos!=null){
				
				try {
					oos.writeUTF("登陆失败");
					oos.flush();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}

}
