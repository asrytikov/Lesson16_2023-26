package p4;

import java.io.Console;

public class Main {

    public static void main(String[] args) {
        Console console = System.console();
        if (console!=null){
            String login = console.readLine("Login: ");
            char[] pass = console.readPassword("Password: ");

            console.printf("Login: %s \n", login);
            console.printf("Password: %s \n", new String(pass));
        }
    }

}
