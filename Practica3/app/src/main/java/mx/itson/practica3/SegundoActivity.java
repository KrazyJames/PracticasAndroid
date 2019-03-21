package mx.itson.practica3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class SegundoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segundo);
        Bundle b = getIntent().getExtras();
        String nombre = b.getString("nombre");
        Toast.makeText(this, nombre, Toast.LENGTH_SHORT).show();
        ((TextView) findViewById(R.id.lblRecibe)).setText(nombre);
    }
}
