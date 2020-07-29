package me.duncte123.elgatokeylightcontroller.keylight.models

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import me.duncte123.elgatokeylightcontroller.keylight.models.base.KeylightJson

data class KeyLightOptions @JsonCreator constructor(
        @JsonProperty("numberOfLights") var numberOfLights: Int,
        @JsonProperty("lights") val lights: List<Light> = mutableListOf()
) : KeylightJson {
    data class Light(
            @JsonProperty("on") var on: Int,
            @JsonProperty("brightness") var brightness: Int,
            @JsonProperty("temperature") var temperature: Int
    )
}