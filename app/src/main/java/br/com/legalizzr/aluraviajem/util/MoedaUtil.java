package br.com.legalizzr.aluraviajem.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public abstract class MoedaUtil {

    private MoedaUtil() {
        super();
    }

    public static final String PORTUGUES = "pt";
    public static final String BRASIL = "br";
    public static final String FORMATO_PADRAO = "R$";
    public static final String FORMATO_PADRAO_COM_ESPACO = "R$ ";

    public static String formataParaBrasileiro(BigDecimal valor) {
        NumberFormat precoFormatoBrasileiro = DecimalFormat
                .getCurrencyInstance(new Locale(PORTUGUES, BRASIL));
        return precoFormatoBrasileiro.format(valor).replace(FORMATO_PADRAO, FORMATO_PADRAO_COM_ESPACO);
    }
}
