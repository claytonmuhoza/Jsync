package com.claytonmuhoza.sync.handlers;

import com.claytonmuhoza.sync.SyncContext;
import java.io.InputStream;

public class NewInAHandler extends SyncHandler {

    @Override
    protected boolean process(SyncContext context) throws Exception {
        var fileA = context.getFileA();
        var fileB = context.getFileB();

        if (fileA.exists() && !fileB.exists()
                && context.getLastSyncInfo().shouldOverwrite(fileA.getLastModified())) {

            System.out.println("🟢 Nouveau fichier dans A → copie vers B : " + context.getRelativePath());

            var in = context.getAccessorA().read(context.getRelativePath());
            context.getAccessorB().write(context.getRelativePath(), in, fileA.getLastModified());

            context.markSyncedFromA();
            return true;
        }
        return false;
    }
}
