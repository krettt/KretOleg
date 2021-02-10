package lesson6exeption.thirdtask;

import java.nio.file.InvalidPathException;

public class App3 {
    public static void main(String[] args) {
        System.err.println("#1.in");
        App3.f();
        System.err.println("#1.out");
    }

    public static void f() {
        System.err.println(".   #2.in");
        try{
            App3.g();
        }catch (RuntimeException e){
            System.err.println(".\t#2.CATCH");
        }
        System.err.println(".   #2.out");
    }

    public static void g() {
        System.err.println(".   .   #3.in");
        App3.h();
        System.err.println(".   .   #3.out");
    }

    public static void h() {
        System.err.println(".   .   .   #4.in");
        try{
            System.err.println(".\t.\t.\t#4.THROW");
            throw new NumberFormatException();
        }catch (InvalidPathException e){

        }

        System.err.println(".   .   .   #4.out");
    }

}

