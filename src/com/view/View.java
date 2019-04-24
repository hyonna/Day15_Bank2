package com.view;

import com.member.MemberDTO;
import com.util.Session;

public class View {
	
	//출력전용
	
	public void view(String message) {
		
		System.out.println(message);
		
		
	}
	
	public void view() {
		
		//mypage
		
		MemberDTO memberDTO = (MemberDTO) Session.member; //세션 오브젝트 타입을 멤버디티오 타입으로 형변환
		System.out.println("================= 정보 ================");
		System.out.println("ID : " + memberDTO.getId());
		System.out.println("NAME : " + memberDTO.getName());
		System.out.println("PHONE : " + memberDTO.getPhone());
		System.out.println("EMAIL : " + memberDTO.getEmail());
//		System.out.println("계좌이름 : " + memberDTO.getAccountDTO().getAccountname());
//		System.out.println("계좌번호 : " + memberDTO.getAccountDTO().getAccountnum());
//		System.out.println("계좌잔고 : " + memberDTO.getAccountDTO().getBalance());
//		System.out.println("개설날짜 : " + memberDTO.getAccountDTO().getMakedate());
//		System.out.println("======================================");
	}

}
