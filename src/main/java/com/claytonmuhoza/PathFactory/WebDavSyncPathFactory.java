package com.claytonmuhoza.PathFactory;

import com.claytonmuhoza.syncPath.LocalSyncPath;
import com.claytonmuhoza.syncPath.SyncPath;

public class WebDavSyncPathFactory implements SyncPathFactory {
    @Override
    public boolean supports(String path) {
        try {
            new LocalSyncPath(path);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
    @Override
    public SyncPath create(String path) {
        return new LocalSyncPath(path);
    }
}
