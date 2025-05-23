/**
 * Copyright 2025 znci
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package dev.znci.rocket.scripting.util

import org.bukkit.Bukkit
import org.bukkit.World
import java.util.*

/**
 * Retrieves a world from the server by either its name or UUID.
 * If the provided string is a valid world name, it fetches the corresponding world.
 * If the string is a valid UUID, it tries to fetch the world using with that UUID.
 * If neither a world by name nor by UUID exists, it throws an error.
 *
 * @param worldNameOrUUID The name or UUID of the world to retrieve.
 * @return The `World` object corresponding to the provided name or UUID.
 * @throws IllegalArgumentException If the provided string is neither a valid world name nor a valid UUID.
 * @throws IllegalStateException If the world could not be found by name or UUID.
 */
fun getWorldByNameOrUUID(worldNameOrUUID: String): World {
    return Bukkit.getWorld(worldNameOrUUID) ?:
    try {
        Bukkit.getWorld(UUID.fromString(worldNameOrUUID))
    } catch (_: IllegalArgumentException) {
        null
    } ?: error("World '$worldNameOrUUID' not found!")
}