package org.beacon.Server;

import org.apache.commons.io.IOUtils;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppClassLoader;
import org.eclipse.jetty.webapp.WebAppContext;

import java.io.*;
import java.nio.channels.FileChannel;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;


public class Jetty {
    public static void main(String[] args) throws Exception {

            new Jetty().runJetty();
    }

    public void runJetty() throws Exception {
        Server jettyServer = new Server(8085);
//
        WebAppContext webContext = new WebAppContext();
        webContext.setClassLoader(new WebAppClassLoader(this.getClass().getClassLoader(), webContext));
        webContext.setServer(jettyServer);
        webContext.setContextPath("/");
        String path = Jetty.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath();
        System.out.println(path);
        JarFile jarFile = new JarFile(path);
        extractWar(jarFile);
        webContext.setWar("Beacon-1.0.war");
        webContext.setExtraClasspath("org.beacon.Rest.EntryPoint");
        File temp = new File("temp");
        if(!temp.exists())
        {
            temp.mkdir();
        }
        webContext.setTempDirectory(temp);

        jettyServer.setHandler(webContext);

        try {
            jettyServer.start();
            jettyServer.join();
        } finally {
            jettyServer.destroy();
        }
    }

    private void extractWar(JarFile jar) throws IOException {
            ZipEntry file = jar.getEntry("Beacon-1.0.war");//(JarEntry) enumEntries.nextElement();

            File outWar = new File(file.getName());
            InputStream is = jar.getInputStream(file);


            FileOutputStream fos = new FileOutputStream(outWar);
             byte[] buffer = new byte[8192];
            int read;

            while ((read = is.read(buffer)) != -1)
            {
                fos.write(buffer, 0, read);
            }
            fos.close();
            is.close();
    }
}
