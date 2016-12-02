package com.javainterview.app.MapInterview;

import java.util.Map;

/**
 * Created on 10/4/2015.
 * Compare values between two maps.
 * A map can contain a string to string or string to another map
 * The nested map shall have the same key, and another string or map.
 *
 * Traverse to the leaf string values with the same keys.
 * Then perform comparisons of the leaf string values.
 */
public class NestedMap {

    /**
     * Method to compare two maps.
     * One map can be nested or the other can be regular.
     *
     * Leaf values are strings
     *
     * @param map1 first map to compare
     * @param map2 second map to compare
     * @param key  key to check
     * @return the val of the string if found
     */
    public int compare(Map<String, Object> map1, Map<String, Object> map2, String key) {
        String val1 = getString(map1, key);
        String val2 = getString(map2, key);

        if (val1 != null && val2 != null) {
            return val1.compareTo(val2);
        } else if (val2 != null) {
            // val2 is greater
            return 1;
        } else if (val1 != null) {
            // val1 is greater
            return -1;
        }

        // both are null
        return 0;
    }

    /**
     * Get the nested val given a key and a map.
     *
     * @param map map to traverse
     * @param key key to check
     * @return val if found
     */
    private String getString(Map<String, Object> map, String key) {
        // keeping checking the nested maps for the key
        while (map.containsKey(key)) {
            Object val = map.get(key);
            // found a string
            // return the val
            if (val instanceof String) {
                return (String) val;
            } else if (val instanceof Map) {
                // nested map so loop through with new map
                map = (Map<String, Object>) val;
            } else if (val == null) {
                return null;
            }
        }

        // key does not exist in map
        return null;
    }


}
