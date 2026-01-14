package contacts;

public class Main {
    public static void main(String[] args) {
        ClientLogic clientLogic;
        if (args.length == 0) clientLogic = new ClientLogic("phonebook.db");
        else clientLogic = new ClientLogic(args[0]);
        clientLogic.start();
    }
}
