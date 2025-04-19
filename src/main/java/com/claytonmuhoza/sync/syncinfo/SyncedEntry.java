package com.claytonmuhoza.sync.syncinfo;

public class SyncedEntry implements LastSyncInfo {
    private final long lastSyncedTime;

    public SyncedEntry(long lastSyncedTime) {
        this.lastSyncedTime = lastSyncedTime;
    }

    @Override
    public boolean shouldOverwrite(long currentTimestamp) {
        return currentTimestamp > lastSyncedTime;
    }

    @Override
    public boolean wasPreviouslySynced() {
        return true;
    }

    public long getLastSyncedTime() {
        return lastSyncedTime;
    }
}
