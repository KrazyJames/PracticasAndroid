package mx.itson.practicaintentmail;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        (findViewById(R.id.btnEnviar)).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnEnviar:
                String destino = ((TextView)findViewById(R.id.txtCorreo)).getText().toString();
                String asunto = ((TextView)findViewById(R.id.txtAsunto)).getText().toString();
                String mensaje = ((TextView)findViewById(R.id.txtMensaje)).getText().toString();
                if (!destino.isEmpty() && !asunto.isEmpty()){
                    try {
                        Intent intent = new Intent (Intent.ACTION_VIEW , Uri.parse("mailto:" + destino));
                        intent.putExtra(Intent.EXTRA_SUBJECT, asunto);
                        intent.putExtra(Intent.EXTRA_TEXT, mensaje);
                        reiniciarCampos();
                        startActivity(intent);
                    } catch(Exception e) {
                        Toast.makeText(this, "Algo salio mal o no tienes una app para correos", Toast.LENGTH_SHORT).show();
                        e.printStackTrace();
                        System.out.println("Posible error: " + e.getMessage());
                    }
                }else{
                    Toast.makeText(this,"Inserte un asunto y destino para enviar", Toast.LENGTH_LONG).show();
                }
                break;
            default:
                break;
        }
    }

    public void reiniciarCampos(){
        ((TextView)findViewById(R.id.txtCorreo)).setText("");
        ((TextView)findViewById(R.id.txtAsunto)).setText("");
        ((TextView)findViewById(R.id.txtMensaje)).setText("");
    }
}
