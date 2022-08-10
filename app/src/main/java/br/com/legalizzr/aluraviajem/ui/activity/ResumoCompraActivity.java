package br.com.legalizzr.aluraviajem.ui.activity;

import static br.com.legalizzr.aluraviajem.ui.activity.PacoteActivity.CHAVE_PACOTE;
import static br.com.legalizzr.aluraviajem.util.DataUtil.periodoEmTexto;
import static br.com.legalizzr.aluraviajem.util.MoedaUtil.formataParaBrasileiro;
import static br.com.legalizzr.aluraviajem.util.ResourceUtil.devolveDrawable;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import br.com.legalizzr.aluraviajem.R;
import br.com.legalizzr.aluraviajem.model.Pacote;

public class ResumoCompraActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Resumo da compra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_compra);

        setTitle(TITULO_APPBAR);

        carregaPacoteRecebido();
    }

    private void carregaPacoteRecebido() {
        Intent intentGet = getIntent();
        if (intentGet.hasExtra(CHAVE_PACOTE)) {
            Pacote pacote = (Pacote) intentGet.getSerializableExtra(CHAVE_PACOTE);

            inicializaCampos(pacote);
        }
    }

    private void inicializaCampos(Pacote pacote) {
        mostraLocal(pacote);
        mostraImagem(pacote);
        mostraData(pacote);
        mostraPreco(pacote);
    }

    private void mostraPreco(Pacote pacote) {
        TextView preco = findViewById(R.id.resumo_compra_preco_pacote);
        String moedaBrasileira = formataParaBrasileiro(pacote.getPreco());
        preco.setText(moedaBrasileira);
    }

    private void mostraData(Pacote pacote) {
        TextView data = findViewById(R.id.resumo_compra_data_viagem);
        String periodoEmTexto = periodoEmTexto(pacote.getDias());
        data.setText(periodoEmTexto);
    }

    private void mostraImagem(Pacote pacote) {
        ImageView imagem = findViewById(R.id.resumo_compra_imagem_pacote);
        Drawable drawableDoPacote = devolveDrawable(this, pacote.getImagem());
        imagem.setImageDrawable(drawableDoPacote);
    }

    private void mostraLocal(Pacote pacote) {
        TextView local = findViewById(R.id.resumo_compra_local_pacote);
        local.setText(pacote.getLocal());
    }
}