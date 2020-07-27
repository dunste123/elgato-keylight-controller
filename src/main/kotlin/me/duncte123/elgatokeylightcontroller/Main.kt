package me.duncte123.elgatokeylightcontroller

import tornadofx.*

/*
Elgato type: elg (https://github.com/NickParks/elgato-light-api/blob/master/src/ElgatoLightAPI.ts#L23)
DNS url (guess): _elg._tcp.local (https://github.com/watson/bonjour/blob/master/lib/browser.js#L44)
dns service: https://github.com/jmdns/jmdns
 */

fun main(args: Array<String>) {
    launch<KeylightControl>(args)
}