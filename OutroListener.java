package br.com.jennilp.outroplugin;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class OutroListener implements Listener {

   // @EventHandler
    //public void quebra(BlockBreakEvent event){
        //Player p = event.getPlayer();
//p.sendMessage(p.getName()," " + "§dVoce quebrou o bloco!");

     @EventHandler
        public void onPlayerJoin(PlayerJoinEvent event) {
    event.setJoinMessage("Player " + event.getPlayer().getName() +  " entrou no servidor");
     }

     @EventHandler
    public void onPLayerQuit(PlayerQuitEvent event){
        event.setQuitMessage("Player " + event.getPlayer().getName() + " saiu do servidor");
     }

@EventHandler
    public void breakBlockEvents(BlockBreakEvent event) {
        Block block = event.getBlock();
        Player player = event.getPlayer();
        World world = player.getWorld();

        if (block.getType() == Material.GOLD_BLOCK) {
            world.strikeLightningEffect(block.getLocation());
            player.playSound(player.getLocation(), Sound.ENTITY_CAT_BEG_FOR_FOOD, 5, 5);
            //player.sendMessage(ChatColor.GREEN + "Voce quebrou um bloco de grama!");
        } else {
            world.createExplosion(block.getLocation(), 5.0f, false);
        }

    }
}
