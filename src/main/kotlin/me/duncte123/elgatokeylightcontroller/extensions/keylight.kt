package me.duncte123.elgatokeylightcontroller.extensions

import com.fasterxml.jackson.databind.JsonNode
import me.duncte123.elgatokeylightcontroller.keylight.models.Keylight
import me.duncte123.elgatokeylightcontroller.keylight.models.base.KeylightJson
import me.duncte123.elgatokeylightcontroller.utils.jackson
import okhttp3.Request
import okhttp3.RequestBody


fun KeylightJson.toJson(): JsonNode {
    return jackson.valueToTree(this)
}

fun KeylightJson.toRequestBody(): RequestBody {
    return this.toJson().toRequestBody()
}

fun <T> Keylight.loadKeylightData(url: String, klass: Class<T>): T {
    val request = Request.Builder()
        .get()
        .url(url)
        .build()

    this.service.client.newCall(request).execute().use { res ->
        val json = jackson.readTree(res.body!!.byteStream())

        return jackson.readValue(json.traverse(), klass)
    }
}