/**
	*		@author : MohiPE
	*		@since : 2016.3.18
	*		@E-Mail : dreamaker7770@gmail.com
	*/
package kr.mohi.invshelter;

import java.util.LinkedHashMap;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerDeathEvent;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.Config;

public class InvShelter extends PluginBase implements Listener {
	private LinkedHashMap<String, Object> config;

	@Override
	public void onEnable() {
		config = (LinkedHashMap<String, Object>) (new Config( getDataFolder() + "/config.yml", Config.YAML, new LinkedHashMap<String, Object>() {
			{
				put("Inventory save", true);
			}
		})).getAll();
		getServer().getPluginManager().registerEvents( this, this );
	}

	@EventHandler
	public void onDeath(PlayerDeathEvent event) {
		if ((Boolean) this.config.get("Inventory save") == true) {
			event.setKeepInventory(true);
			return;
		}
		return;
	}

}