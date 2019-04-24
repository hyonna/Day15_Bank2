package com.control;

import java.util.Scanner;

import com.member.MemberDAO;
import com.member.MemberService;
import com.util.Session;
import com.view.View;

public class MemberController {

	private MemberService ms;
	private View view;
	private Scanner sc;
	private AccountController ac;

	public MemberController() {

		ms = new MemberService();
		view = new View();
		sc = new Scanner(System.in);
		ac = new AccountController();
	}

	public void start() {

		boolean check = true;
		String message = null;

		while (check) {

			if (Session.member != null) {

				System.out.println("1. MyPage");
				System.out.println("2. 로그아웃");
				System.out.println("3. 계좌관리");
				int select = sc.nextInt();
				
				if (select == 1) {
					
					view.view();
					
				} else if(select == 2) {
					
					Session.member = null;

				} else {
					
					ac.start();
					
				}
				

			} else {
				
				System.out.println("1. 회원가입");
				System.out.println("2. 로 그 인");
				System.out.println("3. 종     료");
				int select = sc.nextInt();
				
				switch (select) {
				case 1:
					
					message = ms.insert();
					view.view(message);
					break;
					
				case 2:
					
					message = ms.login();
					view.view(message);
					break;
					
				default:
					check = !check;
				}
				
			}
				

			
		}
	}

}
