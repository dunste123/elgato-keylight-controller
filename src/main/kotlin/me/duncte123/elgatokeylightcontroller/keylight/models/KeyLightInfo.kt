package me.duncte123.elgatokeylightcontroller.keylight.models

data class KeyLightInfo(
    val productName: String,
    val hardwareBoardType: Int,
    val firmwareBuildNumber: Int,
    val firmwareVersion: String,
    val serialNumber: Int,
    // This one we can actually change (idk how but we can)
    var displayName: String,
    val features: List<String>
)