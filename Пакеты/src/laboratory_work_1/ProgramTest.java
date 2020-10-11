package laboratory_work_1;

import org.junit.Assert;
import org.junit.Test;

//import static org.junit.jupiter.api.Assertions.*;

public class ProgramTest {
    @Test
    public void task_test_9_methods() {
        Task task = new Task(10, true);
        Assert.assertEquals(task.minus(5), 5);
        Assert.assertEquals(task.multiply(5), 50);
        Assert.assertEquals(task.plus_equally(5), 15);
        Assert.assertEquals(task.logic_plus(5), 15);
        Assert.assertEquals(task.bit_bias(5), 0);
        Assert.assertTrue(task.operator_less(5, 6));
        Assert.assertTrue(task.operator_one_i(true));
        Assert.assertTrue(task.operator_two_i(true));
        Assert.assertTrue(task.operator_ravenstvo_i(true));
    }

    @Test
    public void task_test_5_prioritet_methods() {
        Task task = new Task(20, false);
        Assert.assertEquals(task.multiply_minus(5, 10), -30);
        Assert.assertEquals(task.multiply_plus_ravno(5, 10), 70);
        Assert.assertFalse(task.less_two_i_minus(5, 10));
        Assert.assertEquals(task.logic_plus_multiply(5, 10), 118);
        Assert.assertEquals(task.plus_ravno_minus(5, 10), 65);
    }

    @Test
    public void task_test_5_accociation_methods() {
        Task task = new Task(30, true);
        Assert.assertEquals(task.accociation_method_multiply(10), 3000);
        Assert.assertEquals(task.accociation_method_minus(10), 10);
        Assert.assertEquals(task.accociation_method_plus_ravno(10, 20), 60);
        Assert.assertEquals(task.accociation_method_del(10, 20), 0);
        Assert.assertEquals(task.accociation_method_plus(10, 20), 90);
    }
}