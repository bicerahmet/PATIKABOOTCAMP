package Numbers;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        ArrayList<Integer> numbers = new ArrayList<>();
        ArrayList<Integer> Q1 = new ArrayList<>(2500), Q2 = new ArrayList<>(25), Q3 = new ArrayList<>(25), Q4 = new ArrayList<>(25);


        //Creating the Arraylist that is consist of 10.000 consecutive integers.
        for(int i=1; i<=10000; i++){
            numbers.add(i);
        }

        //These are the 4 parts of our number
        Q4.addAll(numbers.subList(7500, 10000));     //4th Quarter
        Q3.addAll(numbers.subList(5000, 7500));      //3rd Quarter
        Q2.addAll(numbers.subList(2500, 5000));      //2nd Quarter
        Q1.addAll(numbers.subList(0, 2500));       //1st Quarter

        //We create 4 new thread for each of the quarters
        oddOrEven o1 = new oddOrEven(Q1);
        Thread t1 = new Thread(o1);

        oddOrEven o2 = new oddOrEven(Q2);
        Thread t2 = new Thread(o2);

        oddOrEven o3 = new oddOrEven(Q3);
        Thread t3 = new Thread(o3);

        oddOrEven o4 = new oddOrEven(Q4);
        Thread t4 = new Thread(o4);

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();

        System.out.println("Odds:");
        System.out.println(oddOrEven.oddNumbers.toString());
        System.out.println("Size of odd numbers: " + oddOrEven.oddNumbers.size());

        System.out.println("Evens:");
        System.out.println(oddOrEven.evenNumbers.toString());
        System.out.println("Size of even numbers: " + oddOrEven.evenNumbers.size());

    }
}
