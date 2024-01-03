package com.pinkulu.bedwarsresourcecounter.hud;

import cc.polyfrost.oneconfig.hud.TextHud;
import cc.polyfrost.oneconfig.libs.universal.UImage;
import cc.polyfrost.oneconfig.libs.universal.UMatrixStack;
import cc.polyfrost.oneconfig.renderer.NanoVGHelper;
import cc.polyfrost.oneconfig.renderer.TextRenderer;
import com.pinkulu.bedwarsresourcecounter.config.BedwarsResourceCounterConfig;
import com.pinkulu.bedwarsresourcecounter.listeners.PolyfrostEventListener;
import com.pinkulu.bedwarsresourcecounter.utils.InventoryContents;
import com.pinkulu.bedwarsresourcecounter.utils.Utils;
import net.minecraft.client.Minecraft;
import net.minecraft.init.Items;
import net.minecraft.util.ResourceLocation;

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
                    PolyfrostEventListener.ec_iron,
                    true
            ));
        }
        if(BedwarsResourceCounterConfig.showGold){
            lines.add(Utils.formatRenderString(
                    BedwarsResourceCounterConfig.renderString,
                    "Gold",
                    InventoryContents.getInventoryItemCount(Minecraft.getMinecraft().thePlayer.inventory.mainInventory, Items.gold_ingot.getUnlocalizedName()),
                    PolyfrostEventListener.ec_gold,
                    true
            ));
        }
        if(BedwarsResourceCounterConfig.showDiamond){
            lines.add(Utils.formatRenderString(
                    BedwarsResourceCounterConfig.renderString,
                    "Diamonds",
                    InventoryContents.getInventoryItemCount(Minecraft.getMinecraft().thePlayer.inventory.mainInventory, Items.diamond.getUnlocalizedName()),
                    PolyfrostEventListener.ec_diamond,
                    true
            ));
        }
        if(BedwarsResourceCounterConfig.showEmerald){
            lines.add(Utils.formatRenderString(
                    BedwarsResourceCounterConfig.renderString,
                    "Emeralds",
                    InventoryContents.getInventoryItemCount(Minecraft.getMinecraft().thePlayer.inventory.mainInventory, Items.emerald.getUnlocalizedName()),
                    PolyfrostEventListener.ec_emerald,
                    true
            ));
        }

    }
    @Override
    public boolean isEnabled() {
        return (super.isEnabled() && Utils.shouldRender()) || (super.isEnabled() && PolyfrostEventListener.editingHUD);
    }

    @Override
    public void draw(UMatrixStack matrices, float x, float y, float scale, boolean example) {
        if (lines == null || lines.isEmpty()) return;

        float textY = y;
        for (String line : lines) {
            drawLine(line, x, textY, scale);
            textY += 12 * scale;
        }
    }


    protected void drawLine(String line, float x, float y, float scale) {
        float xo = x;
        if(BedwarsResourceCounterConfig.renderIcons){
            if(line.endsWith("{I}"))
            {
                NanoVGHelper.INSTANCE.setupAndDraw(true, (vg) -> {
                    NanoVGHelper.INSTANCE.drawImage(vg, "https://minecraft.wiki/images/Iron_Ingot.png?849cb&format=original", x - 5 * scale, y - 2 * scale, scale * 10, scale * 10);
                });
            }
            if(line.endsWith("{G}"))
            {
                NanoVGHelper.INSTANCE.setupAndDraw(true, (vg) -> {
                    NanoVGHelper.INSTANCE.drawImage(vg, "https://minecraft.wiki/images/Gold_Ingot_JE4_BE2.png?80cd6&format=original", x - 5 * scale, y - 2 * scale, scale * 10, scale * 10);
                });
            }
            if(line.endsWith("{D}"))
            {
                NanoVGHelper.INSTANCE.setupAndDraw(true, (vg) -> {
                    NanoVGHelper.INSTANCE.drawImage(vg, "https://minecraft.wiki/images/Diamond_JE3_BE3.png?99d00&format=original", x - 5 * scale, y - 2 * scale, scale * 10, scale * 10);
                });
            }
            if(line.endsWith("{E}"))
            {
                NanoVGHelper.INSTANCE.setupAndDraw(true, (vg) -> {
                    NanoVGHelper.INSTANCE.drawImage(vg, "https://minecraft.wiki/images/Emerald_JE3_BE3.png?4c5f3&format=original", x - 5 * scale, y - 2 * scale, scale * 10, scale * 10);
                });
            }
            xo += 5 * scale;
        }
        line = line.substring(0, line.length() - 3);
        TextRenderer.drawScaledString(line, xo, y, color.getRGB(), TextRenderer.TextType.toType(textType), scale);
    }

    @Override
    public float getWidth(float scale, boolean example) {
        if(BedwarsResourceCounterConfig.renderIcons)
            return super.getWidth(scale, example) + scale * 8;
        return super.getWidth(scale, example);
    }
}
