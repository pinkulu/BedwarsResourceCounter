package com.pinkulu.bedwarsresourcecounter.command;

import com.pinkulu.bedwarsresourcecounter.BedwarsResourceCounter;
import cc.polyfrost.oneconfig.utils.commands.annotations.Command;
import cc.polyfrost.oneconfig.utils.commands.annotations.Main;

@Command(value = BedwarsResourceCounter.MODID, description = "Access the " + BedwarsResourceCounter.NAME + " GUI.", aliases = {"brc"})
public class BedwarsResourceCounterCommand {
    @Main
    private void handle() {
        BedwarsResourceCounter.INSTANCE.config.openGui();
    }
}