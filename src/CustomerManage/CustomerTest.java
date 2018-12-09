package CustomerManage;

import java.util.List;
import java.util.Scanner;

public class CustomerTest {
	
	public static void select(CustomerDAO dao) {
		List<CustomerDTO> list = null;
		list = dao.select();
		
		System.out.println("번호 \t 이름 \t\t 이메일 \t 전화번호");
		System.out.println("-------------------------------------------------------------------------");
		
		for(CustomerDTO dto :list) {
			int no = dto.getNo();
			String name = dto.getName();
			String tel = dto.getTel();
			int stamp = dto.getStamp();
			
			System.out.printf("%d \t %s \t %s \t %d", no, name, tel, stamp);
			
			
		}
	}
	
	public static void insert(CustomerDAO dao) {
		Scanner input = new Scanner(System.in);
		CustomerDTO dto = new CustomerDTO();
		
		System.out.println("테이블에 저장할 값 입력 받기");
		System.out.print("회원 번호 입력");
		String no = input.nextLine();
		int ChangeNo = Integer.parseInt(no);
		System.out.print("이름 입력");
		String name = input.nextLine();
		System.out.print("전화번호 입력");
		String tel = input.nextLine();
		System.out.print("스탬프 입력");
		String stamp = input.nextLine();
		int ChangeStamp = Integer.parseInt(stamp);
		
		//위에서 키보드로 입력받은 데이터를 dto 힙에 일단 저장하고 
		dto.setNo(ChangeNo);
		dto.setName(name);
		dto.setTel(tel);
		dto.setStamp(ChangeStamp);
		
		//위에 저장된 dto 데이터를 db에 저장 
		dao.insert(dto);
	}
	
	public static void update(CustomerDAO dao) {
		Scanner input = new Scanner(System.in);
		CustomerDTO dto = new CustomerDTO();
		
		System.out.println("회원정보 수정.....");
		System.out.print("수정할 회원번호를 입력하세요");
		
		String no = input.nextLine();
		int chgNo = Integer.parseInt(no);
		
		System.out.print("수정할 이름을 입력하세요");
		String name = input.nextLine();
		System.out.print("수정할 전화번호를 입력하세요");
		String tel = input.nextLine();
		System.out.print("수정할 스탬프를 입력하세요");
		String stamp = input.nextLine();
		int chgStamp = Integer.parseInt(stamp);
		
		dto.setNo(chgNo);
		dto.setName(name);
		dto.setTel(tel);
		dto.setStamp(chgStamp);
		
		dao.update(dto);
		
	}
	
	private static void delete(CustomerDAO dao) {
		Scanner input = new Scanner(System.in);
		CustomerDTO dto = new CustomerDTO();
		
		System.out.println("회원정보 삭제.....");
		System.out.print("삭제할 회원번호를 입력하세요");
		
		String no = input.nextLine();
		int chgNo = Integer.parseInt(no);
		
		dto.setNo(chgNo);
		dao.delete(dto);
		
		
	}

	public static void main(String[] args) {

		CustomerDAO dao = new CustomerDAO(); //1
		Scanner input = new Scanner(System.in);//2
		
		while(true) {//3
		System.out.println("***메뉴 구성***");
		System.out.println("1.프로그램 종료");
		System.out.println("2. 데이터 저장");
	 	System.out.println("3. 데이터 읽어오기");
	 	System.out.println("4. 데이터 수정하기");
	 	System.out.println("5. 데이터 삭제하기");
	 	System.out.print(">>메뉴선택 : ");
	 	int choice = input.nextInt();
	 	
	 	switch(choice) {
	 	case 1:
	 		System.out.println("프로그램 종료");
	 		return; 
	 	case 2:
	 		insert(dao);
	 		break;
	 	case 3:
	 		select(dao);  
	 		break;
	 	case 4:
	 		update(dao);
	 		break;
	 	case 5:
	 		delete(dao);
	 		break;
	 		
	 	default:
	 		break;
	 	
	 	}
	 	
	 	
	 	
		}
	

	}

	



	

	

}
