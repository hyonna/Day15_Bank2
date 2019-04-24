package com.member;

import static org.junit.Assert.*;

import org.junit.Test;

public class MemberDAOTest {

	//로그인 테스트
	@Test
	public void loginTest() throws Exception {
		
		MemberDAO memberDAO = new MemberDAO();
		MemberDTO memberDTO = new MemberDTO();
		
		memberDTO.setId("iu");
		memberDTO.setPw("iu");
		
		memberDTO = memberDAO.login(memberDTO);
		assertNotNull(memberDTO);
	
	}
	
	// 회원가입 테스트
	//@Test
	public void test() throws Exception {
		MemberDAO memberDAO = new MemberDAO();
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("iu");
		memberDTO.setPw("iu");
		memberDTO.setName("iu");
		memberDTO.setPhone("iu");
		memberDTO.setEmail("iu");
				
		int result = memberDAO.insert(memberDTO);
		assertEquals(1, result);
	}

}
