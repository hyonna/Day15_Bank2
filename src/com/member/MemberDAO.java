package com.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.account.AccountDTO;
import com.util.DBConnector;

public class MemberDAO {

	// 회원가입
	public int insert(MemberDTO memberDTO) throws Exception {

		int result = 0;

		Connection con = DBConnector.getconnect();

		String sql = "insert into member values(?,?,?,?,?)";

		PreparedStatement st = con.prepareStatement(sql);

		st.setString(1, memberDTO.getId());
		st.setString(2, memberDTO.getPw());
		st.setString(3, memberDTO.getName());
		st.setString(4, memberDTO.getPhone());
		st.setString(5, memberDTO.getEmail());

		result = st.executeUpdate();

		DBConnector.disconnect(st, con);

		return result;
	}

	// 로그인
	public MemberDTO login(MemberDTO memberDTO) throws Exception {
		
		Connection con = DBConnector.getconnect();

		String sql = "select * from member where id=? and pw=?";

		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, memberDTO.getId());
		st.setString(2, memberDTO.getPw());
		
		ResultSet rs = st.executeQuery(); //셀렉트는 쿼리
		
		if(rs.next()) {
			
			//AccountDTO accountDTO = new AccountDTO();
			memberDTO.setName(rs.getString("name"));
			memberDTO.setPhone(rs.getString("phone"));
			memberDTO.setEmail(rs.getString("email"));
//			accountDTO.setAccountname(rs.getString("accountname"));
//			accountDTO.setAccountnum(rs.getString("accountnum"));
//			accountDTO.setBalance(rs.getLong("balance"));
//			accountDTO.setMakedate(rs.getDate("makedate"));
			
			//memberDTO.setAccountDTO(accountDTO);
			
		} else {
			
			memberDTO = null; //로그인 안되었을때
			
		}

		DBConnector.disconnect(rs, st, con);
		
		return memberDTO;

		

	}

}
