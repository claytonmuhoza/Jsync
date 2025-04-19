package com.claytonmuhoza.sync.handlers;

import com.claytonmuhoza.sync.SyncContext;

public class NoChangeHandler extends SyncHandler {

    @Override
    protected boolean process(SyncContext context) {
        var fileA = context.getFileA();
        var fileB = context.getFileB();
        var entry = context.getLastSyncInfo();

        if (fileA.exists() && fileB.exists()
                && !entry.shouldOverwrite(fileA.getLastModified())
                && !entry.shouldOverwrite(fileB.getLastModified())) {
            System.out.println("✅ Aucun changement : " + context.getRelativePath());
            return true;
        }

        return false;
    }
}
