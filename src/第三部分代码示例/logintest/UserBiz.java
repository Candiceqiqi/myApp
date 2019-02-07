package 第三部分代码示例.logintest;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

import javax.swing.JOptionPane;

import com.myqq.entity.User;

public class UserBiz {
	
public User doLogin(Socket socket,User user)throws Exception{
		
	ObjectOutputStream objOutputStream1 = new ObjectOutputStream(socket.getOutputStream());
	ObjectInputStream objInputStream1 = new ObjectInputStream(socket.getInputStream());
	objOutputStream1.writeObject(user);
	objOutputStream1.flush();
	
	Object o=objInputStream1.readObject();
	if(o !=null){
		return  (User)o;
	}
	
	return null;
	
	
	}

public String doRegedit(Socket socket,User user)throws Exception{
	

	ObjectOutputStream objOutputStream1 = new ObjectOutputStream(socket.getOutputStream());
	ObjectInputStream objInputStream1 = new ObjectInputStream(socket.getInputStream());
	objOutputStream1.writeObject(user);
	objOutputStream1.flush();
	
	return objInputStream1.readUTF();
	
	}

public String doAddFriends(Socket socket,String owner,String friendqq)throws Exception{
	

	ObjectOutputStream objOutputStream1 = new ObjectOutputStream(
			socket.getOutputStream());
	ObjectInputStream objInputStream1 = new ObjectInputStream(
			socket.getInputStream());
	objOutputStream1.writeUTF(friendqq);
	objOutputStream1.writeUTF(owner);
	objOutputStream1.flush();
	String msg = objInputStream1.readUTF();
	return  msg;
	
	
	}

public List<User> doFindFriends(Socket socket,String friendqq,String type)throws Exception{
	

	ObjectOutputStream objOutputStream1 = new ObjectOutputStream(
			socket.getOutputStream());
	ObjectInputStream objInputStream1 = new ObjectInputStream(
			socket.getInputStream());
	objOutputStream1.writeUTF(friendqq);
	objOutputStream1.writeUTF(type);
	objOutputStream1.flush();
	Object result = objInputStream1.readObject();
	
	return (List<User>) result;
	
	}

}
