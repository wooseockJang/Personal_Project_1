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
	public MemberVO authenticate(MemberVO loginVO) throws Exception {
		// TODO memberMapper 의 상세조회(인증) 실행, 업무로직 추가
		// 1) memberMapper 의 상세조회(인증) 실행
		MemberVO memberVO = memberMapper.authenticate(loginVO);
		// 2) memberVO 있으면 => 암호 체크 : jsp 전송한 암호를 암호화해서 DB와 비교(OK)
		if (memberVO != null) {
			// TODO : 암호화 Bcryt , DB 암호와 입력암호가 같은지 비교
			// 사용법 : BCrypt.checkpw(jsp전송암호, DB암호) 맞으면 true, 틀리면 false
			boolean isMatchedPassword = BCrypt.checkpw(loginVO.getPassword(), memberVO.getPassword());

			// 예외처리 : false 경우 : 암호가 틀립니다.
			if (isMatchedPassword == false) {
				throw new Exception("암호가 틀립니다.");
			}
		}

		return memberVO;

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

	// email 중복확인
	@Override
	public boolean idDuplicate(String userId) {

		return memberMapper.countById(userId) > 0;

	}

}
