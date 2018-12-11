package EmpMange;

import java.util.List;
import java.util.Scanner;

import CustomerManage.CustomerDAO;

public class empMain{
	
	empDAO dao;
	
	public empMain(){
		dao = new empDAO();
	}	
	
	public void delete(int No) {		
		int chgNo = No;
		
		dao.delete(chgNo);
	}
	
	public void update_Info(int No, String Name, String Tel) {
		
		empDTO dto = new empDTO();
		
		dto.setNo(No);
		dto.setName(Name);
		dto.setTel(Tel);
		
		//변경할 필요 없는 근무시간, 시급
		dto.setWorkhour(0);		
		dto.setMsalary(0);
		
		dao.update_Sal(dto);
	}	
	
	//시급 변화
	public void update_sal(int No, int Sal) {
		
		empDTO dto = new empDTO();
		dto.setNo(No);
		dto.setMsalary(Sal);
		
		//변경할 필요 없는 이름, 근무시간, 폰번호
		dto.setName(null);
		dto.setWorkhour(0);
		dto.setTel(null);
		
		dao.update_Sal(dto);
	}	
	
	//근무시간 추가
	public void update_WH(int No, int Whour) {
		
		empDTO dto = new empDTO();
			
		
		dto.setNo(No);		
		dto.setWorkhour(Whour);
		
		dto.setTel(null);
		dto.setMsalary(0);
		dto.setName(null);
		
		dao.update_WH(dto);
	}
	public void insert(int No, String Name, String tel, int Msal) {
		Scanner input = new Scanner(System.in);
		empDTO dto = new empDTO();
			
		dto.setNo(No);
		dto.setName(Name);
		dto.setTel(tel);
		dto.setWorkhour(0);
		dto.setMsalary(Msal);
		
		dao.insert(dto);
	}
	
	public List<empDTO> select(empDAO dao) {
		List<empDTO> list = null;
		list = dao.select();
			
		return list;			
		}

	
}