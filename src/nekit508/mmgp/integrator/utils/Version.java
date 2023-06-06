package nekit508.mmgp.integrator.utils;

import arc.math.Mathf;
import arc.util.Strings;

public final class Version {
    public static int versionToNumber(String version) {
        int out = 0;
        version = version.replace("v", " ");

        String[] str = version.split(".");
        for (int i = 0; i < str.length; i++) {
            out += Integer.parseInt(str[i]) * Mathf.pow(1000, i);
        }

        return out;
    }

    public static String numberToVersion(int number) {
        return Strings.format("v@.@.@", number / 1000000000, number / 1000000, number / 1000);
    }


}
