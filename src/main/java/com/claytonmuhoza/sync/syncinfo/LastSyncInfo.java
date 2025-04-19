package com.claytonmuhoza.sync.syncinfo;

public interface LastSyncInfo {
    boolean shouldOverwrite(long currentTimestamp);
    boolean wasPreviouslySynced();
}
