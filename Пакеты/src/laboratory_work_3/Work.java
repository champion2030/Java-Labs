package laboratory_work_3;

import java.util.Scanner;

public class Work {
    protected int d1, m1, g1;
    protected int d2, m2, g2;
    protected int g, d, d0, dm;

    public Work()
    {
        this.d1 = 0;
        this.m1 = 0;
        this.g1 = 0;
        this.d2 = 0;
        this.m2 = 0;
        this.g2 = 0;
        this.d = 0;
        this.d0 = 0;
        this.g = 0;
        this.dm = 0;
    }

    public void input_first_date() throws InputException
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Input first date");
        try {
            do {
                System.out.print("Input initial day: ");
                if(!in.hasNextInt())
                {
                    d1 = 1;
                    throw new InputException("It is not a correct number");
                }
                else
                {
                    d1 = in.nextInt();
                }

            }while (d1 < 1 || d1 > 31);

            do {
                System.out.print("Input initial month: ");
                if(!in.hasNextInt())
                {
                    m1 = 1;
                    throw new InputException("It is not a correct number");
                }
                else
                {
                    m1 = in.nextInt();
                }
            }while (m1 < 1 || m1 > 12);

            do {
                System.out.print("Input initial year: ");
                if(!in.hasNextInt())
                {
                    g1 = 2001;
                    throw new InputException("It is not a correct number");
                }
                else
                {
                    g1 = in.nextInt();
                }
            }while (g1 <= 1583 || g1 >= 4038);
        }
        catch (InputException ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    public void input_second_date()
    {
        Scanner in = new Scanner(System.in);
        try{
            do {
                System.out.print("Input final day: ");
                if(!in.hasNextInt())
                {
                    d2 = 31;
                    throw new InputException("It is not a correct number");
                }
                else
                {
                    d2 = in.nextInt();
                }
            }while (d2 < 1 || d2 > 31 || d2 == d1);

            do {
                System.out.print("Input final month: ");
                if(!in.hasNextInt())
                {
                    m2 = 12;
                    throw new InputException("It is not a correct number");
                }
                else
                {
                    m2 = in.nextInt();
                }
            }while (m1 < 1 || m1 > 12 || m2 == m1);

            do {
                System.out.print("Input final year: ");
                if(!in.hasNextInt())
                {
                    g2 = 2020;
                    throw new InputException("It is not a correct number");
                }
                else
                {
                    g2 = in.nextInt();
                }
            }while (g2 <= 1583 || g2 >= 4038);

        }
        catch (InputException ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    public int task() throws InputException {
        if(d1 == 0 || d2 == 0 || m1 == 0 || m2 == 0)
        {
            throw new InputException("An invalid date was entered");
        }
        else
        {
            g = g2 - g1;
            d0 = (g/4)+1;
            d = g * 365;
            d += d0;
            dm = func(m1,dm,d1,g1);
            d -= dm;
            dm = 0;
            dm = func(m2,dm,d2,g2);
            d += dm;
            return d;
        }
    }

    public int func(int m1, int dm, int d1, int g)
    {
        switch(m1)
        {
            case 1:
                dm = d1;
                break;
            case 2:
                dm=31+d1;
                break;
            case 3:
                if (g-(g/4)*4==0)dm=d1+60;
                else dm=59+d1;
                break;
            case 4:
                if (g-(g/4)*4==0)dm=91+d1;
                else dm=90+d1;
                break;
            case 5:
                if (g-(g/4)*4==0) dm=121+d1;
                else dm=120+d1;
                break;
            case 6:
                if (g-(g/4)*4==0) dm=152+d1;
                else dm=151+d1;
                break;
            case 7:
                if (g-(g/4)*4==0) dm=182+d1;
                else dm=181+d1;
                break;
            case 8:
                if (g-(g/4)*4==0) dm=213+d1;
                else dm=212+d1;
                break;
            case 9:
                if (g-(g/4)*4==0) dm=244+d1;
                else dm=243+d1;
                break;
            case 10:
                if (g-(g/4)*4==0) dm=274+d1;
                else dm=273+d1;
                break;
            case 11:
                if (g-(g/4)*4==0) dm=305+d1;
                else dm=304+d1;
                break;
            case 12:
                if (g-(g/4)*4==0) dm=335+d1;
                else dm=334+d1;
                break;
        }
        return dm;
    }
}
