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
 * �������߳�
 * @author zhangsan
 * @version 1.0 ServerThread.java
 * @date ����10:14:23u
 *
 */
public class ServerThread extends Thread {
	
	private Socket socket;
	
	public ServerThread(Socket socket){
		
		this.socket=socket;
	}
	
	public void run() {
		
		//����������������
		ObjectInputStream ois=null;
		ObjectOutputStream oos=null;
		try {
			ois=new ObjectInputStream(socket.getInputStream());
			oos=new ObjectOutputStream(socket.getOutputStream());
			//�������ȵõ��ͻ������������û�����
			User u=(User)ois.readObject();
			//���ļ���ȥ����ָ�����û��Ƿ����
			//�����ļ�
			File file=new File(Gloables.FILE);
			if(!file.exists()){
				file.createNewFile();
			}
			boolean flag=false;  //�ж��û��Ƿ���ȵı�־λ
			//���ļ����ڣ��õ�ǰ�ͻ�������Ŀͻ����ļ��еĿͻ�ȥ�Ƚ�
			//�ж��ļ��ĳ����Ƿ����0����������ڵ�����ȡ�ļ�����
			List<Object> allObject=new ArrayList<Object>();
			if(file.length()>0){
			   FileInputStream fis=new FileInputStream(file);
			   //Ȼ�������Ľڵ�����װ�ɶ���������
			   ObjectInputStream ois1=new ObjectInputStream(fis);
			   //ѭ���Ƚϵ�ǰ�û����ļ��������е��û�
			   //ѭ������Ϊ�ڵ������Ƿ�������
			   while(fis.available()>0){
			      Object o=ois1.readObject();
			      //�ѵ�ǰ���ļ��ж����Ķ����ȷ��뼯��
			      allObject.add(o);
			      //��o����ת��User����
			      User user=(User)o;
			      //��ʼ�ж�
			      if(user.getUsername().equals(u.getUsername())&&user.getPassword().equals(u.getPassword())){
			    	  
			    	  //���ñ�־״̬Ϊ��
			    	  flag=true;
			    	  //���ļ��еĶ����赱ǰ�ӿͻ��˻�ȡ���û�
			    	  u=user;
			    	  break;
			      }
			   }
			   //�رսڵ���
			   fis.close();
			}
			//�Ѵӿͻ��˶�ȡ���Ķ�����뼯��
			allObject.add(u);
			//����������������������ļ�
			ObjectOutputStream fileOutput=new ObjectOutputStream(new FileOutputStream(Gloables.FILE));
			//���������еĶ���д���ļ�
			for(Object o: allObject){
				
				fileOutput.writeObject(o);
			}
			//�رն�����
			fileOutput.close();
			
			//�����־λΪ�棬�����û����ڣ�ִ����Ӧ�Ĳ���
			if(flag){
				System.out.println("��½�����ɹ�ִ�У�");
				oos.writeObject(u);
			}
			else {
				
				//���ظ��ͻ���һ���ն���
				oos.writeObject(null);
			}
			//���oos����
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
					oos.writeUTF("��½ʧ��");
					oos.flush();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}

}
