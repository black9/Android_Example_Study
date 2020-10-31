import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

// TCP 기반 network 통신

// server / client 측에 각각 Socket 객체가 필요

public class Server {

	public static void main(String[] args) throws IOException {

		// Server 측 Socket 객체 생성

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
