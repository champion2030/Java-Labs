package laboratory_work_5;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {
    @Test
    public void tasks_test() throws CheckStringException {
        Task task1 = new Task("fghij,pqrst,abcde,uvwxy,klmno.");
        Assert.assertEquals(task1.tasks(), "abcde fghij klmno. pqrst uvwxy ");
    }
    @Test(expected = CheckStringException.class)
    public void task_test_exception() throws CheckStringException {
        Task task1 = new Task(".");
        task1.tasks();
    }
}