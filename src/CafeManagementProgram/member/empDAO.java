package CafeManagementProgram.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbcp2.BasicDataSource;

class empDAO {
		BasicDataSource ds;
	
	empDAO(){
		ds = new BasicDataSource(); 
		
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		ds.setUsername("scott");
		ds.setPassword("tiger");
		
		ds.setInitialSize(5); 
	}
	
	public List<empDTO> select(){
		List<empDTO> list = new ArrayList<empDTO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = ds.getConnection();
			String sql = "select * from customer order by no";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				empDTO dto = new empDTO();
				dto.setNo(rs.getInt("no"));
				dto.setSalary(rs.getInt("salary"));
				dto.setName(rs.getString("name"));
				dto.setWork(rs.getString("work"));
				dto.setTel(rs.getString("tel"));
				list.add(dto);
			}
	}catch (SQLException e) {
		e.printStackTrace();
	}finally {
		try {
			if(rs != null) { rs.close(); }
			if(pstmt != null) { pstmt.close(); }
			if(con != null)  { con.close(); }
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	return list;
}
	public void insert(empDTO dto) {
		Connection con = null;
		String sql = "insert into customer values(?, ?, ?, ?, ?)";
		PreparedStatement pstmt  = null;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, dto.getNo());
			pstmt.setInt(2, dto.getSalary());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getWork());
			pstmt.setString(5, dto.getTel());
			
			int result = pstmt.executeUpdate();
			
			if(result == 1) {
				System.out.println("데이터 저장 성공.");
			} else {
				System.out.println("데이터 저장 실패.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) { pstmt.close(); }
				if(con != null)  { con.close(); }
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
}

public void update(empDTO dto) {
	Connection con = null;
	PreparedStatement pstmt = null;
	String sql = "update customer set name=?,  tel=? , work = ? , where no=?, where salary=?";
	
	try {
		con = ds.getConnection();
		pstmt = con.prepareStatement(sql);
		
		
		pstmt.setInt(1, dto.getNo());
		pstmt.setInt(2, dto.getSalary());
		pstmt.setString(3, dto.getName());
		pstmt.setString(4, dto.getWork());
		pstmt.setString(5, dto.getTel());
		/*pstmt.setInt(4, dto.getNo());
		pstmt.setInt(5, dto.getSalary());*/
		
		int result = pstmt.executeUpdate();
		
		if(result == 1) {
			System.out.println("데이터 수정 성공.");
		} else {
			System.out.println("데이터 수정 실패.");
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		try {
			if(pstmt != null) { pstmt.close(); }
			if(con != null)  { con.close(); }
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
public void delete(int no) {
	Connection con = null;
	PreparedStatement pstmt = null;
	String sql = "delete from customer where no = ?";
	
	try {
		con = ds.getConnection();
		
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, no);
		
		int result = pstmt.executeUpdate();
		
		if(result == 1) {
			System.out.println("회원 삭제 성공.");
		} else {
			System.out.println("회원 삭제 실패");
		}
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		try {
			if(pstmt != null) { pstmt.close(); }
			if(con != null)  { con.close(); }
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
}