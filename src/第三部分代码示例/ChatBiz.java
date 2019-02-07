package 第三部分代码示例;

import java.io.File;
import java.net.Socket;

public interface ChatBiz {
	
	//定义功能
	public void sendMsg(Socket s,Message msg) ;
	
	public void sendFile(Socket s,String toqq, File file) ;
	
	

}
