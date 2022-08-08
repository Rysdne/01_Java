package json;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonParser {

	public static void main(String[] args) {

		String data = "{\"one\":10, \"two\":20, \"three\":30, \"four\":40}";
		try {
		JSONParser json = new JSONParser();
		
		// System.out.println(data);
		// 일반적으로 출력 시 \가 보이지 않아 toJSONString() 사용
		
			JSONObject obj = (JSONObject)json.parse(data);
			System.out.println(obj.get("one"));
			System.out.println(obj.get("two"));
			System.out.println(obj.get("three"));
			System.out.println(obj.get("four"));
			
			System.out.println("toJSONString : "+obj.toJSONString());
			// 결과값이 순서대로 저장되지 않음, 배열로 순서를 정할 순 없는 듯
			
			System.out.println("toString : "+obj.toString());
			System.out.println("toString(key,value) : "+obj.toString("five", 50));
			System.out.println("get(key) : "+obj.get("five"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}
