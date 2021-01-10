package com.example.rodrimaqclientes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {



    public static SQLiteDatabase usersDb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        CreateAndUpdateDb();
        //ClearDb();
    }


    public void RegisterClient (View view){
        Intent intent = new Intent( this, RegisterWindow.class);
        startActivity(intent);
    }

    public void SearchClient (View view){
        Intent intent = new Intent( this, SearchWindow.class);
        startActivity(intent);
    }

    public void ShowAll (View view){
        Intent intent = new Intent( this, AdvSearchWindow.class);
        startActivity(intent);
    }

    public void ClearDb()
    {
        usersDb.delete("users" ,null,null);
        usersDb.delete("itens" ,null,null);
        System.out.println("LIMPOU TABELAS");

    }

    public void CreateAndUpdateDb()
    {


            usersDb = RegisterWindow.usersDb;
            usersDb = this.openOrCreateDatabase("Users", MODE_PRIVATE, null);

            usersDb.execSQL("CREATE TABLE IF NOT EXISTS users (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                    " nome VARCHAR, codCliente VARCHAR, filiacao VARCHAR, cpf VARCHAR, rg VARCHAR, nasc VARCHAR, celular VARCHAR, fixo VARCHAR, email VARCHAR," +
                    " endRes VARCHAR, numRes INTEGER, bairroRes VARCHAR, cidadeRes VARCHAR, ufRes VARCHAR, cepRes VARCHAR," +
                    " endCom VARCHAR, numCom INTEGER, bairroCom VARCHAR, cidadeCom VARCHAR, ufCom VARCHAR, cepCom VARCHAR," +
                    " endCorr VARCHAR )");

            System.out.println("criou tabela users");

            //usersDb = BuySellWindow.usersDb;

            usersDb.execSQL("CREATE TABLE IF NOT EXISTS itens (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                    " vendaOuCompra VARCHAR, tipoVeiculo VARCHAR, modeloVeiculo VARCHAR, marcaVeiculo VARCHAR, anoVeiculo VARCHAR, valorVeiculo INTEGER," +
                    " userID INTEGER," +
                    " FOREIGN KEY (userID) REFERENCES users (id) )");

            System.out.println("criou tabela itens");


    }


}