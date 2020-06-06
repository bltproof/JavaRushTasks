package com.javarush.task.task22.task2208;

import java.util.LinkedHashMap;
import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("name", "Ivanov");
        map.put("country", "Ukraine");
        map.put("age", null);
        map.put("city", "Kiev");

        String s = getQuery(map);
        System.out.println(s);

    }

    public static String getQuery(Map<String, String> params) {
        StringBuilder sb = new StringBuilder();

        for (Map.Entry<String, String> entry : params.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();

            if (key != null && value != null) {
                sb.append(key).append(" = '").append(value).append("' ").append("and ");
            }
        }

        return sb.delete(sb.length() - 4, sb.length()).toString().trim();
    }
}