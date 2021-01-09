package com.example.rodrimaqclientes;

import androidx.appcompat.app.AppCompatActivity;

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
    LinearLayout table;
    public static SQLiteDatabase usersDb;


    ArrayList<String> datalist = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_window);

        try{
            usersDb = MainActivity.usersDb;
        }catch (Exception e){
            e.printStackTrace();
        }
        table = (LinearLayout) findViewById(R.id.table_layout);
        nomeBusca = (EditText) findViewById(R.id.ET_buscaCliente);


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
                    " JOIN itens WHERE users.id = userID AND nome= '" + nomebuscar +"'";


        try{
            Cursor c = usersDb.rawQuery(sql, null);

            int nomeIndex = c.getColumnIndex("nome");
            int celularIndex = c.getColumnIndex("celular");

            int emailIndex = c.getColumnIndex("email");
            int vendaOuCompraIndex = c.getColumnIndex("vendaOuCompra");
            int tipoVeiculoIndex = c.getColumnIndex("tipoVeiculo");
            int modeloVeiculoIndex = c.getColumnIndex("modeloVeiculo");
            int marcaVeiculoIndex = c.getColumnIndex("marcaVeiculo");
            int anoVeiculoIndex = c.getColumnIndex("anoVeiculo");
            int valorVeiculoIndex = c.getColumnIndex("valorVeiculo");


            if (c.moveToFirst()){
                do {
                    Log.i("Results - nome", c.getString(nomeIndex));
                    datalist.add(c.getString(nomeIndex));

                    Log.i("Results - cel", c.getString(celularIndex));
                    datalist.add(c.getString(celularIndex));



                    Log.i("Results - email", c.getString(emailIndex));
                    datalist.add(c.getString(emailIndex));

                    Log.i("Results - venda ou compra", c.getString(vendaOuCompraIndex));
                    datalist.add(c.getString(vendaOuCompraIndex));

                    Log.i("Results - tipo", c.getString(tipoVeiculoIndex));
                    datalist.add(c.getString(tipoVeiculoIndex));

                    Log.i("Results - modelo", c.getString(modeloVeiculoIndex));
                    datalist.add(c.getString(modeloVeiculoIndex));

                    Log.i("Results - marca", c.getString(marcaVeiculoIndex));
                    datalist.add(c.getString(marcaVeiculoIndex));

                    Log.i("Results - ano", c.getString(anoVeiculoIndex));
                    datalist.add(c.getString(anoVeiculoIndex));

                    Log.i("Results - valor", c.getString(valorVeiculoIndex));
                    datalist.add(c.getString(valorVeiculoIndex));



                }while (c.moveToNext());

            }
            createTitle(table);
            for(int i = 0; i<datalist.size(); i++)
            {
                createTable(table,i);
            }
        }catch( Exception e){
            e.printStackTrace();
        }

    }

    void createTitle(LinearLayout main){
        LinearLayout row = new LinearLayout(this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0, 7);
        row.setLayoutParams(params);
        row.setOrientation(LinearLayout.HORIZONTAL);
        row.setWeightSum(100);

        // your table title here

        String[] title={"Nome","Cel","Email","Venda ou Compra","Tipo Veículo","Modelo Veículo","Marca Veículo","Ano Veículo", "Valor Veículo"};


        for (int i = 0; i < 9; i++) {
            LinearLayout.LayoutParams textparam;
            //if(i == 2){
            //    textparam = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, (float) 20.285);
            //}else{
            textparam = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, (float) 13.285);
            //}
            TextView col1 = new TextView(this);
            col1.setText(title[i]);
            col1.setTextSize(13);
            col1.setPadding(0,0,0,0);
            col1.setLayoutParams(textparam);

            row.addView(col1);
        }
        main.addView(row);
    }

    void createTable(LinearLayout main,int pos) {

    }
}