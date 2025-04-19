package com.claytonmuhoza.sync.syncinfo;

public class NeverSynced implements LastSyncInfo {
    @Override
    public boolean shouldOverwrite(long currentTimestamp) {
        return true;
    }

    @Override
    public boolean wasPreviouslySynced() {
        return false;
    }
}