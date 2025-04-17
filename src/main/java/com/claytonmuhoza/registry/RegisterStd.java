package com.claytonmuhoza.registry;

import java.util.*;

public class RegisterStd implements Register {
    private final Map<String, Entry> entries = new HashMap<>();

    public void update(String path, long timestamp) {
        entries.put(path, new EntryStd(path, timestamp));
    }

    public Entry getEntry(String path) {
        return entries.get(path);
    }

    public Collection<Entry> getAllEntries() {
        return entries.values();
    }

    public boolean contains(String path) {
        return entries.containsKey(path);
    }

    public void remove(String path) {
        entries.remove(path);
    }
}
