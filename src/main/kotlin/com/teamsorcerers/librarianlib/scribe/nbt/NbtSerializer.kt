package com.teamsorcerers.librarianlib.scribe.nbt

import dev.thecodewarrior.mirror.type.TypeMirror
import dev.thecodewarrior.prism.DeserializationException
import dev.thecodewarrior.prism.Prism
import dev.thecodewarrior.prism.SerializationException
import dev.thecodewarrior.prism.Serializer
import net.minecraft.nbt.NbtCompound
import net.minecraft.nbt.NbtElement

typealias NbtPrism = Prism<NbtSerializer<*>>

abstract class NbtSerializer<T: Any>: Serializer<T> {
    constructor(type: TypeMirror): super(type)
    constructor(): super()

    protected abstract fun deserialize(tag: NbtElement): T
    protected abstract fun serialize(value: T): NbtElement

    fun read(tag: NbtElement): Any {
        try {
            return deserialize(tag)
        } catch (e: Exception) {
            throw DeserializationException("Error deserializing $type", e)
        }
    }

    @Suppress("UNCHECKED_CAST")
    fun write(value: Any): NbtElement {
        try {
            return serialize(value as T)
        } catch (e: Exception) {
            throw SerializationException("Error serializing $type", e)
        }
    }

    /**
     * Throws an exception if [tag] is null or it isn't the passed type, using [name] as the property name in the
     * message. The message will be one of:
     * - `Missing <<name>>`
     * - `Unexpected type <<actual type>> for <<name>>`
     */
    fun<T: NbtElement> expectType(tag: NbtElement?, type: Class<T>, name: String): T {
        if(tag == null)
            throw DeserializationException("Missing $name")
        if(!type.isAssignableFrom(tag.javaClass))
            throw DeserializationException("Unexpected type ${tag.nbtType.crashReportName} for $name")
        @Suppress("UNCHECKED_CAST")
        return tag as T
    }

    /**
     * Throws an exception if this tag is null or it isn't the passed type, using [name] as the property name in the
     * message. The message will be one of:
     * - `Missing <<name>>`
     * - `Unexpected type <<actual type>> for <<name>>`
     */
    inline fun<reified T: NbtElement> NbtElement?.expectType(name: String): T {
        return expectType(this, T::class.java, name)
    }

    /**
     * Throws an exception if [key] is missing from [compound] or it isn't the passed type.
     */
    fun<T: NbtElement> expect(compound: NbtCompound, key: String, type: Class<T>): T {
        val tag = compound[key] ?: throw DeserializationException("Missing `$key`")
        if(!type.isAssignableFrom(tag.javaClass))
            throw DeserializationException("Unexpected type ${tag.nbtType.crashReportName} for `$key`")
        @Suppress("UNCHECKED_CAST")
        return tag as T
    }

    /**
     * Throws an exception if [key] is missing from this tag or it isn't the passed type
     */
    inline fun<reified T: NbtElement> NbtCompound.expect(key: String): T {
        return expect(this, key, T::class.java)
    }
}