package CustomerManage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbcp2.BasicDataSource;

public class CustomerDAO {
	BasicDataSource ds;
	
	CustomerDAO() {
		ds = new BasicDataSource();
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver"); //setDriverClassName : 드라이버에 대한 이름을 알려주라는 기능 
		ds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		ds.setUsername("scott");
		ds.setPassword("tiger");
		ds.setInitialSize(5); 
		
	}
	
	public List<CustomerDTO> select() {
		
		List<CustomerDTO> list = new ArrayList<CustomerDTO>(5);
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		try {
			con = ds.getConnection(); //jdbc 연결
			String sql = "select * from customer order by no";
			pstmt = con.prepareStatement(sql); //명령문 
			rs = pstmt.executeQuery();
			//db 에서 데이터를 읽어왔는데 이걸 담을 힙을 만들어야지 
			while(rs.next()) {
				CustomerDTO dto = new CustomerDTO();
				dto.setNo(rs.getInt("no"));
				dto.setName(rs.getString("name"));
				dto.setTel(rs.getString("tel"));
				dto.setStamp(rs.getInt("stamp"));
				
				list.add(dto);
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			try {
			if(rs!=null) {rs.close();}
			if(pstmt!=null) {pstmt.close();}
			if(con!=null) {con.close();}
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public void insert(CustomerDTO dto) {
		Connection con = null;
		String sql = "insert into customer values(?,?,?,?)";
		PreparedStatement pstmt = null;
		
			try {
				con = ds.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, dto.getNo());
				pstmt.setString(2, dto.getName());
				pstmt.setString(3, dto.getTel());
				pstmt.setInt(4, dto.getStamp());
				int result = pstmt.executeUpdate();
				
				if(result == 1) {
					System.out.println("데이터 저장 성공");
				}else {
					System.out.println("데이터 저장 실패");
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			} finally {
				try {
					
					if(pstmt!=null) {pstmt.close();}
					if(con!=null) {con.close();}
					}catch (SQLException e) {
						e.printStackTrace();
					}
				}
		}


	public void update(CustomerDTO dto) {
		Connection con = null; 
		PreparedStatement pstmt = null;
		String sql = "update customer set name = ?, tel =?, stamp = ? where no = ?";
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getTel());
			pstmt.setInt(3, dto.getStamp());
			pstmt.setInt(4, dto.getNo());
			
			int result = pstmt.executeUpdate();
			
			if(result == 1) {
				System.out.println("데이터 수정 성공");
			}else {
				System.out.println("데이터 수정 실패");
			}
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) { pstmt.close(); }
				if(con != null)  { con.close(); }
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		}

	public void delete(int no) {

		Connection  con = null; 
		PreparedStatement pstmt = null;
		String sql = "delete from customer where no = ? ";
		
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			int result = pstmt.executeUpdate();
			
			if(result == 1) {
				System.out.println("데이터 삭제 성공");
			}else {
				System.out.println("데이터 삭제 실패");
			}
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) { pstmt.close(); }
				if(con != null)  { con.close(); }
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}

		
		
	
		
		
	
	
	
	


