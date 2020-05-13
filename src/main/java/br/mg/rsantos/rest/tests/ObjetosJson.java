package br.mg.rsantos.rest.tests;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

public class ObjetosJson {

    public static LinkedHashMap<String, Object> book(){
        LinkedHashMap<String, Object> test = new LinkedHashMap<String, Object>();
        test.put("ID", 1);
        test.put("Title", "Book Test");
        test.put("Description", "Description Test");
        test.put("PageCount", 500);
        test.put("Excerpt", "Excerpt Test");
        test.put("PublishDate", "0001-01-01T00:00:00");
        return test;

    }
}
