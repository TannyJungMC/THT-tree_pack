package tannyjung.tht.procedures;

import tannyjung.tht.network.ThtModVariables;

import net.minecraft.world.level.LevelAccessor;

public class AutoGenStartCount1Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		ThtModVariables.MapVariables.get(world).auto_gen_count = 1;
		ThtModVariables.MapVariables.get(world).syncData(world);
		AutoGenStartProcedure.execute(world, x, y, z);
	}
}
