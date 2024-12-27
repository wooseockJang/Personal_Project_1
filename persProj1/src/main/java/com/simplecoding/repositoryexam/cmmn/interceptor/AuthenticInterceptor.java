/**
 * 
 */
package com.simplecoding.repositoryexam.cmmn.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

import com.simplecoding.repositoryexam.vo.auth.MemberVO;

/**
  * @fileName : AuthenticInterceptor.java
  * @author : KTE
  * @since : 2024. 9. 19. 
  * description :
  */


public class AuthenticInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO : 세션에 id/password(memberVO)가 있으면 그 화면 이동시키고, 없으면 로그인 페이지로 이동
		
		// 세션에 memberVO 가져오기
		MemberVO memberVO = (MemberVO) WebUtils.getSessionAttribute(request, "memberVO");
	      
	      if(memberVO!=null) {
	    	 // 세션에 memberVO가 있으면 그 화면 이동
	         return true;
	      } 
	      else {
	    	 // ModelAndView(이동jsp명) : model 대신 사용가능
	    	 // 사용자가 없으면 로그인 페이지로 강제이동 
	         ModelAndView modelAndView = new ModelAndView("redirect:/login");         
	         throw new ModelAndViewDefiningException(modelAndView);
	      }
	}
	
}
