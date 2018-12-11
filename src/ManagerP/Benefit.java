package ManagerP;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
	
	// 	
	public List<BenefitDTO> ShowBenefit() {
		List<BenefitDTO> list = null;
		list = dao.ShowBenefit();
			
		/*
		for(BenefitDTO e : list) {
			String date = e.getYyyymmdd();
			int Benefit = e.getBenefit();
		}*/
		return list;
	}
	public BenefitDTO Selected_ShowBenefit(String Date) {
		//Date는 사용자로부터 날짜를 입력 받아올것 2018/12/30 과 같은 방식
		BenefitDTO dto=null;
		dto = dao.ShowBenefit_Selectday(Date);	

		
		return dto;
	}
	
	
	
	
	
	
	
	
}
