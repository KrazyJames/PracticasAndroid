package mx.itson.intents;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        (findViewById(R.id.btnLlamar)).setOnClickListener(this);
        (findViewById(R.id.btnOtro)).setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btnLlamar){
            String destino = ((TextView)findViewById(R.id.txtNumero)).getText().toString().replaceAll("\\s+", "");
            if(!destino.isEmpty()&&destino.length()==10){
                Intent dial = new Intent(Intent.ACTION_DIAL,Uri.fromParts("tel", destino, null));
                startActivity(dial);
                ((TextView)findViewById(R.id.txtNumero)).setText("");
            }else{
                Toast.makeText(this,"Inserte un numero de 10 digitos",Toast.LENGTH_LONG).show();
            }
        }
        if(v.getId()==R.id.btnOtro){
            Intent otro = new Intent(getApplicationContext(), mx.itson.intents.otro.class);
            startActivity(otro);
        }
    }

}
