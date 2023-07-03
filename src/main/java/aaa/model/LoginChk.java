package aaa.model;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import aaa.model.Member;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Service
//@Valid --> spring 에서 이 객체에 대한 멤버변수의 에러 점검
public class LoginChk {
	
	@Resource
	Users users;
	
	public boolean hasErrors(UUser uuser, BindingResult bRes, HttpSession session) {
		
		// 에러가 없으면 false
		
		System.out.println("LoginChk hasErrors() 진입"+uuser.pid+","+uuser.pw);
		
		System.out.println(users.users.size());
		
		//spring의 validation 에서 에러 자동처리
		//빈칸이 있는지 있는지 없는지 테스트
		if(bRes.hasErrors()) {
			System.out.println("@Valid Member mem에 의한 spring 에러 처리");
			return true;
		}
		
		if(users.users.get(uuser.pid) == null) {
			
			System.out.println("계정 존재하지 않음 불일치");
			bRes.rejectValue("pid",null ,"계정이 존재하지 않습니다.");
			return true;
		}
		
		if(users.users.get(uuser.pid) != null) {
			
			if(!users.users.get(uuser.pid).pw.equals(uuser.pw)) {
				System.out.println("암호 불일치");
				bRes.rejectValue("pw",null ,"암호가 일치하지 않습니다.");
				return true;			
			}
		}
		
		session.setAttribute("user", users.users.get(uuser.pid));
		
		
				
		return false;
	}

}
