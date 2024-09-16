package tannyjung.tht.procedures;

import tannyjung.tht.network.ThtModVariables;

import org.checkerframework.checker.units.qual.s;

import net.minecraftforge.fml.loading.FMLPaths;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

public class AutoGenLoopTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		File file = new File("");
		String file_name = "";
		String directory = "";
		String merge_text = "";
		double posY = 0;
		double merge_text_pos = 0;
		double generate_speed = 0;
		double generate_speed_repeat = 0;
		ThtModVariables.MapVariables.get(world).detect_exist = false;
		ThtModVariables.MapVariables.get(world).syncData(world);
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					"execute in tht:dimension positioned 0 0 0 if entity @e[tag=THT-random_tree,distance=..1000] run THT dev rt_detect_exist");
		if (ThtModVariables.MapVariables.get(world).detect_exist == false) {
			if (ThtModVariables.MapVariables.get(world).auto_gen_cooldown > 0) {
				ThtModVariables.MapVariables.get(world).auto_gen_cooldown = ThtModVariables.MapVariables.get(world).auto_gen_cooldown - 1;
				ThtModVariables.MapVariables.get(world).syncData(world);
			} else {
				ThtModVariables.MapVariables.get(world).auto_gen_cooldown = 10;
				ThtModVariables.MapVariables.get(world).syncData(world);
				file = new File((FMLPaths.GAMEDIR.get().toString() + "/config/THT/custom"), File.separator + "auto_gen.txt");
				if (file.exists() == true) {
					try {
						BufferedReader fileReader = new BufferedReader(new FileReader(file));
						String stringiterator = "";
						while ((stringiterator = fileReader.readLine()) != null) {
							if (stringiterator.contains("file_name : ") == true) {
								file_name = stringiterator.replace("file_name : ", "");
							}
							if (stringiterator.contains("directory : ") == true) {
								directory = stringiterator.replace("directory : ", "");
							}
							if (stringiterator.contains("generate_speed : ") == true) {
								generate_speed = new Object() {
									double convert(String s) {
										try {
											return Double.parseDouble(s.trim());
										} catch (Exception e) {
										}
										return 0;
									}
								}.convert(stringiterator.replace("generate_speed : ", ""));
								if (generate_speed <= 0) {
									generate_speed = 1;
								}
							}
							if (stringiterator.contains("generate_speed_repeat : ") == true) {
								generate_speed_repeat = new Object() {
									double convert(String s) {
										try {
											return Double.parseDouble(s.trim());
										} catch (Exception e) {
										}
										return 0;
									}
								}.convert(stringiterator.replace("generate_speed_repeat : ", ""));
							}
							if (stringiterator.contains("posY : ") == true) {
								posY = new Object() {
									double convert(String s) {
										try {
											return Double.parseDouble(s.trim());
										} catch (Exception e) {
										}
										return 0;
									}
								}.convert(stringiterator.replace("posY : ", ""));
							}
							if (stringiterator.contains("chat_message : ") == true) {
								ThtModVariables.MapVariables.get(world).auto_gen_chat_messages = (stringiterator.replace("chat_message : ", "")).equals("true");
								ThtModVariables.MapVariables.get(world).syncData(world);
							}
						}
						fileReader.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
					file = new File((FMLPaths.GAMEDIR.get().toString() + "/" + directory), File.separator + (file_name + ".txt"));
					if (file.exists() == true) {
						if (ThtModVariables.MapVariables.get(world).auto_gen_count <= 0) {
							ThtModVariables.MapVariables.get(world).auto_gen = false;
							ThtModVariables.MapVariables.get(world).syncData(world);
							ThtModVariables.MapVariables.get(world).auto_gen_count = 0;
							ThtModVariables.MapVariables.get(world).syncData(world);
							if (world instanceof ServerLevel _level)
								_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										"execute as @e[tag=THT-random_tree] at @s if dimension tht:dimension run kill @s");
							if (world instanceof ServerLevel _level)
								_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										"execute in tht:dimension run forceload remove all");
							if (world instanceof ServerLevel _level)
								_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										"tellraw @a [\"\",{\"text\":\"THT : Auto gen now turned OFF\",\"color\":\"gray\"}]");
						} else {
							ThtModVariables.MapVariables.get(world).auto_gen_count = ThtModVariables.MapVariables.get(world).auto_gen_count - 1;
							ThtModVariables.MapVariables.get(world).syncData(world);
							file_name = "unnamed";
							if (world instanceof ServerLevel _level)
								_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										"execute in tht:dimension run forceload add 32 32 -32 -32");
							if (world instanceof ServerLevel _level)
								_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										"execute in tht:dimension run fill 75 3 75 -75 3 -75 air");
							try {
								BufferedReader fileReader = new BufferedReader(new FileReader(file));
								String stringiterator = "";
								while ((stringiterator = fileReader.readLine()) != null) {
									merge_text = merge_text + "" + stringiterator;
								}
								fileReader.close();
							} catch (IOException e) {
								e.printStackTrace();
							}
							for (int index0 = 0; index0 < (int) (merge_text).length(); index0++) {
								if ((merge_text.substring(0, (int) merge_text_pos)).contains("BlockEntityTag:{") == true) {
									merge_text = merge_text.substring((int) merge_text_pos, (int) ((merge_text).length() - 1));
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(), ("execute in tht:dimension positioned 0 "
														+ posY + " 0 run summon armor_stand ~0.5 ~0.5 ~0.5 {Tags:[\"THT-random_tree\"],NoGravity:1b,Marker:1b,CustomName:'{\"text\":\"THT-random_tree\"}'," + merge_text));
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												("execute in tht:dimension positioned 0 0 0 as @e[name=THT-random_tree,distance=..1000] at @s run data merge entity @s {ForgeData:{"
														+ ("debug_mode:false" + ",countdown:0" + ",global_generate_speed:false" + (",generate_speed:" + generate_speed) + (",generate_speed_repeat:" + generate_speed_repeat)) + "}}"));
									break;
								} else {
									merge_text_pos = merge_text_pos + 1;
								}
							}
						}
					}
				}
			}
		}
	}
}
