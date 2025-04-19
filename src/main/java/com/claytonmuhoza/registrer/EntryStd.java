package com.claytonmuhoza.registrer;

public class EntryStd implements Entry {
    private final String path;
    private final long timestamp;

    public EntryStd(String path, long timestamp) {
        this.path = path;
        this.timestamp = timestamp;
    }

    public String getPath() {
        return path;
    }

    public long getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "Entry{path='" + path + "', timestamp=" + timestamp + '}';
    }
}
