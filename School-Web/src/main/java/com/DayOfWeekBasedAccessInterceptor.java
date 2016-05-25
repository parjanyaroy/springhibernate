package com;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class DayOfWeekBasedAccessInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest req,HttpServletResponse res,Object handler)throws Exception
	{
		Calendar cal= Calendar.getInstance();
		int dayOfWeek= cal.get(cal.DAY_OF_WEEK);
		if(dayOfWeek==1)
		{
			res.getWriter().write("Website closed on sundays");
			return false;
		}
		return true; // after returning true , the application 1) calls request handler method 2) gets a appropriate view 
	}

	// After view response is generated
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("afterCompletion "+request.getRequestURI().toString());
		super.afterCompletion(request, response, handler, ex);
	}

	// After request handler method is executed
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("postHandle "+request.getRequestURI().toString());
		super.postHandle(request, response, handler, modelAndView);
	}
}
