/**
 * 
 */
package com.simplecoding.repositoryexam.vo.advanced;

import org.springframework.web.multipart.MultipartFile;

import com.simplecoding.repositoryexam.vo.common.Criteria;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
  * @fileName : GalleryVO.java
  * @author : KTE
  * @since : 2024. 9. 12. 
  * description : 연습 : 테이블을(TB_GALLERY) 참고해서 VO 객체 만드세요
  *               (샘플 : FileDbVO 참고)
  */

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuppressWarnings("serial")
public class GalleryVO extends Criteria {
	// 속성
	private String uuid;           // 기본키
	private String galleryTitle;   // 제목
    private byte[] galleryData;    // 업로드파일
    private MultipartFile image;   // 내부적 사용(이미지)
    private String galleryFileUrl; // 다운로드 url
    
    
    // 생성자
    public GalleryVO(String galleryTitle, byte[] galleryData) {
        this.galleryTitle = galleryTitle;
        this.galleryData = galleryData;
    }

    public GalleryVO(String uuid, String galleryTitle, byte[] galleryData) {
        this.uuid = uuid;
        this.galleryTitle = galleryTitle;
        this.galleryData = galleryData;
    }
	
}
