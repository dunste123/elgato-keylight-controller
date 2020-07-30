package me.duncte123.elgatokeylightcontroller.keylight.service

import me.duncte123.elgatokeylightcontroller.utils.lightService
import java.net.InetAddress
import javax.jmdns.JmDNS
import javax.jmdns.ServiceEvent
import javax.jmdns.ServiceListener

class Bonjour {
    private val jmdns = JmDNS.create(InetAddress.getLocalHost())

    init {
        jmdns.addServiceListener(KEYLIGHT_DOMAIN, TestListener())

        println("Booting Bonjour service")
    }

    fun shutdown() {
        jmdns.close()
    }

    class TestListener : ServiceListener {
        override fun serviceAdded(event: ServiceEvent) {
            println("Service added: ${event.info}")
        }

        override fun serviceRemoved(event: ServiceEvent) {
            println("Service removed: ${event.info}")
        }

        override fun serviceResolved(event: ServiceEvent) {
            println("Service resolved: ${event.info.inet4Addresses.joinToString { "$it:${event.info.port}" }}")
            println(event.info)

            lightService.addLight(event.info)
        }
    }

    companion object {
        const val KEYLIGHT_DOMAIN = "_elg._tcp.local."
    }
}