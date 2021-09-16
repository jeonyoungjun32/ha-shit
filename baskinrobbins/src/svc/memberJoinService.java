package svc;

import java.sql.Connection;

import dao.MemberDAO;

import static db.Jdbcutil.*;
import vo.Member;

public class memberJoinService {
	
	public boolean JoinMember(Member member) throws Exception {
		
		Connection con = getConnection();
		
		MemberDAO memberDAO = MemberDAO.getInstance();
		
		memberDAO.setConnection(con);
		
		memberDAO.insertMember(member);
		
		
		return false;
	}
}
