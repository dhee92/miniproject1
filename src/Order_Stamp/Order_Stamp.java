package Order_Stamp;

import CustomerManage.CustomerMain;
import StockManage.StockMain;

public class Order_Stamp {
	CustomerMain CusM;
	StockMain StockM;
		
	public Order_Stamp(){
		CusM = new CustomerMain();
		StockM = new StockMain();
	}
	
	public void OrderAmericano(int num) {//num은 주만한 잔 수 
		
		int BeanN = num*(-20);		
		StockM.update(BeanN, 0, 0, 0);
		//영업이익에 넣기
	}

	public void OrderLatte(int num) {//num은 주만한 잔 수 
		
		int BeanN = num*(-20);
		int MilkN = num*(-300);
		
		StockM.update(BeanN, MilkN, 0, 0);
		
	}
	public void OrderMocha(int num) {//num은 주만한 잔 수 
		
		int BeanN = num*(-20);
		int MilkN = num*(-300);
		int ChocoN= num*(-10);
		
		StockM.update(BeanN, MilkN, ChocoN, 0);
	
	}
	public void OrderVanilla(int num) {//num은 주만한 잔 수 
		int BeanN = num*(-20);
		int MilkN = num*(-300);
		int VanillaN = num*(-10);
		
		StockM.update(BeanN, MilkN, 0, VanillaN);	
		
	}
	
	
	
	
	
	
	
	
}
