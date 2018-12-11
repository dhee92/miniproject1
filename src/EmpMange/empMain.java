package EmpMange;

import java.util.List;
import java.util.Scanner;

import CustomerManage.CustomerDAO;

public class empMain{
	
	empDAO dao;
	
	public empMain(){
		dao = new empDAO();
	}	
	
	public void delete(String No) {		
		int chgNo = Integer.parseInt(No);
		
		dao.delete(chgNo);
	}
	
	public void update_Info(String No, String Name, String Tel) {
		
		empDTO dto = new empDTO();
		
		int ChNo=Integer.parseInt(No);
		dto.setNo(ChNo);	
		dto.setName(Name);
		dto.setTel(Tel);
		
		//변경할 필요 없는 근무시간, 시급
		dto.setWorkhour(0);		
		dto.setMsalary(0);
		
		dao.update_Sal(dto);
	}	
	
	//시급 변화
	public void update_sal(String No, String Sal) {
		
		empDTO dto = new empDTO();
		int ChNo = Integer.parseInt(No);
		dto.setNo(ChNo);
		int ChSal=Integer.parseInt(Sal);
		dto.setMsalary(ChSal);
		
		//변경할 필요 없는 이름, 근무시간, 폰번호
		dto.setName(null);
		dto.setWorkhour(0);
		dto.setTel(null);
		
		dao.update_Sal(dto);
	}	
	
	//근무시간 추가
	public void update_WH(String No, String Whour) {
		
		empDTO dto = new empDTO();
			
		int ChNo=Integer.parseInt(No);
		dto.setNo(ChNo);		
		int ChWh = Integer.parseInt(Whour);
		dto.setWorkhour(ChWh);
		
		dto.setTel(null);
		dto.setMsalary(0);
		dto.setName(null);
		
		dao.update_WH(dto);
	}
	public void insert(String No, String Name, String tel, String Msal) {
		Scanner input = new Scanner(System.in);
		empDTO dto = new empDTO();
			
		int ChNo=Integer.parseInt(No);
		dto.setNo(ChNo);	
		dto.setName(Name);
		dto.setTel(tel);
		dto.setWorkhour(0);
		int ChMsal = Integer.parseInt(Msal);
		dto.setMsalary(ChMsal);
		
		dao.insert(dto);
	}
	
	public List<empDTO> select() {
		List<empDTO> list = null;
		list = dao.select();
			
		return list;			
		}

	
}