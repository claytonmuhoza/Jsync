package com.claytonmuhoza.sync.handlers;

import com.claytonmuhoza.sync.SyncContext;
import java.io.InputStream;

public class NewInBHandler extends SyncHandler {

    @Override
    protected boolean process(SyncContext context) throws Exception {
        var fileA = context.getFileA();
        var fileB = context.getFileB();

        if (!fileA.exists() && fileB.exists()
                && context.getLastSyncInfo().shouldOverwrite(fileB.getLastModified())) {

            System.out.println("🟢 Nouveau fichier dans B → copie vers A : " + context.getRelativePath());

            var in = context.getAccessorB().read(context.getRelativePath());
            context.getAccessorA().write(context.getRelativePath(), in, fileB.getLastModified());

            context.markSyncedFromB();
            return true;
        }
        return false;
    }
}
