package logintest;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务器端
 * @author zhangsan
 * @version 1.0 QQServer.java
 * @date 上午09:48:15
 *
 */
public class QQServer {
	
	public static void main(String[] args) throws IOException {
		
		//定义服务器端的端口号
		ServerSocket socket=null;
		try {
			socket=new ServerSocket(Gloables.SERVERPORT);
			//提示信息
			System.out.println("服务器启动成功！");
			while(true){
				
				//调用阻塞方法
				Socket ss=socket.accept();
				//启动服务器线程
				new ServerThread(ss).start();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(socket!=null){
					socket.close();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

}
