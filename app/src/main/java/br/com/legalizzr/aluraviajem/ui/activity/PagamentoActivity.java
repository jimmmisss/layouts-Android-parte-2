package br.com.legalizzr.aluraviajem.ui.activity;

import static br.com.legalizzr.aluraviajem.ui.activity.PacoteActivity.CHAVE_PACOTE;
import static br.com.legalizzr.aluraviajem.util.MoedaUtil.formataParaBrasileiro;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import br.com.legalizzr.aluraviajem.R;
import br.com.legalizzr.aluraviajem.model.Pacote;

public class PagamentoActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Pagamento";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);

        setTitle(TITULO_APPBAR);

        carregaPacoteRecebido();
    }

    private void carregaPacoteRecebido() {
        Intent intentGet = getIntent();
        if (intentGet.hasExtra(CHAVE_PACOTE)) {
            final Pacote pacote = (Pacote) intentGet.getSerializableExtra(CHAVE_PACOTE);

            mostraPreco(pacote);

            configuraBotao(pacote);
        }
    }

    private void configuraBotao(Pacote pacote) {
        Button botaoFinalizaCompra = findViewById(R.id.pgto_botao_finaliza_compra);
        botaoFinalizaCompra.setOnClickListener(view -> {
            vaiParaResumoCompra(pacote);
        });
    }

    private void vaiParaResumoCompra(Pacote pacote) {
        Intent intent = new Intent(PagamentoActivity.this, ResumoCompraActivity.class);
        intent.putExtra(CHAVE_PACOTE, pacote);
        startActivity(intent);
    }

    private void mostraPreco(Pacote pacote) {
        TextView preco = findViewById(R.id.pgto_preco_pacote);
        var moedaBrasileira = formataParaBrasileiro(pacote.getPreco());
        preco.setText(moedaBrasileira);
    }
}