package com.pinkulu.bedwarsresourcecounter;

import cc.polyfrost.oneconfig.events.EventManager;
import com.pinkulu.bedwarsresourcecounter.command.BedwarsResourceCounterCommand;
import com.pinkulu.bedwarsresourcecounter.config.BedwarsResourceCounterConfig;
import cc.polyfrost.oneconfig.events.event.InitializationEvent;
import com.pinkulu.bedwarsresourcecounter.listeners.PolyfrostEventListener;
import net.minecraftforge.fml.common.Mod;
import cc.polyfrost.oneconfig.utils.commands.CommandManager;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

/**
 * The entrypoint of the Example Mod that initializes it.
 *
 * @see Mod
 * @see InitializationEvent
 */
@Mod(modid = BedwarsResourceCounter.MODID, name = BedwarsResourceCounter.NAME, version = BedwarsResourceCounter.VERSION)
public class BedwarsResourceCounter {
    public static final String MODID = "@ID@";
    public static final String NAME = "@NAME@";
    public static final String VERSION = "@VER@";
    // Sets the variables from `gradle.properties`. See the `blossom` config in `build.gradle.kts`.
    @Mod.Instance(MODID)
    public static BedwarsResourceCounter INSTANCE; // Adds the instance of the mod, so we can access other variables.
    public static BedwarsResourceCounterConfig config;

    // Register the config and commands.
    @Mod.EventHandler
    public void onInit(FMLInitializationEvent event) {
        config = new BedwarsResourceCounterConfig();
        EventManager.INSTANCE.register(new PolyfrostEventListener());
        CommandManager.INSTANCE.registerCommand(new BedwarsResourceCounterCommand());

    }
}
