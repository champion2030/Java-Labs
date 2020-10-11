package laboratory_work_1;

public class Task {
    public int a;
    public boolean b;

    Task(int a_value, boolean b_value){
        a = a_value;
        b = b_value;
    }

    public int minus(int n){
        System.out.println("a = " + a + " n = " + n);
        System.out.printf("Оператор -  : %d - %d = %d\n", a, n, a-n);
        return a-n;
    }
    public int multiply(int n){
        System.out.println("a = " + a + " n = " + n);
        System.out.printf("Оператор *  : %d * %d = %d\n", a, n, a*n);
        return a*n;
    }
    public int plus_equally(int n){
        System.out.println("a = " + a + " n = " + n);
        System.out.printf("Оператор +=  : %d += %d  Результат = %d\n", a, n, a+=n);
        return a;
    }
    public int logic_plus(int n){
        System.out.println("a = " + a + " n = " + n);
        System.out.printf("Оператор |  : %d | %d = %d\n", a, n, a|n); //| (логическое сложение в двоичном виде)
        return a|n;
    }
    public int bit_bias(int n){
        System.out.println("a = " + a + " n = " + n);
        System.out.printf("Оператор >>=  : %d >>= %d  Результат = %d\n", a, n, a>>=n); //смещает число a вправо на b разрядов
        return a;
    }
    public boolean operator_less(int n, int m){
        System.out.println(" n = " + n + " m = " + m);
        System.out.printf("Оператор < : %d < %d  %b\n", n, m, b = n < m);
        return b;
    }
    public boolean operator_one_i(boolean k){
        System.out.println("b = " + b + " k = " + k);
        System.out.printf("Оператор &  : %b & %b = %b\n", b, k, b&k); //y равно true, если и z, и x равны true, иначе y будет равно false
        return b&k;
    }
    public boolean operator_two_i(boolean k){
        System.out.println("b = " + b + " k = " + k);
        System.out.printf("Оператор &&  : %b && %b = %b\n", b, k, b&&k);
        return b&&k;
    }
    public boolean operator_ravenstvo_i(boolean k){
        System.out.println("b = " + b + " k = " + k);
        System.out.printf("Оператор ==  : %b == %b = %b\n", b, k, b == k);
        return b == k;
    }





    public int multiply_minus(int n, int m){
        System.out.println("a = " + a +" n = " + n + " m = " + m);
        System.out.printf("Операторы * и - : %d - %d * %d = %d\n", a, n, m, a-n*m);
        return a-n*m;
    }
    public int multiply_plus_ravno(int n, int m){
        System.out.println("a = " + a +" n = " + n + " m = " + m);
        System.out.printf("Операторы * и += : %d += %d * %d  %d\n", a, n, m, a+=n*m);
        return a;
    }
    public boolean less_two_i_minus(int n, int m){
        System.out.println("a = " + a +" n = " + n + " m = " + m);
        System.out.printf("Операторы < и && : (%d < %d) && (%d < %d) = %b\n", a, n, a, m, b = (a > n) && (a < m));
        return b;
    }
    public int logic_plus_multiply(int n, int m){
        System.out.println("a = " + a +" n = " + n + " m = " + m);
        System.out.printf("Операторы | и * : %d | %d * %d = %d\n", a, n, m, a|n*m);
        return a|n*m;
    }
    public int plus_ravno_minus(int n, int m){
        System.out.println("a = " + a +" n = " + n + " m = " + m);
        System.out.printf("Операторы += и - : %d += %d - %d Результат = %d\n", a, n, m, a += n - m);
        return a;
    }

    public int accociation_method_multiply(int n){
        System.out.println("a = " + a +" n = " + n);
        System.out.printf("Оператор * : %d * %d * %d = %d\n", a, n, n, a*n*n);
        return a*n*n;
    }
    public int accociation_method_minus(int n){
        System.out.println("a = " + a +" n = " + n);
        System.out.printf("Оператор - : %d - %d - %d = %d\n", a, n, n, a-n-n);
        return a-n-n;
    }
    public int accociation_method_plus_ravno(int n, int m){
        System.out.println("a = " + a +" n = " + n + " m = " + m);
        System.out.printf("Оператор += : %d += %d += %d = %d\n", a, n, m, a+=n+=m);
        return a;
    }
    public int accociation_method_del(int n, int m){
        System.out.println("a = " + a +" n = " + n + " m = " + m);
        System.out.printf("Оператор / : %d / %d / %d = %d\n", a, n, m, a / n / m);
        return a / n / m;
    }
    public int accociation_method_plus(int n, int m){
        System.out.println("a = " + a +" n = " + n + " m = " + m);
        System.out.printf("Оператор + : %d + %d + %d = %d\n", a, n, m, a+n+m);
        return a+n+m;
    }
}
