package br.com.douglas.projetocafe.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import br.com.douglas.projetocafe.MainActivity;
import br.com.douglas.projetocafe.Model.Itens;
import br.com.douglas.projetocafe.R;

public class ItensAdapter extends BaseAdapter {
    private final List<Itens> itens;
    private final Context context;

    public ItensAdapter(Context context, List<Itens> itens) {
        this.context = context;
        this.itens = itens;
    }

    @Override
    public int getCount() {
        return itens.size();
    }

    @Override
    public Object getItem(int position) {
        return itens.get(position);
    }

    @Override
    public long getItemId(int position) {
        return itens.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
         // TextView view=new TextView(context);
          Itens iten = itens.get(position);
          //view.setText(iten.toString());

        LayoutInflater inflater = LayoutInflater.from(context);
        View view= inflater.inflate(R.layout.list_item,parent,false);

        TextView campoNome = (TextView)view.findViewById(R.id.item_nome);
        campoNome.setText(iten.getNome());

        TextView campoValor = (TextView)view.findViewById(R.id.valor_item);
        //campoValor.setText((int) iten.getValor());
        String valor = String.valueOf(iten.getValor());
        campoValor.setText(valor);

        return view;
    }
}
