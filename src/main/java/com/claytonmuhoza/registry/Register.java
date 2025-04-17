package com.claytonmuhoza.registry;

import java.util.*;
import java.util.HashMap;
import java.util.Map;

public class Register {
    private static Register instance;
    private final Map<String, Long> fileTimestamps;

    private Register() {
        this.fileTimestamps = new HashMap<>();
    }

    public static synchronized Register getInstance() {
        if (instance == null) {
            instance = new Register();
        }
        return instance;
    }

    public void update(String relativePath, long timestamp) {
        fileTimestamps.put(relativePath, timestamp);
    }

    public Long getTimestamp(String relativePath) {
        return fileTimestamps.get(relativePath);
    }

    public Map<String, Long> getAll() {
        return fileTimestamps;
    }
}
