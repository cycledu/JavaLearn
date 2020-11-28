package java8.Test;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author : jingtao
 * @Data : 2020/11/27/12:51
 * @Description :
 * @PageOrWebSite£º
 * @Expected result £º
 */
public class listRemoveRepeate {
    public static void main(String[] args) {
        String s1 = "{\"id\":\"1\",\"employee\":{\"name\":\"Bill Gates\",\"weight\":\"62\",\"city\":\"Seattle\"}}";
        String s2 = "{\"id\":\"2\",\"employee\":{\"name\":\"Bill Gates\",\"weight\":\"67\",\"city\":\"Seattle\"}}";
        String s3 = "{\"id\":\"2\",\"employee\":{\"name\":\"hhhh\",\"weight\":\"98\",\"city\":\"Seattle\"}}";
        JSONObject jsonObject1 = JSONObject.parseObject(s1);
        JSONObject jsonObject2 = JSONObject.parseObject(s2);
        JSONObject jsonObject3 = JSONObject.parseObject(s3);
        System.out.println(jsonObject1.getString("id"));
        Map<String, JSONObject> map = new HashMap<>();
        map.put(jsonObject1.getString("id"), jsonObject1);
        map.put(jsonObject2.getString("id"), jsonObject2);
        String id = jsonObject3.getString("id");
        JSONObject jsonObject4 = map.get(id);
        if (jsonObject4 != null) {
            JSONObject employee = jsonObject3.getJSONObject("employee");
            JSONObject jsonObject = jsonObject4.getJSONObject("employee");
            if (Integer.valueOf(jsonObject.getString("weight")) < Integer.valueOf(jsonObject3.getJSONObject("employee").getString("weight"))) {
                jsonObject.replaceAll((k, v) -> {
                    if (!k.equals("id"))
                        v = employee.getString(k);
                    return v;
                });
            }
        } else {
            map.put(id, jsonObject3);
        }
        map.forEach((k, v) -> System.out.println("k:" + k + ",v:" + v));
    }
}
