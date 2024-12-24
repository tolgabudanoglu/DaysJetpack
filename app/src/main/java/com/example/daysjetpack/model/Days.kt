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
        Days(R.drawable.day_2, R.string.day_2_title, R.string.day_2_description),
        Days(R.drawable.day_3, R.string.day_3_title, R.string.day_3_description),
        Days(R.drawable.day_4, R.string.day_4_title, R.string.day_4_description),
        Days(R.drawable.day_5, R.string.day_5_title, R.string.day_5_description),
        Days(R.drawable.day_6, R.string.day_6_title, R.string.day_6_description),
        Days(R.drawable.day_7, R.string.day_7_title, R.string.day_7_description),
        Days(R.drawable.day_8, R.string.day_8_title, R.string.day_8_description),
        Days(R.drawable.day_9, R.string.day_9_title, R.string.day_9_description),
        Days(R.drawable.day_10, R.string.day_10_title, R.string.day_10_description),
        Days(R.drawable.day_11, R.string.day_11_title, R.string.day_11_description),
        Days(R.drawable.day_12, R.string.day_12_title, R.string.day_12_description),
        Days(R.drawable.day_13, R.string.day_13_title, R.string.day_13_description),
        Days(R.drawable.day_14, R.string.day_14_title, R.string.day_14_description),
        Days(R.drawable.day_15, R.string.day_15_title, R.string.day_15_description),
        Days(R.drawable.day_16, R.string.day_16_title, R.string.day_16_description),
        Days(R.drawable.day_17, R.string.day_17_title, R.string.day_17_description),
        Days(R.drawable.day_18, R.string.day_18_title, R.string.day_18_description),
        Days(R.drawable.day_19, R.string.day_19_title, R.string.day_19_description),
        Days(R.drawable.day_20, R.string.day_20_title, R.string.day_20_description),
        Days(R.drawable.day_21, R.string.day_21_title, R.string.day_21_description),
        Days(R.drawable.day_22, R.string.day_22_title, R.string.day_22_description),
        Days(R.drawable.day_23, R.string.day_23_title, R.string.day_23_description),
        Days(R.drawable.day_24, R.string.day_24_title, R.string.day_24_description),
        Days(R.drawable.day_25, R.string.day_25_title, R.string.day_25_description),
        Days(R.drawable.day_26, R.string.day_26_title, R.string.day_26_description),
        Days(R.drawable.day_27, R.string.day_27_title, R.string.day_27_description),
        Days(R.drawable.day_28, R.string.day_28_title, R.string.day_28_description),
        Days(R.drawable.day_29, R.string.day_29_title, R.string.day_29_description),
        Days(R.drawable.day_30, R.string.day_30_title, R.string.day_30_description)
    )
}
