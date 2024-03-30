package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static final Integer PORT = 8080;

    public static void main(String[] args) throws IOException {

        while (true) {
            try (ServerSocket serverSocket = new ServerSocket(PORT)) {
                Socket clientSocket = serverSocket.accept();
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                String name = in.readLine();
                System.out.printf("Hi %s, your port is %d", name, clientSocket.getPort());
                out.println(clientSocket.getPort());
            }
        }
    }
}