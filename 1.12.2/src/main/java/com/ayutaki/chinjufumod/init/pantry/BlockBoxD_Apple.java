package com.ayutaki.chinjufumod.init.pantry;

import java.util.ArrayList;
import java.util.List;

import com.ayutaki.chinjufumod.init.ASDecoModPantry;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockBoxD_Apple extends BlockBox_Apple {

	public BlockBoxD_Apple(String unlocalizedName) {
		super(unlocalizedName);
	}

	@Override
	public boolean isDouble() {
		return true;
	}

	/*ドロップ指定、ピックアップ指定*/
	@Override
	public List<ItemStack> getDrops(IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
		List<ItemStack> stack = new ArrayList<ItemStack>();

		stack.add(new ItemStack(ASDecoModPantry.BOX_H_EMPTY, 2, this.damageDropped(state)));
		stack.add(new ItemStack(Items.APPLE, 16, this.damageDropped(state)));
		return stack;

	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world,
			BlockPos pos, EntityPlayer player) {
		return new ItemStack(ASDecoModPantry.BOX_H_APPLE);
	}

}
