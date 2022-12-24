package com.github.kamida.teleportscroll.commands;

import com.github.kamida.teleportscroll.items.itemManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class commands implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player player = (Player) sender;

        if (command.getName().equalsIgnoreCase("telescroll")) {
            if (args.length >= 1) {
                if (args[0].equalsIgnoreCase("give")) {
                    if (!player.hasPermission("telescroll.give")) {
                        sender.sendMessage("You do not have the permission telescroll.give");
                        return true;
                    }

                    if (!(sender instanceof Player)) {
                        sender.sendMessage("Only players can use that command!");
                        return true;

                    } else if (args.length > 1) {
                        if (Integer.parseInt(args[1]) > 0) {
                            for (int i = 0; i < Integer.valueOf(args[1]); i++) {
                                player.getInventory().addItem(itemManager.scroll);
                            }
                        }
                    } else {
                        player.sendMessage("Invalid Amount");
                    }
                } else if (args[0].equalsIgnoreCase("help")) {
                    player.sendMessage("Usage: /telescrolls give <amount>");
                } else if (args[0].equalsIgnoreCase("version")) {
                    player.sendMessage("Version 0.1 created by Kamida#5192");
                }
            } else {
                player.sendMessage("Usage: /telescrolls give <amount>");
            }
        }
        return true;
    }
}