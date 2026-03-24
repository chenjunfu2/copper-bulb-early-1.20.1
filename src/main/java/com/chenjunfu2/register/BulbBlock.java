package com.chenjunfu2.register;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BulbBlock extends Block {
    //CODEC 麻将答辩?
//    public static final MapCodec<BulbBlock> CODEC = createCodec(BulbBlock::new);
//    public static final BooleanProperty POWERED = MyBlockProperties.POWERED;
//    public static final BooleanProperty LIT = MyBlockProperties.LIT;

    public static final BooleanProperty POWERED = BooleanProperty.of("powered");
    public static final BooleanProperty LIT = BooleanProperty.of("lit");

//    @Override
//    public MapCodec<? extends BulbBlock> getCodec() {
//        return CODEC;
//    }

    public BulbBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.getDefaultState().with(LIT, false).with(POWERED, false));
    }

    @Override
    public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
        if (oldState.getBlock() != state.getBlock() && world instanceof ServerWorld serverWorld) {
            this.update(state, serverWorld, pos);
        }
    }

    @Override
    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
        if (world instanceof ServerWorld serverWorld) {
            this.update(state, serverWorld, pos);
        }
    }

    public void update(BlockState state, ServerWorld world, BlockPos pos) {
        boolean bl = world.isReceivingRedstonePower(pos);
        if (bl != (Boolean)state.get(POWERED)) {
            BlockState blockState = state;
            if (!(Boolean)state.get(POWERED)) {
                blockState = state.cycle(LIT);
                try{
                    world.playSound(null, pos, blockState.get(LIT) ? ModSoundEvents.BLOCK_COPPER_BULB_TURN_ON : ModSoundEvents.BLOCK_COPPER_BULB_TURN_OFF, SoundCategory.BLOCKS);
                }catch(Exception e){
                    e.printStackTrace();
                }
                //上面是音效 后面一定补上hhh
            }

            world.setBlockState(pos, blockState.with(POWERED, bl), Block.NOTIFY_ALL);
        }
    }

    @Override
    public void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(LIT, POWERED);
    }

    @Override
    public boolean hasComparatorOutput(BlockState state) {
        return true;
    }

    @Override
    public int getComparatorOutput(BlockState state, World world, BlockPos pos) {
        return world.getBlockState(pos).get(LIT) ? 15 : 0;
    }

}
