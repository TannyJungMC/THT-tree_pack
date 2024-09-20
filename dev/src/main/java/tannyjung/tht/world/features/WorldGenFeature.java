
package tannyjung.tht.world.features;

import tannyjung.tht.world.features.configurations.StructureFeatureConfiguration;
import tannyjung.tht.procedures.WorldGenAdditionalGenerationConditionProcedure;

import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.WorldGenLevel;

public class WorldGenFeature extends StructureFeature {
	public WorldGenFeature() {
		super(StructureFeatureConfiguration.CODEC);
	}

	public boolean place(FeaturePlaceContext<StructureFeatureConfiguration> context) {
		WorldGenLevel world = context.level();
		int x = context.origin().getX();
		int y = context.origin().getY();
		int z = context.origin().getZ();
		if (!WorldGenAdditionalGenerationConditionProcedure.execute(world))
			return false;
		return super.place(context);
	}
}
