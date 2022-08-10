package br.com.legalizzr.aluraviajem.util;

import androidx.annotation.NonNull;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoField;

public abstract class DataUtil {

    public static final String DIA_E_MES = "dd/MM";

    private DataUtil() {
        super();
    }

    @NonNull
    public static String periodoEmTexto(int dias) {
        var formatoBrasileiro = new SimpleDateFormat(DIA_E_MES);
        var dataIda = LocalDate.now();
        var dataVolta = LocalDate.now().plusDays(dias);
        var dataFormatadaIda = formatoBrasileiro.format(dataIda);
        var dataFormatadaVolta = formatoBrasileiro.format(dataVolta);
        return dataFormatadaIda + " - " + dataFormatadaVolta
                + " - " + " de " + dataVolta.get(ChronoField.YEAR);
    }
}
