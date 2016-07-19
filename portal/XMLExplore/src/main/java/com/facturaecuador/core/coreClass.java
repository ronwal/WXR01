package com.facturaecuador.core;

import factura.xml.ParserManager;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Latinus on 5/11/15.
 */
public class coreClass {
    public void loadXML(File fileXML, String ruc) throws Exception {
        Path path = Paths.get(fileXML.getAbsolutePath());
        new ParserManager().parseDocument(ruc, fileXML.getName(), 1, Files.readAllBytes(path));
        System.out.println(fileXML.getAbsolutePath());
    }
}
