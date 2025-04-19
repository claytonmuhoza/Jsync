package com.claytonmuhoza.sync;

import com.claytonmuhoza.profile.Profile;
import com.claytonmuhoza.registrer.Entry;
import com.claytonmuhoza.registrer.Register;
import com.claytonmuhoza.syncPath.access.PathAccessor;
import com.claytonmuhoza.sync.side.MissingFile;
import com.claytonmuhoza.sync.side.PresentFile;
import com.claytonmuhoza.sync.side.SideFile;
import com.claytonmuhoza.sync.syncinfo.LastSyncInfo;
import com.claytonmuhoza.sync.syncinfo.NeverSynced;
import com.claytonmuhoza.sync.syncinfo.SyncedEntry;

import java.util.*;

public class SyncContextBuilder {

    public static List<SyncContext> buildContexts(Profile profile) throws Exception {
        PathAccessor accessorA = profile.getPathA().getAccessor();
        PathAccessor accessorB = profile.getPathB().getAccessor();
        Register register = profile.getRegister();

        Set<String> allPaths = new HashSet<>();
        allPaths.addAll(accessorA.listRelativePaths());
        allPaths.addAll(accessorB.listRelativePaths());
        for (Entry e : register.getAllEntries()) {
            allPaths.add(e.getPath());
        }

        List<SyncContext> result = new ArrayList<>();
        for (String path : allPaths) {
            SideFile fileA = accessorA.exists(path)
                    ? new PresentFile(accessorA.getLastModified(path))
                    : new MissingFile();

            SideFile fileB = accessorB.exists(path)
                    ? new PresentFile(accessorB.getLastModified(path))
                    : new MissingFile();
            LastSyncInfo syncInfo = register.contains(path)
                    ? new SyncedEntry(register.getEntry(path).getTimestamp())
                    : new NeverSynced();

            result.add(new SyncContext(path, fileA, fileB, syncInfo, accessorA, accessorB, register));
        }

        return result;
    }
}
