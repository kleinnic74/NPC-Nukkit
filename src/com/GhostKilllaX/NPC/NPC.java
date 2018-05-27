package com.GhostKilllaX.NPC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.GhostKilllaX.NPC.entitys.NPC_Bat;
import com.GhostKilllaX.NPC.entitys.NPC_Blaze;
import com.GhostKilllaX.NPC.entitys.NPC_Boat;
import com.GhostKilllaX.NPC.entitys.NPC_CaveSpider;
import com.GhostKilllaX.NPC.entitys.NPC_Chicken;
import com.GhostKilllaX.NPC.entitys.NPC_Cow;
import com.GhostKilllaX.NPC.entitys.NPC_Creeper;
import com.GhostKilllaX.NPC.entitys.NPC_Donkey;
import com.GhostKilllaX.NPC.entitys.NPC_ElderGuardian;
import com.GhostKilllaX.NPC.entitys.NPC_EnderDragon;
import com.GhostKilllaX.NPC.entitys.NPC_Enderman;
import com.GhostKilllaX.NPC.entitys.NPC_Endermite;
import com.GhostKilllaX.NPC.entitys.NPC_Entity;
import com.GhostKilllaX.NPC.entitys.NPC_Evoker;
import com.GhostKilllaX.NPC.entitys.NPC_Ghast;
import com.GhostKilllaX.NPC.entitys.NPC_Guardian;
import com.GhostKilllaX.NPC.entitys.NPC_Horse;
import com.GhostKilllaX.NPC.entitys.NPC_Human;
import com.GhostKilllaX.NPC.entitys.NPC_Husk;
import com.GhostKilllaX.NPC.entitys.NPC_IronGolem;
import com.GhostKilllaX.NPC.entitys.NPC_Lama;
import com.GhostKilllaX.NPC.entitys.NPC_MCow;
import com.GhostKilllaX.NPC.entitys.NPC_Minecart;
import com.GhostKilllaX.NPC.entitys.NPC_Mule;
import com.GhostKilllaX.NPC.entitys.NPC_Ocelot;
import com.GhostKilllaX.NPC.entitys.NPC_Pig;
import com.GhostKilllaX.NPC.entitys.NPC_PolarBear;
import com.GhostKilllaX.NPC.entitys.NPC_Rabbit;
import com.GhostKilllaX.NPC.entitys.NPC_SHorse;
import com.GhostKilllaX.NPC.entitys.NPC_Sheep;
import com.GhostKilllaX.NPC.entitys.NPC_Shulker;
import com.GhostKilllaX.NPC.entitys.NPC_Silverfish;
import com.GhostKilllaX.NPC.entitys.NPC_Skeleton;
import com.GhostKilllaX.NPC.entitys.NPC_Slime;
import com.GhostKilllaX.NPC.entitys.NPC_Snowman;
import com.GhostKilllaX.NPC.entitys.NPC_Spider;
import com.GhostKilllaX.NPC.entitys.NPC_Squid;
import com.GhostKilllaX.NPC.entitys.NPC_Stray;
import com.GhostKilllaX.NPC.entitys.NPC_Vex;
import com.GhostKilllaX.NPC.entitys.NPC_Villager;
import com.GhostKilllaX.NPC.entitys.NPC_Vindicator;
import com.GhostKilllaX.NPC.entitys.NPC_Witch;
import com.GhostKilllaX.NPC.entitys.NPC_Wither;
import com.GhostKilllaX.NPC.entitys.NPC_Witherskeleton;
import com.GhostKilllaX.NPC.entitys.NPC_Wolf;
import com.GhostKilllaX.NPC.entitys.NPC_ZHorse;
import com.GhostKilllaX.NPC.entitys.NPC_Zombie;
import com.GhostKilllaX.NPC.entitys.NPC_ZombiePigman;
import com.GhostKilllaX.NPC.entitys.NPC_ZombieVillager;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.entity.Entity;
import cn.nukkit.entity.EntityHuman;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.EventPriority;
import cn.nukkit.event.Listener;
import cn.nukkit.event.entity.EntityDamageByEntityEvent;
import cn.nukkit.event.entity.EntitySpawnEvent;
import cn.nukkit.event.player.PlayerMoveEvent;
import cn.nukkit.inventory.PlayerInventory;
import cn.nukkit.level.Level;
import cn.nukkit.math.Vector3f;
import cn.nukkit.nbt.tag.CompoundTag;
import cn.nukkit.nbt.tag.DoubleTag;
import cn.nukkit.nbt.tag.FloatTag;
import cn.nukkit.nbt.tag.ListTag;
import cn.nukkit.nbt.tag.StringTag;
import cn.nukkit.plugin.PluginBase;

public class NPC extends PluginBase implements Listener {

	public List<String> id = new ArrayList<>();
	public List<String> kill = new ArrayList<>();
	public Set<String> entitys = Arrays
			.asList("Bat", "Blaze", "CaveSpider", "Chicken", "Cow", "Creeper", "Donkey", "ElderGuardian", "EnderDragon",
					"Enderman", "Endermite", "Evoker", "Ghast", "Guardian", "Horse", "Human", "Husk", "IronGolem",
					"Lama", "MCow", "Magmacube", "Mule", "Ocelot", "Pig", "PolarBear", "Rabbit", "SHorse", "Sheep",
					"Shulker", "Silverfish", "Skeleton", "Slime", "Snowman", "Spider", "Squid", "Stray", "Vex",
					"Villager", "Vindicator", "Witch", "Wither", "Witherskeleton", "Wolf", "ZHorse", "Zombie",
					"ZombiePigman", "ZombieVillager", "Boat", "Minecart")
			.stream().map(String::toLowerCase).collect(Collectors.toSet());

	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
		this.getLogger().info("NPC Plugin activated");
		this.registerNPC();
	}

	public void registerNPC() {
		Entity.registerEntity(NPC_Bat.class.getSimpleName(), NPC_Bat.class);
		Entity.registerEntity(NPC_Chicken.class.getSimpleName(), NPC_Chicken.class);
		Entity.registerEntity(NPC_Cow.class.getSimpleName(), NPC_Cow.class);
		Entity.registerEntity(NPC_Donkey.class.getSimpleName(), NPC_Donkey.class);
		Entity.registerEntity(NPC_Horse.class.getSimpleName(), NPC_Horse.class);
		Entity.registerEntity(NPC_MCow.class.getSimpleName(), NPC_MCow.class);
		Entity.registerEntity(NPC_Mule.class.getSimpleName(), NPC_Mule.class);
		Entity.registerEntity(NPC_Ocelot.class.getSimpleName(), NPC_Ocelot.class);
		Entity.registerEntity(NPC_Pig.class.getSimpleName(), NPC_Pig.class);
		Entity.registerEntity(NPC_PolarBear.class.getSimpleName(), NPC_PolarBear.class);
		Entity.registerEntity(NPC_Rabbit.class.getSimpleName(), NPC_Rabbit.class);
		Entity.registerEntity(NPC_Sheep.class.getSimpleName(), NPC_Sheep.class);
		Entity.registerEntity(NPC_SHorse.class.getSimpleName(), NPC_SHorse.class);
		Entity.registerEntity(NPC_Villager.class.getSimpleName(), NPC_Villager.class);
		Entity.registerEntity(NPC_Wolf.class.getSimpleName(), NPC_Wolf.class);
		Entity.registerEntity(NPC_ZHorse.class.getSimpleName(), NPC_ZHorse.class);
		Entity.registerEntity(NPC_ElderGuardian.class.getSimpleName(), NPC_ElderGuardian.class);
		Entity.registerEntity(NPC_Guardian.class.getSimpleName(), NPC_Guardian.class);
		Entity.registerEntity(NPC_Snowman.class.getSimpleName(), NPC_Snowman.class);
		Entity.registerEntity(NPC_Lama.class.getSimpleName(), NPC_Lama.class);
		Entity.registerEntity(NPC_Squid.class.getSimpleName(), NPC_Squid.class);
		Entity.registerEntity(NPC_Villager.class.getSimpleName(), NPC_Villager.class);

		Entity.registerEntity(NPC_Vindicator.class.getSimpleName(), NPC_Vindicator.class);
		Entity.registerEntity(NPC_Vex.class.getSimpleName(), NPC_Vex.class);
		Entity.registerEntity(NPC_IronGolem.class.getSimpleName(), NPC_IronGolem.class);
		Entity.registerEntity(NPC_Blaze.class.getSimpleName(), NPC_Blaze.class);
		Entity.registerEntity(NPC_EnderDragon.class.getSimpleName(), NPC_EnderDragon.class);
		Entity.registerEntity(NPC_Wither.class.getSimpleName(), NPC_Wither.class);
		Entity.registerEntity(NPC_Ghast.class.getSimpleName(), NPC_Ghast.class);
		Entity.registerEntity(NPC_CaveSpider.class.getSimpleName(), NPC_CaveSpider.class);
		Entity.registerEntity(NPC_Creeper.class.getSimpleName(), NPC_Creeper.class);
		Entity.registerEntity(NPC_Enderman.class.getSimpleName(), NPC_Enderman.class);
		Entity.registerEntity(NPC_Endermite.class.getSimpleName(), NPC_Endermite.class);
		Entity.registerEntity(NPC_ZombiePigman.class.getSimpleName(), NPC_ZombiePigman.class);
		Entity.registerEntity(NPC_Silverfish.class.getSimpleName(), NPC_Silverfish.class);
		Entity.registerEntity(NPC_Skeleton.class.getSimpleName(), NPC_Skeleton.class);
		Entity.registerEntity(NPC_Spider.class.getSimpleName(), NPC_Spider.class);
		Entity.registerEntity(NPC_Stray.class.getSimpleName(), NPC_Stray.class);
		Entity.registerEntity(NPC_Witch.class.getSimpleName(), NPC_Witch.class);
		Entity.registerEntity(NPC_Husk.class.getSimpleName(), NPC_Husk.class);
		Entity.registerEntity(NPC_Zombie.class.getSimpleName(), NPC_Zombie.class);
		Entity.registerEntity(NPC_ZombieVillager.class.getSimpleName(), NPC_ZombieVillager.class);
		Entity.registerEntity(NPC_Evoker.class.getSimpleName(), NPC_Evoker.class);
		Entity.registerEntity(NPC_Shulker.class.getSimpleName(), NPC_Shulker.class);
		Entity.registerEntity(NPC_Slime.class.getSimpleName(), NPC_Slime.class);
		Entity.registerEntity(NPC_Witherskeleton.class.getSimpleName(), NPC_Witherskeleton.class);

		Entity.registerEntity(NPC_Boat.class.getSimpleName(), NPC_Boat.class);
		Entity.registerEntity(NPC_Minecart.class.getSimpleName(), NPC_Minecart.class);

		Entity.registerEntity(NPC_Human.class.getSimpleName(), NPC_Human.class);
	}

	/**
	 *
	 * @param sender
	 * @param args
	 * @param name
	 * @return
	 * 
	 */
	public CompoundTag nbt(Player sender, String[] args, String name) {
		CompoundTag nbt = new CompoundTag()
				.putList(
						new ListTag<>("Pos")
								.add(new DoubleTag("", sender.x)).add(new DoubleTag("", sender.y)).add(
										new DoubleTag("", sender.z)))
				.putList(new ListTag<DoubleTag>("Motion").add(new DoubleTag("", 0)).add(new DoubleTag("", 0))
						.add(new DoubleTag("", 0)))
				.putList(new ListTag<FloatTag>("Rotation").add(new FloatTag("", (float) sender.getYaw()))
						.add(new FloatTag("", (float) sender.getPitch())))
				.putBoolean("Invulnerable", true).putString("NameTag", name).putList(new ListTag<StringTag>("Commands"))
				.putBoolean("npc", true).putFloat("scale", 1);
		if ("Human".equals(args[1])) {
			nbt.putCompound("Skin",
					new CompoundTag().putBoolean("Transparent", false).putByteArray("Data", sender.getSkin().getData())
							.putString("ModelId", sender.getSkin().getModel()));
			nbt.putBoolean("ishuman", true);
			nbt.putString("Item", sender.getInventory().getItemInHand().getName());
			nbt.putString("Helmet", sender.getInventory().getHelmet().getName());
			nbt.putString("Chestplate", sender.getInventory().getChestplate().getName());
			nbt.putString("Leggings", sender.getInventory().getLeggings().getName());
			nbt.putString("Boots", sender.getInventory().getBoots().getName());
		}
		return nbt;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (!(sender instanceof Player)) {
			this.getLogger().error("that command only works ingame");
			return true;
		}
		Player player = (Player) sender;
		switch (command.getName().toLowerCase()) {
		case "npc":
			if (args.length < 1) {
				sender.sendMessage("§a>/npc help");
				return true;
			}
			switch (args[0].toLowerCase()) {
			case "spawn":
				if (args.length < 2) {
					sender.sendMessage("§a>usage: /npc spawn <entity> <name>");
					return true;
				}
				if (!entitys.contains(args[1].toLowerCase())) {
					sender.sendMessage("§a>Entity §a" + args[1] + "§ac is not supported.");
					return true;
				}
				String name;
				if (args.length < 2) {
					name = "%k";
				} else {
					String delimiter = " ";
					name = String.join(delimiter, args);
					name = name.replaceFirst("spawn", "");
					name = name.replaceFirst(args[1], "");
					name = name.replaceFirst(" ", "");
					name = name.replaceFirst(" ", "");
				}
				name = name.replaceAll("%n", "\n");
				CompoundTag nbt = this.nbt(player, args, name);
				Entity ent = Entity.createEntity("NPC_" + args[1], player.chunk, nbt);
				ent.setNameTag(name);
				if (!"%k".equals(name)) {
					ent.setNameTagAlwaysVisible();
				}
				ent.spawnToAll();
				sender.sendMessage("§aNPC spawned with the ID: " + ent.getId() + " and the name: " + ent.getName());
				return true;
			case "getid":
				String pn = player.getName();
				id.add(pn);
				player.sendMessage("§aID MODE  click an entity to get his ID");
				return true;
			case "addcmd":
				boolean in = isInteger(args[1]);
				if (!in) {
					player.sendMessage("§cusage: /npc addcmd <ID> <cmd>");
					return true;
				}
				if (args.length < 3) {
					sender.sendMessage("§cusage: /npc addcmd <id> <cmd>");
					return true;
				}
				Level level = player.getLevel();
				int eid = Integer.parseInt(args[1]);
				Entity enti = level.getEntity(eid);
				if (enti instanceof NPC_Human || enti instanceof NPC_Entity || enti.namedTag.getBoolean("npc")) {
					String delimite = " ";
					String cmd;
					cmd = String.join(delimite, args);
					cmd = cmd.replaceFirst("addcmd", "");
					cmd = cmd.replaceFirst(args[1], "");
					StringTag st = new StringTag(cmd, cmd);
					if (enti.namedTag.getList("Commands", StringTag.class).getAll().contains(st)) {
						player.sendMessage("§aCommand already added");
						return true;
					}
					enti.namedTag.getList("Commands", StringTag.class).add(st);
					player.sendMessage("§aCommand added");
					return true;
				} else {
					player.sendMessage("§cNo NPC found with that ID");
					return true;
				}
			case "listcmd":
				if (args.length < 2) {
					sender.sendMessage("§cusage: /npc listcmd <ID>");
					return true;
				}
				boolean isint = isInteger(args[1]);
				if (!isint) {
					sender.sendMessage("§cusage: /npc listcmdd <ID>");
					return true;
				}
				Entity entity = player.getLevel().getEntity(Integer.parseInt(args[1]));
				if (entity instanceof NPC_Entity || entity instanceof NPC_Human || entity.namedTag.getBoolean("npc")) {
					List<StringTag> cmddd = entity.namedTag.getList("Commands", StringTag.class).getAll();
					player.sendMessage("§aCommands of §e" + entity.getName() + " (" + entity.getId() + ")§a:");
					for (StringTag cmdd : cmddd) {
						String cmdlist = cmdd.data;
						player.sendMessage(cmdlist);
					}
					return true;
				} else {
					player.sendMessage("§cNo NPC found with that ID");
					return true;
				}
			case "delcmd":
				boolean inte = isInteger(args[1]);
				if (!inte) {
					player.sendMessage("§cusage: /npc delcmd <ID> <cmd>");
					return true;
				}
				if (args.length < 3) {
					sender.sendMessage("§cusage: /npc delcmd <id> <cmd>");
					return true;
				}
				Level l = player.getLevel();
				Entity en = l.getEntity(Integer.parseInt(args[1]));
				if (en instanceof NPC_Human || en instanceof NPC_Entity || en.namedTag.getBoolean("npc")) {
					String delimite = " ";
					String cmd;
					cmd = String.join(delimite, args);
					cmd = cmd.replaceFirst("delcmd", "");
					cmd = cmd.replaceFirst(args[1], "");
					StringTag st = new StringTag(cmd, cmd);
					if (en.namedTag.getList("Commands", StringTag.class).getAll().contains(st)) {
						en.namedTag.getList("Commands", StringTag.class).remove(st);
						player.sendMessage("§aCommand§e" + cmd + "§a  removed");
						return true;
					} else {
						player.sendMessage("§cCommand§e" + cmd + "§c  not found");
						return true;
					}
				} else {
					player.sendMessage("§cNo NPC found with that ID");
					return true;
				}
			case "edit":
				if (args.length < 3) {
					player.sendMessage("§cusage: /npc edit <ID> <item|armor|scale|name> <scale int|name>");
					return true;
				}
				boolean ii = isInteger(args[1]);
				if (!ii) {
					sender.sendMessage("§cusage: /npc edit <ID> <item|armor|scale|name|tphere> <scale int|name>");
					return true;
				}
				Entity e = player.getLevel().getEntity(Integer.parseInt(args[1]));
				if (e == null) {
					player.sendMessage("§cno entity found with that ID");
					return true;
				}
				int a = 0;
				PlayerInventory pl = player.getInventory();
				switch (args[2].toLowerCase()) {
				case "item":
				case "hand":
				case "handitem":
					if (e instanceof NPC_Human || e.namedTag.getBoolean("ishuman")) {
						NPC_Human nh = (NPC_Human) e;
						nh.getInventory().setItemInHand(pl.getItemInHand());
						player.sendMessage("§aItem changed to §e" + pl.getItemInHand().getName());
						nh.namedTag.putString("Item", pl.getItemInHand().getName());
						return true;
					} else {
						player.sendMessage("§cThat entity can't have that");
						return true;
					}
				case "armor":
					if (e instanceof NPC_Human || e.namedTag.getBoolean("ishuman")) {
						EntityHuman nh = (EntityHuman) e;
						nh.getInventory().setHelmet(pl.getHelmet());
						player.sendMessage("§aHelmet changed to §e" + pl.getHelmet().getName());
						nh.namedTag.putString("Helmet", pl.getHelmet().getName());
						nh.getInventory().setChestplate(pl.getChestplate());
						player.sendMessage("§aChestplate changed to §e" + pl.getChestplate().getName());
						nh.namedTag.putString("Chestplate", pl.getChestplate().getName());
						nh.getInventory().setLeggings(pl.getLeggings());
						player.sendMessage("§aLeggings changed to §e" + pl.getLeggings().getName());
						nh.namedTag.putString("Leggings", pl.getLeggings().getName());
						nh.getInventory().setBoots(pl.getBoots());
						player.sendMessage("§aBoots changed to §e" + pl.getBoots().getName());
						nh.namedTag.putString("Boots", pl.getBoots().getName());
						return true;
					} else {
						player.sendMessage("§cNo Human NPC found with that ID");
						return true;
					}
				case "scale":
					if (args.length < 4) {
						player.sendMessage("§cusage. /npc edit <ID> scale <int>  §edefault is 1");
						return true;
					}
					boolean isf = isFloat(args[3]);
					if (!isf) {
						player.sendMessage("§cusage. /npc edit <ID> scale <int>  §edefault is 1");
						return true;
					}
					if (Float.parseFloat(args[3]) > 25) {
						player.sendMessage("§cmax scale is 25");
						return true;
					}
					if (e instanceof NPC_Human || e instanceof NPC_Entity || e.namedTag.getBoolean("npc")) {
						e.setScale(Float.parseFloat(args[3]));
						e.namedTag.putFloat("scale", Float.parseFloat(args[3]));
						player.sendMessage("§aScale changed to §e" + args[3]);
						return true;
					} else {
						player.sendMessage("§cNo NPC found with that ID");
						return true;
					}
				case "name":
					if (args.length < 3) {
						player.sendMessage("§cusage. /npc edit <ID> name <name>");
						return true;
					}
					if (e instanceof NPC_Human || e instanceof NPC_Entity || e.namedTag.getBoolean("npc")) {
						if (args.length != 3) {
							String delimiter = " ";
							name = String.join(delimiter, args);
							name = name.replaceFirst("edit", "");
							name = name.replaceFirst("name", "");
							name = name.replaceFirst(args[1], "");
							name = name.replaceFirst(" ", "");
							name = name.replaceFirst(" ", "");
							name = name.replaceFirst(" ", "");
						} else {
							name = "%k";
							e.setNameTagVisible(false);
							e.setNameTagAlwaysVisible(false);
							player.sendMessage("§aName removed");
						}
						name = name.replaceAll("%n", "\n");
						if (!name.equals("%k")) {
							e.setNameTag(name);
							e.setNameTagVisible();
							player.sendMessage("§aName changed to §e" + name);
						}
						e.namedTag.putString("NameTag", name);
						return true;
					} else {
						player.sendMessage("§cNo NPC found with that ID");
						return true;
					}
				case "tphere":
				case "movehere":
				case "gohere":
					if (args.length < 2) {
						player.sendMessage("§cusage. /npc edit <ID> tphere");
						return true;
					}
					if (e instanceof NPC_Human || e instanceof NPC_Entity || e.namedTag.getBoolean("npc")) {
						e.teleport(player);
						e.respawnToAll();
						player.sendMessage("§aEntity teleported");
						return true;
					}
				default:
				}
			case "kill":
			case "remove":
				String nam = player.getNameTag();
				if (kill.contains(nam)) {
					kill.remove(nam);
					player.sendMessage("§cKILL MODE  deactivated");
					return true;
				} else {
					kill.add(nam);
					player.sendMessage("§aKILL MODE  click an entity to remove it");
					return true;
				}
			case "list":
			case "ae":
				sender.sendMessage("§aviable entitys: " + entitys.toString());
				return true;
			default:
				sender.sendMessage("§3§lNPC HELP§r§e Plugin created by GhostKilllaX");
				sender.sendMessage("§aspawn a NPC: §e/npc spawn <entity> <name>");
				sender.sendMessage("§aadd a cmd: §e/npc addcmd <ID> <cmd>");
				sender.sendMessage("§adelete a cmd: §e/npc delcmd <ID> <cmd>");
				sender.sendMessage("§asee all cmd's: §e/npc listcmd <ID>");
				sender.sendMessage(
						"§aedit an existing NPC: §e/npc edit <ID> <item|armor|scale|name|tphere> <scale int|name>");
				sender.sendMessage("§aget the id: §e/npc getid");
				sender.sendMessage("§aget a list from aviable entitys: §e/npc list");
				sender.sendMessage("§adelete a NPC: §e/npc kill");
				return true;
			}
		}
		return false;
	}

	@EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = false)
	public void touch(EntityDamageByEntityEvent event) {
		Entity entity = event.getEntity();

		if (entity instanceof NPC_Entity || entity instanceof NPC_Human || entity.namedTag.getBoolean("npc")) {
			event.setCancelled();

			if (event.getDamager() instanceof Player) {
				Player player = (Player) event.getDamager();
				String name = player.getName();

				if (this.id.contains(name)) {
					player.sendMessage("§aThe ID from that entity is " + entity.getId());
					this.id.remove(name);
				} else if (this.kill.contains(name)) {
					entity.close();
					player.sendMessage("§aEntity removed");
					this.kill.remove(name);
				} else {
					List<StringTag> cmddd = entity.namedTag.getList("Commands", StringTag.class).getAll();
					for (StringTag cmdd : cmddd) {
						String cmd = cmdd.data;
						cmd = cmd.replaceAll("%p", player.getName());
						this.getServer().dispatchCommand(this.getServer().getConsoleSender(), cmd);
					}
				}
			}
		}
	}

	@EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = false)
	public void spawn(EntitySpawnEvent ev) {
		Entity entity = ev.getEntity();

		if (entity instanceof NPC_Entity || entity instanceof NPC_Human || entity.namedTag.getBoolean("npc")) {
			if (!"%k".equals(entity.namedTag.getString("NameTag"))) {
				entity.setNameTag(entity.namedTag.getString("NameTag"));
				entity.setNameTagVisible(true);
				entity.setNameTagAlwaysVisible(true);
			}
		}
	}

	@EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = false)
	public void playerMoved(PlayerMoveEvent event) {
		Player p = event.getPlayer();
		for (Entity e : p.getLevel().getEntities()) {
			if (e.getPosition().distance(p.getPosition()) < 10) {
				Vector3f direction = e.getPosition().asVector3f().subtract(p.getPosition().asVector3f());
				double pitch = Math.toDegrees(Math.atan2(direction.length(), direction.y) + Math.PI);
				double yaw = Math.toDegrees(Math.atan2(direction.z, direction.x));
				e.setRotation(yaw, pitch);
			}
		}
	}

	public static boolean isInteger(String s) {
		boolean isValidInteger = false;
		try {
			Integer.parseInt(s);
			isValidInteger = true;
		} catch (NumberFormatException ex) {
		}
		return isValidInteger;
	}

	public static boolean isFloat(String s) {
		boolean isValidFloat = false;
		try {
			Float.parseFloat(s);
			isValidFloat = true;
		} catch (NumberFormatException ex) {
		}
		return isValidFloat;
	}

}
