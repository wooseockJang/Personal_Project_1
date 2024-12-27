package com.simplecoding.repositoryexam.controller.advanced;

import java.util.List;

import org.egovframe.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.simplecoding.repositoryexam.service.advanced.GalleryService;
import com.simplecoding.repositoryexam.vo.advanced.FileDbVO;
import com.simplecoding.repositoryexam.vo.advanced.GalleryVO;
import com.simplecoding.repositoryexam.vo.common.Criteria;

@Controller
public class GalleryController {
	
	@Autowired GalleryService galleryService;
	
//  전체조회
	@GetMapping("/advanced/gallery")
	public String selectGalleryList(Model model, @ModelAttribute("searchVO") Criteria searchVO) throws Exception {
		
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

		List<?> galaxy = galleryService.selectGalleryList(searchVO);
		
		model.addAttribute("galaxy", galaxy);
		
		// TODO: 3) 테이블의 총 갯수: 페이지 객체에 저장
		int totCnt = galleryService.selectGalleryListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo", paginationInfo);
		
		return "advanced/gallery/gallery_all";
	}
	
	// 추가 페이지 생성
	@GetMapping("/advanced/gallery/addition")
	public String createGalleryView() {
		
		return "advanced/gallery/add_gallery";
	}
	
	// (3) 저장 버튼 클릭시 실행 : insert
	@PostMapping("/advanced/gallery/add")
	public String createFileDb(@RequestParam(defaultValue = "") String galleryTitle,
			@RequestParam(required = false) MultipartFile image) throws Exception {
		
		GalleryVO galleryVO = new GalleryVO(galleryTitle, image.getBytes());;
		
		galleryService.insertGallery(galleryVO);

		return "redirect:/advanced/gallery";
	}


}
