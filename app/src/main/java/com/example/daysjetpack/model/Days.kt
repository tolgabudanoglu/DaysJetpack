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
    val days = (1..30).map { day ->
        Days(
            imageRes = R.drawable::class.java.getField("day_$day").getInt(null),
            titleRes = R.string::class.java.getField("day_${day}_title").getInt(null),
            descRes = R.string::class.java.getField("day_${day}_description").getInt(null)
        )
    }
}
