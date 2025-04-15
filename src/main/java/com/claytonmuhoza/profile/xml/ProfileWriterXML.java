package com.claytonmuhoza.profile.xml;

import com.claytonmuhoza.profile.Profile;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class ProfileWriterXML {

    public static void write(Profile profile) throws Exception {
        boolean isSaved = false;
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Création du document XML
        Document doc = builder.newDocument();
        Element root = doc.createElement("profile");
        root.setAttribute("name", profile.getProfileName().toString());
        doc.appendChild(root);

        // Source
        Element source = doc.createElement("source");
        //source.setAttribute("type", profile.getSource().getType().name().toLowerCase());
        source.setTextContent(profile.getSourcePath().toString());
        root.appendChild(source);

        // Target
        Element target = doc.createElement("target");
        //target.setAttribute("type", profile.getTarget().getType().name().toLowerCase());
        target.setTextContent(profile.getTargetPath().toString());
        root.appendChild(target);

        // Écriture du fichier
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "sync-profile.dtd");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");

        File file = new File(profile.getProfileName() + ".sync");
        transformer.transform(new DOMSource(doc), new StreamResult(file));

        System.out.println("Profil sauvegardé dans " + file.getAbsolutePath());
    }
}
