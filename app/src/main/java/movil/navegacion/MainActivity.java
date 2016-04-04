package movil.navegacion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import movil.navegacion.adapters.LibroAdapter;
import movil.navegacion.models.Libro;

public class MainActivity extends AppCompatActivity {

    ListView list;
    LibroAdapter adapter;
    List<Libro> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView) findViewById(R.id.list);
        data =  new ArrayList<>();
        adapter = new LibroAdapter(this, data);
        list.setAdapter(adapter);

        registerForContextMenu(list);

        loadLibros();

    }

    public void loadLibros(){
        Libro l1 = new Libro();
        l1.setNombre("Libro 1");
        l1.setAutor("Autor 1");

        Libro l2 = new Libro();
        l2.setNombre("Libro 2");
        l2.setAutor("Autor 2");

        Libro l3 = new Libro();
        l3.setNombre("Libro 3");
        l3.setAutor("Autor 3");

        data.add(l1);
        data.add(l2);
        data.add(l3);

        adapter.notifyDataSetChanged();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opc,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_add:
                Toast.makeText(this,"Seleccionaste Agregar",Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_about:
                Toast.makeText(this,"Seleccionaste Acerca de",Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_help:
                Toast.makeText(this,"Seleccionaste Ayuda",Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu_ctx, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_delete: break;
            case R.id.action_edit: break;
        }
        return super.onContextItemSelected(item);
    }
}
