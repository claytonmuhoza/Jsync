package com.claytonmuhoza.syncPath;

import com.claytonmuhoza.syncPath.access.PathAccessor;

public interface SyncPath {
    public SyncPath getPath();
    public boolean exists();
    public String toString();
    PathAccessor getAccessor();
}
