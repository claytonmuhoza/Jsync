package com.claytonmuhoza.sync.handlers;

import com.claytonmuhoza.sync.SyncContext;

public class DeletedInAHandler extends SyncHandler {

    @Override
    protected boolean process(SyncContext context) throws Exception {
        var fileA = context.getFileA();
        var fileB = context.getFileB();

        if (!fileA.exists() && fileB.exists() && context.getLastSyncInfo().wasPreviouslySynced()) {
            System.out.println("🗑️ Suppression dans A → suppression dans B : " + context.getRelativePath());

            context.getAccessorB().delete(context.getRelativePath());
            context.removeFromRegister();
            return true;
        }
        return false;
    }
}
