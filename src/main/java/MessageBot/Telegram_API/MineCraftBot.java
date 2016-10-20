package MessageBot.Telegram_API;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class MineCraftBot extends JavaPlugin implements Listener{
	
	@Override
	public void onEnable() {
		// TODO Auto-generated method stub
		//super.onEnable();
		getServer().getLogger().info("Telegram bot Start!!");
		getServer().getPluginManager().registerEvents(this, this);
	}
	
	@Override
	public void onDisable() {
		// TODO Auto-generated method stub
		super.onDisable();
		getServer().getLogger().info("Telegram bot Stop!!");
	}
}
