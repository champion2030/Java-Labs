package laboratory_work_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class laba2 {
    public static void main(String[] args) throws Exception{

        /*int[][] nums = new int[5][];
        nums[0] = new int[2];
        nums[1] = new int[4];
        nums[2] = new int[6];
        nums[3] = new int[5];
        nums[4] = new int[1];

        input_matrix(nums);
        System.out.println("Original matrix");
        output_matrix(nums);


        int[][] nums1 = new int[5][];
        nums1[0] = new int[3];
        nums1[1] = new int[5];
        nums1[2] = new int[7];
        nums1[3] = new int[6];
        nums1[4] = new int[2];
        change_matrix1(nums1,nums);
        System.out.println("Changed matrix nums");
        output_matrix(nums1);*/

        ArrayList<ArrayList<Integer>> listOLists = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> firstList = new ArrayList<Integer>();
        listOLists.add(firstList);

        ArrayList<Integer> secondList = new ArrayList<Integer>();
        listOLists.add(secondList);

        ArrayList<Integer> thirdList = new ArrayList<Integer>();
        listOLists.add(thirdList);

        ArrayList<Integer> fourthList = new ArrayList<Integer>();
        listOLists.add(fourthList);

        ArrayList<Integer> fifthList = new ArrayList<Integer>();

        listOLists.add(fifthList);

        input_list(firstList, secondList, thirdList, fourthList, fifthList);

        for(List p : listOLists){

            System.out.println(p);
        }
        firstList.add(0);
        secondList.add(0);
        thirdList.add(0);
        fourthList.add(0);
        fifthList.add(0);

        for(List p : listOLists){

            System.out.println(p);
        }

    }

    static void input_matrix(int[][] nums) {
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                System.out.printf("Enter array element [%d][%d] = ", i, j);
                while (!in.hasNextInt()) {
                    System.out.println("It is not a number, input again");
                    System.out.printf("Enter array element [%d][%d] = ", i, j);
                    in.next();
                }
                nums[i][j] = in.nextInt();
            }
            System.out.println();
        }
    }

    static void output_matrix(int[][] nums)
    {
        for (int[] num : nums) {
            for (int i : num) {
                System.out.printf("%d ", i);
            }
            System.out.println();
        }
    }


    // Добавляем 0 в последнюю ячейку матрицы
    static void change_matrix1(int[][] nums1, int[][]nums)
    {
        for (int i = 0; i < nums.length; i++) {
            System.arraycopy(nums[i], 0, nums1[i], 0, nums[i].length);
            nums1[i][nums1[i].length-1] = 0;
        }
    }

    static void input_list(ArrayList<Integer> first, ArrayList<Integer> second, ArrayList<Integer> third ,ArrayList<Integer> fourth, ArrayList<Integer> fifth) {
        Scanner in = new Scanner(System.in);
        int k;
        for (int i = 0; i < 2; i++) {
            System.out.print("Enter array element = ");
            while (!in.hasNextInt()) {
                System.out.println("It is not a number, input again");
                System.out.print("Enter array element = ");
                in.next();
            }
            k = in.nextInt();
            first.add(k);
        }


        for (int i = 0; i < 4; i++) {
            System.out.print("Enter array element = ");
            while (!in.hasNextInt()) {
                System.out.println("It is not a number, input again");
                System.out.print("Enter array element = ");
                in.next();
            }
            k = in.nextInt();
            second.add(k);
        }

        for (int i = 0; i < 6; i++) {
            System.out.print("Enter array element = ");
            while (!in.hasNextInt()) {
                System.out.println("It is not a number, input again");
                System.out.print("Enter array element [%d][%d] = ");
                in.next();
            }
            k = in.nextInt();
            third.add(k);
        }

        for (int i = 0; i < 5; i++) {
            System.out.print("Enter array element = ");
            while (!in.hasNextInt()) {
                System.out.println("It is not a number, input again");
                System.out.print("Enter array element = ");
                in.next();
            }
            k = in.nextInt();
            fourth.add(k);
        }


        System.out.print("Enter array element = ");
        while (!in.hasNextInt()) {
            System.out.println("It is not a number, input again");
            System.out.print("Enter array element = ");
            in.next();
        }
        k = in.nextInt();
        fifth.add(k);



    }
}
