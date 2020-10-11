package laboratory_work_7;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class laba7 {
    volatile static int a;
    static final List<Integer> numbers = Collections.synchronizedList(new ArrayList<Integer>());
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        a = 0;
        System.out.print("How many sides do you want to test? Input number = ");
        while (!in.hasNextInt()) {
            System.out.println("It is not a number, input again");
            System.out.print("Input a = ");
            in.next();
        }
        a = in.nextInt();
        new Input().start();
        new Task().start();
    }

    static class Input extends Thread {
        @Override
        public void run() {
            while (a != 0){
                synchronized (numbers)
                {
                    for(int i = 0; i < a; i++){
                        int b =  1 + (int) (Math.random() * 100);
                        numbers.add(b);
                        numbers.notify();
                    }
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Task extends Thread {
        @Override
        public void run() {
            count();
        }

        public synchronized void count(){
            while (a != 0)
            {
                synchronized (numbers)
                {
                    try {
                        numbers.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    int A = numbers.remove(0);
                    int p = (A*3)/2;
                    double S = Math.sqrt(p*(p-A)*(p-A)*(p-A));
                    System.out.println("Side = " + A);
                    System.out.println("Area = " + S);
                    a--;
                }
            }
        }
    }
}



