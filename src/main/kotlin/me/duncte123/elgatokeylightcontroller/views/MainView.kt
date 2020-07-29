package me.duncte123.elgatokeylightcontroller.views

import tornadofx.*

class MainView: View("Main") {
    override val root = vbox {
        button("Press me") {
            println("test")
        }
        label("Waiting")
    }
}