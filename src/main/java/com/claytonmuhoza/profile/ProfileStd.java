package com.claytonmuhoza.profile;

import com.claytonmuhoza.registrer.Register;
import com.claytonmuhoza.syncPath.SyncPath;

public class ProfileStd implements Profile {
    private final SyncPath sourceSyncPath;
    private final SyncPath targetSyncPath;
    private final ProfileName profileName;
    private final Register register;
    public ProfileStd(ProfileName profileName, SyncPath sourceSyncPath, SyncPath targetSyncPath, Register register ) {
        this.sourceSyncPath = sourceSyncPath;
        this.targetSyncPath = targetSyncPath;
        this.profileName = profileName;
        this.register = register;
    }
    @Override
    public ProfileName getProfileName() {
        return profileName;
    }

    @Override
    public SyncPath getPathA() {
        return sourceSyncPath;
    }

    @Override
    public SyncPath getPathB() {
        return targetSyncPath;
    }

    @Override
    public Register getRegister() {
        return this.register;
    }
}
