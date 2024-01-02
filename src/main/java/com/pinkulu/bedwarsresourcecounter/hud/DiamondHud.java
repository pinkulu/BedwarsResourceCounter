package com.pinkulu.bedwarsresourcecounter.hud;

import cc.polyfrost.oneconfig.hud.SingleTextHud;
import com.pinkulu.bedwarsresourcecounter.config.BedwarsResourceCounterConfig;
import com.pinkulu.bedwarsresourcecounter.listeners.PolyfrostEventListener;
import com.pinkulu.bedwarsresourcecounter.utils.InventoryContents;
import com.pinkulu.bedwarsresourcecounter.utils.Utils;
import net.minecraft.client.Minecraft;
import net.minecraft.init.Items;

public class DiamondHud extends SingleTextHud {
    public DiamondHud() {
        super("", false);
    }

    @Override
    public String getText(boolean example) {
        return Utils.formatRenderString(
                BedwarsResourceCounterConfig.renderString,
                "Diamonds",
                InventoryContents.getInventoryItemCount(Minecraft.getMinecraft().thePlayer.inventory.mainInventory, Items.diamond.getUnlocalizedName()),
                PolyfrostEventListener.ec_diamond
        );
    }

    @Override
    public boolean isEnabled() {
        return (super.isEnabled() && Utils.shouldRender()) || (super.isEnabled() && PolyfrostEventListener.editingHUD);
    }
}
