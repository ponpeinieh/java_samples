/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a;

import x.X;
//import y.Y; //error
//import z.Z; //error
import java.lang.reflect.InvocationTargetException;

/**
 *
 * @author jacky
 */
public class A {

    public static void main(String[] args) {
        try {
            Class clazzX = Class.forName("x.X");
            System.out.println(clazzX.getDeclaredConstructors()[0].newInstance());

            Class clazzY = Class.forName("y.Y");
            System.out.println(clazzY.getDeclaredConstructors()[0].newInstance());

            Class clazzZ = Class.forName("z.Z");
            System.out.println(clazzZ.getDeclaredConstructors()[0].newInstance()); //runtime error
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            ex.printStackTrace();
        }
    }
}
