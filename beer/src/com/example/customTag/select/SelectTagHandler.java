package com.example.customTag.select;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.DynamicAttributes;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class SelectTagHandler extends SimpleTagSupport implements DynamicAttributes{
	
	private List optionsList;
	private String name;
	private String size;
	
	private static final String AFTER_TEMPLATE = "%s='%s' ";
	private static final String OPTION_TEMPLATE = "<option value='%1$s'> %1$s </option>";
	
	
	
	@Override
	public void doTag() throws JspException, IOException {		
		
		PageContext page = (PageContext) getJspContext();
		JspWriter jsp = page.getOut();
		
		jsp.print("<select ");
		jsp.print(String.format(AFTER_TEMPLATE, "name", this.name));
		jsp.print(String.format(AFTER_TEMPLATE, "size", this.size));
		
		for(String attrName : this.tagAttr.keySet()){
			
			String attrDefinition = 
					String.format(AFTER_TEMPLATE, attrName, tagAttr.get(attrName));
			jsp.print(attrDefinition);
		}
		jsp.println('>');
		
		for(Object option : this.optionsList){
			
			String optionTag = String.format(OPTION_TEMPLATE, option.toString());
			
			jsp.println(optionTag);
		}
		
		jsp.println(" </select>");
		
	}



	public List getOptionsList() {
		return optionsList;
	}



	public void setOptionsList(List optionsList) {
		this.optionsList = optionsList;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getSize() {
		return size;
	}



	public void setSize(String size) {
		this.size = size;
	}


	private Map<String, Object> tagAttr = new HashMap<String, Object>();

	@Override
	public void setDynamicAttribute(String uri, String name, Object value) throws JspException {
		
		this.tagAttr.put(name, value);
		
	}
	
	
	
	
	

}
