import java.util.List;
public class Planning
{
    private String[][] timetable;
    private static List<String> days = List.of("lundi","mardi","mercredi","jeudi","vendredi");
    public Planning()
    {
        /*
        this.timetable = {
        {null,null,null,null,null,null,null,null,null,null},
        {null,null,null,null,null,null,null,null,null,null},
        {null,null,null,null,null,null,null,null,null,null},
        {null,null,null,null,null,null,null,null,null,null},
        {null,null,null,null,null,null,null,null,null,null}
        };
        */
        this.timetable = new String[5][10];
        System.out.println("Planning created");
    }

    public void reserver(String jour, int heure, String reservation)
    {
        
        if (days.contains(jour.toLowerCase()))
        {
            if (heure >= 9 && heure < 19)
            {
                if (this.timetable[days.indexOf(jour.toLowerCase())][heure-9] == null) //cannot use .equals() here: can't call .equals on a null string!
                {
                    this.timetable[days.indexOf(jour.toLowerCase())][heure-9] = reservation;
                    System.out.printf("booking %s %dh00 successful\n",jour, heure);
                }
                else{System.out.println("time slot already booked");}
            }
            else{System.out.println("gym is closed at this time");}            
        }
        else{System.out.printf("the day %s isn't valid\n",jour);}     
    }

    public void liberer(String jour, int heure)
    {
        if (days.contains(jour.toLowerCase()))
        {
            if (heure < 19 && heure >= 9)
            {
                if (this.timetable[days.indexOf(jour.toLowerCase())][heure-9] != null)
                {
                    this.timetable[days.indexOf(jour.toLowerCase())][heure-9] = null;
                    System.out.println("successfully freed time slot!");
                }
                else{System.out.println("time slot already free man");}
            }
            else{System.out.println("gym is closed at this time");}
        }
        else{System.out.println("day isn't valid");}
    }
    public String etatCreneau(String jour, int heure)
    {
        if (days.contains(jour.toLowerCase()))
        {
            if (heure < 19 && heure >= 9)
            {
                return this.timetable[days.indexOf(jour.toLowerCase())][heure-9];
            }
            return null;
        }
        return null;
    }
    public void displayTimeTable()
    {
        for (int i = 0; i<this.timetable.length ; i++)
        {
            System.out.print("\n" + days.get(i) + " : | ");
            for (String timeSlot : this.timetable[i])
            {
                if(timeSlot != null){System.out.print(timeSlot + " | ");}
                else{System.out.print("0 | ");}
                   
            }
            
        }
        System.out.println("");
        
    }
}
public class td3ex2
{
    public static void main(String[] args) {
        Planning planning1 = new Planning();
        planning1.reserver("MardI",15,"Printhigka");
        planning1.reserver("Lundi",9,"hector");
        planning1.reserver("Lundi",9,"hector");
        planning1.reserver("MardI",18,"Printhigka");
        System.out.println(planning1.etatCreneau("lundi", 9));
        planning1.displayTimeTable();
        planning1.liberer("Lundi", 9);
        planning1.liberer("Lundi", 9);
        planning1.displayTimeTable();
    }
}