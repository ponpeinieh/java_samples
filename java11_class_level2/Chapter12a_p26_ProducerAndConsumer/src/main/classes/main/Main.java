/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import java.util.ServiceLoader;
import x.X;
import y.L;

/**
 *
 * @author jacky
 */
public class Main
{
    public static void main(String[] args)
    {
        ServiceLoader<X> xLoader = ServiceLoader.load(X.class);
        
        for (X x : xLoader)
        {
            System.out.println("got type: " + x.getType());
            if (x.getType().equals("TypeP"))
            {
                System.out.println(x.saySomething());
            }
        }
        
        ServiceLoader<L> lLoader = ServiceLoader.load(L.class);
        
        for (L l : lLoader)
        {
            System.out.println("got type: " + l.getType());
            if (l.getType().equals("TypeQ"))
            {
                System.out.println(l.sayHello());
            }
        }
        
    }
}
