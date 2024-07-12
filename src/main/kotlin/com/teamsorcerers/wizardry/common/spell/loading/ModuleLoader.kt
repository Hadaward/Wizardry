package com.teamsorcerers.wizardry.common.spell.loading

import com.google.gson.JsonObject
import com.google.gson.JsonParseException
import com.teamsorcerers.wizardry.Wizardry
import com.teamsorcerers.wizardry.common.init.ModPatterns
import com.teamsorcerers.wizardry.common.spell.component.*
import net.minecraft.item.Item
import net.minecraft.registry.Registries
import net.minecraft.util.Identifier

object ModuleLoader: FileLoader<Module>() {
    private const val MODULE = "module"
    private const val NAME = "name"
    private const val ITEMS = "items"
    private const val MANA = "mana"
    private const val MODIFIERS = "modifiers"
    private const val COST = "cost"
    private const val VALUES = "values"

    override fun compileJson(json: JsonObject): Module {
        val pattern = ModPatterns.PATTERN[Identifier.of(json[MODULE].asString)]
        val name = json[NAME].asString
        val items = json[ITEMS].asJsonArray.map{it.asString}.map{Identifier.of(it)}.map(Registries.ITEM::get)
        val mana = json[MANA].asDouble

        val modifierCosts = HashMap<String, Double>()
        val attributeValues = HashMap<String, List<Double>>()
        val modifierJson = json[MODIFIERS].asJsonObject
        for ((attribute, modifier) in modifierJson.entrySet()) {
            if (!modifier.isJsonObject) continue
            val modifierValues = modifier.asJsonObject
            if (modifierValues.has(COST))
                modifierCosts[attribute] = modifierValues.get(COST).asDouble
            if (!modifierValues[VALUES].isJsonArray) continue
            attributeValues[attribute] = modifierValues[VALUES].asJsonArray.map{it.asDouble}
        }

        return constructModule(pattern, name, items, mana, modifierCosts, attributeValues)
    }

    @Suppress("UNCHECKED_CAST")
    override fun compileYaml(yaml: Map<String, Any>): Module {
        val pattern = ModPatterns.PATTERN[Identifier.of(yaml[MODULE] as String)]
        val name = yaml[NAME] as String
        val items = (yaml[ITEMS] as List<String>).map{Identifier.of(it)}.map(Registries.ITEM::get).toList()
        val mana = (yaml[MANA] as Number).toDouble()

        val modifierCosts = HashMap<String, Double>()
        val attributeValues = HashMap<String, List<Double>>()
        val modifierMap = yaml[MODIFIERS] as Map<String, Map<String, Any>>
        for (attribute in modifierMap.keys) {
            val modifierValues = modifierMap[attribute] ?: continue
            if (modifierValues.containsKey(COST))
                modifierCosts[attribute] = (modifierValues[COST] as Number).toDouble()
            attributeValues[attribute] = (modifierValues[VALUES] as List<Number>).map(Number::toDouble)
        }

        return constructModule(pattern, name, items, mana, modifierCosts, attributeValues)
    }

    private fun constructModule(pattern: Pattern, name: String, items: List<Item>, mana: Double, modifierCosts: Map<String, Double>, attributeValues: Map<String, List<Double>>): Module {
        return when (pattern) {
            is PatternShape -> ModuleShape(pattern, name, items, mana, modifierCosts, attributeValues)
            is PatternEffect -> ModuleEffect(pattern, name, items, mana, modifierCosts, attributeValues)
            else -> throw JsonParseException("Pattern was an illegal type: ${pattern.javaClass}")
        }
    }
}