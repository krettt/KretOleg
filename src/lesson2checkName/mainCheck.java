package lesson2checkName;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class mainCheck {
    public static void main(String[] args) {

        System.out.println("Please input your surname and name(exemp.: Oleh Kret) : ");
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();


            Pattern p = Pattern.compile("[А-ЯA-Z][а-яa-z]+\s[А-ЯA-Z][а-яa-z]+");
            Matcher m = p.matcher(input);
            boolean b = m.matches();
            System.out.println(b);

    }
}