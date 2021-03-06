/*
 *
 * This file is part of ProductionLine, licensed under MIT License (MIT).
 *
 * Copyright (c) 2017 GoodTime Studio <https://github.com/GoodTimeStudio>
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

package com.mcgoodtime.productionline.recipes;

import com.mcgoodtime.productionline.init.PLItems;
import net.minecraft.item.ItemStack;

/**
 * Created by BestOwl on 2017/3/25.
 * List of Packager's Recipes
 *
 * @author BestOwl
 */
public class PackagerRecipes extends RecipeBase {

    public static final PackagerRecipes instance = new PackagerRecipes();

    private PackagerRecipes() {
        register(new ItemStack(PLItems.salt, 9), new ItemStack(PLItems.packagedSalt));
    }

    public void register(ItemStack input, ItemStack output) {
        processList.add(new RecipePart(input, output));
        }
        }
