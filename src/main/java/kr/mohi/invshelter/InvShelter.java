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
	private LinkedHashMap<String, Object> config;

	@Override
	public void onEnable() {
		getDataFolder().mkdir();
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
		}
		event.setDeathMessage(new TextContainer(""));
	}
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		if(! event.getPlayer().isOp())
			event.setJoinMessage(new TextContainer(""));
		//else event.setJoinMessage( "관리자 " + event.getPlayer().getName() + "가 접속하였습니다." );
	}
	@EventHandler
	public void onQuit(PlayerQuitEvent event) {
		if(! event.getPlayer().isOp())
			event.setQuitMessage(new TextContainer(""));
		//else event.setQuitMessage( "관리자 " + event.getPlayer().getName() + "가 접속하였습니다." );
	}
}
