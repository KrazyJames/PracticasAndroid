package mx.itson.practica3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        (findViewById(R.id.btnNombre)).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnNombre:
                Intent intent = new Intent(this, SegundoActivity.class);
                String nombre = ((TextView) findViewById(R.id.txtNombre)).getText().toString();
                intent.putExtra("nombre", nombre);
                startActivity(intent);
                break;
            default:
                System.out.println("viwe id no valido");
                break;
        }
    }
}
