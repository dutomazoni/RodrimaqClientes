package com.example.rodrimaqclientes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class BuySellWindow extends AppCompatActivity {

    public static SQLiteDatabase usersDb;

    EditText tipoVeiculo , modeloVeiculo , marcaVeiculo , anoVeiculo , valorVeiculo;
    RadioGroup vendaOuCompra;
    String userId = RegisterWindow.curId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_sell_window);

        tipoVeiculo = (EditText) findViewById(R.id.ET_tipoVeiculo);
        modeloVeiculo = (EditText) findViewById(R.id.ET_modeloVeiculo);
        marcaVeiculo = (EditText) findViewById(R.id.ET_marcaVeiculo);
        anoVeiculo = (EditText) findViewById(R.id.ET_anoVeiculo);
        valorVeiculo = (EditText) findViewById(R.id.ET_valorVeiculo);

        vendaOuCompra = (RadioGroup) findViewById(R.id.compraOuVenda_question);

        try{
            usersDb = MainActivity.usersDb;
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void StartScreen (View view){
        Register();
        Toast.makeText(BuySellWindow.this, "Sucesso!", Toast.LENGTH_LONG).show();
        Intent intent = new Intent( this, MainActivity.class);
        startActivity(intent);
    }

    public void NewItem (View view){
        Register();
        Toast.makeText(BuySellWindow.this, "Sucesso!", Toast.LENGTH_LONG).show();
        Intent intent = new Intent( this, BuySellWindow.class);
        startActivity(intent);
    }

    public void Register ()
    {
        String tipoV = tipoVeiculo.getText().toString();
        String modeloV = modeloVeiculo.getText().toString();
        String marcaV = marcaVeiculo.getText().toString();
        String anoV = anoVeiculo.getText().toString();
        String valorV = valorVeiculo.getText().toString();


        int vendaOuCom = vendaOuCompra.getCheckedRadioButtonId();
        System.out.println("VENDA OU COMPRA = ");
        System.out.println(vendaOuCom);
        String respVouC = "";

        if(vendaOuCom == 2131230956) // Venda
        {
            respVouC = "Venda";
        }else{
            respVouC = "Compra";
        }



        String sql = "INSERT INTO itens " +
                "(vendaOuCompra, tipoVeiculo, modeloVeiculo, marcaVeiculo, anoVeiculo, valorVeiculo, userID)" +
                " VALUES (? , ? , ? , ? , ? , ? , ? )";

        SQLiteStatement statement = usersDb.compileStatement(sql);

        statement.bindString(1,respVouC);
        statement.bindString(2,tipoV);
        statement.bindString(3,modeloV);
        statement.bindString(4,marcaV);
        statement.bindString(5,anoV);
        statement.bindString(6,valorV);
        statement.bindString(7,userId);

        statement.execute();


    }
}