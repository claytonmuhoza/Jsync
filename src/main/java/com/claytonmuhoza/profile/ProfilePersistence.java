package com.claytonmuhoza.profile;

import java.io.File;

public interface ProfilePersistence {
    void save(Profile profile) throws Exception;
    Profile load(ProfileName profileName) throws Exception;
}