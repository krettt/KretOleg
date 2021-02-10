package lesson6exeption;

import java.io.FileWriter;
import java.io.IOException;

import java.util.Scanner;


public class FirstTask {
    public static void main(String[] args) throws IOException {

       FirstTask.getCheckedEx();
        System.out.println("----------------------");
       FirstTask.getUncheckedEx();
    }

    public static void getCheckedEx() throws IOException {


        try {
            FirstTask.createFileWriter();
        } catch (IOException e) {
            System.out.println("Catch exception!\nAt first write then close!");
            FirstTask.createCorectFileWriter();
        }finally {
            System.out.println("Process successful!");
        }

    }
    public static void createFileWriter() throws IOException {
        FileWriter fileWriter = new FileWriter("out.txt");
        System.out.println("First time write in file!");
        fileWriter.close();
        fileWriter.write("Hello world");
    }
    public static void createCorectFileWriter() throws IOException {
        FileWriter fileWriter = new FileWriter("out.txt");
        System.out.println("Second time write in file!");
        fileWriter.write("Hello world");
        fileWriter.close();
    }


    public static void getUncheckedEx() {
        int[] testArray = {0, 1, 2};
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Input number");
            try {
                int a = scanner.nextInt();
                testArray[a] = 10 / a;
                break;
            } catch (ArithmeticException e) {
                System.out.println("Happened inadmissible operation,you can't input 0!");

            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Array haven't this index"+
                        "Input only : "+testArray.length);

            }
        }
    }
}
