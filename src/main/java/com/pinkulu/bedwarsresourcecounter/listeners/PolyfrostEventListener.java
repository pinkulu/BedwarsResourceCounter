package com.pinkulu.bedwarsresourcecounter.listeners;

import cc.polyfrost.oneconfig.events.event.ReceivePacketEvent;
import cc.polyfrost.oneconfig.events.event.ScreenOpenEvent;
import cc.polyfrost.oneconfig.events.event.TickEvent;
import cc.polyfrost.oneconfig.libs.eventbus.Subscribe;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiChest;
import net.minecraft.init.Items;
import net.minecraft.inventory.ContainerChest;
import net.minecraft.network.login.server.S03PacketEnableCompression;
import net.minecraft.network.play.server.S01PacketJoinGame;

import java.util.Objects;


public class PolyfrostEventListener {
    public static int ec_iron = 0;
    public static int ec_gold = 0;
    public static int ec_diamond = 0;
    public static int ec_emerald = 0;
    public static boolean editingHUD = false;


    @Subscribe
    public void onTick(TickEvent event) {
        if (Minecraft.getMinecraft().thePlayer == null) return;
        if (Minecraft.getMinecraft().thePlayer.openContainer == null) return;
        if (!(Minecraft.getMinecraft().thePlayer.openContainer instanceof ContainerChest)) return;

        GuiChest guiChest = (GuiChest) Minecraft.getMinecraft().currentScreen;
        if(guiChest == null) return;
        ContainerChest containerChest = (ContainerChest) guiChest.inventorySlots;
        if(containerChest == null) return;
        int iron = 0;
        int gold = 0;
        int diamond = 0;
        int emerald = 0;
        if(Objects.equals(containerChest.getLowerChestInventory().getDisplayName().getUnformattedText(), "Ender Chest")) {
                for (int i = 0; i < containerChest.getLowerChestInventory().getSizeInventory(); i++) {
                    if (containerChest.getLowerChestInventory().getStackInSlot(i) == null) continue;
                    if (containerChest.getLowerChestInventory().getStackInSlot(i).getUnlocalizedName().equals(Items.iron_ingot.getUnlocalizedName())) {
                        iron += containerChest.getLowerChestInventory().getStackInSlot(i).stackSize;
                    }
                    if (containerChest.getLowerChestInventory().getStackInSlot(i).getUnlocalizedName().equals(Items.gold_ingot.getUnlocalizedName())) {
                        gold += containerChest.getLowerChestInventory().getStackInSlot(i).stackSize;
                    }
                    if (containerChest.getLowerChestInventory().getStackInSlot(i).getUnlocalizedName().equals(Items.diamond.getUnlocalizedName())) {
                        diamond += containerChest.getLowerChestInventory().getStackInSlot(i).stackSize;
                    }
                    if (containerChest.getLowerChestInventory().getStackInSlot(i).getUnlocalizedName().equals(Items.emerald.getUnlocalizedName())) {
                        emerald += containerChest.getLowerChestInventory().getStackInSlot(i).stackSize;
                    }
                }
            ec_iron = iron;
            ec_gold = gold;
            ec_diamond = diamond;
            ec_emerald = emerald;
        }
    }
    @Subscribe
    private void screenOpen(ScreenOpenEvent event) {
        if (event.screen == null) {
            editingHUD = false;
            return;
        }
        if (event.screen.toString().contains("HudGui")) editingHUD = true;
        if (event.screen.toString().contains("OneConfigGui")) editingHUD = true;
    }

    @Subscribe
    private void receivePacket(ReceivePacketEvent event) {
        if (event.packet.toString().contains("S01PacketJoinGame")) {
            ec_iron = 0;
            ec_gold = 0;
            ec_diamond = 0;
            ec_emerald = 0;
        }
    }


}
