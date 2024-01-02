package com.pinkulu.bedwarsresourcecounter.hud;

import cc.polyfrost.oneconfig.hud.SingleTextHud;
import com.pinkulu.bedwarsresourcecounter.config.BedwarsResourceCounterConfig;
import com.pinkulu.bedwarsresourcecounter.listeners.PolyfrostEventListener;
import com.pinkulu.bedwarsresourcecounter.utils.InventoryContents;
import com.pinkulu.bedwarsresourcecounter.utils.Utils;
import net.minecraft.client.Minecraft;
import net.minecraft.init.Items;

public class GoldHud extends SingleTextHud {
    public GoldHud() {
        super("", false);
    }

    @Override
    public String getText(boolean example) {
        return Utils.formatRenderString(
                BedwarsResourceCounterConfig.renderString,
                "Gold",
                InventoryContents.getInventoryItemCount(Minecraft.getMinecraft().thePlayer.inventory.mainInventory, Items.gold_ingot.getUnlocalizedName()),
                PolyfrostEventListener.ec_gold
        );    }
    @Override
    public boolean isEnabled() {
        return (super.isEnabled() && Utils.shouldRender()) || (super.isEnabled() && PolyfrostEventListener.editingHUD);
    }
}
