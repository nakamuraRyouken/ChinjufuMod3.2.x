package com.ayutaki.chinjufumod.init.hakkou;

import java.util.Random;

import com.ayutaki.chinjufumod.init.ASDecoModHakkou;
import com.ayutaki.chinjufumod.init.TTimeItems;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class BlockTaru_Shubo_1 extends Block {

	public BlockTaru_Shubo_1() {
		super(Material.WOOD);

		this.setSoundType(SoundType.WOOD);
		this.setHardness(1.0F);
		this.setResistance(5.0F);
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing side,
			float hitX, float hitY, float hitZ) {

		ItemStack itemstack = playerIn.getHeldItem(hand);
		Item item = itemstack.getItem();

		if (item != Items.BOWL) {
			return true;
		}

		else if (item == Items.BOWL) {

			itemstack.shrink(1);
			worldIn.playSound(null, pos, SoundEvents.ITEM_BUCKET_FILL, SoundCategory.PLAYERS, 0.7F, 1.2F);

			if (itemstack.isEmpty()) {
				((EntityPlayer) playerIn).inventory.addItemStackToInventory(new ItemStack(TTimeItems.SHUBO));
			}
			else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(TTimeItems.SHUBO))) {
				playerIn.dropItem(new ItemStack(TTimeItems.SHUBO), false);
			}

			return worldIn.setBlockState(pos, ASDecoModHakkou.HAKKOUTARU.getDefaultState());
		}
		return true;
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	/*ドロップ指定、ピックアップ指定*/
	public boolean canSilkHarvest(World world, EntityPlayer player, int x, int y, int z, int metadata) {
		return false;
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return new ItemStack(ASDecoModHakkou.HAKKOUTARU).getItem();
	}

	@Override
	public int quantityDropped(Random random) {
		return 1;
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
		return new ItemStack(ASDecoModHakkou.HAKKOUTARU);
	}

}
