package com.claytonmuhoza.profile;

import com.claytonmuhoza.registry.Register;
import com.claytonmuhoza.syncPath.SyncPath;

public interface Profile {
    public ProfileName getProfileName();
    public SyncPath getPathA();
    public SyncPath getPathB();
    public Register getRegister();
}
