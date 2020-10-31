import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

// TCP ��� network ���

// server / client ���� ���� Socket ��ü�� �ʿ�

public class Server {

	public static void main(String[] args) throws IOException {

		// Server �� Socket ��ü ����

		ServerSocket ss = new ServerSocket(8888);
		
		System.out.println("[server start]");

		while (true) {

			Socket s = ss.accept();

			InputStream is = s.getInputStream();

			byte[] message = new byte[1024];

			is.read(message);

			String str = new String(message);

			System.out.println(str.trim());
			
			
			OutputStream os = s.getOutputStream();
			
			os.write(str.getBytes());
			
		}

	}

}
