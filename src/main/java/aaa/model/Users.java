package aaa.model;

import java.util.HashMap;
import java.util.Set;

import org.springframework.stereotype.Component;

@Component
public class Users {
	
	HashMap<String, UUser> users;
	

	public Users() {
		users = new HashMap<>();
		users.put("aaa", new UUser("aaa","1111","제빵왕"));
		users.put("bbb", new UUser("bbb","2222","김탁구"));
		users.put("ccc", new UUser("ccc","3333","서태조"));
		users.put("ddd", new UUser("ddd","4444","구마준"));
		users.put("eee", new UUser("eee","5555","겜제빵"));
		users.put("fff", new UUser("fff","6666","타꼬야끼"));

	}
	
	
	

}
