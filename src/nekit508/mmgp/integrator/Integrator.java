package nekit508.mmgp.integrator;

import arc.Events;
import arc.files.Fi;
import arc.util.Log;
import arc.util.serialization.JsonReader;
import com.sun.tools.javac.Main;
import nekit508.mmgp.core.events.EventTypes;
import nekit508.mmgp.core.file.Formatter;
import nekit508.mmgp.core.file.InternalFileTree;
import nekit508.mmgp.integrator.migrating.MigrationSettings;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.jar.Manifest;

public class Integrator {
    public static InternalFileTree internal = new InternalFileTree(Integrator.class);
    public static String version;

    public static final Fi projectRootDir = new Fi("");
    public static final Fi versionFile = projectRootDir.child("mmg-plugin.version");

    static {
        Formatter.formatKeys.put("jarFileName", internal.jar.name());
        Events.on(EventTypes.PreHandleFile.class, e -> {
            Log.info(e.file.absolutePath());
            Formatter.formatKeys.put("fileName", e.file.absolutePath());
        });
    }


    public static void main(String[] a) {
        Log.info("Integrating into @ started", projectRootDir.absolutePath());
        try {
            Enumeration<URL> resources = Main.class.getClassLoader()
                    .getResources("META-INF/MANIFEST.MF");
            while (resources.hasMoreElements()) {
                URL manifestUrl = resources.nextElement();
                Manifest manifest = new Manifest(manifestUrl.openStream());
                version = manifest.getMainAttributes().getValue("plugin-version");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.info("Plugin version: @", version);

        String projectPluginVersion = "NULL";
        Fi versionFile = projectRootDir.child("mmg.version");
        if (versionFile.exists())
            projectPluginVersion = versionFile.readString();

        //new MigrationSettings().migrate(version, projectPluginVersion);

        try {
            URL url = new URL("https://github.com/nekit508/mmg-plugin/archive/refs/heads/main.zip");
            url.
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
