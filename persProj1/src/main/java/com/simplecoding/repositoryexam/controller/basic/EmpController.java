/**
 * 
 */
package com.simplecoding.repositoryexam.controller.basic;

import java.awt.print.Pageable;
import java.util.List;

import org.antlr.grammar.v3.ANTLRParser.exceptionGroup_return;
import org.antlr.grammar.v3.ANTLRParser.throwsSpec_return;
import org.egovframe.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.simplecoding.repositoryexam.mapper.basic.EmpMapper;
import com.simplecoding.repositoryexam.service.basic.DeptService;
import com.simplecoding.repositoryexam.service.basic.EmpService;
import com.simplecoding.repositoryexam.vo.basic.DeptVO;
import com.simplecoding.repositoryexam.vo.basic.EmpVO;
import com.simplecoding.repositoryexam.vo.common.Criteria;

/**
  * @fileName : DeptController.java
  * @author : KTE
  * @since : 2024. 9. 5. 
  * description :
  */

@Controller
public class EmpController {
	// Controller 역할: 1) 서비스 객체의 함수를 실행 2) jsp로 결과를 전송
	
	@Autowired
	private EmpService empService;
	
	// 전체 조회 함수
	@GetMapping("/basic/emp")
	public String  selectEmpList(Model model, @ModelAttribute("searchVO") Criteria searchVO) throws Exception
	{	
		// TODO: 0) 페이징 변수에 설정: 
		searchVO.setPageUnit(3); // 1페이지당 화면에 보이는 갯수, setter함수
		searchVO.setPageSize(2); // 페이지 번호를 보여줄 갯수, setter함수set
	
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
		List<?> emps = empService.selectEmpList(searchVO)
;		// 2) 모델에 결과를 담아 jsp로 전송
		model.addAttribute("emps", emps);
		
		// TODO: 3) 부서 테이블의 총 갯수: 페이지 객체에 저장
		int totCnt = empService.selectEmpListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo", paginationInfo);
		
		return "basic/emp/emp_all";
	}
	
		// 추가 페이지 열기 함수
		@GetMapping("/basic/emp/addition")
		public String createDeptView(Model model) {
			return "basic/emp/add_emp";
		}
		
		// 저장 버튼 클릭 실행 함수: insert 실행 => post 방식
		@PostMapping("/basic/emp/add")
		public String createEmp(@ModelAttribute EmpVO empVO) throws Exception {
			// 1) 서비스의 함수 실행: insert 함수	
			empService.insertEmp(empVO);
			return "redirect:/basic/emp"; // 전체 조회 페이지로 강제이동
		}
		
//		4) 상세 조회 페이지 열기 함수
		@GetMapping("/basic/emp/edition")
		public String updateEmpView(@RequestParam int eno, Model model) throws Exception { // @RequestParam으로 eno값을 받음
			EmpVO empVO = empService.selectEmp(eno);
			
			model.addAttribute("empVO", empVO);
			return "basic/emp/update_emp";
		}
		
		@PostMapping("/basic/emp/edit")
		public String updateEmp(@ModelAttribute EmpVO empVO, @RequestParam int eno) throws Exception {
			empService.updateEmp(empVO);
			
			return "redirect:/basic/emp";
		}
		
		@PostMapping("/basic/emp/delete")
		public String deleteEmp(@RequestParam int eno, @ModelAttribute EmpVO empVO) throws Exception {
		
			empService.deleteEmp(empVO);
			
			return "redirect:/basic/emp";
		}
	
}
