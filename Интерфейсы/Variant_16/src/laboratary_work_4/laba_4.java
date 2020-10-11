package laboratary_work_4;

public class laba_4 {
    public static void main(String[] args) {
        SmartPhone smartPhone = new SmartPhone();
        Client client = new Client();
    }
}

/*Если бы мы использовали наследование, не смогли бы добавить объект Telegram в класс Smartphone. Ведь класс Telegram
не может наследоваться одновременно от Application и от Messenger
А мы уже успели унаследовать его от Messenger, и в таком виде добавить в класс Client.*/