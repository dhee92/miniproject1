package StockManage;

import java.util.Scanner;



public class StockTest {
	
	
	public static void insert(StockDAO dao) {
		Scanner input = new Scanner(System.in);
		StockDTO dto = new StockDTO();
				
		System.out.println("테이블에 입력할 값 입력 받기");
		System.out.print("원두 : ");
		String no = input.nextLine();
		int changeNo = Integer.parseInt(no);
		System.out.print("이름 입력 : ");
		String name = input.nextLine();
		System.out.print("이메일 입력 : ");
		String email = input.nextLine();
		System.out.print("전화번호 입력 : ");
		String  tel = input.nextLine();
		
	/*	dto.setNo(changeNo);
		dto.setName(name);
		dto.setEmail(email);
		dto.setTel(tel);
		
		dao.insert(dto);*/
		
		
		
		
		
	}		

	public static void main(String[] args) {
		
		StockDAO dao = new StockDAO();
		Scanner input = new Scanner(System.in);
			
		
		while(true) {
			System.out.println("\n\n****** 메뉴 구성 ******");
			System.out.println("1. 프로그램 종료. ");
			System.out.println("2. 재고 변화");
			System.out.println("3. 재고 확인 ");
			System.out.println(">>메뉴 선택 : ");
			
			int choice = input.nextInt();
			
			switch(choice) {
			
				case 1:
					System.out.println("이제 프로그램을 종료합니다.");
					return;
				case 2:
					insert(dao);
					break;
				case 3:
					/*select(dao);*/
					break;
				default:
					break;			
			}
			
			
			
		}
		
		
		
		

	}

}
