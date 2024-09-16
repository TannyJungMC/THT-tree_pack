package tannyjung.tht.procedures;

import net.minecraft.world.entity.Entity;

public class RandomTreeTickPartCreateCoreTestProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		String unless_core = "";
		String unless_inner = "";
		String unless = "";
		String do_not_replace = "";
		entity.getPersistentData().putString("setblock_unless", "");
		entity.getPersistentData().putString("block_placer", (entity.getPersistentData().getString("type") + "_outer"));
		if (true) {
			if (!(entity.getPersistentData().getString((entity.getPersistentData().getString("type") + "_inner"))).equals("")) {
				unless_inner = " unless block ~ ~ ~ tht:block_placer_" + entity.getPersistentData().getString("type") + "_inner"
						+ (" unless block ~ ~ ~ " + entity.getPersistentData().getString((entity.getPersistentData().getString("type") + "_inner")));
			}
			if (!(entity.getPersistentData().getString((entity.getPersistentData().getString("type") + "_core"))).equals("")) {
				unless_core = " unless block ~ ~ ~ tht:block_placer_" + entity.getPersistentData().getString("type") + "_core"
						+ (" unless block ~ ~ ~ " + entity.getPersistentData().getString((entity.getPersistentData().getString("type") + "_core")));
			}
		}
		if (entity.getPersistentData().getDouble("part_create2") >= entity.getPersistentData().getDouble("part_create") - entity.getPersistentData().getDouble((entity.getPersistentData().getString("type") + "_outer_level"))) {
			entity.getPersistentData().putString("block", (entity.getPersistentData().getString((entity.getPersistentData().getString("type") + "_outer"))));
			entity.getPersistentData().putString("setblock_unless", (unless_core + "" + unless_inner));
			if (true) {
				if ((entity.getPersistentData().getString("type")).equals("branch") || (entity.getPersistentData().getString("type")).equals("twig") || (entity.getPersistentData().getString("type")).equals("leaves_twig")
						|| (entity.getPersistentData().getString("type")).equals("leaves")) {
					do_not_replace = (" unless block ~ ~ ~ " + entity.getPersistentData().getString(("trunk" + "_outer"))) + "" + (" unless block ~ ~ ~ tht:block_placer_" + "trunk" + "_outer");
				}
				if ((entity.getPersistentData().getString("type")).equals("twig") || (entity.getPersistentData().getString("type")).equals("leaves_twig") || (entity.getPersistentData().getString("type")).equals("leaves")) {
					do_not_replace = do_not_replace + "" + (" unless block ~ ~ ~ " + entity.getPersistentData().getString(("branch" + "_outer"))) + (" unless block ~ ~ ~ tht:block_placer_" + "branch" + "_outer");
				}
				if ((entity.getPersistentData().getString("type")).equals("leaves_twig") || (entity.getPersistentData().getString("type")).equals("leaves")) {
					do_not_replace = do_not_replace + "" + (" unless block ~ ~ ~ " + entity.getPersistentData().getString(("twig" + "_outer"))) + (" unless block ~ ~ ~ tht:block_placer_" + "twig" + "_outer");
				}
				if ((entity.getPersistentData().getString("type")).equals("leaves")) {
					do_not_replace = do_not_replace + "" + (" unless block ~ ~ ~ " + entity.getPersistentData().getString(("leaves_twig" + "_outer"))) + (" unless block ~ ~ ~ tht:block_placer_" + "leaves_twig" + "_outer");
				}
				entity.getPersistentData().putString("setblock_unless", (entity.getPersistentData().getString("setblock_unless") + "" + do_not_replace));
			}
			entity.getPersistentData().putString("type_short", (entity.getPersistentData().getString((entity.getPersistentData().getString("type") + "_outer_short"))));
			entity.getPersistentData().putString("block_placer", (entity.getPersistentData().getString("type") + "_outer"));
		} else {
			if (entity.getPersistentData().getDouble("part_create2") >= entity.getPersistentData().getDouble("part_create")
					- (entity.getPersistentData().getDouble((entity.getPersistentData().getString("type") + "_outer_level")) + entity.getPersistentData().getDouble((entity.getPersistentData().getString("type") + "_inner_level")))) {
				entity.getPersistentData().putString("block", (entity.getPersistentData().getString((entity.getPersistentData().getString("type") + "_inner"))));
				entity.getPersistentData().putString("setblock_unless", unless_core);
				entity.getPersistentData().putString("type_short", (entity.getPersistentData().getString((entity.getPersistentData().getString("type") + "_inner_short"))));
				entity.getPersistentData().putString("block_placer", (entity.getPersistentData().getString("type") + "_inner"));
			} else {
				entity.getPersistentData().putString("block", (entity.getPersistentData().getString((entity.getPersistentData().getString("type") + "_core"))));
				entity.getPersistentData().putString("setblock_unless", "");
				entity.getPersistentData().putString("type_short", (entity.getPersistentData().getString((entity.getPersistentData().getString("type") + "_core_short"))));
				entity.getPersistentData().putString("block_placer", (entity.getPersistentData().getString("type") + "_core"));
			}
		}
	}
}
