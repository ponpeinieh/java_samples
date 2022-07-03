/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package l;

/**
 *
 * @author jacky
 */
public class O implements x.X
{
    @Override
    public String getType()
    {
        return "TypeO"; 
    }

    @Override
    public String saySomething()
    {
        return "Message from " + this.getClass().getName();
    } 
}
