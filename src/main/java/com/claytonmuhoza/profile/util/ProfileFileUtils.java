package com.claytonmuhoza.profile.util;

public class ProfileFileUtils {
    public static String toSafeFileName(String profileName) {
        return profileName.replaceAll("[^a-zA-Z0-9-_]", "_") + ".sync";
    }
}
