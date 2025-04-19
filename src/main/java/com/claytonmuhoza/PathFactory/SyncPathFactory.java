package com.claytonmuhoza.PathFactory;

import com.claytonmuhoza.syncPath.SyncPath;

public interface SyncPathFactory {
    boolean supports(String path);
    SyncPath create(String path);
}

