package com.example.rodrimaqclientes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;


public class RegisterWindow extends AppCompatActivity {

    public static SQLiteDatabase usersDb;

    EditText Nome , CodCliente , Filiacao , Cpf , Rg , Nasc , Celular , Fixo , Email;
    //EditText EstCivil, ConjNome , ConjCpf , ConjRg , ConjNasc;
    EditText EndRes, CidadeRes, CepRes;
    EditText EndCom, CidadeCom;
    RadioGroup EndCor;
    //EditText UrbQuant, ConstUrbQuant, UrbArea, ConstUrbArea, TerraEsc, TerraArea, ArrendadaArea, ArrendadaContrato, ArrendadaCusto, AreaTotal;
    static String curId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_window);

        Nome = (EditText) findViewById(R.id.ET_nome);
        CodCliente = (EditText) findViewById(R.id.ET_cod);
        Filiacao = (EditText) findViewById(R.id.ET_filiacao);
        Cpf = (EditText) findViewById(R.id.ET_cpf);
        Rg = (EditText) findViewById(R.id.ET_rg);
        Nasc = (EditText) findViewById(R.id.ET_nasc);
        Celular = (EditText) findViewById(R.id.ET_cel);
        Fixo = (EditText) findViewById(R.id.ET_fixo);
        Email = (EditText) findViewById(R.id.ET_email);

        /*EstCivil = (EditText) findViewById(R.id.ET_estCiv);
        ConjNome = (EditText) findViewById(R.id.ET_conj);
        ConjCpf = (EditText) findViewById(R.id.ET_cpfConj);
        ConjRg = (EditText) findViewById(R.id.ET_rgConj);
        ConjNasc = (EditText) findViewById(R.id.ET_nascConj);*/

        EndRes = (EditText) findViewById(R.id.ET_endRes);
        CidadeRes = (EditText) findViewById(R.id.ET_cidadeRes);
        CepRes = (EditText) findViewById(R.id.ET_cepRes);

        EndCom = (EditText) findViewById(R.id.ET_endCom);
        CidadeCom = (EditText) findViewById(R.id.ET_cidadeCom);

        EndCor = (RadioGroup) findViewById(R.id.endCorr_question);

        try{
            usersDb = MainActivity.usersDb;
        }catch (Exception e){
            e.printStackTrace();
        }

    }



    public void Register ()
    {
        String nome = Nome.getText().toString();
        String codCliente = CodCliente.getText().toString();
        String fili = Filiacao.getText().toString();
        String cpf = Cpf.getText().toString();
        String rg = Rg.getText().toString();
        String nasc = Nasc.getText().toString();
        String cel = Celular.getText().toString();
        String fixo = Fixo.getText().toString();
        String email = Email.getText().toString();

        String endRes = EndRes.getText().toString();
        String cidadeRes = CidadeRes.getText().toString();
        String cepRes = CepRes.getText().toString();

        String endCom = EndCom.getText().toString();
        String cidadeCom = CidadeCom.getText().toString();

        int endCor = EndCor.getCheckedRadioButtonId();
        System.out.println("ENDCOR = ");
        System.out.println(endCor);
        String respCorr = "";

        if(endCor == 2131230955) // RESIDENCIAL
        {
            respCorr = "Residencial";
        }else{
            respCorr = "Comercial";
        }


        String sql = "INSERT INTO users " +
                "(nome, codCliente, filiacao, cpf, rg, nasc, celular, fixo, email," +
                " endRes, cidadeRes, cepRes," +
                " endCom,cidadeCom," +
                " endCorr)" +
                " VALUES (? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)";

        SQLiteStatement statement = usersDb.compileStatement(sql);

        statement.bindString(1,nome);
        statement.bindString(2,codCliente);
        statement.bindString(3,fili);
        statement.bindString(4,cpf);
        statement.bindString(5,rg);
        statement.bindString(6,nasc);
        statement.bindString(7,cel);
        statement.bindString(8,fixo);
        statement.bindString(9,email);

        statement.bindString(10,endRes);
        statement.bindString(11,cidadeRes);
        statement.bindString(12,cepRes);

        statement.bindString(13,endCom);
        statement.bindString(14,cidadeCom);

        statement.bindString(15,respCorr);

        statement.execute();


    }

    public int getLastInsertedId(){
        String query = "SELECT id FROM users ORDER BY id DESC LIMIT 1";
        Cursor c = usersDb.rawQuery(query, null);
        int lastInsertedId = 0;
        while(c.moveToNext()){

            lastInsertedId = c.getInt(0);
        }
        c.close();

        return lastInsertedId;
    }

    public void BuySellReg (View view){
        Register();
        curId = Integer.toString(getLastInsertedId());
        System.out.println("CUR ID =");
        System.out.println(curId);
        Toast.makeText(RegisterWindow.this, "Pessoa Física Cadastrada com Sucesso!", Toast.LENGTH_LONG).show();
        Intent intent = new Intent( this, BuySellWindow.class);
        startActivity(intent);
    }

    public void StartScreen (View view){
        Register();
        Toast.makeText(RegisterWindow.this, "Pessoa Física Cadastrada com Sucesso!", Toast.LENGTH_LONG).show();
        Intent intent = new Intent( this, MainActivity.class);
        startActivity(intent);
    }
}