package com.github.kamida.teleportscroll.items;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.MaterialData;

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
        sr.addIngredient(new RecipeChoice.MaterialChoice(
                Material.RED_BED,
                Material.LIME_BED,
                Material.PINK_BED,
                Material.GRAY_BED,
                Material.CYAN_BED,
                Material.BLUE_BED,
                Material.WHITE_BED,
                Material.BROWN_BED,
                Material.GREEN_BED,
                Material.BLACK_BED,
                Material.ORANGE_BED,
                Material.YELLOW_BED,
                Material.PURPLE_BED,
                Material.MAGENTA_BED,
                Material.LIGHT_BLUE_BED,
                Material.LIGHT_GRAY_BED
        ));
        sr.addIngredient(1, Material.PAPER);
        Bukkit.getServer().addRecipe(sr);
    }
}
