package CafeManagementProgram.member;

import java.util.List;
import java.util.Scanner;

public class empTest{
	public static void delete(empDAO dao) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("*** 회원 삭제 기능 ***");
		System.out.print("삭제할 회원 번호 입력 : ");
		String no = input.nextLine();
		int chgNo = Integer.parseInt(no);
		
		dao.delete(chgNo);
	}
	
	public static void update(empDAO dao) {
		Scanner input = new Scanner(System.in);
		empDTO dto = new empDTO();
		
		System.out.println("회원 정보 수정...");
		System.out.print("수정할 회원번호를 입력하세요:");
		// int no = input.nextInt();
		String no = input.nextLine();
		int chgNo = Integer.parseInt(no);
		System.out.print("수정할 시급을 입력하세요:");
		String msalary = input.nextLine();
		int chgMsalary = Integer.parseInt(no);
		System.out.print("수정할 이름을 입력하세요:");
		String name = input.nextLine();
		System.out.print("수정할 근무시간을 입력하세요:");
		String workhour = input.nextLine();
		int chgWorkhour = Integer.parseInt(no);
		System.out.print("수정할 전화번호를 입력하세요:");
		String tel = input.nextLine();
		
		dto.setNo(chgNo);
		dto.setMsalary(chgMsalary);
		dto.setName(name);
		dto.setWorkhour(workhour);
		dto.setTel(tel);
		
		dao.update(dto);
	}
	public static void insert(empDAO dao) {
		Scanner input = new Scanner(System.in);
		empDTO dto = new empDTO();
		
		System.out.println("테이블에 저장할 값 입력 받기...");
		System.out.print("번호 입력 : ");
		String no = input.nextLine();
		int chageNo = Integer.parseInt(no);
		System.out.print("시급 입력 : ");
		String msalary = input.nextLine();
		int chageMsalary = Integer.parseInt(no);
		System.out.print("이름 입력 : ");
		String name = input.nextLine();
		System.out.print("근무시간 입력 : ");
		int chageWorkhour = input.nextLine();
		System.out.print("전화 번호 입력 : ");
		String tel = input.nextLine();
		
		dto.setNo(chageNo);
		dto.setMsalary(chageMsalary);
		dto.setName(name);
		dto.setWorkhour(chageWorkhour);
		dto.setTel(tel);
		
		dao.insert(dto);
	}
	
		public static void select(empDAO dao) {
			List<empDTO> list = null;
			list = dao.select();
			
			System.out.println("번호 \t 시급 \t  이름 \t\t\t  전화번호 \t\t 근무시간");
			System.out.println("--------------------------------------------------------");

			for(empDTO dto: list) {
				int no = dto.getNo();
				int msalary = dto.getMsalary();
				String name = dto.getName();
				String tel = dto.getTel();
				int workhour = dto.getWorkhour();
				
				
				System.out.printf("%d \t %d \t %s \t %s \t %d\n", 
												no, msalary , name, tel, workhour );
			}
		}

	

		public static void main(String[] args) {
			empDAO dao = new empDAO();
			Scanner input = new Scanner(System.in);
			
			while(true) {
				System.out.println("\n\n*** 메뉴 구성 ***");
				System.out.println("1. 프로그램 종료.");
				System.out.println("2. 데이터 저장하기.");
				System.out.println("3. 데이터 읽어오기.");
				System.out.println("4. 데이터 수정하기.");
				System.out.println("5. 데이터 삭제하기.");
				System.out.print(">> 메뉴 선택 : ");
				
				int choice = input.nextInt();
				
				switch(choice) {
					case 1:
						System.out.println("프로그램을 종료합니다.");
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