package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import cartBean.ItemDTO;

public class ItemDAO {
	
	public static Connection getConnection() throws Exception {
//		Class.forName("oracle.jdbc.OracleDriver");
//		
//		String url = "jdbc:oracle:thin:@localhost:1521:xe";
//		String user = "pass";
//		String pw = "1234";
//		
//		Connection con= DriverManager.getConnection(url, user, pw);//지역변수 : 반드시 초기화
		
		//connetion pool 테스트 해봐야함
		Connection con = null;
		try {
			Context init = new InitialContext();
			
			DataSource ds =(DataSource) init.lookup("java:comp/env/jdbc/baskinrobbinsDB");
			con = ds.getConnection();
			System.out.println("연결 성공!");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println("연결 실패!");
		}
		return con;
	}
	
	private static ItemDAO instance=new ItemDAO();
	private DataSource dataSource;
	private ItemDAO() {
	}
	public static ItemDAO getInstance() {
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
	
	/* 1번 기능
	 * getAllItemList() : ArrayList<ItemDTO>
	 */
	public ArrayList<ItemDTO> getAllItemList() throws SQLException{
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<ItemDTO> list=new ArrayList<ItemDTO>();
		try {
			con=dataSource.getConnection();
			String sql="select object_code,object_name,object_price from 테이블이름 order by object_code desc";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				ItemDTO dto=new ItemDTO();
				dto.setObject_code(rs.getString(1));
				dto.setObject_name(rs.getString(2));
				dto.setObject_price(rs.getInt(3));
				list.add(dto);
			}
		}finally {
			closeAll(rs, pstmt, con);
		}
		return list;
	}
	public ItemDTO findItemByNO(String object_code) {
		return null;
	}
	
	/* 2번 기능
	 * findItemByNo(String itemNo) : ItemDTO
	 */
	public ItemDTO findItemByNo(String object_code) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ItemDTO dto = null;
		
		try {
			con = dataSource.getConnection();
			String sql = "SELECT object_code, object_name, object_price, object_allergy "
					+ "FROM item WHERE item_no = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, object_code);
			rs = pstmt.executeQuery();
			if (rs.next())
				dto = new ItemDTO();
		} finally {
			closeAll(rs, pstmt, con);
		}
		
		return dto;
	}
	
	/* 3번 기능
	 * registerItem(ItemDTO) : void
	 */
	public void registerItem(ItemDTO dto) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = dataSource.getConnection();
			String sql = "INSERT INTO item(object_code, object_name, object_price, object_allergy) "
					+ "VALUES(item_seq.nextval,  ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getObject_name());
			pstmt.setInt(2,dto.getObject_price());
			pstmt.setString(3, dto.getObject_allergy());
			pstmt.executeUpdate();
					
		} finally {
			closeAll(pstmt, con);
		}
	}
}//class

