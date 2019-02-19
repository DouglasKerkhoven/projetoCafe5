package br.com.douglas.projetocafe.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import br.com.douglas.projetocafe.Model.Itens;
import br.com.douglas.projetocafe.Model.TratarLogin;

public class ItensDAO extends SQLiteOpenHelper {


    public ItensDAO(Context context) {
        super(context, "detalhes", null, 3);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql ="CREATE TABLE itens (id INTEREGER PRIMARY KEY , nome TEXT NOT NULL, valor REAL);";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS itens";
        db.execSQL(sql);
        onCreate(db);
        //insereLogin();


    }
    public void insereLogin(){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues dados = new ContentValues();
        dados.put("cpf","08105033950");
        dados.put("telefone","998612881");
        db.insert("usuario",null,dados);
    }
    public void insere(Itens itens)
    {

        SQLiteDatabase db = getWritableDatabase();
        ContentValues dados = new ContentValues();
        dados.put("nome","Coca");
        dados.put("valor",5.20);

        db.insert("itens",null,dados);
    }
    public List<TratarLogin> buscarDadosLogin(){
        //insereLogin();
        String sql = "SELECT * FROM usuario;";
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(sql,null);
        List<TratarLogin> login = new ArrayList<>();
        while (c.moveToNext()){
            TratarLogin logins = new TratarLogin();
            logins.setCpf(c.getString(c.getColumnIndex("cpf")));
            logins.setTelefone(c.getString(c.getColumnIndex("telefone")));
            login.add(logins);
        }
        c.close();
        return login;
    }
    public boolean validarLogin(String cpf,String telefone){
        boolean validou=false;
        String sql = "SELECT * FROM usuario;";
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(sql,null);
        while (c.moveToNext()){

            String cpfBanco = c.getString(c.getColumnIndex("cpf"));
            String telefoneBanco = c.getString(c.getColumnIndex("telefone"));
            if(cpfBanco.equals(cpf) && telefoneBanco.equals(telefone))
            {
                validou = true;
                break;
            }
        }
        c.close();
        return validou;
    }

    public List<Itens> buscarItens() {
        String sql = "SELECT * FROM itens;";
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(sql, null);
        List<Itens> itens = new ArrayList<Itens>();
        while (c.moveToNext()){
            Itens item = new Itens();
            item.setId(c.getLong(c.getColumnIndex("id")));
            item.setNome(c.getString(c.getColumnIndex("nome")));
            item.setValor(c.getDouble(c.getColumnIndex("valor")));
            itens.add(item);

        }
        c.close();
        return itens;
    }


}
