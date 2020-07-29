package me.duncte123.elgatokeylightcontroller.keylight.models

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import me.duncte123.elgatokeylightcontroller.keylight.models.base.KeylightJson

data class KeyLightInfo @JsonCreator constructor(
    @JsonProperty("productName") val productName: String,
    @JsonProperty("hardwareBoardType") val hardwareBoardType: Int,
    @JsonProperty("firmwareBuildNumber") val firmwareBuildNumber: Int,
    @JsonProperty("firmwareVersion") val firmwareVersion: String,
    @JsonProperty("serialNumber") val serialNumber: Int,
    // This one we can actually change (idk how but we can)
    @JsonProperty("displayName") var displayName: String,
    @JsonProperty("features") val features: List<String>
) : KeylightJson