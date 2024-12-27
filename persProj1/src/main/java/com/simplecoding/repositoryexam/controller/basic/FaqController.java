package com.simplecoding.repositoryexam.controller.basic;

import java.util.List;

import javax.annotation.Resource;

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

import com.simplecoding.repositoryexam.service.basic.FaqService;
import com.simplecoding.repositoryexam.vo.basic.DeptVO;
import com.simplecoding.repositoryexam.vo.basic.FaqVO;
import com.simplecoding.repositoryexam.vo.common.Criteria;

@Controller
public class FaqController {
	
	@Autowired FaqService faqService;
	
	/** TODO: 유효성 체크 객체 */
	@Resource(name = "beanValidator")
	protected DefaultBeanValidator beanValidator;
	
	@GetMapping("/basic/faq")
	public String selectfaqList(Model model, @ModelAttribute("searchVO") Criteria searchVO) throws Exception {	
//		List<?> faqs = faqService.selectFaqList(searchVO);
//		model.addAttribute("faqs", faqs);
		
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
		
		List<?> faqs = faqService.selectFaqList(searchVO);
		model.addAttribute("faqs", faqs);
		
		// TODO: 3) 부서 테이블의 총 갯수: 페이지 객체에 저장
		int totCnt = faqService.selectFaqListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo", paginationInfo);
		
		return "basic/faq/faq_all";
	}
	
	@GetMapping("/basic/faq/addition")
	public String createFaqView() {
		
		return "basic/faq/add_faq";
	}
	
	@PostMapping("/basic/faq/add")
	public String createFaq(@ModelAttribute FaqVO faqVO, BindingResult bindingResult) throws Exception {
		
		// TODO: 1) 유효성 체크
		beanValidator.validate(faqVO, bindingResult);
		
		// TODO: 2) 만약 에러가 있으면 처리
		if(bindingResult.hasErrors()) {
			return "basic/faq/add_faq"; // 저장 안하고 다시 추가페이지 열기
		}
		
		faqService.insertFaq(faqVO);
		
		return "redirect:/basic/faq"; 
	}
	
	@GetMapping("/basic/faq/edition")
	public String updateFaqView(@RequestParam int fno, Model model) throws Exception {
	
		FaqVO faqVO = faqService.selectFaq(fno);
		
		model.addAttribute("faqVO", faqVO);
		
		return "basic/faq/update_faq";
	}
	
	@PostMapping("/basic/faq/edit")
	public String updateFaq(@RequestParam int fno, @ModelAttribute FaqVO faqVO) throws Exception {
		
		faqService.updateFaq(faqVO);
		
		return "redirect:/basic/faq";
	}
	
	
	@PostMapping("/basic/faq/delete")
	public String deleteFaq(@ModelAttribute FaqVO faqVO) throws Exception {

		faqService.deleteFaq(faqVO);
		
		return "redirect:/basic/faq";
	}
	

}
