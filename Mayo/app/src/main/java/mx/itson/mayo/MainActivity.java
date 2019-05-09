package mx.itson.mayo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import mx.itson.mayo.entidades.Usuario;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
                    actualizarLista();
                    etNombre.setText("");
                    etCorreo.setText("");
                    etTelefono.setText("");
                    List<Usuario> usuarios = new Usuario(getApplicationContext()).getAll();
                    Toast.makeText(getApplicationContext(),
                            "Se añadió correctamente: " + usuarios.get(usuarios.size()-1).getNombre(), Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Faltan datos", Toast.LENGTH_LONG).show();
                }
            }
        });
        actualizarLista();
    }

    private void actualizarLista() {
        List<Usuario> usuarios = new Usuario(getApplicationContext()).getAll();
        ListView lista = findViewById(R.id.lvLista);
        List<String> nombres = new ArrayList<>();
        for (Usuario u : usuarios){
            nombres.add(u.getNombre());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                nombres);
        lista.setAdapter(adapter);
    }
}
