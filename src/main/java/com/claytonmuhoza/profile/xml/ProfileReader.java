package com.claytonmuhoza.profile.xml;

import com.claytonmuhoza.profile.Profile;
import com.claytonmuhoza.profile.ProfileBuilder;
import com.claytonmuhoza.profile.ProfileName;
import com.claytonmuhoza.registrer.Register;
import com.claytonmuhoza.registrer.RegisterStd;
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

        String sourcePath = doc.getElementsByTagName("source").item(0).getTextContent().trim();
        String targetPath = doc.getElementsByTagName("target").item(0).getTextContent().trim();
        Register register = new RegisterStd();

        NodeList entries = doc.getElementsByTagName("entry");
        for (int i = 0; i < entries.getLength(); i++) {
            Element entry = (Element) entries.item(i);
            String path = entry.getAttribute("path");
            long timestamp = Long.parseLong(entry.getAttribute("timestamp"));
            register.update(path, timestamp);
        }

        return builder
                .setProfileName(new ProfileName(name))
                .setPathA(new LocalSyncPath(sourcePath))
                .setPathB(new LocalSyncPath(targetPath))
                .setRegistrer(register)
                .build();

    }
}
