package com.claytonmuhoza.sync.handlers;

import com.claytonmuhoza.sync.SyncContext;

import java.io.InputStream;

public class ModifiedInAHandler extends SyncHandler {

    @Override
    protected boolean process(SyncContext context) throws Exception {
        var fileA = context.getFileA();
        var fileB = context.getFileB();
        var last = context.getLastSyncInfo();

        if (fileA.exists() && fileB.exists()
                && last.shouldOverwrite(fileA.getLastModified())
                && !last.shouldOverwrite(fileB.getLastModified())) {

            System.out.println("✏️ Modifié dans A : copie vers B → " + context.getRelativePath());

            InputStream in = context.getAccessorA().read(context.getRelativePath());
            context.getAccessorB().write(context.getRelativePath(), in, fileA.getLastModified());
            context.getRegister().update(context.getRelativePath(), fileA.getLastModified());

            return true;
        }

        return false;
    }
}
