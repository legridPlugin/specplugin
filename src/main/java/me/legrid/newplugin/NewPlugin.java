package me.legrid.newplugin;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;



public final class NewPlugin extends JavaPlugin implements Listener {




    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("spec")){
            if (sender instanceof Player) {
                Player p = (Player) sender;

                Location spawn = new Location(p.getWorld(), 0, 100, 0);

                if (args.length == 0) {
                    p.setGameMode(GameMode.SURVIVAL);
                    p.teleport(spawn);
                } else {
                    String pname = args[0];
                    Player target = Bukkit.getServer().getPlayerExact(pname);

                    if(target == null){
                        p.sendMessage("Он Оффлайн");

                    } else {
                        p.setGameMode(GameMode.SPECTATOR);
                        p.teleport(target);
                    }
                }
            }
        return true;
    }
        return true;
    }




}



