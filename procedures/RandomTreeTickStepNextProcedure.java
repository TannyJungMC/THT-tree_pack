package tannyjung.tht.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

public class RandomTreeTickStepNextProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		String variable_text2 = "";
		String variable_text = "";
		String type_next = "";
		String type_pre = "";
		boolean variable_logic = false;
		double variable_number = 0;
		double variable_number2 = 0;
		double variable_number3 = 0;
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
		if ((entity.getPersistentData().getString("type")).equals("fine_root") || (entity.getPersistentData().getString("type")).equals("leaves") || entity.getPersistentData().getDouble((type_next + "_count")) > 0) {
			if ((entity.getPersistentData().getString("type")).equals("taproot")) {
				entity.getPersistentData().putString("type", "secondary_root");
			} else if ((entity.getPersistentData().getString("type")).equals("secondary_root")) {
				entity.getPersistentData().putString("type", "tertiary_root");
			} else if ((entity.getPersistentData().getString("type")).equals("tertiary_root")) {
				entity.getPersistentData().putString("type", "fine_root");
			} else if ((entity.getPersistentData().getString("type")).equals("fine_root")) {
				entity.getPersistentData().putString("step", "previous");
				entity.getPersistentData().putString("up-down", "down");
			}
			if ((entity.getPersistentData().getString("type")).equals("trunk")) {
				entity.getPersistentData().putString("type", "branch");
			} else if ((entity.getPersistentData().getString("type")).equals("branch")) {
				entity.getPersistentData().putString("type", "twig");
			} else if ((entity.getPersistentData().getString("type")).equals("twig")) {
				entity.getPersistentData().putString("type", "leaves_twig");
			} else if ((entity.getPersistentData().getString("type")).equals("leaves_twig")) {
				entity.getPersistentData().putString("type", "leaves");
			} else if ((entity.getPersistentData().getString("type")).equals("leaves")) {
				entity.getPersistentData().putString("step", "previous");
				entity.getPersistentData().putString("up-down", "down");
			}
			if ((entity.getPersistentData().getString("up-down")).equals("up")) {
				entity.getPersistentData().putString("step", "summon");
			}
			if ((entity.getPersistentData().getString("step")).equals("previous") && (entity.getPersistentData().getString("up-down")).equals("down")) {
				RandomTreeTickStepPreviousProcedure.execute(world, x, y, z, entity);
			}
		} else {
			entity.getPersistentData().putString("step", "previous");
			entity.getPersistentData().putString("up-down", "down");
			RandomTreeTickStepPreviousProcedure.execute(world, x, y, z, entity);
		}
	}
}
