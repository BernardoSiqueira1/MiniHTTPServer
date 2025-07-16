package server.iohandlers.response;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public final class ResponseSender {

    public static void sendToClient(Socket clientConnection, String serializedResponse){
        try{
            OutputStream socketOutputStream = clientConnection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socketOutputStream));

            bufferedWriter.write(serializedResponse);
            bufferedWriter.flush();
            bufferedWriter.close();
        }
        catch (IOException ioException){
            System.out.println(String
                    .format("Failed to return to client.\n %s", (Object) clientConnection.getInetAddress().getAddress())
            );
        }
    }

}
