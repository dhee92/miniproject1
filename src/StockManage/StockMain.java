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
	public String select() {
		StringBuffer sb = new StringBuffer();
		String st=null;
		StockDTO dto =null;
		dto=Sdao.select();
		
		sb.append(" "+ Integer.toString(dto.getBeanQ())+"\t");
		sb.append(" "+ Integer.toString(dto.getMilkQ())+"\t");
		sb.append(" "+ Integer.toString(dto.getChocoQ())+"\t");
		sb.append( Integer.toString(dto.getVanillaQ()) );
					
		st = sb.toString();
		
		return st;
	}

	

}
