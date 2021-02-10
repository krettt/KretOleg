package lesson6exeption.thirdtask;

import java.nio.file.InvalidPathException;

public class App4 {
    public static void main(String[] args) {
        System.err.println("#1.in");
        App4.f();
        System.err.println("#1.out");
    }

    public static void f() {
        System.err.println(".   #2.in");
            App4.g();
        System.err.println(".   #2.out");
    }

    public static void g() {
        System.err.println(".   .   #3.in");
        try{
            App4.h();
        }catch (RuntimeException e){
            System.err.println(".\t.\t#3.CATCH");
        }
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
