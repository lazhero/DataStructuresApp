package Socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import cr.ac.tec.Info.Info;

public class Client implements Runnable {
    private Socket socket;
    private int port;
    private String ip;
    private DataOutputStream DO;
    private DataInputStream DI;
    private ObjectOutputStream OO;
    private ObjectInputStream OI;
    private boolean Success=false;
    private Info info;
    private Object send;
    public Client(String ip,int Port){
        this.port=Port;
        this.ip=ip;
        connect();

    }

    @Override
    public void run() {
        if(socket==null || !socket.isConnected()) connect();
            try {

                OO.writeObject(this.send);
                System.out.println("Tuve correcta la escritura");
                info=(Info)OI.readObject();
                System.out.println("Tuve correcta la entrada");
                Success=true;

            }
            catch (Exception e){
                Success=false;

                connect();
                run();
            }


    }

    public void connect(){
        int i=100;
        while(socket==null && i>0) {
            try {
                socket = new Socket(ip, port);
                socket.setKeepAlive(true);
                DI = new DataInputStream(socket.getInputStream());
                DO = new DataOutputStream(socket.getOutputStream());
                OO = new ObjectOutputStream(socket.getOutputStream());
                OI = new ObjectInputStream(socket.getInputStream());

            } catch (Exception e) {
                socket = null;
                DI = null;
                DO = null;

            }
            i--;
        }

    }
    public boolean getSucess(){
        return this.Success;
    }
    public Info getInfo(){
        return info;
    }
    public void setSend(Object send){
        this.send=send;
    }
}
