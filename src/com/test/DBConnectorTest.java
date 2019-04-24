package com.test;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Test;

import com.util.DBConnector;

public class DBConnectorTest {

	//DB연결 테스트
	@Test
	public void test() throws Exception {
		Connection con = DBConnector.getconnect();
		assertNotNull(con);
	}

}
