package com.claytonmuhoza.registry;

public class RegistryEntry {
    private final String relativePath;
    private final long lastSyncTime;

    public RegistryEntry(String relativePath, long lastSyncTime) {
        this.relativePath = relativePath;
        this.lastSyncTime = lastSyncTime;
    }

    public String getRelativePath() {
        return relativePath;
    }

    public long getLastSyncTime() {
        return lastSyncTime;
    }
}
