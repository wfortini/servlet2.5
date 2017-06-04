package com.example.model;

import java.util.ArrayList;
import java.util.List;

public class BeerExpert {
	
	public List<String> getBrands(String color){
		List<String> brans = new ArrayList<String>();
		if (color.equals("amber")){
			brans.add("Jack Amber");
			brans.add("Red Moose");
			
		}else{
			brans.add("Jail Pale Ale");
			brans.add("Gout Stout");
		}
		return brans;
	}

}
