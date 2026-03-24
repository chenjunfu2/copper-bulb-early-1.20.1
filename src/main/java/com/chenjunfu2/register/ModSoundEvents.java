package com.chenjunfu2.register;

import com.chenjunfu2.CopperBulbEarly;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSoundEvents {

    public static final SoundEvent BLOCK_COPPER_BULB_BREAK = register("copper_bulb.break");
    public static final SoundEvent BLOCK_COPPER_BULB_STEP = register("copper_bulb.step");
    public static final SoundEvent BLOCK_COPPER_BULB_PLACE = register("copper_bulb.place");
    public static final SoundEvent BLOCK_COPPER_BULB_HIT = register("copper_bulb.hit");
    public static final SoundEvent BLOCK_COPPER_BULB_FALL = register("copper_bulb.fall");
    public static final SoundEvent BLOCK_COPPER_BULB_TURN_ON = register("copper_bulb.turn_on");
    public static final SoundEvent BLOCK_COPPER_BULB_TURN_OFF = register("copper_bulb.turn_off");


    public static final BlockSoundGroup COPPER_BULB = new BlockSoundGroup(
            1.0F,
            1.0F,
		ModSoundEvents.BLOCK_COPPER_BULB_BREAK,
		ModSoundEvents.BLOCK_COPPER_BULB_STEP,
		ModSoundEvents.BLOCK_COPPER_BULB_PLACE,
		ModSoundEvents.BLOCK_COPPER_BULB_HIT,
		ModSoundEvents.BLOCK_COPPER_BULB_FALL
    );


    private static SoundEvent register(String name) {
        final Identifier id = new Identifier(CopperBulbEarly.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerSounds() {}
}
