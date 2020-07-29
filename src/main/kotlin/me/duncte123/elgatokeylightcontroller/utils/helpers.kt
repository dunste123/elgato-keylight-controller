package me.duncte123.elgatokeylightcontroller.utils

import com.fasterxml.jackson.databind.ObjectMapper
import okhttp3.MediaType.Companion.toMediaType

val jsonMediaType = "application/json; charset=utf-8".toMediaType()

val jackson = ObjectMapper()