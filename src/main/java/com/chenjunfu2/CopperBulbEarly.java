package com.chenjunfu2;

import com.chenjunfu2.sounds.ModSoundEvents;
import com.chenjunfu2.block.CopperBulbBlocks;
import com.google.common.base.Suppliers;
import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import net.fabricmc.api.ModInitializer;

import net.minecraft.block.Block;
import net.minecraft.block.Oxidizable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.function.Supplier;

public class CopperBulbEarly implements ModInitializer {
	public static final String MOD_ID = "copper-bulb-early";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModSoundEvents.registerSoundEvents();
		CopperBulbBlocks.RegistriesBlocks();
	}
}