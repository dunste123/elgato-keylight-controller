package me.duncte123.elgatokeylightcontroller.extensions

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import me.duncte123.elgatokeylightcontroller.keylight.models.base.KeylightJson

private val jackson = ObjectMapper()

fun KeylightJson.toJson(): JsonNode {
    return jackson.valueToTree(this)
}