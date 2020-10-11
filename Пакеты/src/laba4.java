import laboratory_work_1.laba1;
import laboratory_work_2.*;
import laboratory_work_3.*;

import java.util.Scanner;


public class laba4 {

    public static void main(String[] args) throws Exception {
        int key;
        Scanner in = new Scanner(System.in);
        do {

            System.out.println("1 - First laboratory work");
            System.out.println("2 - Second laboratory work");
            System.out.println("3 - Third laboratory work");
            System.out.println("4 - Exit");
            System.out.print("Your choice: ");
            key = in.nextInt();
            switch (key) {
                case 1:
                    laba1.first_lab();
                    break;
                case 2:
                    laba2.second_lab();
                    break;
                case 3:
                    laba_3.third_lab();
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Put correct number, please");
                    break;
            }
        } while (key != 4);
    }
}
