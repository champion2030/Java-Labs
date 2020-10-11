package laboratory_work_5;

import java.util.Arrays;
import java.util.Scanner;

public class Task{

    private String str;
    private String[] words;

    public Task(String str_value) {
        this.str = str_value;
        this.words = new String[4];
    }

    public void SetStr() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String name = in.nextLine().toLowerCase();
        String temp = name.replaceAll("\\s","");
        if(!temp.endsWith(".")) { this.str = temp + "."; }
        else { this.str = temp; }
    }

    public String tasks() throws CheckStringException {
        if (str.length() == 1) {
            throw new CheckStringException("You don't enter anything");
        } else {
            Arrays.sort(words = this.str.split(","));
            StringBuilder builder = new StringBuilder();
            for(String s :words) {
                builder.append(s).append(" ");
            }
            return builder.toString();
        }
    }
}
