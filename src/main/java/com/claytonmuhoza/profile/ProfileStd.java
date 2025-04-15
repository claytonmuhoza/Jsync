package com.claytonmuhoza.profile;

import com.claytonmuhoza.syncPath.SyncPath;

public class ProfileStd implements Profile {
    private final SyncPath sourcePath;
    private final SyncPath targetPath;
    private final ProfileName profileName;
    public ProfileStd( ProfileName profileName, SyncPath sourcePath, SyncPath targetPath) {
        this.sourcePath = sourcePath;
        this.targetPath = targetPath;
        this.profileName = profileName;
    }
    @Override
    public ProfileName getProfileName() {
        return profileName;
    }

    @Override
    public SyncPath getSourcePath() {
        return sourcePath;
    }

    @Override
    public SyncPath getTargetPath() {
        return targetPath;
    }
}
