package com.claytonmuhoza.sync.side;

public class MissingFile implements SideFile {

    @Override
    public boolean exists() {
        return false;
    }

    @Override
    public long getLastModified() {
        throw new UnsupportedOperationException("Fichier inexistant");
    }
}