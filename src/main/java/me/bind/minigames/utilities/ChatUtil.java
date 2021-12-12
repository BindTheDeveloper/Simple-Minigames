package me.bind.minigames.utilities;

import lombok.experimental.UtilityClass;
import org.bukkit.ChatColor;

import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class ChatUtil {

    public String translate(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public List<String> translate(List<String> list) {
        return list.stream().map(ChatUtil::translate).collect(Collectors.toList());
    }
}
