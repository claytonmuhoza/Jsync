package com.claytonmuhoza.profile;

import com.claytonmuhoza.syncPath.SyncPath;

import java.util.HashMap;
import java.util.Map;

public class ProfileBuilderStd implements ProfileBuilder {
    private ProfileName name;
    private SyncPath source;
    private SyncPath target;

    @Override
    public void startProfile(String name) {
        this.name = new ProfileName(name);
    }

    @Override
    public void setSource(SyncPath source) {
        this.source = source;
    }

    @Override
    public void setTarget(SyncPath target) {
        this.target = target;
    }

    @Override
    public Profile build() {
        return new ProfileStd(name, source, target);
    }
}
