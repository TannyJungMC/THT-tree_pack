package tannyjung.tht.procedures;

import tannyjung.tht.network.ThtModVariables;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import java.io.File;

public class RandomTreeTickWayFunctionProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		File file = new File("");
		double way_function = 0;
		double length = 0;
		String type = "";
		entity.getPersistentData().putString("set_function", "");
		way_function = 1;
		for (int index0 = 0; index0 < 3; index0++) {
			if (!(entity.getPersistentData().getString(("way" + ("" + way_function).replace(".0", "") + "_function"))).equals("")) {
				if ((entity.getPersistentData().getString(("way" + ("" + way_function).replace(".0", "") + "_function_type"))).equals(entity.getPersistentData().getString("type"))) {
					if (entity.getPersistentData().getDouble(("way" + ("" + way_function).replace(".0", "") + "_function_chance")) > Math.random()
							&& (entity.getPersistentData().getDouble(("way" + ("" + way_function).replace(".0", "") + "_function_max")) > 0
									|| entity.getPersistentData().getDouble(("way" + ("" + way_function).replace(".0", "") + "_function_max")) == 0)) {
						if ((entity.getPersistentData().getString("type")).equals("leaves")) {
							type = "leaves_twig";
						} else {
							type = entity.getPersistentData().getString("type");
						}
						if (entity.getPersistentData().getDouble((type + "_length_save")) == 0) {
							length = 100;
						} else {
							length = 100 - (entity.getPersistentData().getDouble((type + "_length")) / entity.getPersistentData().getDouble((type + "_length_save"))) * 100;
						}
						if (Math.floor(length) >= entity.getPersistentData().getDouble(("way" + ("" + way_function).replace(".0", "") + "_function_range_min"))
								&& Math.floor(length) <= entity.getPersistentData().getDouble(("way" + ("" + way_function).replace(".0", "") + "_function_range_max"))) {
							if (entity.getPersistentData().getDouble(("way" + ("" + way_function).replace(".0", "") + "_function_max")) > 1) {
								entity.getPersistentData().putDouble(("way" + ("" + way_function).replace(".0", "") + "_function_max"), (entity.getPersistentData().getDouble(("way" + ("" + way_function).replace(".0", "") + "_function_max")) - 1));
							} else if (entity.getPersistentData().getDouble(("way" + ("" + way_function).replace(".0", "") + "_function_max")) == 1) {
								entity.getPersistentData().putDouble(("way" + ("" + way_function).replace(".0", "") + "_function_max"), (-1));
							}
							if (ThtModVariables.MapVariables.get(world).auto_gen == true) {
								entity.getPersistentData().putString("set_function", ("+fw" + ("" + way_function).replace(".0", "")));
							} else {
								entity.getPersistentData().putString("set_function", (entity.getPersistentData().getString(("way" + ("" + way_function).replace(".0", "") + "_function"))));
							}
							break;
						}
					}
				}
			}
			way_function = way_function + 1;
		}
	}
}
