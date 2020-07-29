package me.duncte123.elgatokeylightcontroller.keylight.service

import me.duncte123.elgatokeylightcontroller.keylight.models.Keylight
import okhttp3.OkHttpClient
import org.slf4j.LoggerFactory
import javax.jmdns.ServiceInfo

class KeylightController {
    private val logger = LoggerFactory.getLogger(KeylightController::class.java)
    val client = OkHttpClient()

    val lights = mutableMapOf<String, Keylight>()

    fun shutdown() {
        client.connectionPool.evictAll()
        client.dispatcher.executorService.shutdown()
    }

    fun addLight(info: ServiceInfo) {
        logger.info("Adding ${info.name}")

        if (lights.containsKey(info.name)) {
            logger.warn("Light ${info.name} is already registered, ${lights[info.name]}")
            return
        }

        lights[info.name] = Keylight(
            this,
            info.inet4Addresses.first().toString(),
            info.port,
            info.name
        )

        println(lights[info.name])
    }
}