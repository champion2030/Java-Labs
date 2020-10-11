package laboratory_work_9;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class FileTest {
    @Test
    public void tasks_test() throws CheckFileException, IOException {
        FileWork fileWork = new FileWork("test.txt");
        fileWork.read_file();
        fileWork.write_result_file();
        Assert.assertEquals(fileWork.read_file(), fileWork.get_result_str());
    }
    @Test(expected = CheckFileException.class)
    public void task_test_exception() throws CheckFileException, IOException {
        FileWork fileWork = new FileWork("test.txtd");
        fileWork.read_file();
        fileWork.write_result_file();
    }
}