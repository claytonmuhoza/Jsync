package com.claytonmuhoza.syncPath.access;

import java.io.InputStream;
import java.util.List;

public interface PathAccessor {
    List<String> listRelativePaths() throws Exception;

    boolean exists(String relativePath) throws Exception;

    long getLastModified(String relativePath) throws Exception;

    InputStream read(String relativePath) throws Exception;

    void write(String relativePath, InputStream data, long lastModified) throws Exception;

    void delete(String relativePath) throws Exception;
}