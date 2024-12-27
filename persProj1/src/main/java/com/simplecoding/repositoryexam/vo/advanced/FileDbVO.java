package com.simplecoding.repositoryexam.vo.advanced;

import org.springframework.web.multipart.MultipartFile;

import com.simplecoding.repositoryexam.vo.common.Criteria;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @fileName : 
 * @author : KTE
 * @since : 2024. 9. 12. 
 * description :
 */

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@SuppressWarnings("serial") // 상속시 serial이 있는 클래스일때 경고 발생, 위의 경고를 표시안하게 하는 어노테이션
public class FileDbVO extends Criteria {
	
  private String uuid;            // 기본키
  private String fileTitle;       // 제목   
  private String fileContent;     // 내용   
  private byte[] fileData;        // 이미지파일   
  private MultipartFile image;    // 내부적 사용(이미지파일)   
  private String fileUrl;         // 다운로드 url(클릭:이미지 다운로드됨)   
  
  // 매개변수 4개 생성자
  public FileDbVO(String uuid, String fileTitle, String fileContent, byte[] fileData) {
	  this.uuid = uuid;
	  this.fileTitle = fileTitle;
	  this.fileContent = fileContent;
	  this.fileData = fileData;
  }
  
  // 매개변수 3개 생성자
  public FileDbVO(String fileTitle, String fileContent, byte[] fileData) {
	  	super();
		this.fileTitle = fileTitle;
		this.fileContent = fileContent;
		this.fileData = fileData;
  }
  
  
  
  

}

