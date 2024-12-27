package com.simplecoding.repositoryexam.service.impl.basic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplecoding.repositoryexam.mapper.basic.DeptMapper;
import com.simplecoding.repositoryexam.service.basic.DeptService;
import com.simplecoding.repositoryexam.vo.basic.DeptVO;
import com.simplecoding.repositoryexam.vo.common.Criteria;

@Service
public class DeptServiceImpl implements DeptService {

	// 객체: DB와 연결된 객체 - DeptMapper
	@Autowired
	private DeptMapper deptMapper;
	
	@Override
	public List<?> selectDeptList(Criteria searchVO) throws Exception {
		// TODO: 전체 조회
		return deptMapper.selectDeptList(searchVO);
	}

	@Override
	public int selectDeptListTotCnt(Criteria searchVO) {
		// TODO: 갯수세기
		return deptMapper.selectDeptListTotCnt(searchVO);
	}

	@Override
	public void insertDept(DeptVO deptVO) throws Exception {
		// TODO: deptMapper의 insert 함수 실행: 내부 sql문 작성
		deptMapper.insert(deptVO);
	}

	@Override
	public DeptVO selectDept(int dno) throws Exception{
		// TODO: deptMapper의 상세조회 함수 실행
		DeptVO deptVO = deptMapper.selectDept(dno);
		
		return deptVO;
	}

	@Override
	public void updateDept(DeptVO deptVO) throws Exception {
		// TODO: deptMapper의 수정 함수 실행
		
		deptMapper.update(deptVO);
	}

	@Override
	public void deleteDept(DeptVO deptVO) throws Exception {
		// TODO: deptMapper의 삭제 함수 실행
		
		deptMapper.delete(deptVO);
	}
	
	
	
	
}
