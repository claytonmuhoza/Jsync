package com.claytonmuhoza.profile.xml;

import com.claytonmuhoza.profile.*;
import com.claytonmuhoza.profile.util.ProfileFileUtils;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.Map;

public class XmlProfilePersistence implements ProfilePersistence {

    @Override
    public void save(Profile profile) throws Exception {
        File file = new File(ProfileFileUtils.toSafeFileName(profile.getProfileName().toString()));
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document doc = builder.newDocument();
        Element root = doc.createElement("profile");
        root.setAttribute("name", profile.getProfileName().toString());
        doc.appendChild(root);

        Element source = doc.createElement("source");
        source.setTextContent(profile.getPathA().toString());
        root.appendChild(source);

        Element target = doc.createElement("target");
        target.setTextContent(profile.getPathB().toString());
        root.appendChild(target);

        //register
        // <registry>
        Map<String, Long> entries = profile.getRegister().getAll();
        if (!entries.isEmpty()) {
            Element registryElem = doc.createElement("registry");
            for (Map.Entry<String, Long> entry : entries.entrySet()) {
                Element entryElem = doc.createElement("entry");
                entryElem.setAttribute("path", entry.getKey());
                entryElem.setAttribute("timestamp", entry.getValue().toString());
                registryElem.appendChild(entryElem);
            }
            profileElem.appendChild(registryElem);
        }

        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "sync-profile.dtd");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");

        transformer.transform(new DOMSource(doc), new StreamResult(file));
        System.out.println("Profile sauvegardé dans " + file.getAbsolutePath());
    }

    @Override
    public Profile load(ProfileName profileName) throws Exception {
        File file = new File(ProfileFileUtils.toSafeFileName(profileName.toString()));
        ProfileBuilder builder = new ProfileBuilderStd();
        ProfileReader reader = new ProfileReader(builder);
        return reader.read(file);
    }
}
