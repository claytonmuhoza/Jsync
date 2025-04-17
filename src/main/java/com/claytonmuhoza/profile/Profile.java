package com.claytonmuhoza.profile;

import com.claytonmuhoza.registry.Registry;
import com.claytonmuhoza.syncPath.SyncPath;

public interface Profile {
    public ProfileName getProfileName();
    public SyncPath getSourcePath();
    public SyncPath getTargetPath();
}
