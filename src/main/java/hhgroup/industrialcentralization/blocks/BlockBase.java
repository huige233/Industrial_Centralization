package hhgroup.industrialcentralization.blocks;


import hhgroup.industrialcentralization.Main;
import hhgroup.industrialcentralization.init.ModBlock;
import hhgroup.industrialcentralization.init.ModItems;
import hhgroup.industrialcentralization.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

import java.util.Random;

public class BlockBase extends Block implements IHasModel {
    public BlockBase(String name, Material material) {
        super(material);
        setHardness(5.0F);
        setResistance(10.0F);
        setTranslationKey(name).setRegistryName(name);
        //.setCreativeTab(Main.TranscendTab);
        ModBlock.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return Item.getItemFromBlock(this);
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }


}
