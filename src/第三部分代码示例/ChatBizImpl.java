package 第三部分代码示例;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatBizImpl implements ChatBiz {

	@Override
	public void sendMsg(Socket s, Message msg) {
		// TODO Auto-generated method stub
		//通过流,对象流
		try {
			PrintWriter pw=new PrintWriter(s.getOutputStream(),true);
			pw.println(msg);
			pw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

	@Override
	public void sendFile(Socket s, String toqq, File file) {
		// TODO Auto-generated method stub
		
		PrintWriter pw=null;
		BufferedReader br=null;
		
		try {
			
			pw=new PrintWriter(s.getOutputStream(),true);
			pw.write(toqq);
			pw.write(file.getName());
		}
		
	}

}
