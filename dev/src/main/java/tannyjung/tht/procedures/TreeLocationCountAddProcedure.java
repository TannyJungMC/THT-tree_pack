package tannyjung.tht.procedures;

import tannyjung.tht.network.ThtModVariables;

import net.minecraft.world.level.LevelAccessor;

public class TreeLocationCountAddProcedure {
	public static void execute(LevelAccessor world) {
		ThtModVariables.MapVariables.get(world).tree_location_count = ThtModVariables.MapVariables.get(world).tree_location_count + 1;
		ThtModVariables.MapVariables.get(world).syncData(world);
	}
}
