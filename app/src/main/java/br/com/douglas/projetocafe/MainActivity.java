package br.com.douglas.projetocafe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import br.com.douglas.projetocafe.DAO.ItensDAO;
import br.com.douglas.projetocafe.Model.Itens;
import br.com.douglas.projetocafe.Model.TratarLogin;
import br.com.douglas.projetocafe.adapter.ItensAdapter;

public class MainActivity extends AppCompatActivity {

    private Itens itens;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        itens = new Itens();

        ItensDAO dao = new ItensDAO(this);
        dao.insere(itens);
        List<Itens> itens = dao.buscarItens();
        dao.close();

        ListView listaItens = findViewById(R.id.lista_itens);
        ItensAdapter adapter = new ItensAdapter(this, itens);
        listaItens.setAdapter(adapter);
        //teste comit

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,final ContextMenu.ContextMenuInfo menuInfo) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        //final Itens itens= new (Itens) listaItens.getItemAtPosition(info.position);

        MenuItem teste = menu.add("Teste");
        teste.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
              //  ItensDAO dao = new  ItensDAO(MainActivity,this);
                Toast.makeText(MainActivity.this, "Fez alguma coisa", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }
}
