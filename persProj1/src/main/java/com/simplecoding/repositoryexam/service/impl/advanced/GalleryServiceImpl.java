package com.simplecoding.repositoryexam.service.impl.advanced;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.simplecoding.repositoryexam.mapper.advanced.GalleryMapper;
import com.simplecoding.repositoryexam.service.advanced.GalleryService;
import com.simplecoding.repositoryexam.vo.advanced.GalleryVO;
import com.simplecoding.repositoryexam.vo.common.Criteria;

@Service
public class GalleryServiceImpl implements GalleryService{

	@Autowired GalleryMapper galleryMapper;
	
	@Override
	public List<?> selectGalleryList(Criteria searchVO) throws Exception {
		
		return galleryMapper.selectGalleryList(searchVO);
	}

	@Override
	public int selectGalleryListTotCnt(Criteria searchVO) throws Exception {
		
		return galleryMapper.selectGalleryListTotCnt(searchVO);
	}

	@Override
	public void insertGallery(GalleryVO galleryVO) throws Exception {
		String newUuid = UUID.randomUUID().toString();
		String galleryDownloadUrl = generateDownloadUrl(newUuid);
		
		galleryVO.setUuid(newUuid);
		galleryVO.setGalleryFileUrl(galleryDownloadUrl);
		
		galleryMapper.insert(galleryVO);
	}

	// (*)첨부파일 다운로드 url 자동 생성 해주는 함수
	public String generateDownloadUrl(String uuid) {
        return ServletUriComponentsBuilder  // url 만들어 주는 자바객체
                .fromCurrentContextPath()   // spring 기본주소 제공(http://localhost:8000)
                .path("/advanced/gallery/") // /advanced/gallery
                .path(uuid)                 // /uuid
                .toUriString();             // 위의 것들을 모두 조합 => 최종 url 완성
    }
	
}
