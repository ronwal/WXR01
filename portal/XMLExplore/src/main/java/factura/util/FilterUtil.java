/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package factura.util;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author German17
 */
public class FilterUtil {

    public static String check(String filter) {
        filter = (filter == null) ? "%" : filter;
        String checkedFilter = filter.trim().toUpperCase();
        checkedFilter = checkedFilter.replace(" ", "%");
        checkedFilter = checkedFilter.replace("*", "%");
        if (!checkedFilter.startsWith("%")) {
            checkedFilter = "%" + checkedFilter;
        }

        if (!checkedFilter.endsWith("%")) {
            checkedFilter += "%";
        }
        return checkedFilter;
    }

    private static void generateR(List source, List partial, List out) {
        List newPartial = new ArrayList(partial);
        List newSource = new ArrayList();
        if (source.size() == 0) {
            out.add(newPartial);
            return;
        }
        for (int i = 0; i < source.size(); i++) {
            newPartial = new ArrayList(partial);
            newPartial.addAll(source.subList(i, i + 1));
            newSource = new ArrayList(source.subList(0, i));
            if (i < (source.size() + 1)) {
                newSource.addAll(source.subList(i + 1, source.size()));
            }
            generateR(newSource, newPartial, out);
        }
    }

    private static ArrayList generate(ArrayList source) {
        ArrayList out = new ArrayList();
        ArrayList partial = new ArrayList();
        generateR(source, partial, out);
        return out;
    }

    public static String check(String attribute, String filter) {
        filter = (filter == null) ? "%" : filter;
        filter = filter.trim().toUpperCase();
        if (!filter.contains(" ")) {
            if (filter.contains("*")) {
                return "upper(" + attribute + ") like '" + filter.replace("*", "%") + "'";
            }
        }
        StringTokenizer token = new StringTokenizer(filter);

        ArrayList<String> words = new ArrayList<String>();
        while (token.hasMoreTokens()) {
            String s = token.nextToken();
            s = s.replace("'", "");
            s = s.replace("*", "");
            s = s.replace("\\", "");
            s = s.replace("\"", "");
            words.add(s);
        }
        ArrayList<ArrayList> combinations = generate(words);
        ArrayList<String> likes = new ArrayList<String>();
        for (ArrayList<String> combination : combinations) {
            String like = "%";
            for (String s : combination) {
                like += s + "%";
            }
            likes.add(like);
        }

        String query = "";

        for (String like : likes) {
            query += "upper(" + attribute + ") like '" + like + "' or ";
        }

        if (query.length() == 0) {
            return "upper(" + attribute + ") like '%'";
        } else {
            query = query.substring(0, query.length() - 3);
        }


        return query;

    }
}
