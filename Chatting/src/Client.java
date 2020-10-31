import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;


public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException {
		
		Socket client = new Socket("192.168.0.100", 8888);
		
		OutputStream os = client.getOutputStream();
		
		String message = "HI";
		
		os.write(message.getBytes());

		InputStream is = client.getInputStream();
		
		byte b[] = new byte[1024];
		
		is.read(b);
		
		System.out.println( new String(b).trim() );

	}

}













