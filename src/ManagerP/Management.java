package ManagerP;

import StockManage.StockTest;

class Management {
	//관리자 모드
	StockTest stock;
	Management(){
		stock = new StockTest();		
	}
		
	public void updateStock() {
		stock.update();
	}
	
	public void ShowStock() {
		stock.select();
	}
	
	public void AddEmp() {
		// 직원 추가 코드
	}
	
	public void WagesOfEmp() {
		//직원별 임금 출력
	}

	
	
	
	

}
