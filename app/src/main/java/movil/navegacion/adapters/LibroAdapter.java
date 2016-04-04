package movil.navegacion.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import movil.navegacion.R;
import movil.navegacion.models.Libro;

/**
 * Created by Dario Chamorro on 4/04/2016.
 */
public class LibroAdapter extends BaseAdapter {

    Context context;
    List<Libro> data;

    public LibroAdapter(Context context, List<Libro> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if(v == null)
            v = View.inflate(context, R.layout.template_libro,null);

        Libro l = data.get(position);

        TextView nombre = (TextView) v.findViewById(R.id.nombre);
        TextView autor = (TextView) v.findViewById(R.id.autor);

        nombre.setText(l.getNombre());
        autor.setText(l.getAutor());

        return v;
    }
}
