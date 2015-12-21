package servers;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;


public class ServerClient {
public static void main(String[] args) throws Exception
{
    Socket socket = new Socket("localhost",1234);

    loop(socket);


}


public static void loop(Socket socket) throws Exception
{
    Scanner scanner = new Scanner(System.in);
    Scanner socketScanner = new Scanner(socket.getInputStream());
    System.out.println("Input number:");
    int num = scanner.nextInt();
    PrintStream p = new PrintStream(socket.getOutputStream());
    p.println(num);

    int response = socketScanner.nextInt();
    System.out.println("Received: " + response);
    loop(socket);
}

}
