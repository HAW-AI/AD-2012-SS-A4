/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aufgabe1;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Fujitsu
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("ohne Tiefe");
        searchFile("/Dropbox", ".jpg");
        System.out.println("mit Tiefe");
        searchFile("/Dropbox", ".jpg", 1);
    }

    public static void searchFile(String pfad, String typ) {
        if (!pfad.startsWith("c:")) {
            pfad = "c:" + pfad;
        }
        File file = new File(pfad);
        List<String> ordner = new LinkedList<>();
        if (file.listFiles() == null) {
            return;
        }
        for (File f : file.listFiles()) {
            if (!f.isDirectory()) {
                if (f.getName().contains(typ)) {
                    System.out.println("gefunden: " + f.getAbsolutePath());
                }
            } else {
                ordner.add(f.getAbsolutePath());
            }
        }
        for (String string : ordner) {
            searchFile(string, typ);
        }
    }

    private static void searchFile(String pfad, String typ, int tiefe) {
        if (!pfad.startsWith("c:")) {
            pfad = "c:" + pfad;
        }
        File file = new File(pfad);
        List<String> ordner = new LinkedList<>();

        if (file.listFiles() == null) {
            return;
        }

        if (tiefe >= 0) {
            for (File f : file.listFiles()) {
                if (!f.isDirectory()) {
                    if (f.getName().contains(typ)) {
                        System.out.println("gefunden: " + f.getAbsolutePath());
                    }
                } else {
                    ordner.add(f.getAbsolutePath());
                }
            }
            for (String string : ordner) {
                searchFile(string, typ, tiefe - 1);
            }
        }
    }
}