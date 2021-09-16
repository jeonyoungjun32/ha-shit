package cartBean;

import java.util.ArrayList;
import java.util.DuplicateFormatFlagsException;

public class CartBean {
	private ArrayList<ItemDTO> itemList = new ArrayList<ItemDTO>();

	public ArrayList<ItemDTO> getItemList() {

		return itemList;
	}

	// 상품 번호(object_code)에 해당하는 상품이 없으면 -1리턴
	// 있으면 해당 상품 인덱스로 반환
	public int findIndexByNo(String object_code) {
		// 리스트 인덱스번호, index는 아이템의 위치를 반환 해준다
		int index = -1;
		for (int i = 0; i < itemList.size(); i++) {
			// 리스트에 i번째(인덱스)의 object_code가 입력받으면 object_code와 일치했을때
			// index는 아이템의 위치를 반환해준다.
			if (itemList.get(i).getObject_code().contentEquals(object_code)) {
				index = i;
				break;
			}
		}
		return index;
	}

	// 1) 장바구니에 상품 추가
	// 2) 상품 중복되면 DuplicateItemException 을 발생시키고 throw 한다.
	public void additem(ItemDTO dto) throws DuplicateItemException {
		// 중복이 되면 -1주고 DuplicateItemException 발생
		// if(findlndexByNo(dto.getObject_code() != -1)){}
		if (findIndexByNo(dto.getObject_code()) != -1) {
			throw new DuplicateItemException();
		}

		// 중복되지 않으면 add
		itemList.add(dto);
	}

	// 3) 장바구니에서 상품을 삭제
	public void removeItems(String object_code) {
		// Object_code를 통해 해당 상품의 index를 받아옴
		int index = findIndexByNo(object_code);
		// list에서 해당 index 객체 삭제
		itemList.remove(index);
	}

	// 4) 장바구니 담긴 상품 아이템 총액을 반환
	//장바구니 페이지에서 접근해서 사용하는것
	public int getTotalPrice() {
		int total = 0;
		
		for(int i=0;i<itemList.size();i++) {
			total += itemList.get(i).getObject_price();
		}
		return total;
	}

	@Override
	public String toString() {
		return "CaryBean [itemList=" + itemList + "]";
	}
	
	
	
}





























