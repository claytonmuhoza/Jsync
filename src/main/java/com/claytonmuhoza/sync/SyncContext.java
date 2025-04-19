package com.claytonmuhoza.sync;

import com.claytonmuhoza.registrer.Register;
import com.claytonmuhoza.syncPath.access.PathAccessor;
import com.claytonmuhoza.sync.side.SideFile;
import com.claytonmuhoza.sync.syncinfo.LastSyncInfo;

public class SyncContext {
    private final String relativePath;
    private final SideFile fileA;
    private final SideFile fileB;
    private final LastSyncInfo lastSyncInfo;
    private final PathAccessor accessorA;
    private final PathAccessor accessorB;
    private final Register register;

    public SyncContext(String relativePath,
                       SideFile fileA,
                       SideFile fileB,
                       LastSyncInfo lastSyncInfo,
                       PathAccessor accessorA,
                       PathAccessor accessorB,
                       Register register) {
        this.relativePath = relativePath;
        this.fileA = fileA;
        this.fileB = fileB;
        this.lastSyncInfo = lastSyncInfo;
        this.accessorA = accessorA;
        this.accessorB = accessorB;
        this.register = register;
    }

    public String getRelativePath() {
        return relativePath;
    }

    public SideFile getFileA() {
        return fileA;
    }

    public SideFile getFileB() {
        return fileB;
    }

    public LastSyncInfo getLastSyncInfo() {
        return lastSyncInfo;
    }

    public PathAccessor getAccessorA() {
        return accessorA;
    }

    public PathAccessor getAccessorB() {
        return accessorB;
    }

    public Register getRegister() {
        return register;
    }
    public void markSyncedFromA() {
        if (fileA.exists()) {
            register.update(relativePath, fileA.getLastModified());
        }
    }

    public void markSyncedFromB() {
        if (fileB.exists()) {
            register.update(relativePath, fileB.getLastModified());
        }
    }

    public void removeFromRegister() {
        register.remove(relativePath);
    }
}
