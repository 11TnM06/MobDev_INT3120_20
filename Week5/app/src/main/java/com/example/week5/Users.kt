package com.example.week5

import kotlinx.parcelize.Parcelize
@Parcelize
data class Users(

    var name: String? = null,

    var email: String? = null,

    var password: String? = null,

    var avatar: String? = null,

    var fitems: List<String>? = null,

    var fcollections: List<String>? = null,

    var fstories: List<String>? = null

) : MuseumModel()
