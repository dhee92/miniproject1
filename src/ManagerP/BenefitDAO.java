package ManagerP;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbcp2.BasicDataSource;

class BenefitDAO {
	//프로그램을 처음 시작할 때 db에 날짜 값 생성하게 하기
	
	
	BasicDataSource ds;
	
	BenefitDAO(){
		
		ds = new BasicDataSource();
		
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		ds.setUsername("scott");
		ds.setPassword("tiger");
		ds.setInitialSize(5);	
	}
	
	public List<BenefitDTO> ShowBenefit() {
		//전체 이익 출력
		List<BenefitDTO> list = new ArrayList<BenefitDTO>();
		
		Connection con = null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			con = ds.getConnection();
			String sql =  "select * from benefit";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();                
			while(rs.next()) {
				BenefitDTO dto = new BenefitDTO();
				dto.setYyyymmdd("YYYYMMDD");       // 컴퓨터로부터 날짜 입력 받기
				dto.setBenefit(rs.getInt("moneyofday"));	
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs !=null ) {rs.close();}
				if(pstmt!=null) { pstmt.close();}
				if(con!=null) {	con.close();}
			} catch (Exception e) {
				e.printStackTrace();
			}			
		}		
		return list;
	}
	
	
	public int ShowBenefit_Selectday(String Date) {
		//입력받은 날짜별 출력
		int money=0;
		
		Connection con = null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		
		List< BenefitDTO > list = new ArrayList<BenefitDTO>();	
		
		try {
			// BenefitDTO dto = new BenefitDTO();
			con = ds.getConnection();
			String sql =  "select * from benefit"; 
			pstmt = con.prepareStatement(sql);
			rs=pstmt.executeQuery();                
			while(rs.next()) {
				BenefitDTO dto = new BenefitDTO();
				System.out.println(rs.getString("yyyymmdd"));
				dto.setYyyymmdd(rs.getString("yyyymmdd"));  
				System.out.println(rs.getInt("moneyofday"));//이 날짜는 날짜 입력 사람으로부터 받아 올것
				dto.setBenefit(rs.getInt("moneyofday"));
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs !=null ) {rs.close();}
				if(pstmt!=null) { pstmt.close();}
				if(con!=null) {	con.close();}
			} catch (Exception e) {
				e.printStackTrace();
			}			
		}		
		for(BenefitDTO bdto : list) {
			System.out.println(bdto.getYyyymmdd());
			System.out.println(bdto.getBenefit());
			
			if(bdto.getYyyymmdd().equals(Date)) {
				money=bdto.getBenefit();
				break;
			}
		}
		return money;
	}
	
	
	
	public void updateBenefit(BenefitDTO dto) {
		Connection con = null;
		PreparedStatement pstmt=null;
		
		String sql = "update benefit set moneyofday=moneyofday+? where YYYYMMDD = ?";
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			String date = dto.getYyyymmdd();
			System.out.println(date);
			System.out.println(dto.getBenefit());
						
			pstmt.setInt(1, dto.getBenefit());
			pstmt.setString(2,  date);
			
			pstmt.executeUpdate();
										
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) {pstmt.close();}
				if(con!=null) {con.close();}			
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
		
	}
	
	
	

}
