import java.util.ArrayList;
import java.util.List;

public class oddOrEven implements Runnable{

    public ArrayList<Integer> Quarter;          //Temporary arraylist to hold the quarters
    public static ArrayList<Integer> oddNumbers = new ArrayList<>();
    public static ArrayList<Integer> evenNumbers = new ArrayList<>();

    private Object LOCK = new Object();     //LOCK Object that will be used to synchronize the threads.

    public oddOrEven(ArrayList<Integer> Q) {
        this.Quarter = Q;
    }

    @Override
    public void run() {
        for (int i = 0; i < this.Quarter.size(); i++) {
            synchronized(LOCK) {
                if (this.Quarter.get(i) % 2 == 1) {     //Odd numbers can not be divided by 2 without any remainder
                    oddNumbers.add(Quarter.get(i));
                } else {
                    evenNumbers.add(Quarter.get(i));
                }
            }
        }
    }

    public void print(){
        System.out.println("Odds: ");
        System.out.println(oddNumbers.toString());
        System.out.println("Evens: ");
        System.out.println(evenNumbers.toString());
    }

}
