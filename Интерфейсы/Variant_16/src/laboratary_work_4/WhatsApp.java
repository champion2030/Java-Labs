package laboratary_work_4;

public class WhatsApp implements Messenger{
    @Override
    public void sendMessage() {
        System.out.println("Send message in WhatsApp");
    }

    @Override
    public void getMessage() {
        System.out.println("Get message in WhatsApp");
    }
}
