package aaa.model;

import java.util.LinkedHashMap;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor // 기본생성자
@AllArgsConstructor // 모두들어있는 생성자
public class Person {

	String pname = "백승렬";
	boolean marriage = true;
	String gender="it인", email2="네이트";
	
	String [] genders = {"남성","it인","여성"};
	
	String [] emails = {"네이버","다음","네이트","구글","줌"};
	
	public Map<String, String> getHobby(){
		
		Map<String, String> res = new LinkedHashMap<>();
		res.put("coding", "코딩하기");
		res.put("programing", "프로그램만들기");
		res.put("debuging", "디버깅");
		res.put("project", "프로젝트");		
		
		return res;
		
	}
	
}
