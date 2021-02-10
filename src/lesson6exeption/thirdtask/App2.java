package lesson6exeption.thirdtask;

public class App2 {
    public static void main(String[] args) {
        System.err.println("#1.in");
            App2.f();
        System.err.println("#1.out");
    }

    public static void f() {
        System.err.println(".   #2.in");
        App2.g();
        System.err.println(".   #2.out");
    }

    public static void g() {
        System.err.println(".   .   #3.in");
        try {
            App2.h();
        } catch (Error e){
            throw new RuntimeException(e);
        }
        System.err.println(".   .   #3.out");
    }

    public static void h() {
        System.err.println(".   .   .   #4.in");
        try {
            System.err.println(".\t.\t.\tTHROW");
            throw new Error();
        } catch (ArrayStoreException e) {

        }
        System.err.println(".   .   .   #4.out");
    }

}

