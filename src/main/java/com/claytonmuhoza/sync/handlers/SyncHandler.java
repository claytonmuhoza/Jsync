package com.claytonmuhoza.sync.handlers;

import com.claytonmuhoza.sync.SyncContext;

public abstract class SyncHandler {
    private SyncHandler next;

    public SyncHandler setNext(SyncHandler next) {
        this.next = next;
        return next;
    }

    public void handle(SyncContext context) throws Exception {
        if (!process(context) && next != null) {
            next.handle(context);
        }
    }

    protected abstract boolean process(SyncContext context) throws Exception;
}
