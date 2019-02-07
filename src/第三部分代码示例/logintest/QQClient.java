package logintest;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class QQClient {
	
	public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {
		
		Scanner input=new Scanner(System.in);
		System.out.println("�������û���:");
		String username=input.next();
		System.out.println("����������:");
		String password=input.next();
		
		try {
			//�����ͻ����׽���
			Socket socket =new Socket(Gloables.SERVERHOST,Gloables.SERVERPORT);
			//��ӡ��IP��ַ�Ͷ˿ں�
			System.out.println(socket.getInetAddress().getHostAddress()+"\t"+socket.getPort());
			//���ֹ�¼�����Ϣ��װ��User����
			User user=new User();
			user.setUsername(username);
			user.setPassword(password);
			//�������������û���������
			ObjectOutputStream oos=new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream ois=new ObjectInputStream(socket.getInputStream());
			
			//ͨ������������ѿͻ������¼��Ķ��󴫸�������
			oos.writeObject(user);
			oos.flush();
			//ͨ�������������ѷ������������Ķ����ȡ����
			Object o=ois.readObject();
			//ת����User����
			User u=(User)o;
			if(u!=null){
				System.out.println("�ͻ��˵�½�ɹ���");
			}else {
				
				System.out.println("��½ʧ�ܣ������ԣ�");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
