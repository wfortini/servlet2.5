package com.example.listener;


import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;


public class BeerAttributeListener implements HttpSessionAttributeListener {

   
    public BeerAttributeListener() {
       
    }

	
    public void attributeRemoved(HttpSessionBindingEvent arg0)  { 
         
    	String name = arg0.getName();
    	Object value = arg0.getValue();
    	
    	System.out.println("HttpSessionAttributeListener ===============  Attribute removed " + name + " value " + value);
    	
    }

    public void attributeAdded(HttpSessionBindingEvent arg0)  { 
        
    	String name = arg0.getName();
    	Object value = arg0.getValue();
    	
    	System.out.println("HttpSessionAttributeListener ===================  Attribute added " + name + " value " + value);
    }
    

	
    public void attributeReplaced(HttpSessionBindingEvent arg0)  { 
    	
    	String name = arg0.getName();
    	Object value = arg0.getValue();
    	
    	System.out.println("HttpSessionAttributeListener ==================  Attribute replaced " + name + " value " + value);
         
    }
	
}
