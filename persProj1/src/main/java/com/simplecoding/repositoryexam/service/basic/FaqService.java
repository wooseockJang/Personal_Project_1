package com.simplecoding.repositoryexam.service.basic;

import java.util.List;

import com.simplecoding.repositoryexam.vo.basic.DeptVO;
import com.simplecoding.repositoryexam.vo.basic.FaqVO;
import com.simplecoding.repositoryexam.vo.common.Criteria;

public interface FaqService {
	
	public List<?> selectFaqList(Criteria searchVO) throws Exception;
	
	public int selectFaqListTotCnt(Criteria searchVO);
	
	public void insertFaq(FaqVO faqVO) throws Exception ;
	
	public FaqVO selectFaq(int fno) throws Exception;
	
	public void updateFaq(FaqVO faqVO) throws Exception;
	
	public void deleteFaq(FaqVO faqVO) throws Exception;
}
