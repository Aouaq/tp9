package ex2.com.example.tp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
    public static List<Integer> readNumbers(String path) {
        List<Integer> list = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();            // suppression des espaces en début/fin
                if (line.isEmpty()) continue;  // ignorer les lignes vides

                // Conversion de la chaîne en entier
                list.add(Integer.parseInt(line));
            }

        } catch (IOException e) {
            // Gestion des erreurs d’E/S (fichier introuvable, permission…)
            System.err.println("I/O error: " + e.getMessage());

        } catch (NumberFormatException e) {
            // Gestion des lignes non convertibles en entier
            System.err.println("Format invalide dans le fichier: " + e.getMessage());
        }

        // Retourne la liste (peut être partiellement remplie)
        return list;
    }
}
