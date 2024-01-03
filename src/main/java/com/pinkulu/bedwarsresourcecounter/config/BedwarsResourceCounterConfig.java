package com.pinkulu.bedwarsresourcecounter.config;

import cc.polyfrost.oneconfig.config.annotations.*;
import cc.polyfrost.oneconfig.config.data.InfoType;
import cc.polyfrost.oneconfig.libs.universal.UDesktop;
import com.pinkulu.bedwarsresourcecounter.BedwarsResourceCounter;
import com.pinkulu.bedwarsresourcecounter.hud.*;
import cc.polyfrost.oneconfig.config.Config;
import cc.polyfrost.oneconfig.config.data.Mod;
import cc.polyfrost.oneconfig.config.data.ModType;
import cc.polyfrost.oneconfig.config.data.OptionSize;

import java.net.URI;

public class BedwarsResourceCounterConfig extends Config {

    @Text(
            name = "Render String"
    )
    public static String renderString = "{%n}({%t}): {%i} / {%e}";

    @Info(
            text = "You can use {%i} for inventory, ${%e} for ender chest, {%t} for total," +
                    " {%n} for name, {%n[x]} where x is a number of letters",
            type = InfoType.INFO,
            size = OptionSize.DUAL
    )
    public String info;

    @Checkbox(
            name = "Render Icons"
    )
    public static boolean renderIcons = false;


    @Info(
            text = "A Mod by Pinkulu(Luna)",
            type = InfoType.WARNING,
            size = OptionSize.DUAL,
            subcategory = "Self promotion"
    )
    public String selfPromotion;

    @Button(
            name = "Website",
            text = "Website",
            subcategory = "Self promotion"
    )
    Runnable pinkulu = () -> UDesktop.browse(URI.create("https://pinkulu.com"));

    @Button(
            name = "Discord",
            text = "Discord",
            subcategory = "Self promotion"
    )
    Runnable discord = () -> UDesktop.browse(URI.create("https://inv.wtf/pink"));

    @HUD(
            name = "Single HUD",
            category = "Single"
    )
    public SingleHud singleHud = new SingleHud();

    @Checkbox(
            name = "Show Iron",
            category = "Single"
    )
    public static boolean showIron = true;

    @Checkbox(
            name = "Show Gold",
            category = "Single"
    )
    public static boolean showGold = true;

    @Checkbox(
            name = "Show Diamond",
            category = "Single"
    )
    public static boolean showDiamond = true;

    @Checkbox(
            name = "Show Emerald",
            category = "Single"
    )
    public static boolean showEmerald = true;

    @HUD(
            name = "Iron HUD",
            category = "Iron"
    )
    public IronHud ironHud = new IronHud();

    @HUD(
            name = "Gold HUD",
            category = "Gold"
    )
    public GoldHud goldHud = new GoldHud();

    @HUD(
            name = "Diamond HUD",
            category = "Diamond"
    )
    public DiamondHud diamondHud = new DiamondHud();

    @HUD(
            name = "Emerald HUD",
            category = "Emerald"
    )
    public EmeraldHud emeraldHud = new EmeraldHud();

    public BedwarsResourceCounterConfig() {
        super(new Mod(BedwarsResourceCounter.NAME, ModType.HYPIXEL), BedwarsResourceCounter.MODID + ".json");
        initialize();
    }
}

