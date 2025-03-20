package dev.znci.rocket.scripting.lang

import dev.znci.rocket.scripting.registry.Registry
import org.luaj.vm2.LuaTable
import org.luaj.vm2.LuaValue

/**
 *
 * [LuaType] is a pseudo-interface that allows for the determination of a Java->Lua type
 *
 * @param J Java type
 *
 */
abstract class LuaType<J> : LuaTable() {

    open fun get(value: J): LuaValue {
        return LuaValue.valueOf(value.toString())
    }

}