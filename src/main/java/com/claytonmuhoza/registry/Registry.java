package com.claytonmuhoza.registry;

import java.util.*;

import java.util.*;

public interface Registry {
    RegistryEntry get(String path);
    void put(String path, long lastSync);
    void remove(String path);
    Set<String> getAllPaths();
    void save();
    List<RegistryEntry> getAllEntries();
}