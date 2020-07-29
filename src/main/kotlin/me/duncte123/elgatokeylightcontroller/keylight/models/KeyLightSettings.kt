package me.duncte123.elgatokeylightcontroller.keylight.models

data class KeyLightSettings(
    var powerOnBehavior: Int,
    var powerOnBrightness: Int,
    var powerOnTemperature: Int,
    var switchOnDurationMs: Int,
    var switchOffDurationMs: Int,
    var colorChangeDurationMs: Int
)