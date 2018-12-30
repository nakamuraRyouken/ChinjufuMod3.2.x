package com.ayutaki.chinjufumod.init.garden;

import java.util.Random;

import com.ayutaki.chinjufumod.handlers.SoundsHandler;
import com.ayutaki.chinjufumod.init.ASDecoModGarden;

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
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockChouzuAnd_3 extends Block {

	public BlockChouzuAnd_3() {
		super(Material.WOOD);

		this.setSoundType(SoundType.STONE);
		this.setHardness(1.0F);
		this.setResistance(5.0F);
	}

	/* 右クリック操作 */
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

		ItemStack itemstack = playerIn.getHeldItem(hand);
		Item item = itemstack.getItem();

		if (itemstack.isEmpty()) {
			worldIn.playSound(null, pos, SoundsHandler.WATER_SPLASH, SoundCategory.BLOCKS, 0.5F, 1.2F);
			return worldIn.setBlockState(pos, ASDecoModGarden.CHOUZU_AND_4.getDefaultState());
		}

		else if (item == Items.WATER_BUCKET) {

			itemstack.shrink(1);

			if (itemstack.isEmpty()) {
				playerIn.setHeldItem(hand, new ItemStack(Items.BUCKET));
			}
			else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items.BUCKET))) {
				playerIn.dropItem(new ItemStack(Items.BUCKET), false);
			}
			worldIn.playSound(null, pos, SoundEvents.ITEM_BUCKET_EMPTY, SoundCategory.BLOCKS, 1.0F, 1.0F);
			return worldIn.setBlockState(pos, ASDecoModGarden.CHOUZU_AND_1.getDefaultState());
		}
		return true;
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return new AxisAlignedBB(0.0625D, 0.0D, 0.0625D, 0.9375D, 0.75D, 0.9375D);
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
		return new ItemStack(ASDecoModGarden.CHOUZU_AND_kara).getItem();
	}

	@Override
	public int quantityDropped(Random random) {
		return 1;
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
		return new ItemStack(ASDecoModGarden.CHOUZU_AND_kara);
	}

}
