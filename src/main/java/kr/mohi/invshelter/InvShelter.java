/**
 * @author : MohiPE
 * @since : 2016.3.20
 * @email : dreamaker7770@gmail.com
 */

package kr.mohi.invshelter;

import java.util.LinkedHashMap;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerDeathEvent;
import cn.nukkit.event.player.PlayerJoinEvent;
import cn.nukkit.event.player.PlayerQuitEvent;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.Config;
import cn.nukkit.event.TextContainer;

public class InvShelter extends PluginBase implements Listener {
	private ConfigSection config;

	@Override
	public void onEnable() {
		getDataFolder().mkdir();
		this.config = (new Config( getDataFolder() + "/config.yml", Config.YAML, new LinkedHashMap<String, Object>() {
			{
				put("Inventory save", true);
			}
		})).getAll();
		getServer().getPluginManager().registerEvents( this, this );
	}

	@EventHandler
	public void onDeath(PlayerDeathEvent event) {
		if ((boolean) this.config.get("Inventory save")) {
			event.setKeepInventory(true);
		}
	}
}
