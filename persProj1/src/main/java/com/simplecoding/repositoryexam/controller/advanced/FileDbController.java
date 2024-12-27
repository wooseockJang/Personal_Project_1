package com.simplecoding.repositoryexam.controller.advanced;


import java.util.List;
import java.util.UUID;

import javax.mail.Multipart;

import org.egovframe.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ibatis.common.logging.Log;
import com.simplecoding.repositoryexam.mapper.advanced.FileDbMapper;
import com.simplecoding.repositoryexam.service.advanced.FileDbService;
import com.simplecoding.repositoryexam.vo.advanced.FileDbVO;
import com.simplecoding.repositoryexam.vo.basic.DeptVO;
import com.simplecoding.repositoryexam.vo.common.Criteria;

import lombok.extern.log4j.Log4j;

/**
 * @fileName : 
 * @author : KTE
 * @since : 2024. 9. 12. 
 * description :
 */

// 컨트롤러는 서버역할
@Log4j
@Controller
public class FileDbController {
	
	@Autowired FileDbService fileDbService;
	
	// 순서 - (1) 전체조회
	@GetMapping("/advanced/fileDb")
	public String selectFileDbList(Model model, @ModelAttribute("searchVO") Criteria searchVO) throws Exception {
		
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
		
		List<?> fileDbs = fileDbService.selectFileDbList(searchVO);
		
		model.addAttribute("fileDbs", fileDbs);
		
		// TODO: 3) 테이블의 총 갯수: 페이지 객체에 저장
		int totCnt = fileDbService.selectFileDbListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo", paginationInfo);
		
		return "advanced/fileDb/fileDb_all";
	}
	
	
	// (2) 추가 페이지 생성
	@GetMapping("/advanced/fileDb/addition")
	public String createFileDbView() {
		
		return "advanced/fileDb/add_fileDb";
	}

	
	// (3) 저장 버튼 클릭시 실행 : insert
	@PostMapping("/advanced/fileDb/add")
	public String createFileDb(@RequestParam(defaultValue = "") String fileTitle,
			@RequestParam(defaultValue = "") String fileContent,
			@RequestParam(required = false) MultipartFile image) throws Exception {
		
		// 1) 생성자 실행:
		FileDbVO fieDbVO = new FileDbVO(fileTitle, fileContent, image.getBytes());
		// 2) fileDbService 의 insert(객체) 함수 실행
		fileDbService.insertFileDb(fieDbVO);

		return "redirect:/advanced/fileDb";
	}
	
	
	// (4) 상세 조회 + 첨부파일 전송(jsp로) : byte[] 형태로 전송 : @ResponseBody
	// 복습 : "/fileDb/{uuid}" : 파라미터 방식 @PathVariable
	@GetMapping("/advanced/fileDb/{uuid}")
	@ResponseBody
	public ResponseEntity<byte[]> fileDownload(@PathVariable String uuid) throws Exception {
		
		// 1) 상세조회 : 객체받기(첨부파일)
		FileDbVO fileDbVO = fileDbService.selectFileDb(uuid);
		
		// 2) 첨부파일 jsp 전송 : 규격대로 전송
		// 첨부파일 다운로드 응답 생성
        HttpHeaders headers = new HttpHeaders(); // html 문서 객체(머리말)
        headers.setContentDispositionFormData("attachment", fileDbVO.getUuid()); // 첨부파일1(문서형태)
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM); // 첨부파일2(문서형태)          

        return new ResponseEntity<byte[]>(fileDbVO.getFileData(), headers, HttpStatus.OK); // 첨부파일 전송 + OK 신호 보냄
	}
	
	
	// (5) 삭제
	@PostMapping("/advanced/fileDb/delete")
	public String deleteFileDb(@RequestParam(defaultValue = "") String uuid) throws Exception {
		log.info("테스트 : " + uuid);
		
		fileDbService.delete(uuid);

		return "redirect:/advanced/fileDb";
	}
	
}
