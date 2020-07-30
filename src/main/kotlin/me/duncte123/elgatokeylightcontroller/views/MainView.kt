package me.duncte123.elgatokeylightcontroller.views

import javafx.collections.FXCollections
import me.duncte123.elgatokeylightcontroller.utils.lightService
import tornadofx.*

class MainView : View("Main") {
    val controller: KeylightController by inject()

    override val root = vbox(spacing = 20) {
        hbox {
            label("Toggle lights")
            button("Press me") {
                action {
                    println("Pressed")

                    lightService.lights.values.forEach {
                        it.toggleLight()
                    }
                }
            }
        }
        listview(controller.values)
    }
}

class KeylightController : Controller() {
    val values = FXCollections.observableArrayList(lightService.lights.values.map { it.info!!.displayName })
}