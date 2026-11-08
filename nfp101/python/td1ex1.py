def main():
    print("please input a temperature in Celsius")
    celsiusTemperature = float(input())
    fahrenheitTemperature = float(int(((celsiusTemperature*9/5)+32)*100)/100)
    print("temperature in Fahrenheit, rounded up to the 100th = \n unrounded temperature = ",fahrenheitTemperature, (celsiusTemperature*9/5)+32)

if __name__ == '__main__':
    main()