package com.claytonmuhoza.sync.side;

public interface SideFile {
    boolean exists();
    long getLastModified();
}
