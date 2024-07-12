package com.teamsorcerers.wizardry.common.spell.loading

import com.google.gson.JsonObject
import com.teamsorcerers.wizardry.common.spell.component.Modifier
import net.minecraft.registry.Registries
import net.minecraft.util.Identifier

object ModifierLoader: FileLoader<Modifier>() {
    private const val NAME = "name"
    private const val ITEMS = "items"

    override fun compileJson(json: JsonObject): Modifier {
        val name = json[NAME].asString
        val items = json[ITEMS].asJsonArray.map{it.asString}.map{Identifier.of(it)}.map(Registries.ITEM::get)
        return Modifier(name, items)
    }

    @Suppress("UNCHECKED_CAST")
    override fun compileYaml(yaml: Map<String, Any>): Modifier {
        val name = yaml[NAME] as String
        val items = (yaml[ITEMS] as List<String>).map{Identifier.of(it)}.map{Registries.ITEM[it]}.toList()
        return Modifier(name, items)
    }
}