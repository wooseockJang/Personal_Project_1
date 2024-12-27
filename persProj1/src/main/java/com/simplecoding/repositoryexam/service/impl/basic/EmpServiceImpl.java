package com.simplecoding.repositoryexam.service.impl.basic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplecoding.repositoryexam.mapper.basic.EmpMapper;
import com.simplecoding.repositoryexam.service.basic.EmpService;
import com.simplecoding.repositoryexam.vo.basic.DeptVO;
import com.simplecoding.repositoryexam.vo.basic.EmpVO;
import com.simplecoding.repositoryexam.vo.common.Criteria;

@Service
public class EmpServiceImpl implements EmpService{

	@Autowired
	private EmpMapper empMapper;

	@Override
	public List<?> selectEmpList(Criteria searchVO) throws Exception {
		// TODO Auto-generated method stub
		return empMapper.selectEmpList(searchVO);
	
	}

	@Override
	public int selectEmpListTotCnt(Criteria searchVO) {
		
		return empMapper.selectEmpListTotCnt(searchVO);
	}

	@Override
	public void insertEmp(EmpVO empVO) throws Exception {
		empMapper.insert(empVO);
	}

	@Override
	public EmpVO selectEmp(int eno) throws Exception {
		EmpVO empVO = empMapper.selectEmp(eno);
		
		return empVO;
	}

	@Override
	public void updateEmp(EmpVO empVO) throws Exception {
		
		empMapper.update(empVO);
	}

	@Override
	public void deleteEmp(EmpVO empVO) throws Exception {
	
		empMapper.delete(empVO);
	}
	
	
	
	
}
