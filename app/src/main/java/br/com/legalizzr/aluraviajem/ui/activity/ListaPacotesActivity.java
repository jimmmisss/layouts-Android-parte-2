package br.com.legalizzr.aluraviajem.ui.activity;

import static br.com.legalizzr.aluraviajem.ui.activity.PacoteActivity.CHAVE_PACOTE;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import br.com.legalizzr.aluraviajem.R;
import br.com.legalizzr.aluraviajem.dao.PacoteDAO;
import br.com.legalizzr.aluraviajem.model.Pacote;
import br.com.legalizzr.aluraviajem.ui.adapter.ListaPacoteAdapter;

public class ListaPacotesActivity extends AppCompatActivity {

    public static final String TITUTLO_APPBAR = "Pacotes";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(TITUTLO_APPBAR);
        setContentView(R.layout.activity_lista_pacotes);

        configuraçãoLista();
    }

    private void configuraçãoLista() {
        ListView listaDePacotes = findViewById(R.id.lista_pacotes_listview);
        final List<Pacote> pacotes = new PacoteDAO().lista();
        listaDePacotes.setAdapter(new ListaPacoteAdapter(pacotes, this));
        listaDePacotes.setOnItemClickListener((adapterView, view, i, l) -> {
            Pacote pacoteClicado = pacotes.get(i);
            vaiParaResumopacote(pacoteClicado);
        });
    }

    private void vaiParaResumopacote(Pacote pacoteClicado) {
        Intent intent = new Intent(ListaPacotesActivity.this, ResumoPacoteActivity.class);
        intent.putExtra(CHAVE_PACOTE, pacoteClicado);
        startActivity(intent);
    }
}