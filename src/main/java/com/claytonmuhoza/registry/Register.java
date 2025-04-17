package com.claytonmuhoza.registry;

import java.util.*;

public interface Register {
    public void update(String path, long timestamp);

    public Entry getEntry(String path);

    public Collection<Entry> getAllEntries();

    public boolean contains(String path);

    public void remove(String path);
}

