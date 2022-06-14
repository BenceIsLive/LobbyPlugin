package dev.bence.lobbyplugin.utils;

import net.md_5.bungee.api.ChatColor;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChatUtils {

    public static final Pattern HEX_PATTERN = Pattern.compile("&#(\\w{5}[0-9a-f])");

    /**
     * Formats chat color
     *
     * @param s
     * @return
     */
    public static String format(String s) {
        Matcher matcher = HEX_PATTERN.matcher(s);
        StringBuffer buffer = new StringBuffer();

        while (matcher.find()) {
            matcher.appendReplacement(buffer, ChatColor.of("#" + matcher.group(1)).toString());
        }

        return ChatColor.translateAlternateColorCodes('&', matcher.appendTail(buffer).toString());
    }

    /**
     * Formats chat color
     * @param list
     * @return
     */
    public static List<String> format(List<String> list) {
        List<String> formattedList = new ArrayList<>();
        for (String s : list) {
            Matcher matcher = HEX_PATTERN.matcher(s);
            StringBuffer buffer = new StringBuffer();
            while (matcher.find()) {
                matcher.appendReplacement(buffer, ChatColor.of("#" + matcher.group(1)).toString());
            }
            formattedList.add(ChatColor.translateAlternateColorCodes('&', matcher.appendTail(buffer).toString()));
        }
        return formattedList;
    }
}