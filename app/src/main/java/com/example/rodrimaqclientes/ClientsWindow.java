package com.example.rodrimaqclientes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class ClientsWindow extends AppCompatActivity {

    public static SQLiteDatabase usersDb;
    TextView tableNomes, tableCelulares, tableFixos, tableEmails, tableCodCliente, tableFiliacao, tableCpf, tableRg, tableNasc,
             tableEndRes, tableNumRes, tableBairroRes, tableCidadeRes, tableUfRes, tableeCepRes,
             tableEndCom, tableNumCom, tableBairroCom, tableCidadeCom, tableUfCom, tableeCepCom,
             tableEndCor,
             tableVendasCompras, tableTiposVeiculos, tableModelosVeiculos, tableMarcasVeiculos, tableAnosVeiculos, tableValoresVeiculos;


    ArrayList<String> nomes = new ArrayList<>();
    ArrayList<String> cods = new ArrayList<>();
    ArrayList<String> filiacoes = new ArrayList<>();
    ArrayList<String> cpfs = new ArrayList<>();
    ArrayList<String> rgs = new ArrayList<>();
    ArrayList<String> nascs = new ArrayList<>();
    ArrayList<String> celulares = new ArrayList<>();
    ArrayList<String> fixos = new ArrayList<>();
    ArrayList<String> emails = new ArrayList<>();
    
    ArrayList<String> endRes = new ArrayList<>();
    ArrayList<String> numRes = new ArrayList<>();
    ArrayList<String> bairroRes = new ArrayList<>();
    ArrayList<String> cidadeRes = new ArrayList<>();
    ArrayList<String> ufRes = new ArrayList<>();
    ArrayList<String> cepRes = new ArrayList<>();

    ArrayList<String> endCom = new ArrayList<>();
    ArrayList<String> numCom = new ArrayList<>();
    ArrayList<String> bairroCom = new ArrayList<>();
    ArrayList<String> cidadeCom = new ArrayList<>();
    ArrayList<String> ufCom = new ArrayList<>();
    ArrayList<String> cepCom = new ArrayList<>();

    ArrayList<String> endCor = new ArrayList<>();
    
    ArrayList<String> vendasCompras = new ArrayList<>();
    ArrayList<String> tiposVeiculo = new ArrayList<>();
    ArrayList<String> modelosVeiculo = new ArrayList<>();
    ArrayList<String> marcasVeiculo = new ArrayList<>();
    ArrayList<String> anosVeiculo = new ArrayList<>();
    ArrayList<String> valoresVeiculo = new ArrayList<>();
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clients_window);

        try{
            usersDb = MainActivity.usersDb;
        }catch (Exception e){
            e.printStackTrace();
        }
        
        tableNomes = (TextView) findViewById(R.id.ET_tableNome);
        tableCodCliente = (TextView) findViewById(R.id.ET_tableCodCliente);
        tableFiliacao = (TextView) findViewById(R.id.ET_tableFiliacao);
        tableCpf = (TextView) findViewById(R.id.ET_tableCpf);
        tableRg = (TextView) findViewById(R.id.ET_tableRg);
        tableNasc = (TextView) findViewById(R.id.ET_tableNasc);
        tableCelulares = (TextView) findViewById(R.id.ET_tableCel);
        tableFixos = (TextView) findViewById(R.id.ET_tableFixo);
        tableEmails = (TextView) findViewById(R.id.ET_tableEmail);

        tableEndRes = (TextView) findViewById(R.id.ET_tableEndRes);
        tableNumRes = (TextView) findViewById(R.id.ET_tableNumRes);
        tableBairroRes = (TextView) findViewById(R.id.ET_tableBairroRes);
        tableCidadeRes = (TextView) findViewById(R.id.ET_tableCidadeRes);
        tableUfRes = (TextView) findViewById(R.id.ET_tableUfRes);
        tableeCepRes = (TextView) findViewById(R.id.ET_tableCepRes);

        tableEndCom = (TextView) findViewById(R.id.ET_tableEndCom);
        tableNumCom = (TextView) findViewById(R.id.ET_tableNumCom);
        tableBairroCom = (TextView) findViewById(R.id.ET_tableBairroCom);
        tableCidadeCom = (TextView) findViewById(R.id.ET_tableCidadeCom);
        tableUfCom = (TextView) findViewById(R.id.ET_tableUfCom);
        tableeCepCom = (TextView) findViewById(R.id.ET_tableCepCom);

        tableVendasCompras = (TextView) findViewById(R.id.ET_tableVendaOuCompra);
        tableTiposVeiculos = (TextView) findViewById(R.id.ET_tableTipoVeiculo);
        tableModelosVeiculos = (TextView) findViewById(R.id.ET_tableModeloVeiculo);
        tableMarcasVeiculos = (TextView) findViewById(R.id.ET_tableMarcaVeiculo);
        tableAnosVeiculos = (TextView) findViewById(R.id.ET_tableAnoVeiculo);
        tableValoresVeiculos = (TextView) findViewById(R.id.ET_tableValor);


    }

    public void ShowClients(View view)
    {

        try{
            Cursor c = usersDb.rawQuery("SELECT * FROM users JOIN itens WHERE users.id = userID ", null);

            int nomeIndex = c.getColumnIndex("nome");
            int codClienteIndex = c.getColumnIndex("codCliente");
            int filiacaoIndex = c.getColumnIndex("filiacao");
            int cpfIndex = c.getColumnIndex("cpf");
            int rgIndex = c.getColumnIndex("rg");
            int nascIndex = c.getColumnIndex("nasc");
            int celularIndex = c.getColumnIndex("celular");
            int fixoIndex = c.getColumnIndex("fixo");
            int emailIndex = c.getColumnIndex("email");

            int endResIndex = c.getColumnIndex("endRes");
            int numResIndex = c.getColumnIndex("numRes");
            int bairroResIndex = c.getColumnIndex("bairroRes");
            int cidadeResIndex = c.getColumnIndex("cidadeRes");
            int ufResIndex = c.getColumnIndex("ufRes");
            int cepResIndex = c.getColumnIndex("cepRes");

            int endComIndex = c.getColumnIndex("endCom");
            int numComIndex = c.getColumnIndex("numCom");
            int bairroComIndex = c.getColumnIndex("bairroCom");
            int cidadeComIndex = c.getColumnIndex("cidadeCom");
            int ufComIndex = c.getColumnIndex("ufCom");
            int cepComIndex = c.getColumnIndex("cepCom");
//
//            int endCorrIndex = c.getColumnIndex("endCorr");
            
            int vendaOuCompraIndex = c.getColumnIndex("vendaOuCompra");
            int tipoVeiculoIndex = c.getColumnIndex("tipoVeiculo");
            int modeloVeiculoIndex = c.getColumnIndex("modeloVeiculo");
            int marcaVeiculoIndex = c.getColumnIndex("marcaVeiculo");
            int anoVeiculoIndex = c.getColumnIndex("anoVeiculo");
            int valorVeiculoIndex = c.getColumnIndex("valorVeiculo");

            if (c.moveToFirst()){

                nomes.clear();
                cods.clear();
                filiacoes.clear();
                cpfs.clear();
                rgs.clear();
                nascs.clear();
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

                    //Log.i("Results - nome", c.getString(nomeIndex));
                    cods.add(c.getString(codClienteIndex));

                    //Log.i("Results - nome", c.getString(nomeIndex));
                    filiacoes.add(c.getString(filiacaoIndex));

                    //Log.i("Results - nome", c.getString(nomeIndex));
                    cpfs.add(c.getString(cpfIndex));

                    //Log.i("Results - nome", c.getString(nomeIndex));
                    rgs.add(c.getString(rgIndex));

                    //Log.i("Results - nome", c.getString(nomeIndex));
                    nascs.add(c.getString(nascIndex));

                    //Log.i("Results - cel", c.getString(celularIndex));
                    celulares.add(c.getString(celularIndex));

                    //Log.i("Results - fixos", c.getString(fixoIndex));
                    fixos.add(c.getString(fixoIndex));

                    //Log.i("Results - email", c.getString(emailIndex));
                    emails.add(c.getString(emailIndex));

                    //Log.i("Results - nome", c.getString(nomeIndex));
                    endRes.add(c.getString(endResIndex));

                    //Log.i("Results - nome", c.getString(nomeIndex));
                    numRes.add(c.getString(numResIndex));

                    //Log.i("Results - nome", c.getString(nomeIndex));
                    bairroRes.add(c.getString(bairroResIndex));

                    //Log.i("Results - nome", c.getString(nomeIndex));
                    cidadeRes.add(c.getString(cidadeResIndex));

                    //Log.i("Results - nome", c.getString(nomeIndex));
                    ufRes.add(c.getString(ufResIndex));

                    //Log.i("Results - nome", c.getString(nomeIndex));
                    cepRes.add(c.getString(cepResIndex));

                    endCom.add(c.getString(endComIndex));
                    numCom.add(c.getString(numComIndex));
                    bairroCom.add(c.getString(bairroComIndex));
                    cidadeCom.add(c.getString(cidadeComIndex));
                    ufCom.add(c.getString(ufComIndex));
                    cepCom.add(c.getString(cepComIndex));

                    //endCor.add(c.getString(endCorrIndex));
                    
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

        }catch( Exception e){
            e.printStackTrace();
        }

        for(int i = 0; i < nomes.size(); i++)
        {
            tableNomes.setText(tableNomes.getText() + nomes.get(i) + "\n");
            tableCodCliente.setText(tableCodCliente.getText() + cods.get(i) + "\n");
            tableFiliacao.setText(tableFiliacao.getText() + filiacoes.get(i) + "\n");
            tableCpf.setText(tableCpf.getText() + cpfs.get(i) + "\n");
            tableRg.setText(tableRg.getText() + rgs.get(i) + "\n");
            tableNasc.setText(tableNasc.getText() + nascs.get(i) + "\n");
            tableCelulares.setText(tableCelulares.getText() + celulares.get(i) + "\n");
            tableFixos.setText(tableFixos.getText() + fixos.get(i) + "\n");
            tableEmails.setText(tableEmails.getText() + emails.get(i) + "\n");

            tableEndRes.setText(tableEndRes.getText() + endRes.get(i) + "\n");
            tableNumRes.setText(tableNumRes.getText() + numRes.get(i) + "\n");
            tableBairroRes.setText(tableBairroRes.getText() + bairroRes.get(i) + "\n");
            tableCidadeRes.setText(tableCidadeRes.getText() + cidadeRes.get(i) + "\n");
            tableUfRes.setText(tableUfRes.getText() + ufRes.get(i) + "\n");
            tableeCepRes.setText(tableeCepRes.getText() + cepRes.get(i) + "\n");

            tableEndCom.setText(tableEndCom.getText() + endCom.get(i) + "\n");
            tableNumCom.setText(tableNumCom.getText() + numCom.get(i) + "\n");
            tableBairroCom.setText(tableBairroCom.getText() + bairroCom.get(i) + "\n");
            tableCidadeCom.setText(tableCidadeCom.getText() + cidadeCom.get(i) + "\n");
            tableUfCom.setText(tableUfCom.getText() + ufCom.get(i) + "\n");
            tableeCepCom.setText(tableeCepCom.getText() + cepCom.get(i) + "\n");

            //tableEndCor.setText(tableEndCor.getText() + endCor.get(i) + "\n");
            
            tableVendasCompras.setText(tableVendasCompras.getText() + vendasCompras.get(i) + "\n");
            tableTiposVeiculos.setText(tableTiposVeiculos.getText() + tiposVeiculo.get(i) + "\n");
            tableModelosVeiculos.setText(tableModelosVeiculos.getText() + modelosVeiculo.get(i) + "\n");
            tableMarcasVeiculos.setText(tableMarcasVeiculos.getText() + marcasVeiculo.get(i) + "\n");
            tableAnosVeiculos.setText(tableAnosVeiculos.getText() + anosVeiculo.get(i) + "\n");
            tableValoresVeiculos.setText(tableValoresVeiculos.getText() + valoresVeiculo.get(i) + "\n");
        }

    }

    public void startScreen(View view)
    {
        Intent intent = new Intent( this, MainActivity.class);
        startActivity(intent);
    }
}