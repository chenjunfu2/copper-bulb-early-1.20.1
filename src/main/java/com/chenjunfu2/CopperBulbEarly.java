package com.chenjunfu2;

import com.chenjunfu2.register.ModSoundEvents;
import com.chenjunfu2.register.RegistriesBlocks;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroups;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CopperBulbEarly implements ModInitializer {
	public static final String MOD_ID = "copper-bulb-early";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		RegistriesBlocks.RegistriesBlocks();
		ModSoundEvents.registerSounds();
	}
}