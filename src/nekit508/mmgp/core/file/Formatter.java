package nekit508.mmgp.core.file;

import arc.Events;
import arc.files.Fi;
import arc.struct.ObjectMap;
import arc.struct.Seq;
import arc.util.Log;
import nekit508.mmgp.core.events.EventTypes;

import java.util.Iterator;

public class Formatter {
    public static ObjectMap<String, String> formatKeys = new ObjectMap<>();

    private static int counter;

    public static String handleFile(Fi file) {
        preHandleFile(file);
        String in = file.readString();
        String out = "";

        for (int i = 0; i < in.length(); i++) {
            String symbol = String.valueOf(in.charAt(i));

            if (symbol.equals("$")) {
                if (at(in, i+1).equals("[")) {
                    int start = i + 2;
                    int end = i + in.substring(i).indexOf("]");
                    String key = in.substring(start, end);
                    String value = formatKeys.get(key);
                    out += value;
                    Log.infoList(start, end);
                    i = end+1;
                }
            } else {
                out += symbol;
            }
        }

        return out;
    }

    static String at(String str, int ind) {
        return String.valueOf(str.charAt(ind));
    }

    public static void preHandleFile(Fi fi) {
        Events.fire(new EventTypes.PreHandleFile(){{file=fi;}});
    }
}
