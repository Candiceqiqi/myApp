package �������ִ���ʾ��;

import java.io.File;
import java.net.Socket;

public interface ChatBiz {
	
	//���幦��
	public void sendMsg(Socket s,Message msg) ;
	
	public void sendFile(Socket s,String toqq, File file) ;
	
	

}
