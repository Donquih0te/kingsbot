package ru.kingsbot.command;

import ru.kingsbot.command.chat.HuntingCommand;
import ru.kingsbot.command.chat.RaidCommand;
import ru.kingsbot.command.chat.TributeCommand;
import ru.kingsbot.command.group.*;
import ru.kingsbot.command.group.army.AttackCommand;
import ru.kingsbot.command.group.boss.AddDamageAmountCommand;
import ru.kingsbot.command.group.boss.AddDamageCommand;
import ru.kingsbot.command.group.boss.BossAttackCommand;
import ru.kingsbot.command.group.boss.BossTypeCommand;
import ru.kingsbot.command.group.building.*;
import ru.kingsbot.command.group.building.armory.*;
import ru.kingsbot.command.group.building.capitol.CitizenCommand;
import ru.kingsbot.command.group.building.capitol.CreateCitizenCommand;
import ru.kingsbot.command.group.building.capitol.UpgradeCitizenCommand;
import ru.kingsbot.command.group.building.protection.BuyProtectionBuildingCommand;
import ru.kingsbot.command.group.building.protection.TowerCommand;
import ru.kingsbot.command.group.building.protection.WallCommand;
import ru.kingsbot.command.group.clan.ClanRatingCommand;
import ru.kingsbot.command.group.clan.ClanRequestCommand;
import ru.kingsbot.command.group.clan.HandlingCommand;
import ru.kingsbot.command.group.market.*;
import ru.kingsbot.command.group.resource.CitizenResourceCommand;
import ru.kingsbot.command.group.resource.FindResourceCommand;
import ru.kingsbot.command.group.resource.OpenResourceCommand;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CommandMap {

    private static final String DEFAULT_GROUP_COMMAND_NAME = "info";
    private static final String DEFAULT_CHAT_COMMAND_NAME = "info";

    // Default group commands.  Key(Command name), Value(Command)
    private final Map<String, Command> commands = new HashMap<>();

    // Default chat commands.  Key(Command name), Value(Command)
    private final Map<String, Command> chatCommands = new HashMap<>();

    public CommandMap() {}

    public void loadDefaultCommands() {
        setDefaultCommands();
        setChatCommands();
    }

    private void setDefaultCommands() {
        commands.put("info", new InfoCommand());

        commands.put("building", new BuildingCommand());
        commands.put("buy_building", new BuyBuildingCommand());
        commands.put("upgrade_building", new UpgradeBuildingCommand());

        commands.put("storage", new StorageCommand());

        commands.put("armory", new ArmoryCommand());
        commands.put("buy_warrior", new BuyWarriorCommand());
        commands.put("buy_warrior_amount", new BuyWarriorAmountCommand());
        commands.put("upgrade_warrior", new UpgradeWarriorCommand());
        commands.put("clubman", new ClubmanCommand());
        commands.put("rock_thrower", new RockThrowerCommand());

        commands.put("capitol", new CapitolCommand());
        commands.put("citizen", new CitizenCommand());
        commands.put("create_citizen", new CreateCitizenCommand());
        commands.put("upgrade_citizen", new UpgradeCitizenCommand());

        commands.put("protection", new ProtectionCommand());
        commands.put("wall", new WallCommand());
        commands.put("tower",new TowerCommand());
        commands.put("buy_protection_building", new BuyProtectionBuildingCommand());

        commands.put("resource", new ResourceCommand());
        commands.put("open_resource", new OpenResourceCommand());
        commands.put("citizen_resource", new CitizenResourceCommand());
        commands.put("find_resource", new FindResourceCommand());

        //commands.put("hero", new HeroCommand());

        commands.put("age", new AgeCommand());

        commands.put("army", new ArmyCommand());
        commands.put("attack", new AttackCommand());

        commands.put("market",new MarketCommand());
        commands.put("buy_resource", new BuyResourceCommand());
        commands.put("buy_resource_amount", new BuyResourceAmountCommand());
        commands.put("sell_resource", new SellResourceCommand());
        commands.put("sell_resource_amount", new SellResourceAmountCommand());
        commands.put("chose_resource", new ChoseResourceCommand());

        commands.put("boss",new BossCommand());
        commands.put("boss_attack", new BossAttackCommand());
        commands.put("boss_type", new BossTypeCommand());
        commands.put("add_damage", new AddDamageCommand());
        commands.put("add_damage_amount", new AddDamageAmountCommand());

        commands.put("clan", new ClanCommand());
        commands.put("clan_request", new ClanRequestCommand());
        commands.put("clan_commands", new HandlingCommand());
        commands.put("clan_rating", new ClanRatingCommand());

        commands.put("top", new TopCommand());
        commands.put("help", new HelpCommand());
        commands.put("friend", new FriendCommand());

        commands.put("back", new BackCommand());
        commands.put("user_banned", new UserBannedCommand());
        commands.put("not_found", new NotFoundCommand());
        commands.put("start", new StartCommand());
    }

    private void setChatCommands() {
        chatCommands.put("info", new ru.kingsbot.command.chat.InfoCommand());
        chatCommands.put("hunting", new HuntingCommand());
        chatCommands.put("raid", new RaidCommand());
        chatCommands.put("tribute", new TributeCommand());
        chatCommands.put("top", new TopCommand());
    }

    public Command getCommand(String name) {
        return Optional.of(commands.get(name)).orElseGet(() -> commands.get(DEFAULT_GROUP_COMMAND_NAME));
    }

    public Command getChatCommand(String name) {
        return Optional.of(chatCommands.get(name)).orElseGet(() -> chatCommands.get(DEFAULT_CHAT_COMMAND_NAME));
    }

}
