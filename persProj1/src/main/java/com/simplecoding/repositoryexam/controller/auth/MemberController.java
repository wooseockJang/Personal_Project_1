/**
 * 
 */
package com.simplecoding.repositoryexam.controller.auth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.simplecoding.repositoryexam.service.auth.MemberService;
import com.simplecoding.repositoryexam.vo.auth.MemberVO;

/*
  * @fileName : MemberController.java
  * @author : KTE
  * @since : 2024. 9. 19. 
  * description : 로그인/회원가입/로그아웃
*/

@Controller
public class MemberController {

	@Autowired
	MemberService memberService;

	// 로그인 화면 이동
	@GetMapping("/login")
	public String loginView() {

		return "auth/login";
	}

	// 회원가입 화면 이동
	@GetMapping("/register")
	public String registerView() {

		return "auth/register";
	}

	// 로그인 진행 : 로그인 버튼 클릭시 실행 : post방식 : 보안 , get방식 : id/password 노출
	@PostMapping("/loginProcess")
	public String login(@ModelAttribute MemberVO loginVO, HttpServletRequest request, Model model) throws Exception {

		// 1) id/password 가지고 DB 에 정보가 있는지 확인 : 인증(SELECT SQL)
		MemberVO memberVO = memberService.authenticate(loginVO);

		if (memberVO == null) {
			model.addAttribute("errorMessage", "ID가 존재하지 않거나 비밀번호가 틀립니다.");
			return "auth/login"; // 로그인 페이지로 포워딩
		}

		// 2) 인증 OK(DB 에 유저가 있으면) : 세션에 email/password 넣기
		request.getSession().setAttribute("memberVO", memberVO); // 키 이름 : memberVO

		return "redirect:/"; // 첫 페이지 강제이동
	}

	// 로그아웃 클릭시 세션에서 memberVO 삭제
	@GetMapping("/logout")
	public String logout(HttpSession httpSession) {

		// 1) 세션에 memberVO 객체 삭제
		httpSession.removeAttribute("memberVO");
		// 2) 세션에 무효화 실행
		httpSession.invalidate();

		return "redirect:/login";
	}

	// 회원가입 :
	@PostMapping("/register/addition")
	public String register(@ModelAttribute MemberVO memberVO) throws Exception {

		// 1) 상세조회 해서 우리 db에 있는 사람인지 확인 : 있으면 가입되어 있음 (끝)
		MemberVO memberVO2 = memberService.authenticate(memberVO);
		// 선택) 예외처리 : 우리 DB에 있는 사람인지 확인
		if (memberVO2 != null) {
			throw new Exception("이미 가입되어 있습니다.");
		}

		// 2) 서비스의 insert 함수 실행
		memberService.registerMember(memberVO);

		return "redirect:/login";
	}

	// id 중복 확인
	@GetMapping("/auth/check-userId")
	@ResponseBody
	public String checkIdDuplicate(@RequestParam String userId) {
		boolean isDuplicate = memberService.idDuplicate(userId); // 중복 확인 서비스 호출
		return isDuplicate ? "true" : "false"; // 문자열로 반환
	}

}