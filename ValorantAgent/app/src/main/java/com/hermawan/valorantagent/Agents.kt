package com.hermawan.valorantagent

data class Agents (
    var name: String = "",
    var role: String = "",
    var bio: String = "",
    var skill: ArrayList<ArrayList<String>> = ArrayList(4),
    var photo: Int = 0
    )