package mx.itson.mayo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import mx.itson.mayo.database.MayoDB;
import mx.itson.mayo.entidades.Usuario;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new MayoDB(getApplicationContext(), "MayoDB", null, 1);
        final EditText etNombre = findViewById(R.id.etNombre);
        final EditText etCorreo = findViewById(R.id.etCorreo);
        final EditText etTelefono = findViewById(R.id.etTelefono);
        findViewById(R.id.btnGuardar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!etNombre.getText().toString().isEmpty() &&
                        !etCorreo.getText().toString().isEmpty() &&
                        !etTelefono.getText().toString().isEmpty()){
                    Usuario u = new Usuario(getApplicationContext());
                    u.guardar(etNombre.getText().toString(),etTelefono.getText().toString(), etCorreo.getText().toString());
                }else{
                    Toast.makeText(getApplicationContext(), "Faltan datos", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
