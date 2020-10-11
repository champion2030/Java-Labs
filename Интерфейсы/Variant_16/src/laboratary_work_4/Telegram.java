package laboratary_work_4;

public class Telegram implements Messenger, Application{

    public Telegram()
    {
        install();
    }

    @Override
    public void sendMessage() {
        System.out.println("Send message in Telegram");
    }

    @Override
    public void getMessage() {
        System.out.println("Get message in Telegram");
    }

    @Override
    public void install() {
        System.out.println("Installation of Telegram finished");
    }

    @Override
    public void delete() {
        System.out.println("Uninstall of Telegram finished");
    }
}
