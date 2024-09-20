package tannyjung.tht.network;

import tannyjung.tht.ThtMod;

import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;

import net.minecraft.world.level.saveddata.SavedData;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.nbt.CompoundTag;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ThtModVariables {
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		ThtMod.addNetworkMessage(SavedDataSyncMessage.class, SavedDataSyncMessage::buffer, SavedDataSyncMessage::new, SavedDataSyncMessage::handler);
	}

	@Mod.EventBusSubscriber
	public static class EventBusVariableHandlers {
		@SubscribeEvent
		public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getEntity().level().isClientSide()) {
				SavedData mapdata = MapVariables.get(event.getEntity().level());
				SavedData worlddata = WorldVariables.get(event.getEntity().level());
				if (mapdata != null)
					ThtMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(0, mapdata));
				if (worlddata != null)
					ThtMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(1, worlddata));
			}
		}

		@SubscribeEvent
		public static void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getEntity().level().isClientSide()) {
				SavedData worlddata = WorldVariables.get(event.getEntity().level());
				if (worlddata != null)
					ThtMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(1, worlddata));
			}
		}
	}

	public static class WorldVariables extends SavedData {
		public static final String DATA_NAME = "tht_worldvars";

		public static WorldVariables load(CompoundTag tag) {
			WorldVariables data = new WorldVariables();
			data.read(tag);
			return data;
		}

		public void read(CompoundTag nbt) {
		}

		@Override
		public CompoundTag save(CompoundTag nbt) {
			return nbt;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();
			if (world instanceof Level level && !level.isClientSide())
				ThtMod.PACKET_HANDLER.send(PacketDistributor.DIMENSION.with(level::dimension), new SavedDataSyncMessage(1, this));
		}

		static WorldVariables clientSide = new WorldVariables();

		public static WorldVariables get(LevelAccessor world) {
			if (world instanceof ServerLevel level) {
				return level.getDataStorage().computeIfAbsent(e -> WorldVariables.load(e), WorldVariables::new, DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class MapVariables extends SavedData {
		public static final String DATA_NAME = "tht_mapvars";
		public double world_height_limit_get = 0;
		public double world_height_limit = 0;
		public boolean world_gen_roots = false;
		public boolean version_1192 = false;
		public double tree_placer_tick_set = 0;
		public double tree_placer_tick = 0;
		public double tree_placer_process_limit = 0;
		public double tree_placer_distance_limit = 0;
		public double tree_placer_count_limit = 0;
		public double tree_placer_auto_speed_test = 0;
		public boolean tree_placer_auto_speed = false;
		public double tree_location_count = 0;
		public boolean tree_location = false;
		public double tp_limit = 0;
		public double time_convert = 0;
		public boolean tanny_pack_wip = false;
		public String tanny_pack_version = "";
		public double surface_detector_size = 0;
		public double surface_detector_height = 0;
		public boolean square_parts = false;
		public boolean square_leaves = false;
		public double season_detector_tick = 0;
		public boolean season_detector = false;
		public String season = "";
		public double safe_zone_village = 0;
		public double safe_zone_spawn = 0;
		public double rt_roots = 0;
		public double rt_dynamic_tick_set = 0;
		public double rt_dynamic_tick = 0;
		public double rt_dynamic_simulation = 0;
		public double rt_dynamic_process_limit = 0;
		public boolean rt_dynamic = false;
		public double pre_leaves_litter_coniferous_chance = 0;
		public double pre_leaves_litter_chance = 0;
		public boolean no_core = false;
		public String mod_version = "";
		public double loop_second = 0;
		public double leaves_regrow_winter_chance = 0;
		public double leaves_regrow_summer_chance = 0;
		public double leaves_regrow_spring_chance = 0;
		public double leaves_regrow_chance_coniferous = 0;
		public double leaves_regrow_autumn_chance = 0;
		public double leaves_litter_remover_count_limit = 0;
		public double leaves_litter_remover_chance = 0;
		public boolean leaves_litter = false;
		public double leaves_drop_winter_chance = 0;
		public double leaves_drop_summer_chance = 0;
		public double leaves_drop_spring_chance = 0;
		public double leaves_drop_chance_coniferous = 0;
		public double leaves_drop_autumn_chance = 0;
		public double leaves_drop_animation_count_limit = 0;
		public double leaves_drop_animation_chance = 0;
		public double leaves_coniferous_regrow_chance = 0;
		public double leaves_coniferous_drop_chance = 0;
		public boolean grid_fix = false;
		public double global_rarity = 0;
		public double global_generate_speed_speed = 0.0;
		public double global_generate_speed_repeat = 0.0;
		public boolean global_generate_speed = false;
		public double generation_distance_max = 0;
		public double generation_count_max = 0;
		public boolean fireworks = false;
		public boolean developer_mode = false;
		public boolean detect_exist = false;
		public boolean auto_update = false;
		public double auto_gen_forceload_size = 0;
		public double auto_gen_count = 0;
		public double auto_gen_cooldown = 0;
		public boolean auto_gen_chat_messages = false;
		public boolean auto_gen = false;
		public boolean auto_check_update = false;

		public static MapVariables load(CompoundTag tag) {
			MapVariables data = new MapVariables();
			data.read(tag);
			return data;
		}

		public void read(CompoundTag nbt) {
			world_height_limit_get = nbt.getDouble("world_height_limit_get");
			world_height_limit = nbt.getDouble("world_height_limit");
			world_gen_roots = nbt.getBoolean("world_gen_roots");
			version_1192 = nbt.getBoolean("version_1192");
			tree_placer_tick_set = nbt.getDouble("tree_placer_tick_set");
			tree_placer_tick = nbt.getDouble("tree_placer_tick");
			tree_placer_process_limit = nbt.getDouble("tree_placer_process_limit");
			tree_placer_distance_limit = nbt.getDouble("tree_placer_distance_limit");
			tree_placer_count_limit = nbt.getDouble("tree_placer_count_limit");
			tree_placer_auto_speed_test = nbt.getDouble("tree_placer_auto_speed_test");
			tree_placer_auto_speed = nbt.getBoolean("tree_placer_auto_speed");
			tree_location_count = nbt.getDouble("tree_location_count");
			tree_location = nbt.getBoolean("tree_location");
			tp_limit = nbt.getDouble("tp_limit");
			time_convert = nbt.getDouble("time_convert");
			tanny_pack_wip = nbt.getBoolean("tanny_pack_wip");
			tanny_pack_version = nbt.getString("tanny_pack_version");
			surface_detector_size = nbt.getDouble("surface_detector_size");
			surface_detector_height = nbt.getDouble("surface_detector_height");
			square_parts = nbt.getBoolean("square_parts");
			square_leaves = nbt.getBoolean("square_leaves");
			season_detector_tick = nbt.getDouble("season_detector_tick");
			season_detector = nbt.getBoolean("season_detector");
			season = nbt.getString("season");
			safe_zone_village = nbt.getDouble("safe_zone_village");
			safe_zone_spawn = nbt.getDouble("safe_zone_spawn");
			rt_roots = nbt.getDouble("rt_roots");
			rt_dynamic_tick_set = nbt.getDouble("rt_dynamic_tick_set");
			rt_dynamic_tick = nbt.getDouble("rt_dynamic_tick");
			rt_dynamic_simulation = nbt.getDouble("rt_dynamic_simulation");
			rt_dynamic_process_limit = nbt.getDouble("rt_dynamic_process_limit");
			rt_dynamic = nbt.getBoolean("rt_dynamic");
			pre_leaves_litter_coniferous_chance = nbt.getDouble("pre_leaves_litter_coniferous_chance");
			pre_leaves_litter_chance = nbt.getDouble("pre_leaves_litter_chance");
			no_core = nbt.getBoolean("no_core");
			mod_version = nbt.getString("mod_version");
			loop_second = nbt.getDouble("loop_second");
			leaves_regrow_winter_chance = nbt.getDouble("leaves_regrow_winter_chance");
			leaves_regrow_summer_chance = nbt.getDouble("leaves_regrow_summer_chance");
			leaves_regrow_spring_chance = nbt.getDouble("leaves_regrow_spring_chance");
			leaves_regrow_chance_coniferous = nbt.getDouble("leaves_regrow_chance_coniferous");
			leaves_regrow_autumn_chance = nbt.getDouble("leaves_regrow_autumn_chance");
			leaves_litter_remover_count_limit = nbt.getDouble("leaves_litter_remover_count_limit");
			leaves_litter_remover_chance = nbt.getDouble("leaves_litter_remover_chance");
			leaves_litter = nbt.getBoolean("leaves_litter");
			leaves_drop_winter_chance = nbt.getDouble("leaves_drop_winter_chance");
			leaves_drop_summer_chance = nbt.getDouble("leaves_drop_summer_chance");
			leaves_drop_spring_chance = nbt.getDouble("leaves_drop_spring_chance");
			leaves_drop_chance_coniferous = nbt.getDouble("leaves_drop_chance_coniferous");
			leaves_drop_autumn_chance = nbt.getDouble("leaves_drop_autumn_chance");
			leaves_drop_animation_count_limit = nbt.getDouble("leaves_drop_animation_count_limit");
			leaves_drop_animation_chance = nbt.getDouble("leaves_drop_animation_chance");
			leaves_coniferous_regrow_chance = nbt.getDouble("leaves_coniferous_regrow_chance");
			leaves_coniferous_drop_chance = nbt.getDouble("leaves_coniferous_drop_chance");
			grid_fix = nbt.getBoolean("grid_fix");
			global_rarity = nbt.getDouble("global_rarity");
			global_generate_speed_speed = nbt.getDouble("global_generate_speed_speed");
			global_generate_speed_repeat = nbt.getDouble("global_generate_speed_repeat");
			global_generate_speed = nbt.getBoolean("global_generate_speed");
			generation_distance_max = nbt.getDouble("generation_distance_max");
			generation_count_max = nbt.getDouble("generation_count_max");
			fireworks = nbt.getBoolean("fireworks");
			developer_mode = nbt.getBoolean("developer_mode");
			detect_exist = nbt.getBoolean("detect_exist");
			auto_update = nbt.getBoolean("auto_update");
			auto_gen_forceload_size = nbt.getDouble("auto_gen_forceload_size");
			auto_gen_count = nbt.getDouble("auto_gen_count");
			auto_gen_cooldown = nbt.getDouble("auto_gen_cooldown");
			auto_gen_chat_messages = nbt.getBoolean("auto_gen_chat_messages");
			auto_gen = nbt.getBoolean("auto_gen");
			auto_check_update = nbt.getBoolean("auto_check_update");
		}

		@Override
		public CompoundTag save(CompoundTag nbt) {
			nbt.putDouble("world_height_limit_get", world_height_limit_get);
			nbt.putDouble("world_height_limit", world_height_limit);
			nbt.putBoolean("world_gen_roots", world_gen_roots);
			nbt.putBoolean("version_1192", version_1192);
			nbt.putDouble("tree_placer_tick_set", tree_placer_tick_set);
			nbt.putDouble("tree_placer_tick", tree_placer_tick);
			nbt.putDouble("tree_placer_process_limit", tree_placer_process_limit);
			nbt.putDouble("tree_placer_distance_limit", tree_placer_distance_limit);
			nbt.putDouble("tree_placer_count_limit", tree_placer_count_limit);
			nbt.putDouble("tree_placer_auto_speed_test", tree_placer_auto_speed_test);
			nbt.putBoolean("tree_placer_auto_speed", tree_placer_auto_speed);
			nbt.putDouble("tree_location_count", tree_location_count);
			nbt.putBoolean("tree_location", tree_location);
			nbt.putDouble("tp_limit", tp_limit);
			nbt.putDouble("time_convert", time_convert);
			nbt.putBoolean("tanny_pack_wip", tanny_pack_wip);
			nbt.putString("tanny_pack_version", tanny_pack_version);
			nbt.putDouble("surface_detector_size", surface_detector_size);
			nbt.putDouble("surface_detector_height", surface_detector_height);
			nbt.putBoolean("square_parts", square_parts);
			nbt.putBoolean("square_leaves", square_leaves);
			nbt.putDouble("season_detector_tick", season_detector_tick);
			nbt.putBoolean("season_detector", season_detector);
			nbt.putString("season", season);
			nbt.putDouble("safe_zone_village", safe_zone_village);
			nbt.putDouble("safe_zone_spawn", safe_zone_spawn);
			nbt.putDouble("rt_roots", rt_roots);
			nbt.putDouble("rt_dynamic_tick_set", rt_dynamic_tick_set);
			nbt.putDouble("rt_dynamic_tick", rt_dynamic_tick);
			nbt.putDouble("rt_dynamic_simulation", rt_dynamic_simulation);
			nbt.putDouble("rt_dynamic_process_limit", rt_dynamic_process_limit);
			nbt.putBoolean("rt_dynamic", rt_dynamic);
			nbt.putDouble("pre_leaves_litter_coniferous_chance", pre_leaves_litter_coniferous_chance);
			nbt.putDouble("pre_leaves_litter_chance", pre_leaves_litter_chance);
			nbt.putBoolean("no_core", no_core);
			nbt.putString("mod_version", mod_version);
			nbt.putDouble("loop_second", loop_second);
			nbt.putDouble("leaves_regrow_winter_chance", leaves_regrow_winter_chance);
			nbt.putDouble("leaves_regrow_summer_chance", leaves_regrow_summer_chance);
			nbt.putDouble("leaves_regrow_spring_chance", leaves_regrow_spring_chance);
			nbt.putDouble("leaves_regrow_chance_coniferous", leaves_regrow_chance_coniferous);
			nbt.putDouble("leaves_regrow_autumn_chance", leaves_regrow_autumn_chance);
			nbt.putDouble("leaves_litter_remover_count_limit", leaves_litter_remover_count_limit);
			nbt.putDouble("leaves_litter_remover_chance", leaves_litter_remover_chance);
			nbt.putBoolean("leaves_litter", leaves_litter);
			nbt.putDouble("leaves_drop_winter_chance", leaves_drop_winter_chance);
			nbt.putDouble("leaves_drop_summer_chance", leaves_drop_summer_chance);
			nbt.putDouble("leaves_drop_spring_chance", leaves_drop_spring_chance);
			nbt.putDouble("leaves_drop_chance_coniferous", leaves_drop_chance_coniferous);
			nbt.putDouble("leaves_drop_autumn_chance", leaves_drop_autumn_chance);
			nbt.putDouble("leaves_drop_animation_count_limit", leaves_drop_animation_count_limit);
			nbt.putDouble("leaves_drop_animation_chance", leaves_drop_animation_chance);
			nbt.putDouble("leaves_coniferous_regrow_chance", leaves_coniferous_regrow_chance);
			nbt.putDouble("leaves_coniferous_drop_chance", leaves_coniferous_drop_chance);
			nbt.putBoolean("grid_fix", grid_fix);
			nbt.putDouble("global_rarity", global_rarity);
			nbt.putDouble("global_generate_speed_speed", global_generate_speed_speed);
			nbt.putDouble("global_generate_speed_repeat", global_generate_speed_repeat);
			nbt.putBoolean("global_generate_speed", global_generate_speed);
			nbt.putDouble("generation_distance_max", generation_distance_max);
			nbt.putDouble("generation_count_max", generation_count_max);
			nbt.putBoolean("fireworks", fireworks);
			nbt.putBoolean("developer_mode", developer_mode);
			nbt.putBoolean("detect_exist", detect_exist);
			nbt.putBoolean("auto_update", auto_update);
			nbt.putDouble("auto_gen_forceload_size", auto_gen_forceload_size);
			nbt.putDouble("auto_gen_count", auto_gen_count);
			nbt.putDouble("auto_gen_cooldown", auto_gen_cooldown);
			nbt.putBoolean("auto_gen_chat_messages", auto_gen_chat_messages);
			nbt.putBoolean("auto_gen", auto_gen);
			nbt.putBoolean("auto_check_update", auto_check_update);
			return nbt;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();
			if (world instanceof Level && !world.isClientSide())
				ThtMod.PACKET_HANDLER.send(PacketDistributor.ALL.noArg(), new SavedDataSyncMessage(0, this));
		}

		static MapVariables clientSide = new MapVariables();

		public static MapVariables get(LevelAccessor world) {
			if (world instanceof ServerLevelAccessor serverLevelAcc) {
				return serverLevelAcc.getLevel().getServer().getLevel(Level.OVERWORLD).getDataStorage().computeIfAbsent(e -> MapVariables.load(e), MapVariables::new, DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class SavedDataSyncMessage {
		private final int type;
		private SavedData data;

		public SavedDataSyncMessage(FriendlyByteBuf buffer) {
			this.type = buffer.readInt();
			CompoundTag nbt = buffer.readNbt();
			if (nbt != null) {
				this.data = this.type == 0 ? new MapVariables() : new WorldVariables();
				if (this.data instanceof MapVariables mapVariables)
					mapVariables.read(nbt);
				else if (this.data instanceof WorldVariables worldVariables)
					worldVariables.read(nbt);
			}
		}

		public SavedDataSyncMessage(int type, SavedData data) {
			this.type = type;
			this.data = data;
		}

		public static void buffer(SavedDataSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeInt(message.type);
			if (message.data != null)
				buffer.writeNbt(message.data.save(new CompoundTag()));
		}

		public static void handler(SavedDataSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer() && message.data != null) {
					if (message.type == 0)
						MapVariables.clientSide = (MapVariables) message.data;
					else
						WorldVariables.clientSide = (WorldVariables) message.data;
				}
			});
			context.setPacketHandled(true);
		}
	}
}
