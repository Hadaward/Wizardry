package com.teamsorcerers.wizardry.common.block

import com.teamsorcerers.wizardry.common.init.ModBlocks
import net.minecraft.block.SaplingBlock
import net.minecraft.block.SaplingGenerator
import net.minecraft.util.math.intprovider.ConstantIntProvider
import net.minecraft.util.math.random.Random
import net.minecraft.world.gen.feature.ConfiguredFeature
import net.minecraft.world.gen.feature.Feature
import net.minecraft.world.gen.feature.TreeFeatureConfig
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize
import net.minecraft.world.gen.foliage.BlobFoliagePlacer
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider
import net.minecraft.world.gen.trunk.StraightTrunkPlacer

class BlockWisdomSapling(generator: SaplingGenerator?, settings: Settings?) :
    SaplingBlock(generator, settings) {
    open class WisdomSaplingGenerator {
        private var config: TreeFeatureConfig? = null
        private val treeFeatureConfig: TreeFeatureConfig? = null
    }
}