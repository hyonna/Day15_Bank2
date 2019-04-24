package com.member;

import java.util.Scanner;

import com.util.Session;

public class MemberService {

	private Scanner sc;
	private MemberDAO memberDAO;

	public MemberService() {

		sc = new Scanner(System.in);
		memberDAO = new MemberDAO();

	}

	public String insert() {

		MemberDTO memberDTO = new MemberDTO();

		System.out.println("ID를 입력하세요.");
		memberDTO.setId(sc.next());

		System.out.println("PW를 입력하세요.");
		memberDTO.setPw(sc.next());

		System.out.println("이름을 입력하세요.");
		memberDTO.setName(sc.next());

		System.out.println("전화번호를 입력하세요.");
		memberDTO.setPhone(sc.next());

		System.out.println("E-mail을 입력하세요.");
		memberDTO.setEmail(sc.next());

		int result = 0;
		String message = "회원가입성공";

		try {

			result = memberDAO.insert(memberDTO);
			if (result < 1) {

				throw new Exception();

			}

		} catch (Exception e) {

			e.printStackTrace();
			message = "회원가입 실패";

		}

		return message;

	}

	public String login() {

		MemberDTO memberDTO = new MemberDTO();

		System.out.println("ID를 입력하세요.");
		memberDTO.setId(sc.next());

		System.out.println("PW를 입력하세요.");
		memberDTO.setPw(sc.next());

		String message = "로그인실패";

		try {

			memberDTO = memberDAO.login(memberDTO);
			Session.member = memberDTO;

		} catch (Exception e) {

			e.printStackTrace();

		}

		if (memberDTO != null) {

			message = "로그인성공";

		}

		return message;

	}

}
