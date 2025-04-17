package com.claytonmuhoza.profile;

import com.claytonmuhoza.registry.Register;
import com.claytonmuhoza.syncPath.SyncPath;

public interface ProfileBuilder {
    ProfileBuilder setProfileName(String name);
    ProfileBuilder setPathA(SyncPath source);
    ProfileBuilder setPathB(SyncPath target);
    ProfileBuilder setRegistrer(Register register);
    Profile build();
}
