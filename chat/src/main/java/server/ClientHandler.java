package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Arrays;

public class ClientHandler implements Runnable {
    private final String login;
    private final Socket socket;
    private final Server server;
    private final BufferedReader reader;
    private final PrintWriter writer;

    public ClientHandler(Socket socket, Server server) throws IOException {
        this.socket = socket;
        this.server = server;
        this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.writer = new PrintWriter(socket.getOutputStream(), true);

        this.login = reader.readLine();
    }

    public String getLogin() {
        return login;
    }

    public void send(String message){
        writer.println(message);
    }

    @Override
    public void run() {
        String message;
        try {
            while ((message = reader.readLine()) != null){
                if(message.startsWith("/")){

                    String[] tokens = message.split(" ");
                    String command = tokens[0];

                    switch (command) {
                        case "/online" -> server.online(this);
                        case "/w" -> {
                            if(tokens.length > 2){
                                String recipient = tokens[1];
                                String privateMsg = String.join(" ",
                                        Arrays.copyOfRange(tokens, 2, tokens.length));
                                server.whisper(privateMsg, this, recipient);
                            }
                        }
                    }
                }
                server.broadcast(login + ": "+ message, this);
            }
            socket.close();
        } catch (IOException e){
            throw new RuntimeException(e);
        }

    }
}
