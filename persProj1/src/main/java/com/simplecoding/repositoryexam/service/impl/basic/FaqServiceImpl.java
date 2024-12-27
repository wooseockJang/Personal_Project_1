package com.simplecoding.repositoryexam.service.impl.basic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplecoding.repositoryexam.mapper.basic.FaqMapper;
import com.simplecoding.repositoryexam.service.basic.FaqService;
import com.simplecoding.repositoryexam.vo.basic.DeptVO;
import com.simplecoding.repositoryexam.vo.basic.FaqVO;
import com.simplecoding.repositoryexam.vo.common.Criteria;

@Service
public class FaqServiceImpl implements FaqService {
	
	@Autowired FaqMapper faqMapper;
	
	@Override
	public List<?> selectFaqList(Criteria searchVO) throws Exception {
		
		return faqMapper.selectFaqList(searchVO);
	}

	@Override
	public int selectFaqListTotCnt(Criteria searchVO) {
		
		return faqMapper.selectFaqListTotCnt(searchVO);
	}

	@Override
	public void insertFaq(FaqVO faqVO) throws Exception {
		
		faqMapper.insert(faqVO);
	}

	@Override
	public FaqVO selectFaq(int fno) throws Exception {
		FaqVO faqVO = faqMapper.selectFaq(fno);
	
		return faqVO;
	}

	@Override
	public void updateFaq(FaqVO faqVO) throws Exception {
		faqMapper.update(faqVO);
	}

	@Override
	public void deleteFaq(FaqVO faqVO) throws Exception {
		faqMapper.delete(faqVO);
	}

	
	
}
