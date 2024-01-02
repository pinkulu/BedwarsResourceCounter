package com.pinkulu.bedwarsresourcecounter.hud;

import cc.polyfrost.oneconfig.hud.TextHud;
import com.pinkulu.bedwarsresourcecounter.config.BedwarsResourceCounterConfig;
import com.pinkulu.bedwarsresourcecounter.listeners.PolyfrostEventListener;
import com.pinkulu.bedwarsresourcecounter.utils.InventoryContents;
import com.pinkulu.bedwarsresourcecounter.utils.Utils;
import net.minecraft.client.Minecraft;
import net.minecraft.init.Items;

import java.util.List;

public class SingleHud extends TextHud {
    public SingleHud() {
        super(true);

    }

    @Override
    protected void getLines(List<String> lines, boolean example) {
        if(BedwarsResourceCounterConfig.showIron){
            lines.add(Utils.formatRenderString(
                    BedwarsResourceCounterConfig.renderString,
                    "Iron",
                    InventoryContents.getInventoryItemCount(Minecraft.getMinecraft().thePlayer.inventory.mainInventory, Items.iron_ingot.getUnlocalizedName()),
                    PolyfrostEventListener.ec_iron
            ));
        }
        if(BedwarsResourceCounterConfig.showGold){
            lines.add(Utils.formatRenderString(
                    BedwarsResourceCounterConfig.renderString,
                    "Gold",
                    InventoryContents.getInventoryItemCount(Minecraft.getMinecraft().thePlayer.inventory.mainInventory, Items.gold_ingot.getUnlocalizedName()),
                    PolyfrostEventListener.ec_gold
            ));
        }
        if(BedwarsResourceCounterConfig.showDiamond){
            lines.add(Utils.formatRenderString(
                    BedwarsResourceCounterConfig.renderString,
                    "Diamond",
                    InventoryContents.getInventoryItemCount(Minecraft.getMinecraft().thePlayer.inventory.mainInventory, Items.diamond.getUnlocalizedName()),
                    PolyfrostEventListener.ec_diamond
            ));
        }
        if(BedwarsResourceCounterConfig.showEmerald){
            lines.add(Utils.formatRenderString(
                    BedwarsResourceCounterConfig.renderString,
                    "Emerald",
                    InventoryContents.getInventoryItemCount(Minecraft.getMinecraft().thePlayer.inventory.mainInventory, Items.emerald.getUnlocalizedName()),
                    PolyfrostEventListener.ec_emerald
            ));
        }
    }
    @Override
    public boolean isEnabled() {
        return (super.isEnabled() && Utils.shouldRender()) || (super.isEnabled() && PolyfrostEventListener.editingHUD);
    }
}
