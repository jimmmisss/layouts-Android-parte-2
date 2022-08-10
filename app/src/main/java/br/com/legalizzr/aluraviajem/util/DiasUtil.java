package br.com.legalizzr.aluraviajem.util;

import androidx.annotation.NonNull;

public abstract class DiasUtil {

    private DiasUtil() {
        super();
    }

    public static final String PLURAL = " dias";
    public static final String SINGLE = " dia";

    @NonNull
    public static String formataDiasEmTexto(int qtdeDias) {
        if (qtdeDias > 1) {
            return qtdeDias + PLURAL;
        }
        return qtdeDias + SINGLE;
    }
}
