def main():
    listMonth = ["janvier", "fevrier", "mars", "avril", "mai", "juin","juillet", "aout", "septembre", "octobre", "novembre", "decembre"]
    print("please input the month you're looking for")
    month = input().lower()
    print("input month = ",month)
    if (month in listMonth):
        print("month number ", listMonth.index(month)+1)
    else:
        print("input month not in list")

if (__name__ == '__main__'):
    main()