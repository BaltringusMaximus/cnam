import java.util.ArrayList;
import java.util.Scanner;
//package javatest;
public class Book
{
    private String titre;
    private String auteur;
    private int anneePublication;
    private static int nombreTotalLivres = 0;
    public Book(String titre, String auteur, int anneePublication)
    {
        this.titre = titre;
        this.auteur = auteur;
        this.anneePublication = anneePublication;
        nombreTotalLivres += 1;
    }
    public String getTitre()
    {
        return titre;
    }
    public String getAuteur()
    {
        return auteur;
    }
    public int getAnneePublication()
    {
        return anneePublication;
    }
    public void setTitre(String titre)
    {
        this.titre = titre;
    }
    public void setAuteur(String auteur)
    {
        this.auteur = auteur;
    }
    public void setTitre(int anneePublication)
    {
        this.anneePublication = anneePublication;
    }
    public String afficherInfos()
    {
        return String.format("titre = %s auteur = %s anneePublication = %d, current number of books = %d",this.titre,this.auteur,this.anneePublication,this.nombreTotalLivres);
    }
    public static int getNombreTotalLivres()
    {
        return nombreTotalLivres;
    }
}

public class td2ex1
{
    public static void main(String[] args) 
    {
        Book book1 = new Book("Torah","G-d",0);
        System.out.println(book1.afficherInfos());
        System.out.println(book1.getNombreTotalLivres());
        book1.setTitre("Old Testament");
        System.out.println(book1.afficherInfos());
        Book book2 = new Book("Psalms","G-d",0);
        System.out.println(book2.afficherInfos());
        
    }
}