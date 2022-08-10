package br.com.legalizzr.aluraviajem.ui.adapter;

import static br.com.legalizzr.aluraviajem.util.DiasUtil.formataDiasEmTexto;
import static br.com.legalizzr.aluraviajem.util.MoedaUtil.formataParaBrasileiro;
import static br.com.legalizzr.aluraviajem.util.ResourceUtil.devolveDrawable;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.legalizzr.aluraviajem.R;
import br.com.legalizzr.aluraviajem.model.Pacote;

public class ListaPacoteAdapter extends BaseAdapter {

    private final List<Pacote> pacotes;
    private final Context context;

    public ListaPacoteAdapter(List<Pacote> pacotes, Context context) {
        this.pacotes = pacotes;
        this.context = context;
    }

    @Override
    public int getCount() {
        return pacotes.size();
    }

    @Override
    public Pacote getItem(int posicao) {
        return pacotes.get(posicao);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int posicao, View view, ViewGroup parent) {
        View viewCriada = LayoutInflater
                .from(context)
                .inflate(R.layout.item_pacote, parent, false);

        Pacote pacote = pacotes.get(posicao);

        mostraImagem(viewCriada, pacote);
        mostraLocal(viewCriada, pacote);
        mostraDias(viewCriada, pacote);
        mostraPreco(viewCriada, pacote);

        return viewCriada;
    }

    private void mostraPreco(View viewCriada, Pacote pacote) {
        TextView preco = viewCriada.findViewById(R.id.item_pacote_preco);
        String moedaBraileira = formataParaBrasileiro(pacote.getPreco());
        preco.setText(moedaBraileira);
    }

    private void mostraDias(View viewCriada, Pacote pacote) {
        TextView dias = viewCriada.findViewById(R.id.item_pacote_dias);
        String diasEmTexto = formataDiasEmTexto(pacote.getDias());
        dias.setText(diasEmTexto);
    }

    private void mostraLocal(View viewCriada, Pacote pacote) {
        TextView local = viewCriada.findViewById(R.id.item_pacote_local);
        local.setText(pacote.getLocal());
    }

    private void mostraImagem(View viewCriada, Pacote pacote) {
        Drawable drawableImagePacote = devolveDrawable(context, pacote.getImagem());
        ImageView imagem = viewCriada.findViewById(R.id.item_pacote_imagem);
        imagem.setImageDrawable(drawableImagePacote);
    }
}
