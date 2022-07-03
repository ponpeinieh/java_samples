package b;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.lang.reflect.InvocationTargetException;
//import x.X;

//import y.Y; //error
//import z.Z; //error
/**
 *
 * @author jacky
 */
public class B {

    public static void main(String[] args) {
        try {
            Class clazzX = Class.forName("x.X");
            System.out.println(clazzX.getDeclaredConstructors()[0].newInstance());

            Class clazzY = Class.forName("y.Y");
            System.out.println(clazzY.getDeclaredConstructors()[0].newInstance());

            Class clazzZ = Class.forName("z.Z");
            System.out.println(clazzZ.getDeclaredConstructors()[0].newInstance());

            Class clazzC = Class.forName("c.C");
            var cstr = clazzC.getDeclaredConstructors()[0];
            cstr.setAccessible(true); //set the private constructor to be accessible through reflection
            System.out.println(cstr.newInstance());
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
        } catch (InvocationTargetException ex) {
            ex.printStackTrace();
        }

    }
}
