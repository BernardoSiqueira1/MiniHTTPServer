package server.iohandlers.response;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public final class ResponseSender {

    public static void sendToClient(Socket clientConnection, String serializedResponse){

        try{
            OutputStream outputStream = clientConnection.getOutputStream();

            outputStream.write(serializedResponse.getBytes(StandardCharsets.ISO_8859_1));
            outputStream.flush();
            outputStream.close();

            clientConnection.close();
        }

        catch (IOException ioException){
            System.out.println("Failed to return to client");
            ioException.printStackTrace();
        }

    }

}
