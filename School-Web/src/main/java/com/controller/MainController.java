package com.controller;

import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.associationtest.Student;
import com.customeditors.CourseDropdownEditor;
import com.customeditors.TeacherDropdownEditor;
import com.dataprocessors.CourseProcessor;
import com.dataprocessors.StudentProcessor;
import com.dataprocessors.TeacherProcessor;
import com.manytomany.Course;
import com.manytoone.ClassTeacher;

import nutshellstore.beans.CustomerDetails;
import nutshellstore.service.CustomerDataProcessorImpl;

@EnableScheduling
@Controller
public class MainController {

	CustomerDataProcessorImpl cDPI;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(ClassTeacher.class, "classTeacher", new TeacherDropdownEditor());
		binder.registerCustomEditor(Set.class, "courses", new CourseDropdownEditor());

	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage() {
		return "login";
	}

	@RequestMapping(value = "/registerStudent", method = RequestMethod.GET)
	public ModelAndView formController() {
		ModelAndView model = new ModelAndView("NewStudentRegistration");
		System.out.println("NewStudentRegistration");
		List<Course> listCourses = (new CourseProcessor()).listCourses();
		List<ClassTeacher> listTeachers = (new TeacherProcessor()).listTeachers();
		model.addObject("allTeachers", listTeachers);
		model.addObject("allCourses", listCourses);
		return model;
	}

	@RequestMapping(value = "/registerStudent", method = RequestMethod.POST)
	public ModelAndView registrationFormSubmit(
			@Valid @ModelAttribute("studentReg") com.associationtest.Student studentReg, BindingResult result) {
		if (!result.hasErrors()) {
			StudentProcessor studentProcessor = new StudentProcessor();
			ModelAndView model = null;
			System.out.println("Customer Id " + studentReg.getStudentId());
			
			if (studentReg.getStudentId() < 0) {
				studentProcessor.createStudent(studentReg);
			} else {
				studentProcessor.updateStudent(studentReg);
			}
			return listStudents();
		} else {
			ModelAndView model = new ModelAndView("NewStudentRegistration");
			return model;
		}

	}

	@RequestMapping(value = "/editStudentData", method = RequestMethod.GET)
	public ModelAndView editStudentData(@RequestParam String studentId) {
		Student editableStudent = (new StudentProcessor()).searchOrDleteStudent(Long.parseLong(studentId), false);
		ModelAndView model = new ModelAndView("NewStudentRegistration");
		List<Course> listCourses = (new CourseProcessor()).listCourses();
		List<ClassTeacher> listTeachers = (new TeacherProcessor()).listTeachers();
		model.addObject("allTeachers", listTeachers);
		model.addObject("allCourses", listCourses);
		model.addObject("editableStudent", editableStudent);
		return model;
	}

	@RequestMapping(value = "/deleteStudentData", method = RequestMethod.GET)
	public ModelAndView deleteStudentData(@RequestParam String studentId) {
		(new StudentProcessor()).searchOrDleteStudent(Long.parseLong(studentId), true);
		return listStudents();
	}

	@RequestMapping(value = "/listStudents", method = RequestMethod.GET)
	public ModelAndView listStudents() {
		StudentProcessor studentProc = new StudentProcessor();
		List<Student> listStudents = studentProc.listStudents();
		// System.out.println("ListCountIs"+listStudents.size());
		ModelAndView model = new ModelAndView("ListStudents");
		model.addObject("studentsList", listStudents);
		return model;
	}

	@RequestMapping(value = "/listTeacherAndCourses", method = RequestMethod.GET)
	public ModelAndView listTeacherAndCourses() {
		ModelAndView model = new ModelAndView("ListTeacherAndCourses");
		List<Course> listCourses = (new CourseProcessor()).listCourses();
		List<ClassTeacher> listTeachers = (new TeacherProcessor()).listTeachers();
		model.addObject("allTeachers", listTeachers);
		model.addObject("allCourses", listCourses);
		return model;
	}

	@RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
	public String accessDeniedPage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		return "accessDenied";
	}

	@RequestMapping(value = { "/welcome", "/" }, method = RequestMethod.GET)
	public String welcomePage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		return "welcome";
	}

	@RequestMapping(value = "/registerCourse", method = RequestMethod.POST)
	public ModelAndView registerCourseSubmit(@Valid @ModelAttribute("courseReg") com.manytomany.Course courseReg,
			BindingResult result) {
		if (!result.hasErrors()) {
			CourseProcessor courseProcessor = new CourseProcessor();
			courseProcessor.addCourse(courseReg);

		}
		return listTeacherAndCourses();
	}
	
	
	@RequestMapping(value = "/registerTeacher", method = RequestMethod.POST)
	public ModelAndView registerTeacherSubmit(@Valid @ModelAttribute("teacherReg") com.manytoone.ClassTeacher teacherReg,
			BindingResult result) {
		if (!result.hasErrors()) {
			TeacherProcessor teacherProcessor = new TeacherProcessor();
			teacherProcessor.addTeacher(teacherReg);

		}
		return listTeacherAndCourses();
	}


	private String getPrincipal() {
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails) principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}

	@ExceptionHandler(value = NullPointerException.class)
	public String handleNullPointerException(Exception e) {
		System.out.println("NullPointerException occured :" + e.getMessage().toString());
		return "NullPointerException"; // Returns the name of the JSP of the
										// error page
	}

}
