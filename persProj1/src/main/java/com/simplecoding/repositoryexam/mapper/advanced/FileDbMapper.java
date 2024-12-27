package com.simplecoding.repositoryexam.mapper.advanced;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.simplecoding.repositoryexam.vo.advanced.FileDbVO;
import com.simplecoding.repositoryexam.vo.common.Criteria;

@Mapper
public interface FileDbMapper {

	public List<?> selectFileDbList(Criteria searchVO) throws Exception; // 1) 전체 조회
	
	public int selectFileDbListTotCnt(Criteria searchVO) throws Exception; // 2) 테이블 총 갯수
	
	public int insert(FileDbVO fileDbVO) throws Exception; // 3) insert 함수
	
	public FileDbVO selectFileDb(String uuid); // 4) 상세 조회
	
	public int delete(String uuid); // 5) 삭제
	
}
