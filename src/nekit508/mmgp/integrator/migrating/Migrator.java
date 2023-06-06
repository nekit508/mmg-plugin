package nekit508.mmgp.integrator.migrating;

import arc.files.Fi;

public abstract class Migrator {
    public abstract void migrate(String from, String to) ;

    void cloneFile(Fi from, Fi into) {
        if (from.isDirectory()) {
            for (Fi fi : from.list()) {
                if (fi.isDirectory()) {
                    into.child(fi.name()).mkdirs();
                } else {
                    into.child(fi.name()).writeString(fi.readString());
                }
            }
        }
    }

    void delete(Fi file) {
        if (!file.exists()) return;
        if (file.isDirectory())
            file.deleteDirectory();
        else
            file.delete();
    }
}
