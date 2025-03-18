package dev.znci.rocket.scripting.registry

import dev.znci.rocket.scripting.lang.LuaType

object Registry {

    val typeMap = mutableMapOf<Any, LuaType<*>>()

    inline fun <reified T : Any> registerType(luaType: LuaType<T>) {
        typeMap[T::class.java] = luaType as LuaType<*>
    }

    fun getFromType(bukkitType: Any): LuaType<*>? {
        return typeMap[bukkitType]
    }

}