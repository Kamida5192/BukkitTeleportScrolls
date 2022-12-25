package com.github.kamida.teleportscroll.events;

import com.github.kamida.teleportscroll.items.itemManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import static com.github.kamida.teleportscroll.teleportScroll.logConsole;

public class teleportEvent implements Listener {
    @EventHandler
    public static void onRightClick(PlayerInteractEvent event) {
        if ((event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK)) {
            if (event.getItem() != null) {
                if (event.getItem().getItemMeta().equals(itemManager.scroll.getItemMeta())) {
                    Player player = event.getPlayer();
                    if (player.getBedSpawnLocation() != null) {
                        logConsole("[Telescroll] " + player.getName() + " teleported to bed");
                        player.teleport(player.getBedSpawnLocation());
                        player.sendMessage("§7Teleported to your bed!");
                    } else {
                        logConsole("[Telescroll] " + player.getName() + " teleported to spawn");
                        player.teleport(player.getWorld().getSpawnLocation());
                        player.sendMessage("§7Teleported to spawn as bed was not found");
                    }
                    player.getInventory().removeItem(itemManager.scroll);
                }
            }
        }
    }
}