class Animal:
    listId = []
    def __new__(self,id,nom,espece,age,regime):
        if (id in self.listId):
            print(f"couldn't instantiate the class, id {id} already exists")
            return
        else:
            self.listId.append(id)
            return super().__new__(self)
#            return self.__init__(self)

    def __init__(self,id,nom,espece,age,regime):
        self.id = id
        self.nom = nom
        self.espece = espece
        self.age = age
        self.regime = regime


    def getId(self):
        return self.id
    
    def getNom(self):
        return self.nom
    
    def getRegime(self):
        return self.regime
    
    def getEspece(self):
        return self.espece
    
    def getAge(self):
        return self.age
    
    def setAge(self,age):
        if(self.age > age):
            print("input age > actual age")
        else:
            self.age = age
    
    def toString(self):
        return f"{self.nom},{self.age},{self.espece},{self.regime},{self.id}"

class Zoo:
    __dictAnimal = dict()
    def __init__(self):
        print("hello!")

    def addAnimal(self,animal):
        self.__dictAnimal[animal.getId()] = animal
    
    def removeAnimalById(self,id):
        removedAnimal = self.__dictAnimal.pop(id)
        return removedAnimal


    def displayZoo(self):
        for id,animal in self.__dictAnimal.items():
            print(id, animal.toString())
    
    def searchAnimalById(self,id):
        if id in list(self.__dictAnimal.keys()):
            print(list(self.__dictAnimal.values())[list(self.__dictAnimal.keys()).index(id)].toString())
            return list(self.__dictAnimal.values())[list(self.__dictAnimal.keys()).index(id)]


    #much more pythonic! : 
    def searchAnimalById2(self,id):
        return self.__dictAnimal.get(id)

    def searchAnimalBySpecies(self,species):
        listAnimalBySpecies = []
        for animal in self.__dictAnimal.values():
            if animal.getEspece().lower() == species.lower():
                listAnimalBySpecies.append(animal)
        return listAnimalBySpecies

    def totalNumberOfAnimal(self):
        return len(self.__dictAnimal)

    def averageAgeOfAnimalBySpecies(self, species):
        sumAge = sum(animal.getAge() for animal in self.searchAnimalBySpecies(species))
        print(f"average age of {species} = {sumAge/len(self.searchAnimalBySpecies(species))}")
        return sumAge/len(self.searchAnimalBySpecies(species))
    

def main():
    animal1 = Animal(1,"hector","castor",10,"herbivore")
    print(type(animal1))
    animal1.toString()
    print(animal1.toString())
    animalF = Animal(1,"hector","castor",10,"herbivore")
    zoo = Zoo()
    zoo.addAnimal(animal1)
    print(zoo.searchAnimalById(1).toString())
    print(zoo.searchAnimalById2(1).toString())
    print(zoo.searchAnimalBySpecies("castor")[0].toString())
    print(zoo.averageAgeOfAnimalBySpecies("castor"))
    animal2 = Animal(2,"pascal","cheval",53,"herbivore")
    animal3 = Animal(3,"eleanor","castor",65,"herbivore")
    zoo.addAnimal(animal3)
    zoo.addAnimal(animal2)
    zoo.displayZoo()
    print(zoo.averageAgeOfAnimalBySpecies("castor"))
    animal3.setAge(54)
    animal3.setAge(98)
    print(zoo.averageAgeOfAnimalBySpecies("castor"))
    print("hello!", zoo.searchAnimalById2(3).toString())
    print("full zoo:")
    zoo.displayZoo()
    zoo.removeAnimalById(1)
    print("new zoo:")
    zoo.displayZoo()
    print(zoo.averageAgeOfAnimalBySpecies("cheval"))


if __name__ == '__main__':
    main()
