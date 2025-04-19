package com.claytonmuhoza;

import com.claytonmuhoza.profile.Profile;
import com.claytonmuhoza.profile.ProfileBuilderStd;
import com.claytonmuhoza.profile.ProfileName;
import com.claytonmuhoza.syncPath.LocalSyncPath;
import com.claytonmuhoza.syncPath.SyncPath;

public class Main {
    public static void main(String[] args) throws Exception {
        try {
            SyncPath src = new LocalSyncPath("/home/clayton/sync/abana");
            SyncPath tgt = new LocalSyncPath("/home/clayton/sync/abantu");
            System.out.println("The source path exist?" + src.exists());
            System.out.println("The target path exist?" + tgt.exists());

            Profile p = new ProfileBuilderStd().setProfileName(new ProfileName("clay")).setPathA(src).setPathB(tgt).build();


        }
        catch (Exception e) {
            System.out.println("Erreur:" + e.getMessage());
        }

    }
}