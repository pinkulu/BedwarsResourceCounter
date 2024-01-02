package com.pinkulu.bedwarsresourcecounter.utils;

import cc.polyfrost.oneconfig.utils.hypixel.HypixelUtils;
import cc.polyfrost.oneconfig.utils.hypixel.LocrawInfo;
import cc.polyfrost.oneconfig.utils.hypixel.LocrawUtil;
import org.apache.commons.lang3.StringUtils;

public class Utils {
    public static boolean shouldRender() {
        if (!HypixelUtils.INSTANCE.isHypixel()) return false;
        final LocrawInfo location = LocrawUtil.INSTANCE.getLocrawInfo();
        if (location == null) return false;
        final String mapName = location.getMapName();
        if (StringUtils.isBlank(mapName)) return false;
        return location.getGameType().equals(LocrawInfo.GameType.BEDWARS);
    }

    public static String formatRenderString(String string, String name, int inventoryCount, int chestCount) {
        String formattedString = string.replace("{%i}", String.valueOf(inventoryCount));
        formattedString = formattedString.replace("{%e}", String.valueOf(chestCount));
        formattedString = formattedString.replace("{%t}", String.valueOf(inventoryCount + chestCount));
        formattedString = formattedString.replace("{%n}", name);
        try {
            if (formattedString.contains("{%n[")) {
                int start = formattedString.indexOf("{%n[") + 4;
                int end = formattedString.indexOf("]}");
                String number = formattedString.substring(start, end);
                int num = Integer.parseInt(number);
                if (num > name.length()) {
                    formattedString = formattedString.replace("{%n[" + number + "]}", name);
                } else {
                    formattedString = formattedString.replace("{%n[" + number + "]}", name.substring(0, num));
                }
            }
        } catch (Exception ignored) {}

        return formattedString;
    }

}
