package org.example.lazyInit;

public class LazyInitApp {

    public static void main(String[] args) {
        System.out.println("Start!");
        ComputedResultBox box = new ComputedResultBox(100);

        printOut(box);
        printOut(box);
        System.out.println("Done!");
    }

    public static void printOut(ComputedResultBox box) {
        System.out.println("Number is: " + box.getResult());
    }







    //Code that executes slowly:
    public static Integer calculateNumber(Integer param) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return param * 100;
    }

}
