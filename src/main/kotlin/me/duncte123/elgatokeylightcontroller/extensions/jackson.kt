package me.duncte123.elgatokeylightcontroller.extensions

import com.fasterxml.jackson.databind.JsonNode
import me.duncte123.elgatokeylightcontroller.utils.jackson
import me.duncte123.elgatokeylightcontroller.utils.jsonMediaType
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody

fun JsonNode.toRequestBody(): RequestBody {
    return jackson.writeValueAsBytes(this).toRequestBody(jsonMediaType)
}