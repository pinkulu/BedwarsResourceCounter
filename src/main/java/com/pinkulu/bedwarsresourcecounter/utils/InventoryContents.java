package com.pinkulu.bedwarsresourcecounter.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;


public class InventoryContents {
    // get inventory contents

    public static int getInventoryItemCount(ItemStack[] inventory, String itemName){
        int count = 0;
        EntityPlayerSP player = Minecraft.getMinecraft().thePlayer;
        if(player == null)
            return 0;
        for(ItemStack stack : inventory){
            if(stack == null)
                continue;
            if(stack.getUnlocalizedName().equals(itemName)){
                count += stack.stackSize;
            }
        }
        return count;
    }
}
