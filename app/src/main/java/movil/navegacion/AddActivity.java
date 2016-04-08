package movil.navegacion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import movil.navegacion.models.Libro;
import movil.navegacion.util.C;

public class AddActivity extends AppCompatActivity implements View.OnClickListener {

    EditText nombre, autor;
    Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nombre = (EditText) findViewById(R.id.nombre);
        autor = (EditText) findViewById(R.id.autor);
        save = (Button) findViewById(R.id.btnSave);

        save.setOnClickListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home)
            finish();


        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        String n = nombre.getText().toString();
        String a = autor.getText().toString();

        Libro l =  new Libro();
        l.setAutor(a);
        l.setNombre(n);

        C.data.add(l);
        finish();
    }
}
