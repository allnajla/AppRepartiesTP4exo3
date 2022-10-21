import java.io.*;
import java.net.*;
import java.util.Scanner;
public class SocketServeur {
    public static void main(String argv[]) {


        int port = 0;
        Scanner keyb = new Scanner(System.in);
// .............................................................
        System.out.print("Port d'écoute : ");
        try {
            port = keyb.nextInt();
        } catch (NumberFormatException e) {
            System.err.println("Le paramètre n'est pas un entier.");
            System.err.println("Usage : java ServeurUDP port-serveur");
            System.exit(-1);
        }

            try {
// .............................................................
                ServerSocket serverSocket = new ServerSocket(port);
// ..........................................................
                while(true) {
                    Socket socket = serverSocket.accept();
// ..........................................................
                    ObjectOutputStream output =
                            new ObjectOutputStream(socket.getOutputStream());
                    ObjectInputStream input =
                            new ObjectInputStream(socket.getInputStream());
// ..........................................................
                    output.writeObject(new String("Donnez votre Nom"));
                    String nom = (String) input.readObject();
                    System.out.println("Nom reçu :" + nom);
                    output.writeObject(new String("Donnez votre age"));
                    int age = (int) input.readObject();

                    System.out.println("Age reçu :" + age);
                    Personne p = new Personne(age, nom);

                    System.out.println(" Personne N°: " + p.Id);
// ..........................................................
                    System.out.println(" ca vient de : " + socket.getInetAddress() +
                            ":" + socket.getPort());
// ..........................................................
                    output.writeObject(new String("Votre identifiant est " + p.Id));
                }
            } catch (Exception e) {
                System.err.println("Erreur : " + e);
            }
       }

}
