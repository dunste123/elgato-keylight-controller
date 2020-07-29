package me.duncte123.elgatokeylightcontroller.keylight.models

// This class is manually build
data class Keylight(
    val ip: String,
    val port: Int,
    val name: String,
    var settings: KeyLightSettings? = null,
    var info: KeyLightInfo? = null,
    var options: KeyLightOptions? = null
) {
    fun toggleLight() {
        val light = options?.lights?.firstOrNull()

        light?.on = if (light?.on == 1) 0 else 1
    }
}