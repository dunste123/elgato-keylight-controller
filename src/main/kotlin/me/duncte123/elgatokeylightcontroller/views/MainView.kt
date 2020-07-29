package me.duncte123.elgatokeylightcontroller.views

import me.duncte123.elgatokeylightcontroller.utils.lightController
import tornadofx.*

class MainView: View("Main") {
    override val root = vbox(spacing = 20) {
        button("Press me") {
            action {
                println("Pressed")

                lightController.lights.values.forEach {
                    it.toggleLight()
                }
            }
        }
        label("Waiting")
    }
}