package Application;

import Server.Application;

import java.io.IOException;

public class MainApplication {

    public static void main(String[] args) throws IOException {

        System.out.println("Iniciando escuta na porta 8080");
        Application HTTPApp = new Application(8080);
        HTTPApp.listen();

    }

}
