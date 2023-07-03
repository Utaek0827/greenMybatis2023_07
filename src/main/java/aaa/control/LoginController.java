package aaa.control;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import aaa.model.HandPhone;
import aaa.model.LoginChk;
import aaa.model.Member;
import aaa.model.Shape;
import aaa.model.Stud;
import aaa.model.UUser;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class LoginController {

		
	@GetMapping(value = "/basic/login")
	String loginForm(UUser uuser) { 
		// Member mem가 있어야 joinForm을 get으로 열었을 때 멤버요소에 접근가능하여 에러가 나지 않는다.
		// 반대로 Member mem가 없다면 에러 발생
		// @Valid Member mem 매개변수에 @Valid를 넣으면 유효성 검사하여 에러메세지를 출력하려는 에러가 발생된다.
		System.out.println("/basic/loginForm 실행");


		return "basic/loginForm";
	}
	
	@Resource
	LoginChk logchk;
	
	@PostMapping(value = "/basic/loginRes")
	String loginComplete(@Valid UUser uuser, BindingResult bRes, HttpSession session) {
		System.out.println("/basic/loginRes 실행");

		//에러가 있다면 form 페이지로 view 변경
		if(logchk.hasErrors(uuser, bRes, session)) {
			return "basic/loginForm"; //view 페이지 진입임(url 변경이 아님)
		}
		

		return "basic/loginRes";
	}
	
	@GetMapping(value = "/basic/logOut")
	String logOut(UUser uuser, HttpSession session) {
		System.out.println("로그아웃");
		session.removeAttribute("user");


		return "basic/loginForm";
	}
	
}
