package com.pinkulu.bedwarsresourcecounter.hud;

import cc.polyfrost.oneconfig.hud.SingleTextHud;
import cc.polyfrost.oneconfig.libs.universal.UMatrixStack;
import cc.polyfrost.oneconfig.renderer.NanoVGHelper;
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
                PolyfrostEventListener.ec_gold,
                false
        );    }
    @Override
    public boolean isEnabled() {
        return (super.isEnabled() && Utils.shouldRender()) || (super.isEnabled() && PolyfrostEventListener.editingHUD);
    }

    @Override
    public void draw(UMatrixStack matrices, float x, float y, float scale, boolean example) {
        float xo = x;
        if (BedwarsResourceCounterConfig.renderIcons) {
            NanoVGHelper.INSTANCE.setupAndDraw(true, (vg) -> {
                NanoVGHelper.INSTANCE.drawImage(vg, "https://minecraft.wiki/images/Gold_Ingot_JE4_BE2.png?80cd6&format=original", x - 5 * scale, y - 2 * scale, scale * 10, scale * 10);
            });
            xo += 5 * scale;
        }
        super.draw(matrices, xo, y, scale, example);
    }

    @Override
    public float getWidth(float scale, boolean example) {
        if(BedwarsResourceCounterConfig.renderIcons)
            return super.getWidth(scale, example) + scale * 8;
        return super.getWidth(scale, example);
    }
}
