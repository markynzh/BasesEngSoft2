package relatorio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class Relatorios {
    private static final String SEPARADOR = ";";
    public static void gerarCSV(File destino, String[] colunas, List<Object[]> linhas) throws IOException {

        try (BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(destino), StandardCharsets.UTF_8))) {

            // Garante acentos corretamente
            writer.write('\uFEFF');
            writer.write(linhaCSV(colunas));
            writer.newLine();
            for (Object[] linha : linhas) {
                String[] valores = new String[linha.length];
                for (int i = 0; i < linha.length; i++) {
                    valores[i] = linha[i] == null ? "-" : linha[i].toString();
                }
                writer.write(linhaCSV(valores));
                writer.newLine();
            }
        }
    }

    private static String linhaCSV(String[] valores) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < valores.length; i++) {
            sb.append(escapar(valores[i]));
            if (i < valores.length - 1) {
                sb.append(SEPARADOR);
            }
        }
        return sb.toString();
    }

    // Coloca entre aspas qualquer valor que contenha o separador, aspas ou quebra de linha
    private static String escapar(String valor) {
        if (valor == null) {
            return "";
        }
        boolean precisaAspas = valor.contains(SEPARADOR) || valor.contains("\"") || valor.contains("\n");
        String resultado = valor.replace("\"", "\"\"");
        return precisaAspas ? "\"" + resultado + "\"" : resultado;
    }
}