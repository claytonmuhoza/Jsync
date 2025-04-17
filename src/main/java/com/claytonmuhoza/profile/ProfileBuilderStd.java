package com.claytonmuhoza.profile;

import com.claytonmuhoza.registry.Register;
import com.claytonmuhoza.syncPath.SyncPath;

import java.util.HashMap;
import java.util.Map;

public class ProfileBuilderStd implements ProfileBuilder {
    private ProfileName name;
    private SyncPath source;
    private SyncPath target;
    private Register register;

    @Override
    public void setProfileName(String name) {
        this.name = new ProfileName(name);
    }

    @Override
    public void setSourcePath(SyncPath source) {
        this.source = source;
    }

    @Override
    public void setTargetPath(SyncPath target) {
        this.target = target;
    }

    @Override
    public void setRegistrer(Register register){this.register = register; }

    @Override
    public Profile build() {
        return new ProfileStd(name, source, target);
    }
}
