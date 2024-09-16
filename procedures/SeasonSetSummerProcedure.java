package tannyjung.tht.procedures;

import tannyjung.tht.network.ThtModVariables;

import net.minecraft.world.level.LevelAccessor;

public class SeasonSetSummerProcedure {
	public static void execute(LevelAccessor world) {
		ThtModVariables.MapVariables.get(world).season = "Summer";
		ThtModVariables.MapVariables.get(world).syncData(world);
	}
}
