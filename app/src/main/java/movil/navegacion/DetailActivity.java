package movil.navegacion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import movil.navegacion.models.Libro;
import movil.navegacion.util.C;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_POS = "pos";

    TextView titulo, autor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        titulo = (TextView) findViewById(R.id.titulo);
        autor = (TextView) findViewById(R.id.autor);

        int pos = getIntent().getIntExtra(EXTRA_POS,0);
        Libro l = C.data.get(pos);

        titulo.setText(l.getNombre());
        autor.setText(l.getAutor());

    }
}
