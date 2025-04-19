package com.claytonmuhoza.syncPath;

import com.claytonmuhoza.syncPath.access.LocalPathAccessor;
import com.claytonmuhoza.syncPath.access.PathAccessor;

import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;

public class LocalSyncPath implements SyncPath {
    private String path;
    private final PathAccessor accessor;
    public LocalSyncPath(String path) {
        if (path == null || path.isBlank()) {
            throw new IllegalArgumentException("Le chemin ne peut pas être vide.");
        }

        // Vérification si le chemin est syntaxiquement correct
        try {
            java.nio.file.Path normalized = Paths.get(path).normalize();
            this.path = normalized.toString();
        } catch (InvalidPathException e) {
            throw new IllegalArgumentException("Chemin invalide : " + e.getMessage());
        }
        if(!exists())
        {
            throw new IllegalArgumentException("le dossier n'existe pas dans le chemin: " + path);
        }
        this.accessor = new LocalPathAccessor(Paths.get(this.path));
    }

    public SyncPath getPath() {
        return this;
    }

    @Override
    public String toString() {
        return path;
    }

    public boolean exists() {
        return Files.isDirectory(Paths.get(path));
    }
    @Override
    public PathAccessor getAccessor() {
        return accessor;
    }

}

