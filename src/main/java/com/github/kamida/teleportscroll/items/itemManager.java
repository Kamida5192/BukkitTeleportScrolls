package com.github.kamida.teleportscroll.items;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class itemManager {
    public static ItemStack scroll;

    public static void init() { createScroll(); }

    private static void createScroll() {
        ItemStack item = new ItemStack(Material.PAPER, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("Teleport Scroll");

        /* Set the Lore of the item*/
        List<String> lore = new ArrayList<>();
        lore.add("Teleports you to bed or spawn");
        meta.setLore(lore);

        /* Visual Aspects */
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);

        scroll = item;

        /* Crafting Recipe */
        ShapelessRecipe sr = new ShapelessRecipe(NamespacedKey.minecraft("teleport_scroll"), item);
        sr.addIngredient(1, Material.ENDER_PEARL);
        sr.addIngredient(1, Material.WHITE_BED);
        sr.addIngredient(1, Material.PAPER);
        Bukkit.getServer().addRecipe(sr);
    }
}
