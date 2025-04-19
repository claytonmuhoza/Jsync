package com.claytonmuhoza.programs;


import com.claytonmuhoza.profile.Profile;
import com.claytonmuhoza.profile.ProfileName;
import com.claytonmuhoza.profile.ProfilePersistence;
import com.claytonmuhoza.profile.xml.XmlProfilePersistence;
import com.claytonmuhoza.sync.engine.DefaultSyncEngine;
import com.claytonmuhoza.sync.engine.SyncEngine;

import java.util.Scanner;

public class Sync {
    public static void main(String[] args) {
        System.out.println("Programme de Sync");
        System.out.println("________________________");
        boolean isSaved = false;
        do {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Veuillez entrer le nom du profil :");
                String profileNameInput = scanner.nextLine();
                ProfilePersistence profilePersistence = new XmlProfilePersistence();
                Profile profile = profilePersistence.load(new ProfileName(profileNameInput));
                System.out.println("Nom du profil :");
                System.out.println(profile.getProfileName());
                SyncEngine syncEngine = new DefaultSyncEngine();
                syncEngine.run(profile, profilePersistence);
                isSaved = true;
            }
            catch (Exception e) {
                System.out.println("Erreur:" + e.getMessage());
            }
        }while(!isSaved);
    }
}
