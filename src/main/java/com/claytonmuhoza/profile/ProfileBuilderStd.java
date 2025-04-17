package com.claytonmuhoza.profile;

import com.claytonmuhoza.registry.Register;
import com.claytonmuhoza.syncPath.SyncPath;

import java.util.HashMap;
import java.util.Map;

public class ProfileBuilderStd implements ProfileBuilder {
    private ProfileName name;
    private SyncPath source;
    private SyncPath target;
    private Register register = Register.getInstance();

    @Override
    public ProfileBuilder setProfileName(ProfileName name) {
        this.name = name;
        return this;
    }

    @Override
    public ProfileBuilder setPathA(SyncPath source)
    {
        this.source = source;
        return this;
    }

    @Override
    public ProfileBuilder setPathB(SyncPath target) {
        this.target = target;
        return this;
    }

    @Override
    public ProfileBuilder setRegistrer(Register register){
        this.register = register;
        return this;
    }

    @Override
    public Profile build() {
        return new ProfileStd(name, source, target, register);
    }
}
