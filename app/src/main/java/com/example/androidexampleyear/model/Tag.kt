package com.example.androidexampleyear.model

import androidx.annotation.ColorRes
import com.example.androidexampleyear.R

enum class Tag(
    val description: String,
    @ColorRes val resId: Int
) {
    DB("Persistence", R.color.teal_200),
    UI("UI/UX", R.color.teal_200),
    AR_VR("AR/VR", R.color.teal_200),
    ARCH("Architecture", R.color.teal_200),
    WEB("Web", R.color.teal_200),
    CAM("Camera", R.color.teal_200),
    MAPS("Maps", R.color.teal_200),
    ML("Machine Learning & CV", R.color.teal_200),
    IOT("IoT", R.color.teal_200),
    JETPACK("Jetpack Compose", R.color.teal_200),
    MEDIA("Media", R.color.teal_200),
    KOTLIN_NATIVE("Kotlin/Native", R.color.teal_200),
    KOTLIN_JS("Kotlin/JS", R.color.teal_200),
    OTHER("Other", R.color.teal_200);

    override fun toString(): String {
        return description
    }
}