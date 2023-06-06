package nekit508.mmgp.integrator.migrating;

import arc.struct.ObjectMap;
import arc.util.Log;

public class MigrationSettings extends Migrator{
    public static final ObjectMap<String, Migrator> migrators = ObjectMap.of(
            "v0.0.2", new V0$0$2Migrator()
    );

    public void migrate(String from, String to) {
        Log.info("Migrating from @ to @", from, to);
    }
}
