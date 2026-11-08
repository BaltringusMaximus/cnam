import java.util.ArrayList;
import java.util.Scanner;
import java.util.Optional;
import java.lang.IllegalArgumentException;

//package javatest;
public class Date
{
    private int jour;
    private int mois;
    private int annee;
    private static final String[] listMonth = {"janvier","fevrier","mars","avril","mai","juin","juillet","aout","septembre","octobre","novembre","decembre"}; // add final to make it unmutable!
    public Date(int jour, int mois, int annee)
    {
        this.annee = annee;
        if (mois<=12 && mois>0){
            this.mois = mois;
        }
        else {throw new IllegalArgumentException("hey! input a valid month innit");}
        this.jour = jour;
    }
    public int getMois(){return this.mois;}
    public int getJour(){return this.jour;}
    public int getAnnee(){return this.annee;}
    public String getNomMois(){return listMonth[this.getMois()-1];}
    public String toString()
    {
        String date = String.format("\ndate = %d,%s,%d\n", this.jour, this.getNomMois(),this.getAnnee());
        System.out.println(date); // unnecessary, just for learning purpose
        return date;
    }
}
public class td3ex1
{
    public static void main(String[] args) 
    {
        Date date1 = null; // this is tricky! it appears that objects created inside a try/catch block are local to the try/catch block (https://stackoverflow.com/questions/12361378/accessing-a-file-object-outside-a-try-catch-block-that-creates-it-java)
                           // therefore, it should first be initialized OUTSIDE of a try/catch block
                           // otherwise, any call to this object outside of the try/catch will cause a "cannot find symbol" error
        try{
            date1 = new Date(1,12,2026);
            date1.toString();
            
        }
        catch (IllegalArgumentException e)
        {
            System.out.println(e);
        }
        date1.toString(); // possible iif it's been initialized outside the try/Catch block
        System.out.println("finished");
    }
}