/**
 * 
 */
package com.simplecoding.repositoryexam.mapper.basic;

import java.util.List;


import org.apache.ibatis.annotations.Mapper;

import com.simplecoding.repositoryexam.vo.basic.DeptVO;
import com.simplecoding.repositoryexam.vo.common.Criteria;

/**
 * @fileName : DeptMapper.java
 * @author : KTE
 * @since : 2024. 9. 5. 
 * description : SQL 문 연결된 인터페이스, CRUD 함수이름 작성
 * spring => sql 작성
     DeptMapper : 함수 이름 (인터페이스)
     => java 작성하면 가독성 안좋음
         "select * from " + ""
     => html 확장한 xml 파일로 작성함: 
         (mybatis 프레임워크 : 자식클래스 역할)
          select * from department
 */

@Mapper
public interface DeptMapper {
	
	public List<?> selectDeptList(Criteria searchVO); // 1) 전체조회 함수: 페이징 기능 추가
	
	public int selectDeptListTotCnt(Criteria searchVO); // 2) 추가 페이지 열기 함수
	
	public int insert(DeptVO deptVO); // 3) 저장 버튼 클릭 실행 함수, // 반환형이 void여도 결과는 같음
	
	public DeptVO selectDept(int dno); // 4) 상세조회 함수
	
	public int update(DeptVO deptVO); // 5) 수정(update) 함수
	
	public int delete(DeptVO deptVO); // 6) 삭제 함수
	
}
