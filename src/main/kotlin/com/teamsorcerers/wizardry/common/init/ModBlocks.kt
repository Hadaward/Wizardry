package com.teamsorcerers.wizardry.common.init

import com.teamsorcerers.wizardry.Wizardry
import com.teamsorcerers.wizardry.common.block.BlockWisdomSapling
import com.teamsorcerers.wizardry.common.block.entity.manabattery.BlockManaBatteryEntity
import com.teamsorcerers.wizardry.mixin.BlocksMixin
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.*
import net.minecraft.block.entity.BlockEntityType
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.sound.BlockSoundGroup

object ModBlocks {
    private val wisdomWoodSettings =
        AbstractBlock.Settings.copy(Blocks.OAK_WOOD)
            .sounds(BlockSoundGroup.WOOD)
            .strength(2f)
            .mapColor(MapColor.BROWN)

    val wisdomLeaves: Block = LeavesBlock(
        AbstractBlock.Settings.copy(Blocks.OAK_LEAVES).strength(0.2f).ticksRandomly().sounds(BlockSoundGroup.GRASS)
            .nonOpaque().allowsSpawning(BlocksMixin::canSpawnOnLeaves).suffocates(BlocksMixin::never)
            .blockVision(BlocksMixin::never)
    )
    var manaBatteryEntity: BlockEntityType<BlockManaBatteryEntity>? = null

    val wisdomLog: Block = PillarBlock(wisdomWoodSettings)
    val wisdomWood: Block = PillarBlock(wisdomWoodSettings)
    val wisdomStrippedLog: Block = PillarBlock(wisdomWoodSettings)
    val wisdomStrippedWood: Block = PillarBlock(wisdomWoodSettings)

    var wisdomSapling: Block =
        BlockWisdomSapling(SaplingGenerator.OAK, AbstractBlock.Settings.copy(Blocks.OAK_SAPLING).nonOpaque())

    fun register(block: Block, name: String, shouldRegisterItem: Boolean): Block {
        val id = Wizardry.getID(name);

        if (shouldRegisterItem) {
            val blockItem = BlockItem(block, Item.Settings())
            Registry.register(Registries.ITEM, id, blockItem);
        }

        return Registry.register(Registries.BLOCK, id, block);
    }

    fun init() {
        Wizardry.logManager.root.info("Registering blocks...");
    }
}