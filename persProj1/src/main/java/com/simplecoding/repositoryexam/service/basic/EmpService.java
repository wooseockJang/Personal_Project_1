package com.simplecoding.repositoryexam.service.basic;

import java.util.List;

import org.springframework.stereotype.Service;

import com.simplecoding.repositoryexam.vo.basic.DeptVO;
import com.simplecoding.repositoryexam.vo.basic.EmpVO;
import com.simplecoding.repositoryexam.vo.common.Criteria;

public interface EmpService {
	
	List<?> selectEmpList(Criteria searchVO) throws Exception;
	
	public int selectEmpListTotCnt(Criteria searchVO);
	
	void insertEmp(EmpVO empVO) throws Exception;
	
	public EmpVO selectEmp(int eno) throws Exception;
	
	public void updateEmp(EmpVO empVO) throws Exception;
	
	public void deleteEmp(EmpVO empVO) throws Exception; 
	
}
