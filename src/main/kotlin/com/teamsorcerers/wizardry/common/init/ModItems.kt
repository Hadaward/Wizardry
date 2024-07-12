package com.teamsorcerers.wizardry.common.init

import com.teamsorcerers.wizardry.Wizardry
import com.teamsorcerers.wizardry.common.item.ItemBook
import com.teamsorcerers.wizardry.common.item.ItemCape
import com.teamsorcerers.wizardry.common.item.ItemStaff
import com.teamsorcerers.wizardry.common.item.itemPearl
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.text.Text
import net.minecraft.util.Rarity

object ModItems {
    val wizardry: ItemGroup = FabricItemGroup.builder()
        .displayName(Text.translatable("itemGroup.wizardry"))
        .build()


    lateinit var manaBucket: Item

    val staff = ItemStaff(
        Item.Settings()
            .maxCount(1)
            .rarity(Rarity.UNCOMMON)

    );
    val book = ItemBook(
        Item.Settings()
            .maxCount(1)
            .rarity(Rarity.UNCOMMON)
    );
    val cape = ItemCape(
        Item.Settings()
            .maxCount(1)
            .rarity(Rarity.UNCOMMON)
    )
    val pearl = itemPearl(
        Item.Settings()
            .maxCount(1)
            .rarity(Rarity.UNCOMMON)
    )
    fun init(){
        registerItem("staff", staff);
        registerItem("book", book);
        registerItem("cape", cape);
        registerItem("pearl", pearl);
    }

    fun registerItem(name: String, item: Item): Item {
        val registeredItem = Registry.register(Registries.ITEM, Wizardry.getID(name), item)
        return registeredItem
    }
}