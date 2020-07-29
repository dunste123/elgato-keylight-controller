package me.duncte123.elgatokeylightcontroller.keylight.models

import me.duncte123.elgatokeylightcontroller.extensions.loadKeylightData
import me.duncte123.elgatokeylightcontroller.extensions.toRequestBody
import me.duncte123.elgatokeylightcontroller.keylight.service.KeylightController
import me.duncte123.elgatokeylightcontroller.utils.jackson
import okhttp3.*
import java.io.IOException

// This class is manually build
data class Keylight(
    val controller: KeylightController,
    val ip: String,
    val port: Int,
    val name: String,
    var settings: KeyLightSettings? = null,
    var info: KeyLightInfo? = null,
    var options: KeyLightOptions? = null
) {
    private val url = "http://$ip:$port/elgato"
    val lightsUrl = "$url/lights"
    val settingsUrl = "$url/lights/settings"
    val accessoryInfoUrl = "$url/accessory-info"


    init {
        try {
            settings = loadKeylightData(settingsUrl, KeyLightSettings::class.java)
            println("Settings $settings")
            info = loadKeylightData(accessoryInfoUrl, KeyLightInfo::class.java)
            println("Info $info")
            options = loadKeylightData(lightsUrl, KeyLightOptions::class.java)
            println("Options $options")
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun toggleLight() {
        val light = options!!.lights.first()

        light.on = if (light.on == 1) 0 else 1

        updateOptions(controller.client)
    }

    fun updateOptions(client: OkHttpClient) {
        val request = Request.Builder()
            .put(options!!.toRequestBody())
            .url(lightsUrl)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                e.printStackTrace()
            }

            override fun onResponse(call: Call, response: Response) {
                response.use {
                    options = jackson.readValue(
                        jackson.readTree(it.body!!.byteStream()).traverse(),
                        KeyLightOptions::class.java
                    )
                }
            }
        })
    }
}