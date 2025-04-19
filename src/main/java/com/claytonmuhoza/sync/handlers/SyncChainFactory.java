package com.claytonmuhoza.sync.handlers;

public class SyncChainFactory {

    public static SyncHandler createDefaultChain() {
        SyncHandler handler = new NewInAHandler();

        handler
                .setNext(new NewInBHandler())
                .setNext(new DeletedInAHandler())
                .setNext(new DeletedInBHandler())
                .setNext(new ModifiedInAHandler())
                .setNext(new ModifiedInBHandler())
                .setNext(new ConflictHandler())
                .setNext(new NoChangeHandler());

        return handler;
    }
}
