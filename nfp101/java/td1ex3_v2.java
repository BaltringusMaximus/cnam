import java.util.ArrayList;
import java.util.Scanner;
public class td1ex3_v2
{
    private static void ajouter_item(ArrayList<String> arrayList, String string) // you have to specify the type of arraylist (if it's an array of strings or something)
    {
        arrayList.add(string);
        System.out.println("added item to the inventoory");
    }
    private static void supprimer_item(ArrayList<String> arrayList, String string)
    {
        if (arrayList.contains(string))
        {
            arrayList.remove(string);
            System.out.println("remove item " + string);
        }
        else
        {
            System.out.println(string + " not in the inventory");
        }
    }
    private static void display_inventory(ArrayList<String> arrayList)
    {
        if(arrayList.size()!=0)
        {
            for(String i : arrayList)
            {
                System.out.println(i);
            }
        }
        else
        {
            System.out.println("inventory empty");
        }
    }
    public static void main(String[] args) 
    {
        ArrayList <String> inventaire= new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean bContinue = true;
        String choice = new String();
        String item = new String();
        while(bContinue)
        {

            System.out.println("\n1. Ajouter un item");
            System.out.println("2. Supprimer un item");
            System.out.println("3. Afficher l’inventaire");
            System.out.println("4. Quitter");
            choice = scanner.nextLine();
            switch(choice)
            {
                case "1":
                    System.out.println("please type in the name of the item to put in the inventory");
                    item = scanner.nextLine();
                    ajouter_item(inventaire,item);
                    break;
                case "2":
                    System.out.println("please type in the name of the item to remove from the inventory");
                    item = scanner.nextLine();
                    supprimer_item(inventaire, item);
                    break;
                case "3":
                    System.out.println("displaying inventory");
                    display_inventory(inventaire);
                    break;
                case "4":
                    System.out.println("bye bye fren:)");
                    bContinue = false;
                    break;
                default:
                    System.out.println("please input a value between 1 and 4 only");
                    break;
            }
        }
        scanner.close();
    }
}