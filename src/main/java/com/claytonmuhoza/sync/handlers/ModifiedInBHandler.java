package com.claytonmuhoza.sync.handlers;

import com.claytonmuhoza.sync.SyncContext;

import java.io.InputStream;

public class ModifiedInBHandler extends SyncHandler {

    @Override
    protected boolean process(SyncContext context) throws Exception {
        var fileA = context.getFileA();
        var fileB = context.getFileB();
        var last = context.getLastSyncInfo();

        if (fileA.exists() && fileB.exists()
                && !last.shouldOverwrite(fileA.getLastModified())
                && last.shouldOverwrite(fileB.getLastModified())) {

            System.out.println("✏️ Modifié dans B : copie vers A → " + context.getRelativePath());

            InputStream in = context.getAccessorB().read(context.getRelativePath());
            context.getAccessorA().write(context.getRelativePath(), in, fileB.getLastModified());
            context.getRegister().update(context.getRelativePath(), fileB.getLastModified());

            return true;
        }

        return false;
    }
}
