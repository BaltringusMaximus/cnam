import java.util.ArrayList;
import java.util.Scanner;
import java.util.Optional;
import java.lang.IllegalArgumentException;
//package javatest;
public class Animal
{
    private int id;
    private String nom;
    private String espece;
    private int age;
    private String regime;
    private static ArrayList<Integer> idList = new ArrayList<Integer>();
    public Animal(int id, String nom, String espece, int age, String regime)
    {
        if (!idList.contains(Integer.valueOf(id)))
        {
            this.id = id;
            this.idList.add(id);
            AnimalConstructor(id, nom, espece, age, regime);
        }
        else
        {
            System.out.println("please input a different id");
//            throw new IllegalArgumentException("impossible to create an animal with this id\n");
            try{throw new IllegalArgumentException("impossible to create an animal with this id\n");}
            catch (IllegalArgumentException e) {System.out.println("carrying on..."); return;}
        }
    }
    private void AnimalConstructor(int id, String nom, String espece, int age, String regime)
    {
        this.nom = nom;
        this.espece = espece;
        this.age = age;
        this.regime = regime;
        return;
    }
    public int getId()
    {
        return id;
    }
    public String getNom()
    {
        return nom;
    }
    public String getEspece()
    {
        return espece;
    }
    public int getAge()
    {
        return age;
    }
    public String getRegime()
    {
        return regime;
    }
    public void setAge(int age)
    {
        if (age>this.age)
        {
            this.age = age;
        }
        else
        {
            System.out.printf("\nanimal is older than %d mate\n", age);
        }
    }
    public String toString()
    {
        return String.format("id %d name %s espece %s age %d diet %s",this.id, this.nom, this.espece, this.age, this.regime);
    }
}


public class Zoo
{
    private ArrayList<Animal> animaux;
    private ArrayList<Animal> animauxBySpecies;
    private Animal empty;
    private double averageAge;
    private double averageAgeSpecies;
    private int counter;
//    private static ArrayList<String> emptyArrayList = new ArrayList<>();
    public Zoo()
    {
        this.animaux = new ArrayList<Animal>();
        this.animauxBySpecies = new ArrayList<Animal>();
        this.empty = new Animal(0,"","",0,"");
        this.averageAge = 0;
        this.averageAgeSpecies = 0;
    }
    public void addAnimal(Animal animal)
    {
        if (animal.getId() != 0)
        {
            animaux.add(animal);
        }
        else
        {
            System.out.println("can't add this animal, it doesn't have a valid id");
        }

    }
    /*
    public void removeAnimal(int id)
    {
//        System.out.println(animaux.get(0).getId());
        for (Animal animal : animaux)
        {
            if (animal.getId() == id)
            {
                System.out.println("test");
                animaux.remove(animal);
            }
        }
    }
    */ // -> this doesn't work, you can't use an iterator like "Animal animal: animaux" to remove "animal", it throws a concurrency exception :/
    public void removeAnimal(int id)
    {
        for (int i = 0; i < animaux.size();i++)
        {
            if (animaux.get(i).getId() == id)
            {
                animaux.remove(i);
            }
        }
    }
    public Animal searchAnimal(int id)
    {
        for (Animal animal: animaux)
        {
            if (animal.getId() == id)
            {
                return animal;
            }
        }
//        return empty; -> not necessary , you can instead return null
        return null;
    }
    
    public ArrayList<Animal> searchAnimalBySpecies(String espece) // ---> don't forget the diamond operator!!!!! so that there needs not to cast things around later on
    {
//        animauxBySpecies.clear(); ---> will dereference previous list if function is called twice, so avoid this and instead do as follows:)
        ArrayList<Animal> animauxBySpecies = new ArrayList<Animal>(); // --> teacher didn't specify animal in the second operator
        for (Animal animal : animaux)
        {
            if (animal.getEspece().equalsIgnoreCase(espece)) // -> best practice
//            if (animal.getEspece() == espece)
            {
//                System.out.println(animal.getNom());
                animauxBySpecies.add(animal);
            }
        }
//        System.out.println("test");
//        System.out.println(animauxBySpecies.get(0).getNom());
        return (animauxBySpecies);
    }
    public void displayAnimal()
    {
        for (Animal animal : animaux)
        {
            System.out.println(animal.toString());
        }
    }
    public int countAnimal()
    {
        return animaux.size();
    }
    public String averageAgeOfAnimal()
    {
        averageAge = 0;
        for (Animal animal : animaux)
        {
            averageAge += (double)animal.getAge();
        }
        if (animaux.size() != 0)
        {
        return String.format("average age of animals = %.1f",averageAge/animaux.size());
        }
        else
        {
            return "zoo is empty mate";
        }
    }
    /*
    public String averageAgeOfAnimalBySpecies(String species)
    {
        averageAgeSpecies = 0;
        counter = 0;
        for (Animal animal : animaux)
        {
//            System.out.printf("\n%s %s %b\n",animal.getEspece(),species,animal.getEspece().equals(species));
//            if(animal.getEspece() == species) -> not good practice, always use object.method when u can
            if (animal.getEspece().equalsIgnoreCase(species))
            {
                averageAgeSpecies += animal.getAge();
                counter++;
            }
        }
        if (counter >0)
        {
            return String.format("average age of %s = %.1f",species,averageAgeSpecies/counter);
        }
        else
        {
            return String.format("no animal belongs to this species");
        }
    }
    */ // --> not best practice, instead do as follows:
    public String averageAgeOfAnimalBySpecies(String species)
    {
        averageAgeSpecies = 0;
//        ArrayList<Animal> animalBySpecies = this.searchAnimalBySpecies(species); --> not even needed since we marked this.searchAnimalBySpecies(species) as ArrayList<Animal>
//        ArrayList<Animal> animalBySpecies = (ArrayList<Animal>) this.searchAnimalBySpecies((String) species);
        for (Animal animal : this.searchAnimalBySpecies(species))
        {
            averageAgeSpecies += animal.getAge();
        }
        if (this.searchAnimalBySpecies(species).size() > 0)
        {
            return String.format("average age of %s = %.1f",species,averageAgeSpecies/this.searchAnimalBySpecies(species).size());
        }
        else
        {
            return String.format("no animal belongs to this species");
        }
    }
}
public class td2ex2
{
    public static void main(String args[])
    {
        Zoo zoo = new Zoo();
        ArrayList<Animal> animauxParEspece = new ArrayList<Animal>();
        Animal hector = new Animal(1,"hector","castor",157,"herbivore");
        Animal babor = new Animal(2,"babor","castor",15,"herbivore");
        Animal patric = new Animal(3,"patric","lombric",45,"carnivore");
        Animal arthur = new Animal(2,"arthur","lemur",15,"omnivore");

        System.out.println(arthur.toString());
        System.out.println(hector.toString());
        hector.setAge(2);
        System.out.println(hector.toString());
        hector.setAge(158);
        System.out.println(hector.toString());
        System.out.println(babor.toString());
        System.out.println(patric.toString());

  //      zoo.addAnimal(hector);
        zoo.addAnimal(hector);
        zoo.addAnimal(patric);
        zoo.addAnimal(babor);
        zoo.addAnimal(arthur);
        System.out.println(zoo.averageAgeOfAnimal());
        System.out.println(zoo.averageAgeOfAnimalBySpecies("castor"));
        System.out.println(zoo.countAnimal());
        System.out.println(zoo.searchAnimal(1).getNom());
        animauxParEspece = zoo.searchAnimalBySpecies((String) "castor");
        for (Animal animal : animauxParEspece)
        {
            System.out.println(animal.getNom());
        }
 //       System.out.println(animauxParEspece.get(0).getNom());
//        zoo.searchAnimalBySpecies("castor").get(0).getNom();// -> doesn't work for a reason
        String nom = ((ArrayList<Animal>)(zoo.searchAnimalBySpecies("castor"))).get(0).getNom(); //-> worked because I specified zoo.searchAnimalBySpecies should return an animal!
        System.out.println("here is why! " + nom);
//        System.out.println(animauxParEspece.get(0).getNom());
        zoo.displayAnimal();
        zoo.removeAnimal(1);

    }
}