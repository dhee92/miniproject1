package ManagerP;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Benefit {
	BenefitDAO dao;
	Date today;
	String TodayDate;

	
	public Benefit() {
		dao = new BenefitDAO();
		//오늘의 날짜 받아오기 ( 예시 : 2018/12/10 문자열타입)
		today = new Date();	
		SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd");
		TodayDate = date.format(today);
	}
	
	public void update(int ObtainedMoney) {
		
		BenefitDTO dto = new BenefitDTO();
		
		dto.setBenefit(ObtainedMoney);
		dto.setYyyymmdd(TodayDate);
		
		dao.updateBenefit(dto);		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
