package com.babiesjulius.invisibleitemframe;

import com.babiesjulius.invisibleitemframe.listener.HotbarListener;
import com.babiesjulius.invisibleitemframe.listener.IteractListener;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        Bukkit.getPluginManager().registerEvents(new IteractListener(), this);
        Bukkit.getPluginManager().registerEvents(new HotbarListener(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
