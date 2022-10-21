public class Personne {
    public static int Id=0;
    int Age ;
    String Nom;

    public Personne(int age, String nom) {
        Age = age;
        Nom = nom;
        Id++;
    }
}
