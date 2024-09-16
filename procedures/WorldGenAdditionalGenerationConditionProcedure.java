package tannyjung.tht.procedures;

import tannyjung.tht.network.ThtModVariables;

import net.minecraft.world.level.LevelAccessor;

public class WorldGenAdditionalGenerationConditionProcedure {
	public static boolean execute(LevelAccessor world) {
		return ThtModVariables.MapVariables.get(world).global_rarity * 0.01 > Math.random();
	}
}
