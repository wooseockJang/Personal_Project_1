package com.simplecoding.repositoryexam.service.advanced;

import java.util.List;

import com.simplecoding.repositoryexam.vo.advanced.GalleryVO;
import com.simplecoding.repositoryexam.vo.common.Criteria;

public interface GalleryService {

	public List<?> selectGalleryList(Criteria searchVO) throws Exception; 
	
	public int selectGalleryListTotCnt(Criteria searchVO) throws Exception;
	
	public void insertGallery(GalleryVO galleryVO) throws Exception; 
}
