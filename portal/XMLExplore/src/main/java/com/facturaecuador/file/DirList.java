/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.facturaecuador.file;

import com.facturaecuador.core.coreClass;

import java.io.File;

/**
 * @author Latinus
 */
public class DirList {

    File dir;

    public DirList() {
        dir = new File("/factura-ecuador/factura-ecuador");
    }

    public void init(String ruc) {
        File[] ficheros = dir.listFiles();
        if (ficheros == null) {
            System.out.println("No hay ficheros en el directorio especificado");
        } else {
            for (File fichero : ficheros) {
                if (fichero.getName().trim().equals(ruc.trim())) {
                    ficheros(fichero,ruc);
                }
            }
        }
    }

    private void ficheros(File subDir,String ruc) {
        File[] ficheros = subDir.listFiles();
        String path;
        if (ficheros == null) {
            System.out.println("No hay ficheros en el directorio especificado");
        } else {
            for (File fichero : ficheros) {
                if (fichero.isDirectory()) {
                    try {
                        System.out.println("SubDir --> " + fichero.getAbsolutePath());
                        ficheros(fichero,ruc);
                    } catch (Exception e) {
                        System.out.println("Error SubDir");
                    }
                } else {
                    try {
                        path = fichero.getAbsolutePath();
                        new coreClass().loadXML(fichero,ruc);
                    } catch (Exception e) {
                        System.out.println("Error SubDir");
                    }
                }
            }
        }
    }

}
