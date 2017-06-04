package com.example.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


public class BeerSessionCounter implements HttpSessionListener {

	static private int servActive;
   
    public BeerSessionCounter() {
        
    }

    public void sessionCreated(HttpSessionEvent arg0)  { 
        servActive++; 
    }

	
    public void sessionDestroyed(HttpSessionEvent arg0)  { 
       servActive--;   
    }
	
}
