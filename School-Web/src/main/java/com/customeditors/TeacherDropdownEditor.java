package com.customeditors;

import java.beans.PropertyEditorSupport;

import com.dataprocessors.TeacherProcessor;
import com.manytoone.ClassTeacher;

public class TeacherDropdownEditor extends PropertyEditorSupport {
	
	public void setAsText(String teacherId)throws IllegalArgumentException
	{
		ClassTeacher teacher = (new TeacherProcessor()).listTeachers(Long.parseLong(teacherId));
		setValue(teacher);
		
	}

}
