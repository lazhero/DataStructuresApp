package cr.tec.datosparty;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import Socket.Client;
import cr.ac.tec.Info.Info;


public class Loging_Activity extends AppCompatActivity {
    EditText ip;
    EditText port;
    Button log;
    ProgressBar bar;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_activity);
        ip=(EditText)findViewById(R.id.roomN);
        port=(EditText)findViewById(R.id.code);
        log=(Button)findViewById(R.id.Log_Button);
        bar=(ProgressBar)findViewById(R.id.progressBar);
       bar.setVisibility(View.INVISIBLE);
    }
    public void log(View view){
       // bar.setVisibility(View.VISIBLE);
        String ip=getIp();
        int port=getPort();
        int[] array={1,2,3};
        Info info=new Info();
        info.setID(array);
        Client client=new Client(ip,port);
        client.setSend("init");
        Thread thread=new Thread(client);
        thread.start();
        try{
            Thread.sleep(200);
        }
        catch (Exception e){}
        if(client.getSucess()){

        }
        else {
            Toast.makeText(this,"Can't Log", Toast.LENGTH_SHORT).show();
        }

        bar.setVisibility(View.INVISIBLE);

    }
    private String getIp(){
        String base=ip.getText().toString();
        System.out.println(base);
        int len=base.length();
        if(len<=1)return null;
        return"192.168."+base.charAt(0)+"."+base.substring(1);
    }
    private int getPort(){
        String temp=port.getText().toString();
        if(temp.equals(""))return 0;
        int gotten=Integer.parseInt(temp);
        if(gotten<0)return 0;
        return gotten;
    }

}
