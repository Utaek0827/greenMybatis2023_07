package aaa.control;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import aaa.model.Member;
import jakarta.validation.Valid;

@Service
//@Valid --> spring 에서 이 객체에 대한 멤버변수의 에러 점검
public class JoinChk {

	public boolean hasErrors(Member mem, BindingResult bRes) {
		
		// 에러가 없으면 false
		
		System.out.println("JoinChk hasErrors() 진입");
		
		//spring의 validation 에서 에러 자동처리
		if(bRes.hasErrors()) {
			System.out.println("@Valid Member mem에 의한 spring 에러 처리");
			return true;
		}
		
		System.out.println("mem.getPw1():"+mem.getPw1());
		System.out.println("mem.getPw2():"+mem.getPw2());

		if(!mem.getPw1().equals(mem.getPw2())) {
			System.out.println("암호 불일치");
							//필드명,에러코드,에러메세지
			bRes.rejectValue("pw2",null ,"암호가 일치하지 않습니다.");
			return true;
		}
		
		
		return false;
	}

}
