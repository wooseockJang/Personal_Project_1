package com.simplecoding.repositoryexam.service.impl.advanced;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.simplecoding.repositoryexam.mapper.advanced.FileDbMapper;
import com.simplecoding.repositoryexam.service.advanced.FileDbService;
import com.simplecoding.repositoryexam.vo.advanced.FileDbVO;
import com.simplecoding.repositoryexam.vo.common.Criteria;

@Service
public class FileDbServiceImpl implements FileDbService {
	
	@Autowired FileDbMapper fileDbMapper;
	
	@Override
	public List<?> selectFileDbList(Criteria searchVO) throws Exception {
		
		return fileDbMapper.selectFileDbList(searchVO);
	}

	@Override
	public int selectFileDbListTotCnt(Criteria searchVO) throws Exception {
		
		return fileDbMapper.selectFileDbListTotCnt(searchVO);
	}

	@Override
	public void insertFileDb(FileDbVO fileDbVO) throws Exception {
		// TODO: 업무로직 추가 : 1) 기본키 자동생성 : 자바의 UUID 만들기(유일한 문자) => 첨부파일 이름 사용
		String newUuid = UUID.randomUUID().toString(); // 새 uuid
		
		//                   2) 첨부파일 다운로드 받기 위해 ? : 다운로드 url이 필요  
		//                       => http://localhost:8000/advanced/fileDb/첨부파일명(UUID 사용)  
		String fileDownloadUrl = generateDownloadUrl(newUuid);
		
		// 3) fileDbVO 객체에 위의 값으로 수정하기
		fileDbVO.setUuid(newUuid);
		fileDbVO.setFileUrl(fileDownloadUrl);
		
		// 4) fileDbMapper : insert함수 실행
		fileDbMapper.insert(fileDbVO);
	}
	
	// (*)첨부파일 다운로드 url 자동 생성 해주는 함수
	public String generateDownloadUrl(String uuid) {
        return ServletUriComponentsBuilder // url 만들어 주는 자바객체
                .fromCurrentContextPath()  // spring 기본주소 제공(http://localhost:8000)
                .path("/advanced/fileDb/") // /advanced/fileDb
                .path(uuid)                // /uuid
                .toUriString();            // 위의 것들을 모두 조합 => 최종 url 완성
    }
	
	// 상세조회
	@Override
	public FileDbVO selectFileDb(String uuid) {
		
		FileDbVO fileDbVO = fileDbMapper.selectFileDb(uuid);
	
		return fileDbVO;
	}

	// 삭제
	@Override
	public void delete(String uuid) throws Exception {
		// 5) fileDbMapper : delete함수 실행
		fileDbMapper.delete(uuid);
	}
	
}
