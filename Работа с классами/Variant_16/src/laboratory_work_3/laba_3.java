package laboratory_work_3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class laba_3 {
    public static void main(String[] args) throws InputException, ParseException {
        Scanner put = new Scanner(System.in);
        String key;
        do
        {
            System.out.println("Choose what do you want to do");
            System.out.println("1 - Put data");
            System.out.println("2 - Exit");
            System.out.print("Your choice: ");
            key = put.nextLine();
            switch (key)
            {
                case "1":
                    Work work = new Work();
                    work.input_first_date();
                    work.input_second_date();
                    System.out.println("Amount of days = " + work.task());
                    break;
                case "2":
                    break;
                default:
                    System.out.println("Put correct number");
                    break;
            }
        }while(!key.equals("2"));


    }
}


