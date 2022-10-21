import java.io.*;
import java.net.*;
import java.util.Scanner;
class SocketClient {
    public static void main(String argv[]) {
        int port = 0;
        String host = "";
        int age;
        String nom;
        String chaine ;
        Scanner keyb = new Scanner(System.in);
// .............................................................
        System.out.print("Nom du serveur : ");
        host = keyb.next();
        System.out.print("Port du serveur : ");
        try {
            port = keyb.nextInt();
        } catch (NumberFormatException e) {
            System.err.println("Le second paramètre n'est pas un entier.");
            System.exit(-1);
        }
// .............................................................
        try {
// .............................................................
            InetAddress adr = InetAddress.getByName(host);
// .............................................................
            Socket socket = new Socket(adr, port);
// .............................................................
            ObjectOutputStream output =
                    new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream input =
                    new ObjectInputStream(socket.getInputStream());
// .............................................................
            chaine = (String) input.readObject();
            System.out.println(chaine);
            nom =keyb.next();
            output.writeObject(nom);
            chaine = (String) input.readObject();
            System.out.println(chaine);
        try{
            age = keyb.nextInt();
            output.writeObject(age);
            chaine = (String) input.readObject();
            System.out.println(chaine);
        } catch (NumberFormatException e) {
            System.err.println("Le paramètre entré n'est pas un entier.");
            System.exit(-1);
        }

        } catch (Exception e) {
            System.err.println("Erreur : " + e);
        }
    }
}


