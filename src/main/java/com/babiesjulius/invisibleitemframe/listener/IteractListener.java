package com.babiesjulius.invisibleitemframe.listener;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ItemFrame;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class IteractListener implements Listener {

    @EventHandler
    public void onPlace(PlayerInteractEntityEvent event) {
        Player player = event.getPlayer();
        if (event.getRightClicked().getType() == EntityType.ITEM_FRAME || event.getRightClicked().getType() == EntityType.GLOW_ITEM_FRAME) {
            ItemStack item = player.getInventory().getItemInMainHand();
            if (item.getType() == Material.STICK) {
                if (item.hasItemMeta()) {
                    if (item.getItemMeta().getDisplayName().matches("INVISIBLE ITEMFRAME")) {
                        event.setCancelled(true);
                        player.playSound(player, Sound.ENTITY_ENDERMAN_TELEPORT, 100, 1);
                        player.getWorld().spawnParticle(Particle.ELECTRIC_SPARK, event.getRightClicked().getLocation(), 10);
                        ItemFrame frame = (ItemFrame) event.getRightClicked();
                        frame.setVisible(!frame.isVisible());
                    }
                }
            }
        }
    }
}