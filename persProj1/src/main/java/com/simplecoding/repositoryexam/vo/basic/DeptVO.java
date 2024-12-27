package com.simplecoding.repositoryexam.vo.basic;
import com.simplecoding.repositoryexam.vo.common.Criteria;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
  * @fileName : DeptVO.java
  * @author : KTE
  * @since : 2024. 9. 5. 
  * description :
  * 코딩 순서 : vo -> mapper -> service -> controller -> jsp
  * 1) ControllerExam: controller -> jsp
  * 2) ModelExam: service -> controller -> jsp
  * 3) RepositoryExam(최종): vo -> mapper -> service -> controller -> jsp
  * vo : table 똑같이 생긴 자바 파일 
  * vo 객체 1개 == 테이블의 1행
  * => 테이블 1건의 정보를 그대로 저장하는 곳
  */

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@SuppressWarnings("serial") // 경고무시 어노테이션
public class DeptVO extends Criteria {
	// 클래스의 3요소: 속성(필드), 생성자, 함수(메소드)(setter/getter)
//	   DNO NUMBER NOT NULL PRIMARY KEY,
//     DNAME VARCHAR2(255),
//     LOC VARCHAR2(255),
	
//     INSERT_TIME VARCHAR2(255), -> 작성x, 상속
//     UPDATE_TIME VARCHAR2(255) -> 작성x, 상속
	private  int dno; // 부서번호 -> 기본키
	private  String dname; // 부서명
	private  String loc; // 부서위치
	
	// 생성자: 속성 모두 있는 생성자 == 어노테이션 존재: @AllArgsConstructor => 클래스 위
//	public DeptVO(int dno, String dname, String loc) {
//		super();
//		this.dno = dno;
//		this.dname = dname;
//		this.loc = loc;
//	}
	
	// 생성자: 속성 X 생성자 == 어노테이션 존재: @NoArgsConstructor => 클래스 위
//	public DeptVO() {
//		super();
//	}
	
	// setter/getter 함수 == 어노테이션 존재: @Setter, @Getter => 클래스 위
//		public int getDno() {
//			return dno;
//		}
//		public String getDname() {
//			return dname;
//		}
//		public String getLoc() {
//			return loc;
//		}
//		public void setDno(int dno) {
//			this.dno = dno;
//		}
//		public void setDname(String dname) {
//			this.dname = dname;
//		}
//		public void setLoc(String loc) {
//			this.loc = loc;
//		}
	
	// (참고) 객체 출력(디버깅): TO-String() 재정의	== 어노테이션 존재: @ToString => 클래스 위
//	@Override
//	public String toString() {
//		return "DeptVO [dno=" + dno + ", dname=" + dname + ", loc=" + loc + "]";
//	}
	
	
	
	
	
	
	
}
