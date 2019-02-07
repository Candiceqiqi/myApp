package 第三部分代码示例;

import java.net.Socket;

public interface UserBiz {
	
	public UserBiz userLogin(Socket s,UserBiz u);
	
	public  String  Register(Socket s, User u) ;
	
	

}
