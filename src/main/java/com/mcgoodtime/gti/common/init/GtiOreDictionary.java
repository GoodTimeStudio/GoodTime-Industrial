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
package com.mcgoodtime.gti.common.init;

import net.minecraft.init.Items;
import net.minecraftforge.oredict.OreDictionary;

/**
 * Created by BestOwl on 2015.11.7.0007.
 *
 * @author BestOwl
 */
public class GtiOreDictionary {

    public static void init() {
        OreDictionary.registerOre("paper", Items.paper);
        OreDictionary.registerOre("paper", GtiItems.rigidPaper);

        OreDictionary.registerOre("advTreetap", GtiItems.ironTreetap);
        OreDictionary.registerOre("advTreetap", GtiItems.bronzeTreetap);
        OreDictionary.registerOre("advTreetap", GtiItems.leadTreetap);
        OreDictionary.registerOre("advTreetap", GtiItems.refinedIronTreetap);
        OreDictionary.registerOre("advTreetap", GtiItems.advancedAlloyTreetap);
        OreDictionary.registerOre("advTreetap", GtiItems.carbonTreetap);

        OreDictionary.registerOre("advSolarLens", GtiItems.advSolarLensUnit);
        OreDictionary.registerOre("advSolarLens", GtiItems.advSolarLensGroup);
        OreDictionary.registerOre("advSolarLens", GtiItems.advSolarLensCluster);
    }
}