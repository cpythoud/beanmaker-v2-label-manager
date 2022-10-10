package org.beanmaker.labels;

import org.jcodegen.html.CData;
import org.jcodegen.html.Tag;

import java.util.HashMap;
import java.util.Map;

class HeroIcons {

    private static final int DEFAULT_SIZE = 24;

    private static final Map<String, String> ICONS;

    static {
        ICONS = new HashMap<>();

        ICONS.put(
                "x-circle",
                "<svg xmlns=\"http://www.w3.org/2000/svg\" fill=\"none\" viewBox=\"0 0 24 24\" stroke-width=\"1.5\" stroke=\"currentColor\" class=\"w-6 h-6\"><path stroke-linecap=\"round\" stroke-linejoin=\"round\" d=\"M9.75 9.75l4.5 4.5m0-4.5l-4.5 4.5M21 12a9 9 0 11-18 0 9 9 0 0118 0z\" /></svg>"
        );

        ICONS.put(
                "trash",
                "<svg xmlns=\"http://www.w3.org/2000/svg\" fill=\"none\" viewBox=\"0 0 24 24\" stroke-width=\"1.5\" stroke=\"currentColor\" class=\"w-6 h-6\"><path stroke-linecap=\"round\" stroke-linejoin=\"round\" d=\"M14.74 9l-.346 9m-4.788 0L9.26 9m9.968-3.21c.342.052.682.107 1.022.166m-1.022-.165L18.16 19.673a2.25 2.25 0 01-2.244 2.077H8.084a2.25 2.25 0 01-2.244-2.077L4.772 5.79m14.456 0a48.108 48.108 0 00-3.478-.397m-12 .562c.34-.059.68-.114 1.022-.165m0 0a48.11 48.11 0 013.478-.397m7.5 0v-.916c0-1.18-.91-2.164-2.09-2.201a51.964 51.964 0 00-3.32 0c-1.18.037-2.09 1.022-2.09 2.201v.916m7.5 0a48.667 48.667 0 00-7.5 0\" /></svg>"
        );

        ICONS.put(
                "pencil",
                "<svg xmlns=\"http://www.w3.org/2000/svg\" fill=\"none\" viewBox=\"0 0 24 24\" stroke-width=\"1.5\" stroke=\"currentColor\" class=\"w-6 h-6\"><path stroke-linecap=\"round\" stroke-linejoin=\"round\" d=\"M16.862 4.487l1.687-1.688a1.875 1.875 0 112.652 2.652L6.832 19.82a4.5 4.5 0 01-1.897 1.13l-2.685.8.8-2.685a4.5 4.5 0 011.13-1.897L16.863 4.487zm0 0L19.5 7.125\" /></svg>"
        );

        ICONS.put(
                "plus",
                "<svg xmlns=\"http://www.w3.org/2000/svg\" fill=\"none\" viewBox=\"0 0 24 24\" stroke-width=\"1.5\" stroke=\"currentColor\" class=\"w-6 h-6\"><path stroke-linecap=\"round\" stroke-linejoin=\"round\" d=\"M12 4.5v15m7.5-7.5h-15\" /></svg>"
        );
    }

    static Tag get(String name) {
        return get(name, null);
    }

    static Tag get(String name, String cssClasses) {
        if (ICONS.containsKey(name))
            return new CData(getSVGCode(name, cssClasses));

        throw new IllegalArgumentException("No icon named: " + name);
    }

    static String getSVGCode(String name) {
        return getSVGCode(name, null);
    }

    static String getSVGCode(String name, String cssClasses) {
        String svg = ICONS.get(name);
        if (cssClasses == null)
            return svg;

        return svg.replace("class=\"w-6 h-6\"", "class=\"" + cssClasses + "\"");
    }

}
