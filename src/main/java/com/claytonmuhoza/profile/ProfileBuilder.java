package com.claytonmuhoza.profile;

import com.claytonmuhoza.registrer.Register;
import com.claytonmuhoza.syncPath.SyncPath;

public interface ProfileBuilder {
    ProfileBuilder setProfileName(ProfileName name);
    ProfileBuilder setPathA(SyncPath source);
    ProfileBuilder setPathB(SyncPath target);
    ProfileBuilder setRegistrer(Register register);
    Profile build();
}
