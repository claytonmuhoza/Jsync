package com.claytonmuhoza.SyncPathFactory;

import com.claytonmuhoza.syncPath.SyncPath;

import java.util.ArrayList;
import java.util.List;

public class SyncPathFactoryImpl implements SyncPathFactory {
    @Override
    public boolean supports(String path) {
        return false;
    }

    private final List<SyncPathFactory> factories = new ArrayList<>();

    public SyncPathFactoryImpl() {
        factories.add(new LocalSyncPathFactory());
        factories.add(new WebDavSyncPathFactory());
    }

    public void register(SyncPathFactory factory) {
        factories.add(factory);
    }

    public SyncPath create(String path) {
        for (SyncPathFactory factory : factories) {
            if (factory.supports(path)) {
                return factory.create(path);
            }
        }
        throw new IllegalArgumentException("Aucune fabrique ne supporte ce chemin : " + path);
    }
}
