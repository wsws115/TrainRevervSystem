package train.search;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;

public class Train_API {
	String st_sub;
	String en_sub;
	String date;
	String train_nm;
	
	public Train_API(String st_sub,String en_sub,String date,String train_nm) {
		this.st_sub = st_sub;
		this.en_sub = en_sub;
		this.date = date;
		this.train_nm = train_nm;
	}
	private static String key = "cXG%2BsVlagSV2%2FrTreOPObTV1p66Hho1fOgZi0uxSNS3GGBq7xLhMe9uPRSf3u4Ya%2BoyDgW4evwP42PU18PTy0g%3D%3D";
	
    public JSONArray train_api() throws IOException {
        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1613000/TrainInfoService/getStrtpntAlocFndTrainInfo"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","MS949") + "="+key); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","MS949") + "=" + URLEncoder.encode("1", "MS949")); /*페이지번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","MS949") + "=" + URLEncoder.encode("100", "MS949")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("_type","MS949") + "=" + URLEncoder.encode("json", "MS949")); /*데이터 타입(xml, json)*/
        urlBuilder.append("&" + URLEncoder.encode("depPlaceId","MS949") + "=" + URLEncoder.encode(st_sub, "MS949")); /*출발기차역ID [상세기능3. 시/도별 기차역 목록조회]에서 조회 가능*/
        urlBuilder.append("&" + URLEncoder.encode("arrPlaceId","MS949") + "=" + URLEncoder.encode(en_sub, "MS949")); /*도착기차역ID [상세기능3. 시/도별 기차역 목록조회]에서 조회 가능*/
        urlBuilder.append("&" + URLEncoder.encode("depPlandTime","MS949") + "=" + URLEncoder.encode(date, "MS949")); /*출발일(YYYYMMDD)*/
        urlBuilder.append("&" + URLEncoder.encode("trainGradeCode","MS949") + "=" + URLEncoder.encode(train_nm, "MS949")); /*차량종류코드*/
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        System.out.println(sb.toString());
      
		try {
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject)jsonParser.parse(sb.toString());
			JSONObject response = (JSONObject)jsonObject.get("response");
			JSONObject body = (JSONObject)response.get("body");
			JSONObject items = (JSONObject)body.get("items");
//			JSONObject item = (JSONObject)items.get("item");
			System.out.println(items);
			//JSON데이터를 넣어 JSON Object 로 만들어 준다.
			        
			//배열 추출
			JSONArray array = (JSONArray) items.get("item");
//			 for(int i=0; i<array.size(); i++){
//			        	 
//			    System.out.println("item"+i+" ===========================================");
//			             
//			    //배열 안에 있는것도 JSON형식 이기 때문에 JSON Object 로 추출
//			    JSONObject object = (JSONObject) array.get(i);
//			             
//			    //JSON name으로 추출
//			    System.out.println("요금 ==> "+object.get("adultcharge"));
//			    System.out.println("출발역 ==> "+object.get("arrplacename"));
//			    System.out.println("출발시간 ==> "+object.get("arrplandtime"));
//			    System.out.println("도착역 ==> "+object.get("depplacename"));
//			    System.out.println("도착시간 ==> "+object.get("depplandtime"));
//			    System.out.println("열차이름 ==> "+object.get("traingradename"));
//			    System.out.println("열차번호 ==> "+object.get("trainno"));
//			    System.out.println("");
//			 }
			 return array;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
        
    }
}