package ManagerP;

import StockManage.StockMain;

class Management {
	//관리자 모드
	StockMain stock;
	Management(){
		stock = new StockMain();		
	}
		
	public void updateStock(int num1,int num2,int num3,int num4) {
		stock.update(num1, num2, num3, num4);
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
