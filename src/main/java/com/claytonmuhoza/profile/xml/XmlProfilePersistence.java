package com.claytonmuhoza.profile.xml;

import com.claytonmuhoza.profile.*;
import com.claytonmuhoza.profile.util.ProfileFileUtils;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

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
        source.setTextContent(profile.getSourcePath().toString());
        root.appendChild(source);

        Element target = doc.createElement("target");
        target.setTextContent(profile.getTargetPath().toString());
        root.appendChild(target);

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
