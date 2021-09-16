package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import vo.Member;

public class MemberDAO {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;

	String sql = "";

	public static Connection getConnection() throws Exception {
//		Class.forName("oracle.jdbc.OracleDriver");
//		
//		String url = "jdbc:oracle:thin:@localhost:1521:xe";
//		String user = "pass";
//		String pw = "1234";
//		
//		Connection con= DriverManager.getConnection(url, user, pw);//지역변수 : 반드시 초기화

		// connetion pool 테스트 해봐야함
		Connection con = null;
		try {
			Context init = new InitialContext();

			DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/baskinrobbinsDB");
			con = ds.getConnection();
			System.out.println("연결 성공!");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println("연결 실패!");
		}
		return con;
		
		
		
	}
	
	private static MemberDAO instance=new MemberDAO();
	private DataSource dataSource;//DBCP
	private MemberDAO() {
		//this.dataSource=DataSourceManager.getInstance().getDataSource();
		//여기 ds = getConn 연결해야한다 ㅅㅂ
	}
	public static MemberDAO getInstance() {
		return instance;
	}
	public void closeAll(PreparedStatement pstmt,Connection con) throws SQLException {
		if(pstmt!=null)
			pstmt.close();
		if(con!=null)
			con.close();
	}
	public void closeAll(ResultSet rs,PreparedStatement pstmt,Connection con) throws SQLException {
		if(rs!=null)
			rs.close();
		closeAll(pstmt, con);
	}
	public Member findMemberById(String id) throws SQLException {
		Member vo=null;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=dataSource.getConnection();
			String sql="select name,address from member where id=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			if(rs.next())
				vo=new Member(id,null,rs.getString(1),rs.getString(2));
		}finally {
			closeAll(rs, pstmt, con);
		}
		return vo;
	}
	public ArrayList<String> getAddressKind() throws SQLException{
		ArrayList<String> list=new ArrayList<String>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=dataSource.getConnection();
			String sql="select distinct(address) from member";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next())
				list.add(rs.getString(1));
		}finally {
			closeAll(rs, pstmt, con);
		}
		return list;
	}
	public int getMemberTotalCount() throws SQLException {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int count=0;
		try {
			con=dataSource.getConnection();
			String sql="select count(*) from member";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next())
				count=rs.getInt(1);
		}finally {
			closeAll(rs, pstmt, con);
		}
		return count;
	}
	
	public ArrayList<Member> findMemberListByAddres(String address) throws SQLException{
		ArrayList<Member> list=new ArrayList<Member>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=dataSource.getConnection();
			String sql="select id,name from member where address=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, address);
			rs=pstmt.executeQuery();
			while(rs.next())
				list.add(new Member(rs.getString(1),null,rs.getString(2),null));
		}finally {
			closeAll(rs, pstmt, con);
		}
		return list;
	}
	
	public Member login(String id,String pw) throws SQLException {
		Member vo=null;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=dataSource.getConnection();
			String sql=
					"select name,address from member where id=? and pw=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs=pstmt.executeQuery();
			if(rs.next())
				vo=new Member(id,pw,rs.getString(1),rs.getString(2));
		}finally {
			closeAll(rs, pstmt, con);
		}
		return vo;
	}
	
	//회원가입 
	public void register(Member vo) throws SQLException {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=dataSource.getConnection();
			String sql="insert into member values(?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getAddress());
			pstmt.executeUpdate();
		}finally {
			closeAll(pstmt, con);
		}
	}
	
	public void updateMember(Member vo) throws SQLException {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=dataSource.getConnection();
			String sql=
			"update member set password=?,name=?,address=? where id=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, vo.getPw());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getAddress());
			pstmt.setString(4, vo.getId());
			pstmt.executeUpdate();
		}finally {
			closeAll(pstmt, con);
		}
		
	}
}
