package laboratory_work_1;

import java.util.Scanner;

public class laba1 {
    public static void first_lab() throws InputExeption {
        Scanner in = new Scanner(System.in);
        int a, key;
        boolean b = false;

        System.out.print("Input a = ");
        while (!in.hasNextInt()) {
            System.out.println("It is not a number, input again");
            System.out.print("Input a = ");
            in.next();
        }
        a = in.nextInt();

        do {
            System.out.println("Choose b");
            System.out.println("1 - b = true");
            System.out.println("2 - b = false");
            System.out.print("Your choice: ");
            key = in.nextInt();
            switch (key) {
                case 1 -> b = true;
                case 2 -> b = false;
                default -> System.out.println("Put correct number, please");
            }
        } while (key != 1 && key != 2);

        Task task = new Task(a, b);

        do {
            System.out.println("1 - (-)");
            System.out.println("2 - (*)");
            System.out.println("3 - (+=)");
            System.out.println("4 - (|)");
            System.out.println("5 - (>>=)");
            System.out.println("6 - (<)");
            System.out.println("7 - (&)");
            System.out.println("8 - (&&)");
            System.out.println("9 - (==)");
            System.out.println("Методы для проверки приоритетов");
            System.out.println("10 - (- и *)");
            System.out.println("11 - (+= и *)");
            System.out.println("12 - (< и &&)");
            System.out.println("13 - (| и *)");
            System.out.println("14 - (+= и -)");
            System.out.println("Методы для проверки ассоциативности");
            System.out.println("15 - (- и *)");
            System.out.println("16 - (+= и *)");
            System.out.println("17 - (< и &&)");
            System.out.println("18 - (| и *)");
            System.out.println("19 - (+= и -)");
            System.out.println("0 - Exit");
            System.out.print("Your choice: ");
            key = in.nextInt();
            switch (key) {
                case 1 -> task.minus(SetNumber());
                case 2 -> task.multiply(SetNumber());
                case 3 -> task.plus_equally(SetNumber());
                case 4 -> task.logic_plus(SetNumber());
                case 5 -> task.bit_bias(SetNumber());
                case 6 -> task.operator_less(SetNumber(), SetNumber());
                case 7 -> task.operator_one_i(SetBool());
                case 8 -> task.operator_two_i(SetBool());
                case 9 -> task.operator_ravenstvo_i(SetBool());
                case 10 -> task.multiply_minus(SetNumber(), SetSecondNumber());
                case 11 -> task.multiply_plus_ravno(SetNumber(), SetSecondNumber());
                case 12 -> task.less_two_i_minus(SetNumber(), SetSecondNumber());
                case 13 -> task.logic_plus_multiply(SetNumber(), SetSecondNumber());
                case 14 -> task.plus_ravno_minus(SetNumber(), SetSecondNumber());
                case 15 -> task.accociation_method_multiply(SetNumber());
                case 16 -> task.accociation_method_minus(SetNumber());
                case 17 -> task.accociation_method_plus_ravno(SetNumber(), SetSecondNumber());
                case 18 -> task.accociation_method_del(SetNumber(), SetSecondNumber());
                case 19 -> task.accociation_method_plus(SetNumber(), SetSecondNumber());
                case 0 -> { }
                default -> System.out.println("Put correct number, please");
            }
        } while (key != 0);
    }


    static int SetNumber() {
        int n;
        Scanner in = new Scanner(System.in);
        System.out.print("Input n = ");
        while (!in.hasNextInt()) {
            System.out.println("It is not a number, input again");
            System.out.print("Input n = ");
            in.next();
        }
        n = in.nextInt();
        return n;
    }

    static int SetSecondNumber() {
        int m;
        Scanner in = new Scanner(System.in);
        System.out.print("Input m = ");
        while (!in.hasNextInt()) {
            System.out.println("It is not a number, input again");
            System.out.print("Input m = ");
            in.next();
        }
        m = in.nextInt();
        return m;
    }

    static boolean SetBool() {
        boolean k = false;
        int key;
        Scanner in = new Scanner(System.in);
        do {
            System.out.println("Choose k");
            System.out.println("1 - k = true");
            System.out.println("2 - k = false");
            System.out.print("Your choice: ");
            key = in.nextInt();
            switch (key) {
                case 1 -> k = true;
                case 2 -> k = false;
                default -> System.out.println("Put correct number, please");
            }
        } while (key != 1 && key != 2);
        return k;
    }
}