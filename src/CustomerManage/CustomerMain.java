package CustomerManage;

import java.util.List;
import java.util.Scanner;

public class CustomerMain {
	
	CustomerDAO dao;
	
	public CustomerMain(){
		dao = new CustomerDAO();
	}
	
	public List<CustomerDTO> select() {
		List<CustomerDTO> list = null;
		list = dao.select();
		
		return list;
		//스윙에서 list를 출력받을것
		

		/*for(CustomerDTO dto :list) {
			int no = dto.getNo();
			String name = dto.getName();
			String tel = dto.getTel();
			int stamp = dto.getStamp();*/
		
			
	}
	//회원 등록
	public void insert(String No, String Name, String Tel) {
		
		CustomerDTO dto = new CustomerDTO();
		
		
		String no = No;
		int ChangeNo = Integer.parseInt(no);
		String name = Name;
		String tel = Tel;
		int ChangeStamp =0;
		

		dto.setNo(ChangeNo);
		dto.setName(name);
		dto.setTel(tel);
		dto.setStamp(ChangeStamp);

		dao.insert(dto);
	}
	
	
	//회원 정보 수정
	public void update(String No, String Name, String Tel) {
	
		CustomerDTO dto = new CustomerDTO();
		
		String no = No;
		int ChangeNo = Integer.parseInt(no);
		
		String name = Name;
		
		String tel = Tel;
		
		int ChangeStamp = 0;
	
		dto.setNo(ChangeNo);
		dto.setName(name);
		dto.setTel(tel);
		dto.setStamp(ChangeStamp);
		
		dao.update(dto);
		
	}
	//스텝프 추가
	public void update_ST(int No, String Stamp) {
		
		CustomerDTO dto = new CustomerDTO();
		String stamp =Stamp;
		int ChangeStamp = Integer.parseInt(stamp);
	
		dto.setNo(No);
		dto.setName(null);
		dto.setTel(null);
		dto.setStamp(ChangeStamp);
		
		dao.update_ST(dto);
		
	}		
	private void delete(int No) {
		dao.delete(No);
		
	}
}

	



	

	


