package laboratory_work_5;

import java.util.Arrays;
import java.util.Scanner;

public class laba_5 {
    public static void main(String[] args) throws CheckStringException {
        /*String key;
        Scanner in = new Scanner(System.in);;
        do {
            System.out.println("\n1 - Enter the string yourself");
            System.out.println("2 - Use a prepared string");
            System.out.println("3 - Exit");
            System.out.print("Your choice: ");
            key = in.nextLine();
            switch (key)
            {
                case "1":
                    Task task = new Task("");
                    task.SetStr();
                    System.out.println(task.tasks());
                    break;
                case "2":
                    Task task1 = new Task("fghij,pqrst,abcde,uvwxy,klmno.");
                    task1.tasks();
                    break;
                case "3":
                    break;
                default:
                    System.out.println("Enter correct number, please");
                    break;
            }
        }while (!key.equals("3"));*/
        try{
            TaskTest taskTest = new TaskTest();
            taskTest.tasks_test();
            taskTest.task_test_exception();
        }catch (Exception ex){ System.out.println(ex.getMessage()); }
    }
}
