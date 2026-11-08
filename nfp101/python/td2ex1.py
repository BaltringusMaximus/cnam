class Livre:
    __nombre_livre = 0

    def __init__(self,titre,auteur,annee_publication):
        self.titre = titre
        self.auteur = auteur
        self.annee_publication = annee_publication
        self.__nombre_livre = self.__nombre_livre + 1
        self.addBook()

    @classmethod
    def addBook(cls):
        cls.__nombre_livre += 1
    
    def getTitre(self):
        return self.titre

    def getAuteur(self):
        return self.auteur
    
    def getAnneePublication(cls):
        return cls.annee_publication
    
    def afficherInfos(self):
        return f"titre = {self.titre}, auteur = {self.auteur}, publié en {self.annee_publication}"

    @classmethod
    def getNombreLivre(self):
        return self.__nombre_livre

    def setTitre(self, titre):
        self.titre = titre
    
    def setAuteur(self,auteur):
        self.auteur = auteur

    def setAnneePublication(self, annee):
        self.annee_publication = annee   
    def __str__(self):
        return f"Livre({self.titre},{self.auteur},{self.annee_publication})"
    
def main():
    livre1 = Livre("Torah","G-d",0)
    print(livre1.afficherInfos())
    print(livre1)
    print(livre1.getNombreLivre())
    livre2 = Livre("book","anybody",2)
    print(livre2,"\n",livre2.afficherInfos(),livre2.getNombreLivre(),livre1.getNombreLivre())
    livre2.setTitre("storybook")
    print(livre2,"\n",livre2.afficherInfos(),livre2.getNombreLivre(),livre1.getNombreLivre())
    livre3 = Livre("bazingus","spoingus",2011)
    print(livre3,Livre.getNombreLivre())
if __name__ == '__main__':
    main()