package br.com.douglas.projetocafe.Model;

import android.widget.EditText;

import java.util.List;

import br.com.douglas.projetocafe.DAO.ItensDAO;
import br.com.douglas.projetocafe.LoginActivity;
import br.com.douglas.projetocafe.R;

public class TratarLogin {
    private EditText campoCpf;
    private EditText campoTelefone;
    private String cpf;
    private String telefone;

    public TratarLogin() {

    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }


    public  TratarLogin(LoginActivity activity) {
        campoCpf = (EditText) activity.findViewById(R.id.campo_Cpf);
        campoTelefone = (EditText) activity.findViewById(R.id.campo_telefone);
    }


    public boolean ValidarLogin() {


        cpf = campoCpf.getText().toString();
        telefone = campoTelefone.getText().toString();

        if(cpf!=null)
            return true;
        else
            return false;
        }
    }

