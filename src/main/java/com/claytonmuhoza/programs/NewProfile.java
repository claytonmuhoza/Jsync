package com.claytonmuhoza.programs;

import com.claytonmuhoza.SyncPathFactory.LocalSyncPathFactory;
import com.claytonmuhoza.profile.*;
import com.claytonmuhoza.profile.xml.XmlProfilePersistence;
import com.claytonmuhoza.registry.Register;
import com.claytonmuhoza.syncPath.LocalSyncPath;
import com.claytonmuhoza.syncPath.SyncPath;

import java.util.Scanner;

public class NewProfile {
    public static void main(String[] args) {
        boolean isSaved = false;
        do {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Veuillez entrer le nom du profil :");
                String profileNameInput = scanner.nextLine();
                ProfileName profileName = new ProfileName(profileNameInput);
                System.out.println("Veuillez le chemin du premier dossier:");
                String sourcePathInput = scanner.nextLine();
                SyncPath pathA = new LocalSyncPathFactory().create(sourcePathInput);
                System.out.println("Veuillez le chemin du second dossier:");
                String targetPathInput = scanner.nextLine();
                SyncPath pathB = new LocalSyncPath(targetPathInput);
                Profile profile = new ProfileBuilderStd().setProfileName(profileName).setPathA(pathA).setPathB(pathB).build();
                ProfilePersistence storeProfile = new XmlProfilePersistence();
                storeProfile.save(profile);
                isSaved = true;
            }
            catch (Exception e) {
                System.out.println("Erreur:" + e.getMessage());
            }
        }while(!isSaved);

    }
}
