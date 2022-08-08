package json;

import org.json.simple.JSONObject;

public class JsonParser2 {

	public static void main(String[] args) {

//		JSONObject obj = new JSONObject();
//		obj.put("one", 10);
//		obj.put("two", 20);
//		obj.put("three", 30);
//		obj.put("four", 40);
//		System.out.println(obj.toString());
//		System.out.println(obj.toJSONString());

		// 위 내용을 key, value로 데이터를 설정 후 반복문을 이용하여 JSON 생성
		String[] key = { "one", "two", "three", "four" };
		int[] value = { 10, 20, 30, 40 };
		JSONObject obj = new JSONObject();
		for (int i = 0; i < key.length; i++) {
			obj.put(key[i], value[i]);
		}
		System.out.println(obj.toJSONString());
		
	}

}
