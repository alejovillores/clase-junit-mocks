package org.algo3.modelo.proveedor;

import org.algo3.modelo.Chiste;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ProveedorTexto implements Proveedor {
    private static final int CATEGORIA = 0;
    private static final int DELIVERY = 1;
    private static final int SETUP = 2;
    private final String fileDir;

    public ProveedorTexto(String filePath) {
        fileDir = filePath;
    }

    public Chiste solicitarChiste(String categoria, String idioma) {
        /*El archivo tiene formato
        * Categoria:idioma:delivery:setup
        */
        try{
            BufferedReader br = new BufferedReader(new FileReader(fileDir));
            String[] parts = obtenerPartesDelChiste(br, categoria, idioma);
            return new Chiste(parts[CATEGORIA], parts[DELIVERY], parts[SETUP]);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String[] obtenerPartesDelChiste(BufferedReader br, String categ, String idioma) throws IOException {
        String line = br.readLine();
        String[] parts = line.split(":");
        boolean chisteAdecuado = formatoChisteCorrecto(parts, categ, idioma);
        while(!chisteAdecuado) {
            line = br.readLine();
            parts = line.split(":");
            chisteAdecuado = formatoChisteCorrecto(parts, categ, idioma);
        }
        return parts;
    }

    private boolean formatoChisteCorrecto(String[] partes, String categ, String idioma) {
        return (partes[CATEGORIA].equalsIgnoreCase(categ)) && (partes[DELIVERY].equalsIgnoreCase(idioma));
    }
}
