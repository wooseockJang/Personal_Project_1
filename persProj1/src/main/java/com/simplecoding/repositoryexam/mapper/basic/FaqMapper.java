package com.simplecoding.repositoryexam.mapper.basic;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.simplecoding.repositoryexam.vo.basic.DeptVO;
import com.simplecoding.repositoryexam.vo.basic.FaqVO;
import com.simplecoding.repositoryexam.vo.common.Criteria;

@Mapper
public interface FaqMapper {
	
	public List<?> selectFaqList(Criteria searchVO);
	
	public int selectFaqListTotCnt(Criteria searchVO);
	
	public int insert(FaqVO faqVO);
	
	public FaqVO selectFaq(int fno);
	
	public int update(FaqVO faqVO); 
	
	public int delete(FaqVO faqVO); 
}
