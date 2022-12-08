package heimaufgaben;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {

    }

    public static void connect(String ip, int port) throws IOException {
        Socket client = new Socket(ip, port);
        boolean connected = client.isConnected();
        Scanner scanner = new Scanner(System.in);
        DataInputStream ClientInput = new DataInputStream(client.getInputStream());
        DataOutputStream ClientOutput = new DataOutputStream(client.getOutputStream());

        while (connected) {
            String eingabe = scanner.nextLine();
            if(eingabe.equalsIgnoreCase("logout")) {
                System.out.println("Client ist ausgeloggt. Server läuft noch.");
                connected = false;
                client.close();
            }






        }

    }
}
