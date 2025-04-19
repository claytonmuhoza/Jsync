package com.claytonmuhoza.sync.engine;

import com.claytonmuhoza.profile.Profile;
import com.claytonmuhoza.profile.ProfilePersistence;

public interface SyncEngine {
    void run(Profile profile, ProfilePersistence profilePersistence) throws Exception;
}
