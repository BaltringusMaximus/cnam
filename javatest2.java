package javatest;
public class javatest2 {
    public static void main(String[] args) {
        String msgHelloWorld = "Hello, World3!";
	int age = 28;
	double price = 19.22;
	String name = "bididouille";
	String test = new String("teststring");
	int test2 = test.substring(0,3).length();
	int a,b,c;
	int x = 10, y=20;
	long longTest = 50L;
	float temperature = 36.5f;
    System.out.println(msgHelloWorld + " hello " +  msgHelloWorld.length());
	System.out.println(longTest + ' ' + temperature); // this line of code will return 118.5 for a reason, so don't print many different variables at the same time, it'll do some fonky business
	System.out.println(longTest);
	System.out.println(temperature); // do that instead to display each variable separately
	System.out.println(price);
	System.out.println(name.substring(0,3).toUpperCase());
	System.out.println(test2);

	int[] numbers;
	numbers = new int[5];
	System.out.println(numbers[0]);
	Integer objInteger = Integer.valueOf(21);
	System.out.println(objInteger);

    }
}