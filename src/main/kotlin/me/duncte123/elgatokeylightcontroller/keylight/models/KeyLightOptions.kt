package me.duncte123.elgatokeylightcontroller.keylight.models

data class KeyLightOptions(var numberOfLights: Int, val light: List<Light> = mutableListOf()) {
    data class Light(var on: Int, var brightness: Int, var temperature: Int)
}