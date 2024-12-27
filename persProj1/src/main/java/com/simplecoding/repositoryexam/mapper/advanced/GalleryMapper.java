package com.simplecoding.repositoryexam.mapper.advanced;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.simplecoding.repositoryexam.vo.advanced.FileDbVO;
import com.simplecoding.repositoryexam.vo.advanced.GalleryVO;
import com.simplecoding.repositoryexam.vo.common.Criteria;

@Mapper
public interface GalleryMapper {

	public List<?> selectGalleryList(Criteria searchVO) throws Exception; // 1) 전체 조회
	
	public int selectGalleryListTotCnt(Criteria searchVO) throws Exception; // 2) 테이블 갯수 세기
	
	public int insert(GalleryVO galleryVO) throws Exception; // 3) insert 함수
	
	public GalleryVO selectGallery(String uuid); // 4) 상세 조회
	
	
	
	
}
