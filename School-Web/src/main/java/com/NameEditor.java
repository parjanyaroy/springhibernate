package com;

import java.beans.PropertyEditorSupport;

public class NameEditor extends PropertyEditorSupport {
	
	public void setAsText(String name)throws IllegalArgumentException
	{
		if(name.contains("Mr.") || name.contains("Ms."))
		{
			setValue(name);
		}
		else
		{
			name="Mr. "+name;
			setValue(name);
		}
	}

}
