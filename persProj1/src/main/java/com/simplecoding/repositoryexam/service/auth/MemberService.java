package com.simplecoding.repositoryexam.service.auth;

import com.simplecoding.repositoryexam.vo.auth.MemberVO;

public interface MemberService {

	public MemberVO authenticate(MemberVO loginVO) throws Exception; // 상세조회(인증)
	
	public void registerMember(MemberVO memberVO) throws Exception; // insert 함수
	
	public boolean idDuplicate(String userId); // ID 중복확인용
	
}
