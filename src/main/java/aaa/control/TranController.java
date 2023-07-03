package aaa.control;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import aaa.db.BoardDTO;
import aaa.db.TranMapper;
import aaa.db.TranService;
import jakarta.annotation.Resource;

@Controller
public class TranController {
	
	@Resource
	TranMapper tm;
	
	@Resource
	TranService service;
	
	
	// spring 기본으로 제공하는 인터페이스
	@Resource
	PlatformTransactionManager manager;
	

	@RequestMapping("/tran/list")
	String list(Model mm) {
		
		mm.addAttribute("mainData", tm.list());
		return "tran/list";
	}
	
	ArrayList<BoardDTO> arrs(int ...arr){
		ArrayList<BoardDTO> res = new ArrayList<>();
		
		for (int i : arr) {
			res.add(new BoardDTO(i,"제목"+i, "유택"+i));
		}
		return res;
	}
	
	//rollback 필요없음 : 에러시 모두 실행 

	@RequestMapping("/tran/insert1")
	String insert1() {
		try {
			tm.insert1(arrs(99,98,71));
		} catch (Exception e) {
			System.out.println("insert1에러발생 >>"+e.getMessage());
		}
		return "redirect:list";
	}
	
	//rollback 필요함 : 에러 발생 이전 내용은 저장되어 있음 //롤백 실행하지않음

	@RequestMapping("/tran/insert2")
	String insert2() {
		try {
			tm.insert2(arrs(99,98,71));
		} catch (Exception e) {
			System.out.println("insert2에러발생 >>"+e.getMessage());
		}
		return "redirect:list";
	}
	
	//rollback 필요하지 않음 : 에러 발생 이전 내용은 저장되어 있음 // 트랙잭션 실행1
	@RequestMapping("/tran/insert3")
	String insert3() {
		
		TransactionStatus status = manager.getTransaction(new DefaultTransactionDefinition());
		
		
		try {
			tm.insert2(arrs(99,98,71));
			manager.commit(status); // 정상실행시 commit
			
			
		} catch (Exception e) {
			manager.rollback(status); // 에러시 rollback
			System.out.println("insert3에러발생 >>"+e.getMessage());
		}
		return "redirect:list";
	}
	
	//rollback 필요하지 않음 : 에러 발생 이전 내용은 저장되어 있음 // 트랙잭션 실행2
	@RequestMapping("/tran/insert4")
	String insert4() {
		try {

			service.tranGo();
		} catch (Exception e) {
			System.out.println("insert4 에러발생 >>"+e.getMessage());
		}
		
		//try ~ catch 존재시 @trasnational 실행 안함
		
		return "redirect:list";
	}
	
	
	
}
