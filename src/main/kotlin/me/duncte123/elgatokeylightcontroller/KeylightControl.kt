package me.duncte123.elgatokeylightcontroller

import me.duncte123.elgatokeylightcontroller.keylight.service.Bonjour
import me.duncte123.elgatokeylightcontroller.utils.lightController
import me.duncte123.elgatokeylightcontroller.views.MainView
import tornadofx.App

class KeylightControl: App(MainView::class) {
    private val bonjour = Bonjour()

    override fun stop() {
        super.stop()

        // shut the service down when we close the window
        bonjour.shutdown()
        lightController.shutdown()
    }
}