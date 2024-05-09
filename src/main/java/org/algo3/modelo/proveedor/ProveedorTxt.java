package org.algo3.modelo.proveedor;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.algo3.modelo.Chiste;

public class ProveedorTxt implements Proveedor {
    @Override
    public Chiste solicitarChiste(String categoria, String idioma) {
        List<String> chistes = new ArrayList<>();
        try {
            String nombreArchivo = String.format("src/main/java/org/algo3/modelo/chistes%s.txt", categoria);
            chistes = Files.readAllLines(
                Paths.get(nombreArchivo),
                StandardCharsets.UTF_8
            );
            int indice = (int) (Math.random() * chistes.size());
            String[] chiste = chistes.get(indice).split(",");
            return new Chiste(categoria, chiste[0], chiste[1]);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
