package 第三部分代码示例;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class OperateBizzImpl implements OperateBiz{

	@Override
	public void doAction(Socket s, int action) throws IOException {
		// TODO Auto-generated method stub
		ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
		
		
	}

}
