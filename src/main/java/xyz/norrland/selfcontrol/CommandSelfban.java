package xyz.norrland.selfcontrol;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.time.Duration;

public class CommandSelfban implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        int MAX_BAN_LIMIT = 730; //7 days

        int banInt;
        if (sender instanceof Player) {
            Player player = (Player) sender;
            try {
                banInt = Integer.parseInt(args[0]);
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                player.sendMessage("/selfban <duration>");
                return true;
            }
            if (banInt > MAX_BAN_LIMIT) {
                player.sendMessage("Maximum duration is 730 (1 Month)");
                return true;
            }
            Duration banDuration = Duration.ofHours(banInt);
            player.ban("You banned yourself", banDuration, player.getName(), true);
        } else {
            sender.sendMessage("Only players can use this command");
        }
        return true;
    }
}
