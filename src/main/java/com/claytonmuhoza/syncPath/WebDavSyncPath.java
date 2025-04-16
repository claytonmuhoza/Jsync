package com.claytonmuhoza.syncPath;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class WebDavSyncPath implements SyncPath {
    private final String url;

    public WebDavSyncPath(String url) {
        if (url == null || url.isBlank()) {
            throw new IllegalArgumentException("L'URL WebDAV ne peut pas être vide.");
        }

        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            throw new IllegalArgumentException("L'URL WebDAV doit commencer par http:// ou https://");
        }

        this.url = url;

        // Vérification d'existence au moment de la construction (si souhaité)
        if (!exists()) {
            throw new IllegalArgumentException("Le dossier distant WebDAV n'existe pas ou n'est pas accessible : " + url);
        }
    }

    @Override
    public SyncPath getPath() {
        return this;
    }

    @Override
    public boolean exists() {
        try {
            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setRequestMethod("PROPFIND"); // méthode WebDAV
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(5000);
            conn.setRequestProperty("Depth", "0");
            conn.connect();

            int status = conn.getResponseCode();
            return (status >= 200 && status < 300);
        } catch (IOException e) {
            return false;
        }
    }

    @Override
    public String toString() {
        return url;
    }
}

