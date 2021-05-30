import org.json.JSONArray;
import org.json.JSONObject;

public class JsonObj {

    public static void main(String[] args) {
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();

        jsonObject.put("keyTest","1");
        jsonObject.put("JsonObject",jsonArray.put("array"));
        System.out.println(jsonObject);

    }
}
