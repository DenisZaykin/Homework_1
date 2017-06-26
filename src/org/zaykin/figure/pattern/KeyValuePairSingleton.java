package org.zaykin.figure.pattern;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by DHM on 6/9/2017.
 */
public class KeyValuePairSingleton {

    private static KeyValuePairSingleton obj = new KeyValuePairSingleton();
    private Map<UUID,UUID> keyValueList = new HashMap<>();

    private KeyValuePairSingleton() {}

    public static KeyValuePairSingleton getInstance() {

        return obj;
    }

    public HashMap<UUID,UUID> getkeyValueList() {

        return new HashMap<UUID,UUID>(keyValueList);

    }

    public void addKeyValueList (UUID key, UUID value) {
        keyValueList.put(key,value);
    }

    public void removeKeyValueList (UUID key) {
        keyValueList.remove(key);
    }

}
