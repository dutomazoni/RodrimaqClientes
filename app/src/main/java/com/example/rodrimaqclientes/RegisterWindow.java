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
    EditText EndRes, NumRes , BairroRes , CidadeRes, UfRes , CepRes;
    EditText EndCom, NumCom , BairroCom , CidadeCom, UfCom , CepCom;
    RadioGroup EndCor;
    //EditText UrbQuant, ConstUrbQuant, UrbArea, ConstUrbArea, TerraEsc, TerraArea, ArrendadaArea, ArrendadaContrato, ArrendadaCusto, AreaTotal;
    EditText Venda, Compra;
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
        NumRes = (EditText) findViewById(R.id.ET_numRes);
        BairroRes = (EditText) findViewById(R.id.ET_bairroRes);
        CidadeRes = (EditText) findViewById(R.id.ET_cidadeRes);
        UfRes = (EditText) findViewById(R.id.ET_ufRes);
        CepRes = (EditText) findViewById(R.id.ET_cepRes);

        EndCom = (EditText) findViewById(R.id.ET_endCom);
        NumCom = (EditText) findViewById(R.id.ET_numCom);
        BairroCom = (EditText) findViewById(R.id.ET_bairroCom);
        CidadeCom = (EditText) findViewById(R.id.ET_cidadeCom);
        UfCom = (EditText) findViewById(R.id.ET_ufCom);
        CepCom = (EditText) findViewById(R.id.ET_cepCom);

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
        String numRes = NumRes.getText().toString();
        String bairroRes = BairroRes.getText().toString();
        String cidadeRes = CidadeRes.getText().toString();
        String ufRes = UfRes.getText().toString();
        String cepRes = CepRes.getText().toString();

        String endCom = EndCom.getText().toString();
        String numCom = NumCom.getText().toString();
        String bairroCom = BairroCom.getText().toString();
        String cidadeCom = CidadeCom.getText().toString();
        String ufCom = UfCom.getText().toString();
        String cepCom = CepCom.getText().toString();

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
                " endRes, numRes, bairroRes, cidadeRes, ufRes, cepRes," +
                " endCom, numCom, bairroCom, cidadeCom, ufCom, cepCom," +
                " endCorr)" +
                " VALUES (? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)";

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
        statement.bindString(11,numRes);
        statement.bindString(12,bairroRes);
        statement.bindString(13,cidadeRes);
        statement.bindString(14,ufRes);
        statement.bindString(15,cepRes);

        statement.bindString(16,endCom);
        statement.bindString(17,numCom);
        statement.bindString(18,bairroCom);
        statement.bindString(19,cidadeCom);
        statement.bindString(20,ufCom);
        statement.bindString(21,cepCom);

        statement.bindString(22,respCorr);

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