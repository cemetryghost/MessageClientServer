import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

@SuppressWarnings("InfiniteLoopStatement")
public class SqServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(1020)) {
            while (true) {
                Socket socket = serverSocket.accept();
                serverClient(socket);
            }
        }
    }

    private static void serverClient(Socket socket) throws IOException {
        String msg;
        System.out.println("Serving client" + socket.getInetAddress());

        DataInputStream inputStream = new DataInputStream(socket.getInputStream());
        DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

        msg = inputStream.readUTF();
        System.out.println("Сервер получил сообщение: " + msg);

        outputStream.writeUTF(msg);
        inputStream.close();
        outputStream.close();
    }
}
