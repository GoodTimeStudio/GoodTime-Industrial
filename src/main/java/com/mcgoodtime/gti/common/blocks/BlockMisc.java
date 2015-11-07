/*
 * This file is part of GoodTime-Industrial, licensed under MIT License (MIT).
 *
 * Copyright (c) 2015 Minecraft-GoodTime <http://github.com/Minecraft-GoodTime>
 * Copyright (c) contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.mcgoodtime.gti.common.blocks;

import com.mcgoodtime.gti.common.init.GtiBlocks;
import com.mcgoodtime.gti.common.tiles.TileGti;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.List;

import static com.mcgoodtime.gti.common.core.Gti.MOD_ID;
import static com.mcgoodtime.gti.common.core.Gti.RESOURCE_DOMAIN;

/**
 * Created by suhao on 2015.10.18.0018.
 *
 * @author suhao
 */
public class BlockMisc extends BlockGti {

    public int maxMeta;
    protected IIcon[] icons;

    public BlockMisc() {
        super(Material.rock, "BlockMisc");
        this.icons = new IIcon[this.getMaxMeta()];
        this.setHardness(1.0F);

        GtiBlocks.compressedWaterHyacinth = new ItemStack(this, 1, 0);
        GtiBlocks.dehydratedWaterHyacinthblock = new ItemStack(this, 1, 1);
    }

    public int getMaxMeta() {
        if (this.maxMeta == 0) {
            int meta = 0;
            while (this.getInternalName(meta) != null) {
                meta++;
            }
            return meta;
        }
        else {
            return this.maxMeta;
        }
    }

    /**
     * Returns the unlocalized name of this item. This version accepts an ItemStack so different stacks can have
     * different names based on their damage or NBT.
     */
    //@Override
    public String getBlockName(ItemStack itemStack) {
        return "item." + MOD_ID + "." + this.getInternalName(itemStack.getItemDamage());
    }

    public String getInternalName(int meta) {
        switch (meta) {
            case 0: return "CompressedWaterHyacinth";
            case 1: return "DehydratedWaterHyacinthBlock";
            default: return null;
        }
    }

    @Override
    public void registerBlockIcons(IIconRegister iir) {
        for (int i = 0; i < this.getMaxMeta(); i++) {
            this.icons[i] = iir.registerIcon(RESOURCE_DOMAIN + ":" + "block" + this.getInternalName(i));
        }
    }

    /**
     * Gets the block's texture. Args: side, meta
     */
    @Override
    public IIcon getIcon(int side, int meta) {
        return this.icons[meta];
    }

    /**
     * returns a list of items with the same ID, but different meta (eg: dye returns 16 items)
     */
    @Override
    @SuppressWarnings("unchecked")
    public void getSubBlocks(Item item, CreativeTabs creativeTabs, List list) {
        for(int meta = 0; meta < this.getMaxMeta(); ++meta) {
            ItemStack stack = new ItemStack(this, 1, meta);
            list.add(stack);
        }
    }

    /**
     * Returns an item stack containing a single instance of the current block type. 'meta' is the block's subtype/damage
     * and is ignored for blocks which do not support subtypes. Blocks which cannot be harvested should return null.
     *//*
    protected ItemStack createStackedBlock(int meta) {
        return new ItemStack(Item.getItemFromBlock(this), 1, this.func_150162_k(meta));
    }*/

    /**
     * The type of render function that is called for this block
     */
    @Override
    public int getRenderType() {
        return 31;
    }
}
