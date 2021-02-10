package lesson6exeption;


import java.io.*;

public class SecondTask {
    public static void main(String[] args) throws IOException {

        FileWriter fileWriter = new FileWriter("secondTask.txt");
        fileWriter.write("Second Task!");
        fileWriter.close();

        SecondTask.createCorect();
        SecondTask.createUncorect();

    }

    public static void createCorect() throws IOException {
        try (FileReader fileReader = new FileReader("secondTask.txt");
             BufferedReader br = new BufferedReader(fileReader)) {
            System.out.println(br.readLine());

        }

    }

    public static void createUncorect() throws IOException {
        try (FileReader fileReader1 = new FileReader("empty.txt");
             BufferedReader br1 = new BufferedReader(fileReader1)) {
            System.out.println(br1.readLine());
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }
}

