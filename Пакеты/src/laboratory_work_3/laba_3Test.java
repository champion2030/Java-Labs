/*package laboratory_work_3;

import org.junit.Assert;
import org.junit.Test;

//import static org.junit.jupiter.api.Assertions.*;

public class laba_3Test {
    @Test
    public void task_test() throws InputException {
        Work work = new Work();
        work.input_first_date(1, 1, 2020);
        work.input_second_date(31, 12, 2020);
        int count = work.task();
        Assert.assertEquals(count, 365);
    }

    @Test(expected = InputException.class)
    public void task_test_exception() throws InputException {
        Work work = new Work();
        work.input_first_date(5467, 1, 2020);
        work.input_second_date(31, 12, 2020);
        int count = work.task();
        Assert.assertEquals(count, 365);
    }
}*/