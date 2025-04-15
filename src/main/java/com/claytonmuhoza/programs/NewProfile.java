package com.claytonmuhoza.programs;

import com.claytonmuhoza.profile.Profile;
import com.claytonmuhoza.profile.ProfileName;
import com.claytonmuhoza.profile.ProfileStd;
import com.claytonmuhoza.profile.xml.ProfileWriterXML;
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
                SyncPath src = new LocalSyncPath(sourcePathInput);
                System.out.println("Veuillez le chemin du second dossier:");
                String targetPathInput = scanner.nextLine();
                SyncPath tgt = new LocalSyncPath(targetPathInput);
                Profile p = new ProfileStd(profileName, src, tgt);
                ProfileWriterXML.write(p);
                isSaved = true;
            }
            catch (Exception e) {
                System.out.println("Erreur:" + e.getMessage());
            }
        }while(!isSaved);

    }
}
