package com.example.customTag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class SimpleTagTest extends SimpleTagSupport{
	
	
	@Override
	public void doTag() throws JspException, IOException {
		getJspContext().getOut().print("Este � um teste da Custom tag");
		super.doTag();
	}

}
