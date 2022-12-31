package com.github.kamida.teleportscroll.events;

import com.github.kamida.teleportscroll.items.itemManager;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.meta.ItemMeta;

public class craftEvent implements Listener {
    @EventHandler
    public void craftItem(CraftItemEvent event) {
        Player player = (Player) event.getWhoClicked();
        ItemMeta result = event.getRecipe().getResult().getItemMeta();

        if (result.equals(itemManager.getScrollMeta())) {
            if (!player.hasPermission("telescroll.craft")) {
                event.setCancelled(true);
                player.sendMessage("You do not have permission to craft this item");
            }
        }
    }
}
