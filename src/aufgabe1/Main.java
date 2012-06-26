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
        for (String string : searchFile("/Dropbox", "")) {
            System.out.println(string);
        }
        System.out.println("mit Tiefe");
        for (String string : searchFile("/Dropbox", ".jpg", 3)) {
            System.out.println(string);
        }
    }
    
    public static List<String> searchFile(String pfad, String typ) {
        return searchFile(pfad, typ, Integer.MAX_VALUE);
    }
    
    private static List<String> searchFile(String pfad, String typ, int tiefe) {
        File file = new File(pfad);
        List<String> ausgabe = new LinkedList<>();
        if (file.listFiles() != null && tiefe >= 0) {
            for (File f : file.listFiles()) {
                if (!f.isDirectory() && f.getName().contains(typ)) {
                    ausgabe.add("gefunden: " + f.getAbsolutePath());
                } else {
                    ausgabe.addAll(searchFile(f.getAbsolutePath(), typ, tiefe - 1));
                }
            }
        }
        return ausgabe;
    }
}
