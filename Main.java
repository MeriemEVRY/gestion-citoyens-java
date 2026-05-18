public class Main {

    public static void main(String[] args) {

        GestionComptes gestion =
                new GestionComptes();

        new VueConnexion(gestion);
    }
}