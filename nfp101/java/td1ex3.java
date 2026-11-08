import java.util.ArrayList;
import java.util.Scanner;
//package javatest;
public class td1ex3
{
    public static void main(String[] args) 
    {
        ArrayList<String> inventaire = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean bContinue = true;
        while (bContinue) 
        { 
            System.out.println("\n1. Ajouter un item");
            System.out.println("2. Supprimer un item");
            System.out.println("3. Afficher l'inventaire");
            System.out.println("4. quitter");
            String choix = scanner.nextLine();
            String item;
            switch (choix)
            {
                case "1":
                    System.out.println("Entrez le nom de l'item a ajouter");
                    item = scanner.nextLine();
                    System.out.println("you have input " + item);
                    inventaire.add(item);
                    break;
                case "2":
                    System.out.println("Entrez le nom de l’item a supprimer :");
                    item = scanner.nextLine();
                    System.out.println("you have input " + item);
                    if (inventaire.contains(item) == true)
                    {
                        inventaire.remove(item);
                        System.out.println(item + "a ete supprime de l’inventaire.");
                    }
                    else
                    {
                        System.out.println(item + "n'est pas dans l'inventaire");
                    }
                    break;
                case "3":
                    if (inventaire.size()>0)
                    {
                        System.out.println("inventaire actuel:");
                        for (String i:inventaire)
                        {
                            System.out.println(i);
                        }
                    }
                    else
                    {
                        System.out.println("inventaire vide");
                    }
                    break;
                case "4":
                    System.out.println("bye bye:)!");
                    bContinue = false;
                    break;
                default:
                    System.out.println("choose something else");
            }
        }

    }
}
