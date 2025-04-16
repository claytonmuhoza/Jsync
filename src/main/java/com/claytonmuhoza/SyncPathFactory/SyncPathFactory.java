package com.claytonmuhoza.SyncPathFactory;

import com.claytonmuhoza.syncPath.SyncPath;

public interface SyncPathFactory {
    boolean supports(String path);
    SyncPath create(String path);
}

