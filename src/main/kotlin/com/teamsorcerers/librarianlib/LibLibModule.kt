package com.teamsorcerers.librarianlib

import com.teamsorcerers.librarianlib.core.util.ModLogManager
import org.apache.logging.log4j.Logger

public abstract class LibLibModule(public val name: String, public val humanName: String) {
    public val logManager: ModLogManager = ModLogManager(name, "LibrarianLib: $humanName")

    /**
     * Create a logger for the given class.
     */
    public fun makeLogger(clazz: Class<*>): Logger = logManager.makeLogger(clazz.simpleName)

    /**
     * Create a logger for the specified class.
     */
    public inline fun <reified T> makeLogger(): Logger = logManager.makeLogger<T>()

    /**
     * Create a logger with the given name.
     */
    public fun makeLogger(label: String?): Logger = logManager.makeLogger(label)
}