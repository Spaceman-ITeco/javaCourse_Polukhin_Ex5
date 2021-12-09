package lesson3;

import java.util.Scanner;

public class DigitsConverterMain {
    private final String name;
    private final int number;

    public static  DigitsConverterMain  parseScanner()
    {
        Scanner input = new Scanner(System.in); // Объявляем Scanner
        System.out.println("Введите имя и число через пробел. Количество цифр в числе должно быть от 2 до 5.");
        String string=input.nextLine();
        String[] words = string.split(" ");
        String name = words[0];
        int number = Integer.parseInt(words[1]);
        int length = String.valueOf(number).length();
        if (length>=2 && length<=5 )
            return new DigitsConverterMain(name,number);
        else
            System.out.println("Количество цифр в числе должно быть от 2 до 5. Введите заново");
        return parseScanner();
    }

    public DigitsConverterMain (String name, int number)
    {   this.name = name;
        this.number = number;}

    static int sumOfDigit(int n)
    {
        if (n == 0)
            return 0;
        return (n % 10 + sumOfDigit(n / 10));
    }
    static int sumToOneDigitOrTen(int n) {
        if (n == 10)
            return 10;
        if(n/10 == 0) return n;
        return sumToOneDigitOrTen(sumOfDigit(n));
    }

    static String ConvertGreetingIntToString(int n)
    {
        String convert="";
        switch(n)
        {
            case 1 :
                convert = "единица";
                break;
            case 2 :
                convert = "два";
                break;
            case 3 :
                convert = "три";
                break;
            case 4 :
                convert = "четыре";
                break;
            case 5 :
                convert = "пять";
                break;
            case 6 :
                convert = "шесть";
                break;
            case 7 :
                convert = "семь";
                break;
            case 8 :
                convert = "восемь";
                break;
            case 9 :
                convert = "девять";
                break;
            case 10 :
                convert = "десять";
                break;
            default :
                System.out.println("Ошибка");
        }
        return convert;
    }

    public static void greetings(String name,String convertSum)
    {
        System.out.printf("Здравствуй, %s! Сумма цифр в числе = %s", name, convertSum);}

    public static void main(String[] args) {
        DigitsConverterMain digitsConverterMain = parseScanner();
        String name = digitsConverterMain.name;
        int sum = sumToOneDigitOrTen(digitsConverterMain.number);
        String convertSum  = ConvertGreetingIntToString(sum);
        greetings(name,convertSum);
    }
}

