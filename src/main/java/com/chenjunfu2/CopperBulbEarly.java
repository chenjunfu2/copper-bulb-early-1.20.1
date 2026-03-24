package com.chenjunfu2;

import com.chenjunfu2.sounds.ModSoundEvents;
import com.chenjunfu2.blocks.RegistriesBlocks;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CopperBulbEarly implements ModInitializer {
	public static final String MOD_ID = "copper-bulb-early";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModSoundEvents.registerSoundEvents();
		RegistriesBlocks.RegistriesBlocks();
	}
}