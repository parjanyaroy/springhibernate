package com.customeditors;

import java.beans.PropertyEditorSupport;
import java.util.List;
import java.util.Set;

import com.dataprocessors.CourseProcessor;
import com.manytomany.Course;

public class CourseDropdownEditor extends PropertyEditorSupport {
	
	public void setAsText(String element)throws IllegalArgumentException
	{
		/*String[] courseIds= element.split(",");
		long[] courseIds_long = new long[courseIds.length];
		int ctr=0;
		for(String id : courseIds)
		{
			courseIds_long[ctr++]=Long.parseLong(id);
		}*/
		Set<Course> listCourses = (new CourseProcessor()).listCourses(element);
		setValue(listCourses);
		
	}
	
	

}
