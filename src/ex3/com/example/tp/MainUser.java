package ex3.com.example.tp;

public class MainUser {
    public static void main(String[] args) {
        User[] users = {
                new User("Alice", 30),   // valide
                new User("", 25),        // nom vide → invalide
                new User("Bob", 16)      // âge < 18 → invalide
        };

        for (User u : users) {
            try {
                u.validate();  // peut lancer InvalidUserException
                System.out.println("Utilisateur validé : " + u);
            } catch (InvalidUserException e) {
                // Gestion de l'erreur de validation
                System.err.println("Validation échouée : " + e.getMessage());
            }
        }
    }
}
