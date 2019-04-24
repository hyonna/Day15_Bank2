package com.account;

import java.util.Scanner;

import com.member.MemberDTO;
import com.util.DBConnector;
import com.util.Session;

public class AccountService {
	
	private Scanner sc;
	private AccountDAO accountDAO;
	
	public AccountService() {
		
		sc = new Scanner(System.in);
		accountDAO = new AccountDAO();
	}

	
	public String insert() {
		
		String message = "계좌개설 성공";
		
		AccountDTO accountDTO = new AccountDTO();
		
		System.out.println("계좌번호 입력");
		accountDTO.setAccountnum(sc.next());
		
		System.out.println("계좌이름 입력");
		accountDTO.setAccountname(sc.next());
		
		accountDTO.setId(((MemberDTO)(Session.member)).getId());
		
		int result = 0;
		
		try {
			
			result = accountDAO.insert(accountDTO, DBConnector.getconnect());
			if(result<1) {
				
				throw new Exception();
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			message = "계좌개설 실패";
			
		}
		
		return message;
		
	}
}
