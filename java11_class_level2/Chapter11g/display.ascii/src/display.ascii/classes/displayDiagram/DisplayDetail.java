/* Copyright © 2017 Oracle and/or its affiliates. All rights reserved. */

package displayDiagram;

import java.util.ArrayList;
import java.util.Iterator;


public class DisplayDetail {
    
    ArrayList<String> boxContents = new ArrayList<>();
    int longestString = 0;
    
    public DisplayDetail(){
    }    
    public DisplayDetail(String initialEntry){
        boxContents.add(initialEntry);
        if (initialEntry.length() > longestString) longestString = initialEntry.length();
    }
    
    public void addDetail(String theText) {
        boxContents.add(theText);
        if (theText.length() > longestString) longestString = theText.length();  
    }
    
    public Iterator<String> getDetails() {
        return boxContents.iterator();
    }

}
