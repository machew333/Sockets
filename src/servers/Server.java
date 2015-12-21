package servers;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class Server {

public static void main(String[] args) throws Exception
{
    System.out.println("Starting...");
    ServerSocket server = new ServerSocket(1234);
    Socket socket = server.accept();
    loop(socket);



}


public static void loop(Socket socket) throws Exception
{

    Scanner socketScanner = new Scanner(socket.getInputStream());
    int num = socketScanner.nextInt();
    System.out.println("Received: " + num);
    num *= 2;

    PrintStream out = new PrintStream(socket.getOutputStream());
    out.println(num);

    loop(socket);
}


}