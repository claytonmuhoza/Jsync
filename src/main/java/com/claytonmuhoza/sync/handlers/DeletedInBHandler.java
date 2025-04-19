package com.claytonmuhoza.sync.handlers;

import com.claytonmuhoza.sync.SyncContext;

public class DeletedInBHandler extends SyncHandler {

    @Override
    protected boolean process(SyncContext context) throws Exception {
        var fileA = context.getFileA();
        var fileB = context.getFileB();

        if (fileA.exists() && !fileB.exists()
                && context.getLastSyncInfo().wasPreviouslySynced()) {

            System.out.println("🗑️ Suppression dans B détectée, suppression dans A : " + context.getRelativePath());

            context.getAccessorA().delete(context.getRelativePath());
            context.getRegister().remove(context.getRelativePath());

            return true;
        }

        return false;
    }
}
