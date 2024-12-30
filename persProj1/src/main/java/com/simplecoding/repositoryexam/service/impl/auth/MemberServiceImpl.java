/**
 * 
 */
package com.simplecoding.repositoryexam.service.impl.auth;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplecoding.repositoryexam.mapper.auth.MemberMapper;
import com.simplecoding.repositoryexam.service.auth.MemberService;
import com.simplecoding.repositoryexam.vo.auth.MemberVO;

import lombok.val;

/**
 * @fileName : MemberServiceImpl.java
 * @author : KTE
 * @since : 2024. 9. 19. description :
 */
@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberMapper memberMapper;

	// 인증 : 상세조회
	@Override
	public MemberVO authenticate(MemberVO loginVO) {
		MemberVO memberVO = memberMapper.authenticate(loginVO);

		if (memberVO == null || !BCrypt.checkpw(loginVO.getPassword(), memberVO.getPassword())) {
			// !BCrypt.checkpw(loginVO.getPassword(), membersVO.getPassword()) => 입력된 비밀번호가 DB의 암호화된 비밀번호와 일치하지 않을 경우에 실행
			//	암호화된 비밀번호는 복호화할 수 없지만, BCrypt는 내부적으로 동일한 해시 알고리즘을 사용하여 평문 비밀번호를 비교합니다.
			
			return null; // 회원이 없거나 비밀번호가 틀릴 경우 null 반환
		}

		return memberVO; // 인증 성공 시 회원 정보 반환
	}

	// insert 함수
	@Override
	public void registerMember(MemberVO memberVO) throws Exception {

		// TODO: 1) password 암호화(해싱 암호화)
		// 사용법: BCrypt.hashpw(jsp전달암호, 옵션);
		String hashedPassword = BCrypt.hashpw(memberVO.getPassword(), BCrypt.gensalt());

		// TODO: 2) MemberMapper 객체 함수 실행
		memberVO.setPassword(hashedPassword);
		memberMapper.register(memberVO);

	}

	// id 중복확인
	@Override
	public boolean idDuplicate(String userId) {

		return memberMapper.countById(userId) > 0;

	}

}
