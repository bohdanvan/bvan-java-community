package com.bvan.jc.chat2.map;

import java.util.HashMap;
import java.util.Map;

/**
 * @author bvanchuhov
 */
public class MapSample {

    public static void main(String[] args) {
        Map<Long, String> idToName = new HashMap<>();

        idToName.put(1L, "John");
        idToName.put(2L, "Bob");
        idToName.put(3L, "Phil");

        System.out.println(idToName.get(2L));
        System.out.println(idToName.get(10L));
    }
}
