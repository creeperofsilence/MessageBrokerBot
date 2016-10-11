package Bad;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class BadEvent extends JavaPlugin implements Listener {

	@Override
	public void onEnable() {
		getServer().getLogger().info("onEnable has been invoked!");
		getServer().getPluginManager().registerEvents(this, this);
	}
	
	@Override
	public void onDisable() {
		getServer().getLogger().info("onDisable has been invoked!");
	}

	@EventHandler
	public void onLogin(PlayerJoinEvent args) {
		//args.getPlayer().chat(eve);
		
	}
}
