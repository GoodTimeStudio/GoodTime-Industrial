/*
 * This file is part of GoodTime-Industrial, licensed under MIT License (MIT).
 *
 * Copyright (c) 2015 GoodTime Studio <https://github.com/GoodTimeStudio>
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
package com.mcgoodtime.productionline.inventory;

import com.mcgoodtime.productionline.inventory.slot.SlotInput;
import com.mcgoodtime.productionline.inventory.slot.SlotOutput;
import com.mcgoodtime.productionline.inventory.slot.SlotUpgrade;
import com.mcgoodtime.productionline.tiles.TileCarbonizeFurnace;
import com.mcgoodtime.productionline.tiles.tileslots.TileSlotInput;
import net.minecraft.inventory.IContainerListener;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import ic2.core.slot.SlotDischarge;
import net.minecraft.entity.player.EntityPlayer;

/*
 * Created by suhao on 2015.7.4.
 */
public class ContainerCarbonizeFurnace extends ContainerPL<TileCarbonizeFurnace> {

    private int lastProgress;
    private int lastRequireEnergy;
    private double lastEnergy;

    public ContainerCarbonizeFurnace(EntityPlayer player, TileCarbonizeFurnace tile) {
        super(player, tile);
        this.addSlotToContainer(new SlotInput((TileSlotInput) tile.tileSlots.get(0), tile, 0, 56, 16));
        this.addSlotToContainer(new SlotDischarge(tile, 1, 1, 56, 53));
        this.addSlotToContainer(new SlotOutput(player, tile, 2, 113, 35));
        this.addSlotToContainer(new SlotOutput(player, tile, 3, 131, 35));
        this.addSlotToContainer(new SlotUpgrade(tile, 4, 153, 26));
        this.addSlotToContainer(new SlotUpgrade(tile, 5, 153, 44));
    }

    @Override
    public void addListener(IContainerListener listener) {
        super.addListener(listener);
        listener.sendProgressBarUpdate(this, 0, this.tile.progress);
        listener.sendProgressBarUpdate(this, 1, (int) this.tile.requireEnergy);
        listener.sendProgressBarUpdate(this, 2, (int) this.tile.energy);
    }

    /**
     * Looks for changes made in the container, sends them to every listener.
     */
    @Override
    public void detectAndSendChanges() {
        super.detectAndSendChanges();

        for (IContainerListener listener : this.listeners) {
            if (this.lastProgress != this.tile.progress) {
                listener.sendProgressBarUpdate(this, 0, this.tile.progress);
            }

            if (this.lastRequireEnergy != this.tile.requireEnergy) {
                listener.sendProgressBarUpdate(this, 1, (int) this.tile.requireEnergy);
            }

            if (this.lastEnergy != this.tile.energy) {
                listener.sendProgressBarUpdate(this, 2, (int) this.tile.energy);
            }
        }

        this.lastProgress = this.tile.progress;
        this.lastRequireEnergy = (int) this.tile.requireEnergy;
        this.lastEnergy = this.tile.energy;
    }

    /**
     * Sends two ints to the client-side Container. Used for furnace burning time, smelting progress, brewing progress,
     * and enchanting level. Normally the first int identifies which variable to update, and the second contains the new
     * value. Both are truncated to shorts in non-local SMP.
     * @param i Identifies which variable to update
     */
    @Override
    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int i, int var) {
        if (i == 0) {
            this.tile.progress = var;
        }

        if (i == 1) {
            this.tile.requireEnergy = var;
        }

        if (i == 2) {
            this.tile.energy = var;
        }
    }
}
