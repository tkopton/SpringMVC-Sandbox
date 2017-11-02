package com.thomaskopton.springmvc01.interceptor;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SpecialPatientCodeInterceptor extends HandlerInterceptorAdapter {
	   private String specialCode;
	   private String errorRedirect;
	   private String specialPatientRedirect;

	   public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException{
	      String givenSpecialCode = request.getParameter("code");

	      if (specialCode.equals(givenSpecialCode)) {
	         response.sendRedirect(request.getContextPath() + "/" + specialPatientRedirect);
	      } else {
	         response.sendRedirect(errorRedirect);
	      }

	      return false;
	   }

	   public void setSpecialCode(String specialCode) {
	      this.specialCode = specialCode;
	   }

	   public void setErrorRedirect(String errorRedirect) {
	      this.errorRedirect = errorRedirect;
	   }

	   public void setSpecialPatientRedirectt(String specialPatientRedirect) {
	      this.specialPatientRedirect = specialPatientRedirect;
	   }
}
