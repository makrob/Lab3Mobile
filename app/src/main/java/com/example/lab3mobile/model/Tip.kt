package com.example.lab3mobile.model

import java.io.Serializable

data class Tip(
    val id: Int,
    val day: Int,
    val title: String,
    val description: String,
    val imageResId: Int
) : Serializable