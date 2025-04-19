package com.claytonmuhoza.registrer;

import java.util.*;

public interface Register {
    public void update(String path, long timestamp);

    public Entry getEntry(String path);

    public Collection<Entry> getAllEntries();
    public List<String> getAllPaths();
    public boolean contains(String path);

    public void remove(String path);
}

