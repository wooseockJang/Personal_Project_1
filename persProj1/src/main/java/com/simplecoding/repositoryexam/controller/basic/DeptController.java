/**
 * 
 */
package com.simplecoding.repositoryexam.controller.basic;

import java.awt.print.Pageable;
import java.util.List;

import javax.annotation.Resource;
import javax.enterprise.inject.New;

import org.antlr.grammar.v3.ANTLRParser.exceptionGroup_return;
import org.antlr.grammar.v3.ANTLRParser.throwsSpec_return;
import org.egovframe.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springmodules.validation.commons.DefaultBeanValidator;

import com.ibatis.common.logging.Log;
import com.simplecoding.repositoryexam.service.basic.DeptService;
import com.simplecoding.repositoryexam.vo.basic.DeptVO;
import com.simplecoding.repositoryexam.vo.common.Criteria;

import lombok.extern.log4j.Log4j;

/**
  * @fileName : DeptController.java
  * @author : KTE
  * @since : 2024. 9. 5. 
  * description :
  */
@Log4j
@Controller
public class DeptController {
	// Controller 역할: 1) 서비스 객체의 함수를 실행 2) jsp로 결과를 전송
	
	@Autowired
	private DeptService deptService;
	
	/** TODO: 유효성 체크 객체 */
	@Resource(name = "beanValidator")
	protected DefaultBeanValidator beanValidator;
	
	// 1) 전체 조회 함수
	@GetMapping("/basic/dept")
	public String  selectDeptList(Model model, @ModelAttribute("searchVO") Criteria searchVO) throws Exception 
	{	
		// TODO: 0) 페이징 변수에 설정: 
		searchVO.setPageUnit(3); // 1페이지당 화면에 보이는 갯수
		searchVO.setPageSize(2); // 페이지 번호를 보여줄 갯수
		
		// TODO: 1) 페이지 객체 생성
		PaginationInfo paginationInfo = new PaginationInfo(); // 페이징 객체
		paginationInfo.setCurrentPageNo(searchVO.getPageIndex()); // 현재 페이지 번호 저장
		paginationInfo.setRecordCountPerPage(searchVO.getPageUnit()); // 1페이지당 보일 게시물 갯수
		paginationInfo.setPageSize(searchVO.getPageSize()); // 페이지 번호를 보여줄 갯수
		
		// TODO: 2) searchVO 객체 페이징 정보 저장
		searchVO.setFirstIndex(paginationInfo.getFirstRecordIndex()); // 첫 페이지 번호
		searchVO.setLastIndex(paginationInfo.getLastPageNo()); // 끝 페이지 번호
		searchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage()); // 1페이지당 보일 게시물 갯수
		
		// 1) 서비스 객체의 함수를 실행: DeptService.전체조회()
		List<?> depts = deptService.selectDeptList(searchVO);
		// 2) 모델에 결과를 담아 jsp로 전송
		model.addAttribute("depts", depts);
		
		// TODO: 3) 부서 테이블의 총 갯수: 페이지 객체에 저장
		int totCnt = deptService.selectDeptListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo", paginationInfo);
		
		return "basic/dept/dept_all";
	}
	
	// 2) 추가 페이지 열기 함수
	@GetMapping("/basic/dept/addition")
	public String createDeptView(Model model) {
		// TODO: 유효성 객체 추가
		model.addAttribute("deptVO", new DeptVO()); 
		
		return "basic/dept/add_dept";
	}
	
	// 3) 저장 버튼 클릭 실행 함수: insert 실행 => post 방식
	// TODO: 저장 버튼 클릭시: 잘못 입력된것을 체크(유효성)
	@PostMapping("/basic/dept/add")
	public String createDept(@ModelAttribute DeptVO deptVO, BindingResult bindingResult) throws Exception {
		
		// TODO: 1) 유효성 체크
		beanValidator.validate(deptVO, bindingResult);
		
		// TODO: 2) 만약 에러가 있으면 처리
		if(bindingResult.hasErrors()) {
			return "basic/dept/add_dept"; // 저장 안하고 다시 추가페이지 열기
		}
		
		//	System.out.println("테스트: " + deptVO); // 디버깅1
		log.info("테스트: " + deptVO); // 디버깅2 성능up, @Log4j 어노테이션
		// 1) 서비스의 함수 실행: insert 함수	
		deptService.insertDept(deptVO);
		
		return "redirect:/basic/dept"; // 전체 조회 페이지로 강제이동
	}
	
	//	4) 상세 조회 페이지 열기 함수
	@GetMapping("/basic/dept/edition")
	public String updateDeptView(@RequestParam int dno, Model model) throws Exception { // @RequestParam으로 dno값을 받음
		// 1) deptService의 상세조회 함수 실행
		DeptVO deptVO = deptService.selectDept(dno);
		// 2) 모델에 담아 jsp로 전송
		model.addAttribute("deptVO", deptVO);
		return "basic/dept/update_dept";
	}
	
	// 5) 수정 버튼 클릭시 수정하는 함수: dno,DeptVO 필요
	@PostMapping("/basic/dept/edit")
	public String updateDept(@RequestParam int dno, @ModelAttribute DeptVO deptVO) throws Exception {
		// 1) deptService의 updateDept 함수 실행
		deptService.updateDept(deptVO);
		// 2) 전체조회 페이지로 강제이동
		return "redirect:/basic/dept";
	}
	
	
	// 6) 삭제 버튼 클릭시 삭제하는 함수: dno(부서번호) or DeptVO(부서객체) 필요
	@PostMapping("/basic/dept/delete")
	public String deleteDept(@ModelAttribute DeptVO deptVO) throws Exception {
		// 1) deptService의 deleteDept 함수 실행
		deptService.deleteDept(deptVO);
		// 2) 전체조회 페이지로 강제이동
		return "redirect:/basic/dept";
	}
	
	
}
