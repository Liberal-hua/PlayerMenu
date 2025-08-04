package cn.handyplus.menu.listener;

import cn.handyplus.lib.annotation.HandyListener;
import cn.handyplus.menu.constants.MenuConstants;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 * 玩家被服务器踢出事件
 * 清理缓存
 *
 * @author handy
 */
@HandyListener
public class PlayerQuitEventListener implements Listener {
    /**
     * 玩家被服务器踢出事件.
     *
     * @param event 事件
     */
    @EventHandler
    public void onKick(PlayerKickEvent event) {
        removeCache(event.getPlayer());
    }

    /**
     * 玩家离开服务器事件.
     *
     * @param event 事件
     */
    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        removeCache(event.getPlayer());
    }

    /**
     * 清理缓存
     *
     * @param player 事件
     */
    private void removeCache(Player player) {
        MenuConstants.INPUT_MENU_MAP.remove(player.getUniqueId());
        MenuConstants.PLAYER_INPUT_MAP.remove(player.getUniqueId());
        MenuConstants.ADMIN_OPEN_PLAYER.remove(player.getUniqueId());
    }

}