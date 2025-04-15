package com.claytonmuhoza.profile;

import com.claytonmuhoza.syncPath.SyncPath;

public interface ProfileBuilder {
    void startProfile(ProfileName name);
    void setSource(SyncPath source);
    void setTarget(SyncPath target);
    Profile build();
}
