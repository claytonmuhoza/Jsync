package com.claytonmuhoza.profile;

import com.claytonmuhoza.syncPath.SyncPath;

public interface ProfileBuilder {
    void setProfileName(String name);
    void setSourcePath(SyncPath source);
    void setTargetPath(SyncPath target);
    Profile build();
}
