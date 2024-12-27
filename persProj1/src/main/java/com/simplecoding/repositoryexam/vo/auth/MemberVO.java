/**
 * 
 */
package com.simplecoding.repositoryexam.vo.auth;

import com.simplecoding.repositoryexam.vo.common.Criteria;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
  * @fileName : MemberVO.java
  * @author : KTE
  * @since : 2024. 9. 19. 
  * description :
  */

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@SuppressWarnings("serial")
public class MemberVO extends Criteria {
	
	private String email;	// 기본키
	private String password;	
	private String name;	
	
}
