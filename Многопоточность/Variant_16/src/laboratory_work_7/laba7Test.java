package laboratory_work_7;


import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;


public class laba7Test {
    @Test
    public void tasks_test() throws ClassNotFoundException, NoSuchMethodException {
        Class myClass = Class.forName("laboratory_work_7.laba7$Task");
        Method myMethod;
        myMethod = myClass.getDeclaredMethod("count");
        Class params[] = new Class[1];
        params[0] = String.class;
        System.out.println("Method Name: " + myMethod.toString());
        System.out.println(Modifier.isSynchronized(myMethod.getModifiers()));
    }
}