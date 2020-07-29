package me.duncte123.elgatokeylightcontroller.keylight.models

data class Keylight(
    val ip: String,
    val port: Int,
    var name: String,
    var settings: KeyLightSettings? = null,
    var info: KeyLightInfo? = null,
    var options: KeyLightOptions? = null
)