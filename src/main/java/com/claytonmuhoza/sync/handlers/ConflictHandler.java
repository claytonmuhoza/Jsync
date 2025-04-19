package com.claytonmuhoza.sync.handlers;

import com.claytonmuhoza.sync.SyncContext;

import java.util.Scanner;

public class ConflictHandler extends SyncHandler {

    @Override
    protected boolean process(SyncContext context) throws Exception {
        var fileA = context.getFileA();
        var fileB = context.getFileB();
        if (fileA.exists() && fileB.exists()
                && context.getLastSyncInfo().shouldOverwrite(fileA.getLastModified())
                && context.getLastSyncInfo().shouldOverwrite(fileB.getLastModified())) {

            System.out.println("⚠️ Conflit détecté : " + context.getRelativePath());
            System.out.println("A : " + fileA.getLastModified());
            System.out.println("B : " + fileB.getLastModified());
            System.out.print("Copier quel côté ? (a/b/skip) : ");

            Scanner sc = new Scanner(System.in);
            String choix = sc.nextLine().trim().toLowerCase();

            switch (choix) {
                case "a" -> {
                    var in = context.getAccessorA().read(context.getRelativePath());
                    context.getAccessorB().write(context.getRelativePath(), in, fileA.getLastModified());
                    context.markSyncedFromA();
                }
                case "b" -> {
                    var in = context.getAccessorB().read(context.getRelativePath());
                    context.getAccessorA().write(context.getRelativePath(), in, fileB.getLastModified());
                    context.markSyncedFromB();
                }
                default -> System.out.println("⏭️ Conflit ignoré : aucun fichier modifié");
            }

            return true;
        }
        return false;
    }
}
