package cartBean;

public class ItemDTO {
	private String object_code;	 	//object_code(물건번호)
	private String object_name; 	 //object_name(물건이름)
	private int object_keal; 		//열량
	private String object_allergy;	 //알레르기
	private Integer object_price;	 //상품가격
	private String object_inout; 	//재고확인
	private String object_date; 	//날짜
	private int object_count; 		//갯수
	
	//기본생성자
	public ItemDTO() {
		super();
	}

	public ItemDTO(String object_code, String object_name, int object_keal, String object_allergy,
			Integer object_price, String object_inout, String object_date, int object_count) {
		super();
		this.object_code = object_code;
		this.object_name = object_name;
		this.object_keal = object_keal;
		this.object_allergy = object_allergy;
		this.object_price = object_price;
		this.object_inout = object_inout;
		this.object_date = object_date;
		this.object_count = object_count;
	}

	public String getObject_code() {
		return object_code;
	}

	public void setObject_code(String object_code) {
		this.object_code = object_code;
	}

	public String getObject_name() {
		return object_name;
	}

	public void setObject_name(String object_name) {
		this.object_name = object_name;
	}

	public int getObject_keal() {
		return object_keal;
	}

	public void setObject_keal(int object_keal) {
		this.object_keal = object_keal;
	}

	public String getObject_allergy() {
		return object_allergy;
	}

	public void setObject_allergy(String object_allergy) {
		this.object_allergy = object_allergy;
	}

	public Integer getObject_price() {
		return object_price;
	}

	public void setObject_price(Integer object_price) {
		this.object_price = object_price;
	}

	public String getObject_inout() {
		return object_inout;
	}

	public void setObject_inout(String object_inout) {
		this.object_inout = object_inout;
	}

	public String getObject_date() {
		return object_date;
	}

	public void setObject_date(String object_date) {
		this.object_date = object_date;
	}

	public int getObject_count() {
		return object_count;
	}

	public void setObject_count(int object_count) {
		this.object_count = object_count;
	}

	@Override
	public String toString() {
		return "basket_장바구니_DTO [object_code=" + object_code + ", object_name=" + object_name + ", object_keal="
				+ object_keal + ", object_allergy=" + object_allergy + ", object_price=" + object_price
				+ ", object_inout=" + object_inout + ", object_date=" + object_date + ", object_count=" + object_count
				+ "]";
	}
	
	
	
	
	
}
