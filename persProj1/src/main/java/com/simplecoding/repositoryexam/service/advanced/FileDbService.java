package com.simplecoding.repositoryexam.service.advanced;

import java.util.List;

import com.simplecoding.repositoryexam.vo.advanced.FileDbVO;
import com.simplecoding.repositoryexam.vo.common.Criteria;

public interface FileDbService {
	
	public List<?> selectFileDbList(Criteria searchVO) throws Exception;
	
	public int selectFileDbListTotCnt(Criteria searchVO) throws Exception;
	
	public void insertFileDb(FileDbVO fileDbVO) throws Exception;
	
	public FileDbVO selectFileDb(String uuid) throws Exception;
	
	public void delete(String uuid) throws Exception;
	
}
