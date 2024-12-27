/**
 * 
 */
package com.simplecoding.repositoryexam.service.basic;

import java.util.List;

import org.antlr.grammar.v3.ANTLRParser.exceptionGroup_return;

import com.simplecoding.repositoryexam.vo.basic.DeptVO;
import com.simplecoding.repositoryexam.vo.common.Criteria;



/**
  * @fileName : DeptService.java
  * @author : KTE
  * @since : 2024. 9. 5. 
  * description :
  */
public interface DeptService {
	
	List<?> selectDeptList(Criteria searchVO) throws Exception; // 전체조회 - 페이징기능,검색어
	
	public int selectDeptListTotCnt(Criteria searchVO); // 갯수 세기
	
	void insertDept(DeptVO deptVO) throws Exception; // insert 함수
	
	public DeptVO selectDept(int dno) throws Exception; // 상세조회 함수
	 
	public void updateDept(DeptVO deptVO) throws Exception; // 수정 함수
	
	public void deleteDept(DeptVO deptVO) throws Exception; // 삭제 함수
}
