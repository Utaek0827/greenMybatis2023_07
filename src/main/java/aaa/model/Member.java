package aaa.model;

import org.hibernate.validator.constraints.NotEmpty;

import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class Member {

	//유효성 검사 정의
	@NotEmpty(message = "아이디를 입력하세요")
	@Size(min = 3, max = 10) //message를 입력하지 않을 경우 "크기가 4에서 10사이어야 합니다." 자동설정
	String pid;
	
	@NotEmpty(message = "비밀번호를 입력하세요")
	@Size(min = 4, max = 13, message = "4~12 자리 이어야 합니다.")
	String pw1;
	
	@NotEmpty(message = "비밀번호를 확인하세요")
	String pw2;
	
	@NotEmpty // message를 입력하지 않을 경우 "비어 있을 수 없습니다" 자동설정
	String pname;
	
	String email;
	
}
