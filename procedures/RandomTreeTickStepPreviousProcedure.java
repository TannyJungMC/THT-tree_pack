package tannyjung.tht.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class RandomTreeTickStepPreviousProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		String type_next = "";
		String type_pre = "";
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					("kill @e[name=THT-tree_" + (entity.getPersistentData().getString("type") + "_" + entity.getPersistentData().getString("tree_id")) + "]"));
		if (!("").equals("pre-next")) {
			type_pre = "";
			type_next = "";
			if (true) {
				if ((entity.getPersistentData().getString("type")).equals("secondary_root")) {
					type_pre = "taproot";
				} else if ((entity.getPersistentData().getString("type")).equals("tertiary_root")) {
					type_pre = "secondary_root";
				} else if ((entity.getPersistentData().getString("type")).equals("fine_root")) {
					type_pre = "tertiary_root";
				}
				if ((entity.getPersistentData().getString("type")).equals("taproot")) {
					type_next = "secondary_root";
				} else if ((entity.getPersistentData().getString("type")).equals("secondary_root")) {
					type_next = "tertiary_root";
				} else if ((entity.getPersistentData().getString("type")).equals("tertiary_root")) {
					type_next = "fine_root";
				}
			}
			if (true) {
				if ((entity.getPersistentData().getString("type")).equals("branch")) {
					type_pre = "trunk";
				} else if ((entity.getPersistentData().getString("type")).equals("twig")) {
					type_pre = "branch";
				} else if ((entity.getPersistentData().getString("type")).equals("leaves_twig")) {
					type_pre = "twig";
				} else if ((entity.getPersistentData().getString("type")).equals("leaves")) {
					type_pre = "leaves_twig";
				}
				if ((entity.getPersistentData().getString("type")).equals("trunk")) {
					type_next = "branch";
				} else if ((entity.getPersistentData().getString("type")).equals("branch")) {
					type_next = "twig";
				} else if ((entity.getPersistentData().getString("type")).equals("twig")) {
					type_next = "leaves_twig";
				} else if ((entity.getPersistentData().getString("type")).equals("leaves_twig")) {
					type_next = "leaves";
				}
			}
		}
		if (entity.getPersistentData().getDouble((entity.getPersistentData().getString("type") + "_count")) > 0 && entity.getPersistentData().getDouble((type_pre + "_length")) <= 0) {
			entity.getPersistentData().putString("step", "summon");
		} else {
			entity.getPersistentData().putString("step", "create");
			if ((entity.getPersistentData().getString("type")).equals("taproot")) {
				if (entity.getPersistentData().getDouble("taproot_length") <= 0 && entity.getPersistentData().getDouble("taproot_count") <= 0) {
					entity.getPersistentData().putString("type", "trunk");
				}
			} else if ((entity.getPersistentData().getString("type")).equals("secondary_root")) {
				entity.getPersistentData().putString("type", "taproot");
			} else if ((entity.getPersistentData().getString("type")).equals("tertiary_root")) {
				entity.getPersistentData().putString("type", "secondary_root");
			} else if ((entity.getPersistentData().getString("type")).equals("fine_root")) {
				entity.getPersistentData().putString("type", "tertiary_root");
			}
			if ((entity.getPersistentData().getString("type")).equals("trunk")) {
				if (entity.getPersistentData().getDouble("trunk_length") <= 0 && entity.getPersistentData().getDouble("trunk_count") <= 0) {
					entity.getPersistentData().putString("step", "end");
				} else {
					entity.getPersistentData().putString("step", "summon");
				}
			} else if ((entity.getPersistentData().getString("type")).equals("branch")) {
				entity.getPersistentData().putString("type", "trunk");
			} else if ((entity.getPersistentData().getString("type")).equals("twig")) {
				entity.getPersistentData().putString("type", "branch");
			} else if ((entity.getPersistentData().getString("type")).equals("leaves_twig")) {
				entity.getPersistentData().putString("type", "twig");
			} else if ((entity.getPersistentData().getString("type")).equals("leaves")) {
				entity.getPersistentData().putString("type", "leaves_twig");
			}
		}
		entity.getPersistentData().putString("up-down", "up");
	}
}
