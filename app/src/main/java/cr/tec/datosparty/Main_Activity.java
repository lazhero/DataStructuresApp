package cr.tec.datosparty;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import pl.droidsonroids.gif.GifImageView;

public class Main_Activity extends AppCompatActivity {
    ImageButton button;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_init);
        button=(ImageButton)findViewById(R.id.PlayButton);

    }
    public void Start(View view){
     // Intent intent=(Main_Activity.this)
    }

}
