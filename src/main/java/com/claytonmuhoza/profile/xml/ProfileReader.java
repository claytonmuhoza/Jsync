package com.claytonmuhoza.profile.xml;

import com.claytonmuhoza.profile.Profile;
import com.claytonmuhoza.profile.ProfileBuilder;
import com.claytonmuhoza.syncPath.LocalSyncPath;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class ProfileReader {

    private final ProfileBuilder builder;

    public ProfileReader(ProfileBuilder builder) {
        this.builder = builder;
    }

    public Profile read(File file) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = factory.newDocumentBuilder();
        Document doc = docBuilder.parse(file);

        Element root = doc.getDocumentElement();
        String name = root.getAttribute("name");
        builder.setProfileName(name);

        String sourcePath = doc.getElementsByTagName("source").item(0).getTextContent().trim();
        String targetPath = doc.getElementsByTagName("target").item(0).getTextContent().trim();

        builder.setSourcePath(new LocalSyncPath(sourcePath));
        builder.setTargetPath(new LocalSyncPath(targetPath));

        return builder.build();
    }
}
