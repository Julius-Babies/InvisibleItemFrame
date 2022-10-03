package com.babiesjulius.invisibleitemframe.listener;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.Entity;
import org.bukkit.entity.ItemFrame;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.inventory.ItemStack;

public class HotbarListener implements Listener {

    @EventHandler
    public void onSwitch(PlayerItemHeldEvent event) {
        Player player = event.getPlayer();
        ItemStack item = event.getPlayer().getInventory().getItem(event.getNewSlot());
        assert item != null;
        if (item.getType() == Material.STICK) {
            if (item.hasItemMeta() && item.getItemMeta().getDisplayName().matches("INVISIBLE ITEMFRAME")) {
                for (ItemFrame frame : player.getWorld().getEntitiesByClass(ItemFrame.class)) {
                    if (!frame.isVisible() && frame.getLocation().distance(player.getLocation()) <= 50) {
                        player.getWorld().spawnParticle(Particle.CRIMSON_SPORE, frame.getLocation(), 100);
                    }
                }

            }
        }
    }
}
