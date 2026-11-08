def main():
    listMonth = ["janvier", "fevrier", "mars", "avril", "mai", "juin","juillet", "aout", "septembre", "octobre", "novembre", "decembre"]
    print("please input the month you're looking for")
    month = input().lower()
    print("input month = ",month)
    numeroMois = -1
    for i in range(len(listMonth)):
        if listMonth[i] == month:
            numeroMois = i+1
    if numeroMois != 1:
        print(month," est le mois numéro", numeroMois)
    else:
        print(month," n'est pas un mois valide")

if (__name__ == '__main__'):
    main()