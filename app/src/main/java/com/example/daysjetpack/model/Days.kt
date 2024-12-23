package com.example.daysjetpack.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.daysjetpack.R

data class Days(
    @DrawableRes val imageRes: Int,
    @StringRes val titleRes: Int,
    @StringRes val descRes: Int
)

object DayRepo {
    val days = listOf(
        Days(R.drawable.day_1, R.string.day_1_title, R.string.day_1_description),
    )
}
