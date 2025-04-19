package com.claytonmuhoza.syncPath.access;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.FileTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LocalPathAccessor implements PathAccessor {
    private final Path root;

    public LocalPathAccessor(Path root) {
        this.root = root;
    }

    @Override
    public List<String> listRelativePaths() throws IOException {
        try (Stream<Path> stream = Files.walk(root)) {
            return stream
                    .filter(Files::isRegularFile)
                    .map(root::relativize)
                    .map(Path::toString)
                    .collect(Collectors.toList());
        }
    }

    @Override
    public boolean exists(String relativePath) {
        return Files.exists(root.resolve(relativePath));
    }

    @Override
    public long getLastModified(String relativePath) throws IOException {
        return Files.getLastModifiedTime(root.resolve(relativePath)).toMillis();
    }

    @Override
    public InputStream read(String relativePath) throws IOException {
        return Files.newInputStream(root.resolve(relativePath));
    }

    @Override
    public void write(String relativePath, InputStream data, long lastModified) throws IOException {
        Path target = root.resolve(relativePath);
        Files.createDirectories(target.getParent());
        Files.copy(data, target, StandardCopyOption.REPLACE_EXISTING);
        Files.setLastModifiedTime(target, FileTime.fromMillis(lastModified));
    }

    @Override
    public void delete(String relativePath) throws IOException {
        Files.deleteIfExists(root.resolve(relativePath));
    }
}

