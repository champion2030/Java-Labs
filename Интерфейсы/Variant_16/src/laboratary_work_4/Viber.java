package laboratary_work_4;

public class Viber implements Messenger{
    @Override
    public void sendMessage() {
        System.out.println("Send message in Viber");
    }

    @Override
    public void getMessage() {
        System.out.println("Get message in Viber");
    }
}
