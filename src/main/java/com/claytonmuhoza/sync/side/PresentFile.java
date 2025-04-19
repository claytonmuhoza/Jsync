package com.claytonmuhoza.sync.side;

public class PresentFile implements SideFile {
    private final long lastModified;

    public PresentFile(long lastModified) {
        this.lastModified = lastModified;
    }

    @Override
    public boolean exists() {
        return true;
    }

    @Override
    public long getLastModified() {
        return lastModified;
    }
}