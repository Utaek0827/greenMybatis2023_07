package aaa.model;

import org.hibernate.validator.constraints.NotEmpty;

import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UUser {
	
	@NotEmpty(message = "아이디를 입력하세요")
	String pid;
	
	@NotEmpty(message = "비밀번호를 입력하세요")
	String pw;
	
	String pname;

	public UUser(String pid, String pw, String pname) {
		super();
		this.pid = pid;
		this.pw = pw;
		this.pname = pname;
	}
	
	

}
