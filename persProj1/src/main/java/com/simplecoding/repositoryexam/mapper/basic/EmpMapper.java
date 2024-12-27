package com.simplecoding.repositoryexam.mapper.basic;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.simplecoding.repositoryexam.vo.basic.DeptVO;
import com.simplecoding.repositoryexam.vo.basic.EmpVO;
import com.simplecoding.repositoryexam.vo.common.Criteria;

/**
 * @fileName : DeptMapper.java
 * @author : KTE
 * @since : 2024. 9. 5. 
 * description :
 */
@Mapper
public interface EmpMapper {
	
	public List<?> selectEmpList(Criteria searchVo);
	
	public int selectEmpListTotCnt(Criteria searchVO);
	
	public void insert(EmpVO empVO); // 저장 버튼 클릭 실행 함수
	
	public EmpVO selectEmp(int eno); // 상세조회 함수
	
	public int update(EmpVO empVO); // 업데이트 함수
	
	public int delete(EmpVO empVO); // 삭제 함수
}
