package br.com.douglas.projetocafe;

import android.content.Intent;
import android.os.Bundle;
//import android.support.design.widget.FloatingActionButton;
//import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import br.com.douglas.projetocafe.DAO.ItensDAO;
import br.com.douglas.projetocafe.Model.TratarLogin;

public class LoginActivity extends AppCompatActivity {

    private TratarLogin login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login = new TratarLogin(this);

        Button botaoLogar = (Button) findViewById(R.id.botaologin);

        botaoLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ItensDAO dao = new ItensDAO(getApplicationContext());
                List<TratarLogin> logins = dao.buscarDadosLogin();
                boolean verificaCampos=login.ValidarLogin();
                boolean valida = dao.validarLogin(login.getCpf(),login.getTelefone());
                if (valida) {
                    //Toast.makeText(LoginActivity.this, "Sucesso", Toast.LENGTH_SHORT).show();

                    Intent intentVaiPraLista = new Intent(LoginActivity.this, MainActivity.class); //inteção, a onde estou, vou para onde
                    startActivity(intentVaiPraLista);

                } else {
                    Toast.makeText(LoginActivity.this, "Cpf ou telefone errados", Toast.LENGTH_SHORT).show();
                }
            }
        });

        }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menulogin,menu);
        return super.onCreateOptionsMenu(menu);


    }
}
