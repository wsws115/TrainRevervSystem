package train.subway;

import java.util.HashMap;
// 기차 API에 들어가는 열차 종류 가져오기
public class SubwayCategory {
	public static HashMap<String, String>sub_category = new HashMap<>();
	public SubwayCategory() {
		sub_category.put("KTX","00");
		sub_category.put("새마을호","01");
		sub_category.put("무궁화호","02");
		sub_category.put("ITX-새마을","08");
		sub_category.put("ITX-청춘","09");
		sub_category.put("SRT","17");
	}
}
	
