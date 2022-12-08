package src.heimaufgaben;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Client {


    public static void main(String[] args) {
        try {
            Socket sock = new Socket("Localhost", 2022);
            BufferedReader fromServ = new BufferedReader(new InputStreamReader(sock.getInputStream(), StandardCharsets.UTF_8), 8192);

            while (!fromServ.ready()) {
                Thread.sleep(5);
            }
            boolean closer = true;
            String Output;
            while (closer) {
                Output = fromServ.readLine();

                if (Output.matches("PONG")) {
                    System.out.println(Output);
                }
                if (Output.startsWith("ECHO ")) {
                    System.out.println(Output.substring(5));
                }
                if (Output.startsWith("TIME ")) {
                    System.out.println(Output.substring(5));
                }
                if (Output.startsWith("DATE ")) {
                    System.out.println(Output.substring(5));
                }


                if (Output.matches("Die Verbindung zum Server wurde beendet.")) {
                    closer = false;
                }


            }
            System.out.println("Der Client wurde beendet");


            fromServ.close();
            sock.close();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
