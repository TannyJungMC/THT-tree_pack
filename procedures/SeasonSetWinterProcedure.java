package tannyjung.tht.procedures;

import tannyjung.tht.network.ThtModVariables;

import net.minecraft.world.level.LevelAccessor;

public class SeasonSetWinterProcedure {
	public static void execute(LevelAccessor world) {
		ThtModVariables.MapVariables.get(world).season = "Winter";
		ThtModVariables.MapVariables.get(world).syncData(world);
	}
}
