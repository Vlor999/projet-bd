import java.sql.*;
import java.util.Scanner;

public class etablirProduit {
    
    public static void afficherTousLesProduits(Connection connection, Scanner scanner) {
        try {
            Statement stmt = connection.createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM Produit");

            // Afficher l'en-tête
            String header = String.format(
                "%-15s %-30s %-15s %-10s %-20s %-30s", 
                "ID Produit", "Nom du Produit", "Prix Revient", "Stock", "Disponibilité", "Nom Catégorie"
            );
            System.out.println("-".repeat(header.length()));
            System.out.println(header);
            System.out.println("-".repeat(header.length()));

            // Afficher les données
            while (res.next()) {
                String row = String.format(
                    "%-15s %-30s %-15s %-10s %-20s %-30s",
                    res.getString("IdProduit"),
                    res.getString("NomProduit"),
                    res.getString("PrixRevient"),
                    res.getString("Stock"),
                    res.getString("DispoProduit"),
                    res.getString("NomCat")
                );
                System.out.println(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void afficherProduitSpécifique(Connection connection, Scanner scanner) {
        ResultSet res = null;
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Produit WHERE NomProduit LIKE ?");
            System.out.print("Nom du produit : ");
            String nomProduit = scanner.nextLine();
            statement.setString(1, "%" + nomProduit + "%");
            res = statement.executeQuery();

            // Afficher l'en-tête
            String header = String.format(
                "%-15s %-30s %-15s %-10s %-20s %-30s", 
                "ID Produit", "Nom du Produit", "Prix Revient", "Stock", "Disponibilité", "Nom Catégorie"
            );
            System.out.println("-".repeat(header.length()));
            System.out.println(header);
            System.out.println("-".repeat(header.length()));

            // Afficher les données
            while (res.next()) {
                String row = String.format(
                    "%-15s %-30s %-15s %-10s %-20s %-30s",
                    res.getString("IdProduit"),
                    res.getString("NomProduit"),
                    res.getString("PrixRevient"),
                    res.getString("Stock"),
                    res.getString("DispoProduit"),
                    res.getString("NomCat")
                );
                System.out.println(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void afficherProduitsDispnibles(Connection connection, Scanner scanner) {
        try {
            Statement stmt = connection.createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM Produit WHERE DISPOPRODUIT = 1");

            // Afficher l'en-tête
            String header = String.format(
                "%-15s %-30s %-15s %-10s %-20s %-30s", 
                "ID Produit", "Nom du Produit", "Prix Revient", "Stock", "Disponibilité", "Nom Catégorie"
            );
            System.out.println(header);
            System.out.println("-".repeat(header.length()));

            // Afficher les données
            while (res.next()) {
                String row = String.format(
                    "%-15s %-30s %-15s %-10s %-20s %-30s",
                    res.getString("IdProduit"),
                    res.getString("NomProduit"),
                    res.getString("PrixRevient"),
                    res.getString("Stock"),
                    res.getString("DispoProduit"),
                    res.getString("NomCat")
                );
                System.out.println(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
