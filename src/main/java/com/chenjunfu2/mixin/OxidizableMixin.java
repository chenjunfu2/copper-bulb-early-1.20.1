package com.chenjunfu2.mixin;

import com.google.common.collect.BiMap;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.block.Block;
import net.minecraft.block.Oxidizable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;

import static com.chenjunfu2.block.CopperBulbBlocks.NEW_OXIDATION_LEVEL_DECREASES;
import static com.chenjunfu2.block.CopperBulbBlocks.NEW_OXIDATION_LEVEL_INCREASES;

@Mixin(Oxidizable.class)
interface OxidizableMixin
{
//	@Redirect(
//		method = "method_34740",
//		at = @At(
//			value = "INVOKE",
//			target = "Lcom/google/common/collect/ImmutableBiMap$Builder;build()Lcom/google/common/collect/ImmutableBiMap;"
//		),
//		remap = false
//	)
//	private static ImmutableBiMap<Block, Block> OXIDATION_LEVEL_INCREASES_Modify(ImmutableBiMap.Builder<Block, Block> builder)
//	{
//		builder
//			.put(CopperBulbBlocks.COPPER_BULB, CopperBulbBlocks.EXPOSED_COPPER_BULB)
//			.put(CopperBulbBlocks.EXPOSED_COPPER_BULB, CopperBulbBlocks.WEATHERED_COPPER_BULB)
//			.put(CopperBulbBlocks.WEATHERED_COPPER_BULB, CopperBulbBlocks.OXIDIZED_COPPER_BULB);
//
//		return builder.build();
//	}
	
	
	@WrapOperation(
		method = "getDecreasedOxidationBlock",
		at = @At(value = "INVOKE", target = "Lcom/google/common/collect/BiMap;get(Ljava/lang/Object;)Ljava/lang/Object;"),
		remap = false
	)
	private static Object getDecreasedOxidationBlockWrapOperation(BiMap instance, Object o, Operation<Object> original)
	{
		Block b = (Block)original.call(instance, o);
		if(b != null)
		{
			return b;
		}
		
		if(NEW_OXIDATION_LEVEL_DECREASES!=null)
		{
			return NEW_OXIDATION_LEVEL_DECREASES.get().get(o);
		}
		
		return null;
	}
	
	@WrapOperation(
		method = "getIncreasedOxidationBlock",
		at = @At(value = "INVOKE", target = "Lcom/google/common/collect/BiMap;get(Ljava/lang/Object;)Ljava/lang/Object;"),
		remap = false
	)
	private static Object getIncreasedOxidationBlockWrapOperation(BiMap instance, Object o, Operation<Object> original)
	{
		Block b = (Block)original.call(instance, o);
		if(b != null)
		{
			return b;
		}
		
		if(NEW_OXIDATION_LEVEL_INCREASES!=null)
		{
			return NEW_OXIDATION_LEVEL_INCREASES.get().get(o);
		}
		
		return null;
	}
	
	
	@WrapOperation(
		method = "getUnaffectedOxidationBlock",
		at = @At(value = "INVOKE", target = "Lcom/google/common/collect/BiMap;get(Ljava/lang/Object;)Ljava/lang/Object;"),
		remap = false
	)
	private static Object getUnaffectedOxidationBlockWrapOperation(BiMap instance, Object o, Operation<Object> original)
	{
		Block b = (Block)original.call(instance, o);
		if(b != null)
		{
			return b;
		}
		
		if(NEW_OXIDATION_LEVEL_DECREASES!=null)
		{
			return NEW_OXIDATION_LEVEL_DECREASES.get().get(o);
		}
		
		return null;
	}
}