package laboratory_work_9;

public class laba9 {
    public static void main(String[] args) throws Exception {
        try{
            FileTest fileTest = new FileTest();
            fileTest.tasks_test();
            fileTest.task_test_exception();
        }catch (Exception ex){ System.out.println(ex.getMessage()); }
        /*FileWork fileWork = new FileWork("D://Второй курс//Работа с файлами//test.txt");
        System.out.println(fileWork.read_file());
        fileWork.write_result_file();
        System.out.println(fileWork.get_result_str());*/
    }
}
