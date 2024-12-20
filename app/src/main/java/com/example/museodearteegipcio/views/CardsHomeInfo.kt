package com.example.museodearteegipcio.views

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class CardsHomeInfo (
        @DrawableRes val picture: Int,
        @StringRes val title: Int,
        @StringRes val description: Int,
)