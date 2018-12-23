package com.hwx;

import java.util.LinkedHashMap;
import java.util.Map;

public class Constant {

    public static final String BROKER_URL = "tcp://localhost:61616";
    public static final String BROKER_QUEUE_NAME = "msg_queue";

    //список опций для выпадающего списка
    public static final Map<Integer, String> PICK_VARIANTS_MAP = new LinkedHashMap<Integer, String>();
    static {
        PICK_VARIANTS_MAP.put(1, "Ivan");
        PICK_VARIANTS_MAP.put(2, "Alexey");
        PICK_VARIANTS_MAP.put(3, "Petr");
        PICK_VARIANTS_MAP.put(4, "Igor");
        PICK_VARIANTS_MAP.put(5, "Fedor");
    }
}
