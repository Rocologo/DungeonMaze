package com.timvisee.dungeonmaze.util;

import org.bukkit.Bukkit;

public class MinecraftUtils {

    /**
     * Get the current Minecraft version.
     *
     * @return The current Minecraft version.
     */
    public static String getMinecraftVersion() {
        // Get the raw version
        final String rawVersion = Bukkit.getVersion();

        // Get the start of the version number in the raw string
        int start = rawVersion.indexOf("MC:");
        if(start == -1)
            return rawVersion;

        // Change the start to exclude the 'MC:' string
        start += 4;

        // Ge the end of the version number
        int end = rawVersion.indexOf(')', start);

        // Get and return the Minecraft version number
        return rawVersion.substring(start, end);
    }
}
