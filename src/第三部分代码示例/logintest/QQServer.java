package logintest;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ��������
 * @author zhangsan
 * @version 1.0 QQServer.java
 * @date ����09:48:15
 *
 */
public class QQServer {
	
	public static void main(String[] args) throws IOException {
		
		//����������˵Ķ˿ں�
		ServerSocket socket=null;
		try {
			socket=new ServerSocket(Gloables.SERVERPORT);
			//��ʾ��Ϣ
			System.out.println("�����������ɹ���");
			while(true){
				
				//������������
				Socket ss=socket.accept();
				//�����������߳�
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
