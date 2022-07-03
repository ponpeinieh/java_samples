/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package n;

/**
 *
 * @author jacky
 */
public class Q implements y.L
{
    @Override
    public String getType()
    {
        return "TypeQ"; 
    }

    @Override
    public String sayHello()
    {
        return "Hello, this is " + this.getClass().getName();
    } 
}
