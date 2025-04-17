package com.claytonmuhoza.profile;

import com.claytonmuhoza.registry.Register;
import com.claytonmuhoza.syncPath.SyncPath;

public interface ProfileBuilder {
    void setProfileName(String name);
    void setSourcePath(SyncPath source);
    void setTargetPath(SyncPath target);
    void setRegistrer(Register register);
    Profile build();
}
