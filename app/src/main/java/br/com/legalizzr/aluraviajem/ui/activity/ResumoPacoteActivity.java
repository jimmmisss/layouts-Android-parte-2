package br.com.legalizzr.aluraviajem.ui.activity;

import static br.com.legalizzr.aluraviajem.ui.activity.PacoteActivity.CHAVE_PACOTE;
import static br.com.legalizzr.aluraviajem.util.DataUtil.periodoEmTexto;
import static br.com.legalizzr.aluraviajem.util.DiasUtil.formataDiasEmTexto;
import static br.com.legalizzr.aluraviajem.util.MoedaUtil.formataParaBrasileiro;
import static br.com.legalizzr.aluraviajem.util.ResourceUtil.devolveDrawable;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import br.com.legalizzr.aluraviajem.R;
import br.com.legalizzr.aluraviajem.model.Pacote;

public class ResumoPacoteActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Resumo do pacote";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_pacote);

        setTitle(TITULO_APPBAR);

        carregapacoteRecebido();
    }

    private void carregapacoteRecebido() {
        Intent intentGet = getIntent();
        if (intentGet.hasExtra(CHAVE_PACOTE)) {
            final Pacote pacote = (Pacote) intentGet.getSerializableExtra(CHAVE_PACOTE);

            inicializaCampos(pacote);

            configuraBotao(pacote);
        }
    }

    private void configuraBotao(Pacote pacote) {
        Button botaoRealizaPagamento = findViewById(R.id.resumo_pacote_botao_realiza_pagamento);
        botaoRealizaPagamento.setOnClickListener(view -> {
            vaiParaPagamento(pacote);
        });
    }

    private void vaiParaPagamento(Pacote pacote) {
        Intent intent = new Intent(ResumoPacoteActivity.this, PagamentoActivity.class);
        intent.putExtra(CHAVE_PACOTE, pacote);
        startActivity(intent);
    }

    private void inicializaCampos(Pacote pacote) {
        mostraLocal(pacote);
        mostraImagem(pacote);
        motraDias(pacote);
        mostraPreco(pacote);
        mostraData(pacote);
    }

    private void mostraData(Pacote pacote) {
        TextView data = findViewById(R.id.resumo_pacote_data);
        data.setText(periodoEmTexto(pacote.getDias()));
    }

    private void mostraPreco(Pacote pacote) {
        TextView preco = findViewById(R.id.resumo_pacote_preco);
        String moedaBrasileira = formataParaBrasileiro(pacote.getPreco());
        preco.setText(moedaBrasileira);
    }

    private void motraDias(Pacote pacote) {
        TextView dias = findViewById(R.id.resumo_pacote_dias);
        String diasEmTexto = formataDiasEmTexto(pacote.getDias());
        dias.setText(diasEmTexto);
    }

    private void mostraImagem(Pacote pacote) {
        Drawable drawable = devolveDrawable(this, pacote.getImagem());
        ImageView imagem = findViewById(R.id.resumo_pacote_imagem);
        imagem.setImageDrawable(drawable);
    }

    private void mostraLocal(Pacote pacote) {
        TextView local = findViewById(R.id.resumo_pacote_local);
        local.setText(pacote.getLocal());
    }
}