package me.duncte123.elgatokeylightcontroller.keylight.models

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import me.duncte123.elgatokeylightcontroller.keylight.models.base.KeylightJson

data class KeyLightSettings @JsonCreator constructor(
        @JsonProperty("powerOnBehavior") var powerOnBehavior: Int,
        @JsonProperty("powerOnBrightness") var powerOnBrightness: Int,
        @JsonProperty("powerOnTemperature") var powerOnTemperature: Int,
        @JsonProperty("switchOnDurationMs") var switchOnDurationMs: Int,
        @JsonProperty("switchOffDurationMs") var switchOffDurationMs: Int,
        @JsonProperty("colorChangeDurationMs") var colorChangeDurationMs: Int
) : KeylightJson