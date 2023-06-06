package nekit508.mmgp.core.file;

import arc.files.Fi;
import arc.files.ZipFi;
import arc.util.Log;

/**
 * Use for JAR internal navigation
 * @author nekit508
 **/
public class InternalFileTree {
    public Class<?> anchorClass;

    public ZipFi root;
    public Fi jar;

    /**
     * @param owner navigation anchor
     **/
    public InternalFileTree(Class<?> owner) {
        anchorClass = owner;

        String classPath = owner.getResource("").getFile().replaceAll("%20", " ");
        classPath = classPath.substring(classPath.indexOf(":")+2);
        String jarPath = classPath.substring(0, classPath.indexOf("!"));

        jar = new Fi(jarPath);
        root = new ZipFi(new Fi(jarPath));
    }

    public Fi child(String childPath) {
        Fi out = root;
        for (String s : childPath.split("/")) {
            out = out.child(s);
        }
        return out;
    }
}
