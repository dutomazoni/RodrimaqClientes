package com.example.rodrimaqclientes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class SearchWindow extends AppCompatActivity {

    EditText nomeBusca;
    public static SQLiteDatabase usersDb;

    TextView tableNomes, tableCelulares, tableFixos, tableEmails, tableVendasCompras, tableTiposVeiculos, tableModelosVeiculos, tableMarcasVeiculos, tableAnosVeiculos, tableValoresVeiculos;


    ArrayList<String> nomes = new ArrayList<>();
    ArrayList<String> celulares = new ArrayList<>();
    ArrayList<String> fixos = new ArrayList<>();
    ArrayList<String> emails = new ArrayList<>();
    ArrayList<String> vendasCompras = new ArrayList<>();
    ArrayList<String> tiposVeiculo = new ArrayList<>();
    ArrayList<String> modelosVeiculo = new ArrayList<>();
    ArrayList<String> marcasVeiculo = new ArrayList<>();
    ArrayList<String> anosVeiculo = new ArrayList<>();
    ArrayList<String> valoresVeiculo = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_window);

        try{
            usersDb = MainActivity.usersDb;
        }catch (Exception e){
            e.printStackTrace();
        }

        nomeBusca = (EditText) findViewById(R.id.ET_buscaCliente);
        tableNomes = (TextView) findViewById(R.id.ET_tableNome);
        tableCelulares = (TextView) findViewById(R.id.ET_tableCel);
        tableFixos = (TextView) findViewById(R.id.ET_tableFixo);
        tableEmails = (TextView) findViewById(R.id.ET_tableEmail);
        tableVendasCompras = (TextView) findViewById(R.id.ET_tableVendaOuCompra);
        tableTiposVeiculos = (TextView) findViewById(R.id.ET_tableTipoVeiculo);
        tableModelosVeiculos = (TextView) findViewById(R.id.ET_tableModeloVeiculo);
        tableMarcasVeiculos = (TextView) findViewById(R.id.ET_tableMarcaVeiculo);
        tableAnosVeiculos = (TextView) findViewById(R.id.ET_tableAnoVeiculo);
        tableValoresVeiculos = (TextView) findViewById(R.id.ET_tableValor);

    }


    public void GoSearch(View view)
    {
        String nomebuscar = nomeBusca.getText().toString();
        Log.i("Results - ", nomebuscar);
        //Funcao busca:
        String sql ="SELECT  " +
                    "nome," +
                    "celular," +
                    "fixo," +
                    "email," +
                    "vendaOuCompra," +
                    "tipoVeiculo," +
                    "modeloVeiculo," +
                    "marcaVeiculo," +
                    "anoVeiculo," +
                    "valorVeiculo" +
                    " FROM " +
                    " users " +
                    " JOIN itens WHERE users.id = userID AND nome LIKE '" + nomebuscar +"'";


        try{
            Cursor c = usersDb.rawQuery(sql, null);

            int nomeIndex = c.getColumnIndex("nome");
            int celularIndex = c.getColumnIndex("celular");
            int fixoIndex = c.getColumnIndex("fixo");
            int emailIndex = c.getColumnIndex("email");
            int vendaOuCompraIndex = c.getColumnIndex("vendaOuCompra");
            int tipoVeiculoIndex = c.getColumnIndex("tipoVeiculo");
            int modeloVeiculoIndex = c.getColumnIndex("modeloVeiculo");
            int marcaVeiculoIndex = c.getColumnIndex("marcaVeiculo");
            int anoVeiculoIndex = c.getColumnIndex("anoVeiculo");
            int valorVeiculoIndex = c.getColumnIndex("valorVeiculo");

            if (c.moveToFirst()){

                nomes.clear();
                celulares.clear();
                fixos.clear();
                emails.clear();
                vendasCompras.clear();
                tiposVeiculo.clear();
                modelosVeiculo.clear();
                marcasVeiculo.clear();
                anosVeiculo.clear();
                valoresVeiculo.clear();


                do {
                    //Log.i("Results - nome", c.getString(nomeIndex));
                    nomes.add(c.getString(nomeIndex));

                    //Log.i("Results - cel", c.getString(celularIndex));
                    celulares.add(c.getString(celularIndex));

                    //Log.i("Results - fixos", c.getString(fixoIndex));
                    fixos.add(c.getString(fixoIndex));

                    //Log.i("Results - email", c.getString(emailIndex));
                    emails.add(c.getString(emailIndex));

                    //Log.i("Results - venda ou compra", c.getString(vendaOuCompraIndex));
                    vendasCompras.add(c.getString(vendaOuCompraIndex));

                    //Log.i("Results - tipo", c.getString(tipoVeiculoIndex));
                    tiposVeiculo.add(c.getString(tipoVeiculoIndex));

                    //Log.i("Results - modelo", c.getString(modeloVeiculoIndex));
                    modelosVeiculo.add(c.getString(modeloVeiculoIndex));

                    //Log.i("Results - marca", c.getString(marcaVeiculoIndex));
                    marcasVeiculo.add(c.getString(marcaVeiculoIndex));

                    //Log.i("Results - ano", c.getString(anoVeiculoIndex));
                    anosVeiculo.add(c.getString(anoVeiculoIndex));

                    //Log.i("Results - valor", c.getString(valorVeiculoIndex));
                    valoresVeiculo.add(c.getString(valorVeiculoIndex));

                }while (c.moveToNext());

            }
            nomebuscar = "";
        }catch( Exception e){
            e.printStackTrace();
        }

        for(int i = 0; i < nomes.size(); i++)
        {
            tableNomes.setText(tableNomes.getText() + nomes.get(i) + "\n");
            tableCelulares.setText(tableCelulares.getText() + celulares.get(i) + "\n");
            tableFixos.setText(tableFixos.getText() + fixos.get(i) + "\n");
            tableEmails.setText(tableEmails.getText() + emails.get(i) + "\n");
            tableVendasCompras.setText(tableVendasCompras.getText() + vendasCompras.get(i) + "\n");
            tableTiposVeiculos.setText(tableTiposVeiculos.getText() + tiposVeiculo.get(i) + "\n");
            tableModelosVeiculos.setText(tableModelosVeiculos.getText() + modelosVeiculo.get(i) + "\n");
            tableMarcasVeiculos.setText(tableMarcasVeiculos.getText() + marcasVeiculo.get(i) + "\n");
            tableAnosVeiculos.setText(tableAnosVeiculos.getText() + anosVeiculo.get(i) + "\n");
            tableValoresVeiculos.setText(tableValoresVeiculos.getText() + valoresVeiculo.get(i) + "\n");
        }

    }

    public void cleanSearches (View view)
    {
            tableNomes.setText("");
            tableCelulares.setText("");
            tableFixos.setText("");
            tableEmails.setText("");
            tableVendasCompras.setText("");
            tableTiposVeiculos.setText("");
            tableModelosVeiculos.setText("");
            tableMarcasVeiculos.setText("");
            tableAnosVeiculos.setText("");
            tableValoresVeiculos.setText("");
    }

    public void startScreen(View view)
    {
        Intent intent = new Intent( this, MainActivity.class);
        startActivity(intent);
    }

}