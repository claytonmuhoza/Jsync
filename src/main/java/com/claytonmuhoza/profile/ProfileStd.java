package com.claytonmuhoza.profile;

import com.claytonmuhoza.registry.Register;
import com.claytonmuhoza.syncPath.SyncPath;

public class ProfileStd implements Profile {
    private final SyncPath sourcePath;
    private final SyncPath targetPath;
    private final ProfileName profileName;
    private final Register register;
    public ProfileStd( ProfileName profileName, SyncPath sourcePath, SyncPath targetPath, Register register ) {
        this.sourcePath = sourcePath;
        this.targetPath = targetPath;
        this.profileName = profileName;
        this.register = register;
    }
    @Override
    public ProfileName getProfileName() {
        return profileName;
    }

    @Override
    public SyncPath getPathA() {
        return sourcePath;
    }

    @Override
    public SyncPath getPathB() {
        return targetPath;
    }

    @Override
    public Register getRegister() {
        return this.register;
    }
}
