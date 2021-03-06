package org.bomber.model.script

sealed class Script

data class RestScript(
    val id: String,
    val name: String,
    val address: String,
    val requestMethod: String,
    val configuration: RestConfiguration
) : Script()