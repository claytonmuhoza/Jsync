package com.claytonmuhoza.sync.engine;

import com.claytonmuhoza.profile.Profile;
import com.claytonmuhoza.profile.ProfileBuilderStd;
import com.claytonmuhoza.profile.ProfilePersistence;
import com.claytonmuhoza.registrer.Entry;
import com.claytonmuhoza.registrer.Register;
import com.claytonmuhoza.sync.SyncContext;
import com.claytonmuhoza.sync.SyncContextBuilder;
import com.claytonmuhoza.sync.handlers.SyncChainFactory;
import com.claytonmuhoza.sync.handlers.SyncHandler;

import java.util.Collection;
import java.util.List;

public class DefaultSyncEngine implements SyncEngine {

    private final SyncHandler handlerChain;

    public DefaultSyncEngine() {
        this.handlerChain = SyncChainFactory.createDefaultChain();
    }

    @Override
    public void run(Profile profile, ProfilePersistence profilePersistence) throws Exception {
        List<SyncContext> contexts = SyncContextBuilder.buildContexts(profile);
        for (SyncContext ctx : contexts) {
            handlerChain.handle(ctx);
        }
        profilePersistence.save(profile);
    }
}

