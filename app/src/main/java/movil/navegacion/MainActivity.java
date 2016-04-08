package movil.navegacion;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import movil.navegacion.adapters.LibroAdapter;
import movil.navegacion.models.Libro;
import movil.navegacion.util.C;

public class MainActivity extends AppCompatActivity implements DialogInterface.OnClickListener, AdapterView.OnItemClickListener {

    ListView list;
    LibroAdapter adapter;

    int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView) findViewById(R.id.list);
        C.data =  new ArrayList<>();
        adapter = new LibroAdapter(this, C.data);
        list.setAdapter(adapter);
        list.setOnItemClickListener(this);

        registerForContextMenu(list);

        loadLibros();

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        adapter.notifyDataSetChanged();
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

        C.data.add(l1);
        C.data.add(l2);
        C.data.add(l3);

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

                Intent intent = new Intent(this
                        , AddActivity.class);
                startActivity(intent);

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
        AdapterView.AdapterContextMenuInfo info =
                (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        pos = info.position;


        switch (item.getItemId()){
            case R.id.action_delete:
                showAlerteDelete();
                break;
            case R.id.action_edit: break;
        }
        return super.onContextItemSelected(item);
    }

    private void showAlerteDelete() {
        AlertDialog alert = new AlertDialog.Builder(this)
                .setTitle("Elinar")
                .setMessage("Esta seguro de eleminar el libro")
                .setPositiveButton("Aceptar",this)
                .setNegativeButton("Cancelar", this)
                .create();
        alert.show();
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        if(which == DialogInterface.BUTTON_POSITIVE){
            C.data.remove(pos);
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(DetailActivity.EXTRA_POS, position);
        startActivity(intent);
    }
}
