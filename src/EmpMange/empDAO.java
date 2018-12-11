package EmpMange;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbcp2.BasicDataSource;

public class empDAO {
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
			String sql = "select * from employee order by no";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				empDTO dto = new empDTO();
				dto.setNo(rs.getInt("no"));
				dto.setMsalary(rs.getInt("msalary"));
				dto.setName(rs.getString("name"));
				dto.setWorkhour(rs.getInt("workhour"));
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
		String sql = "insert into employee values(?, ?, ?, ?, ?)";
		PreparedStatement pstmt  = null;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, dto.getNo());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getTel());
			pstmt.setInt(4, dto.getWorkhour());
			pstmt.setInt(5, dto.getMsalary());
			pstmt.executeUpdate();
						
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
	
	
	//개인정보 수정
	public void update_Info(empDTO dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "update employee set name=?,  tel=? , where no=?";
	
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
		
			
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getTel());
			pstmt.setInt(3, dto.getNo());
			pstmt.executeUpdate();
				
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
	
	//시급 수정
	public void update_Sal(empDTO dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "update employee set Msalary=? , where no=?";
	
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
					
			pstmt.setInt(1, dto.getMsalary());
			pstmt.setInt(2, dto.getNo());
			pstmt.executeUpdate();
				
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
	
	//근무시간 수정
	public void update_WH(empDTO dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "update employee set workhour=workhour+? , where no=?";
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
					
			pstmt.setInt(1, dto.getWorkhour());
			pstmt.setInt(2, dto.getNo());
			pstmt.executeUpdate();
				
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
		String sql = "delete from employee where no = ?";
		
		try {
			con = ds.getConnection();
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			pstmt.executeUpdate();
						
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