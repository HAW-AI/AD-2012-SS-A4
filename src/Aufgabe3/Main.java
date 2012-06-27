/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aufgabe3;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author maiwald
 */
public class Main
{
    public static void main(String[] args)
    {
        double[] dArr =
        {
            1.23, 3.21, 2.13
        };
        System.out.println(Combine.with(" , ").prepend("A ").append(" Z").from(dArr));


        List<String> sLst = new ArrayList<>();
        sLst.add(" Hallo");
        sLst.add(null);
        sLst.add(" ");
        sLst.add(" Welt ");
        String bla = Combine.with(" ").notNulls().trim().notEmpty().prepend("-> ").append(".").from(sLst);
        System.out.println(bla);
    }    
}
