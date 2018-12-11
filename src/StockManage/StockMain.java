package StockManage;
public class StockMain {
	StockDAO Sdao;
	
	public StockMain(){
		Sdao = new StockDAO();
	}
	
	
	public void update(int beanN, int milkN, int chocoN, int vanillaN) {
	
		StockDTO dto = new StockDTO();
				
		int Bean = beanN;
		int Milk = milkN;
		int Choco = chocoN;
		int Vanilla = vanillaN;
		
		dto.setBeanQ(Bean);
		dto.setMilkQ(Milk);
		dto.setChocoQ(Choco);
		dto.setVanillaQ(Vanilla);
		
		Sdao.update(dto);
			
	}		
	public void select() {
		StockDTO dto =null;
		dto=Sdao.select();
				 
		int bean = dto.getBeanQ();
		int milk = dto.getMilkQ();
		int choco = dto.getChocoQ();
		int vanilla = dto.getVanillaQ();
			
	}

}
