package CustomerManage;

public class CustomerDTO {
//	no				number(4) primary key,
//	name			varchar2(20),
//	tel				varchar2(20),
//	stamp			number(4)
	
	private int no;
	private String name;
	private String tel;
	private int stamp;
	
	//필드 선언했으니 위 필드들 저장하고 읽어올 메서드 오버라이드
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public int getStamp() {
		return stamp;
	}
	public void setStamp(int stamp) {
		this.stamp = stamp;
	}
	

	

}
