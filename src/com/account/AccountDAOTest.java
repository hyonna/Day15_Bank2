package com.account;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.member.MemberDAO;
import com.member.MemberDTO;
import com.util.DBConnector;

public class AccountDAOTest {
	
	private AccountDAO accountDAO;
	
	@BeforeClass
	public static void start() {
		
		
	}
	
	@AfterClass
	public static void end() {
		
		
	}
	
	
	@Before
	public void makeDAO() {
		
		accountDAO = new AccountDAO();
		
	}

	@Test
	public void test() throws Exception {
		
		Connection con = DBConnector.getconnect();
		AccountDTO accountDTO = new AccountDTO(); 
		
		accountDTO.setAccountnum("2");
		accountDTO.setAccountname("test");
		accountDTO.setId("iu");
		
		int result = accountDAO.insert(accountDTO, con);
		assertEquals(1, result);
	}
	
	
	@After
	public void after() {
		
		
	}

}
