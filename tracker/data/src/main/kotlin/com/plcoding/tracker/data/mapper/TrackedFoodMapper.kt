package com.plcoding.tracker.data.mapper

import com.plcoding.tracker.data.local.entity.TrackedFoodEntity
import com.plcoding.tracker.domain.model.MealType
import com.plcoding.tracker.domain.model.TrackedFood
import java.time.LocalDate

fun TrackedFoodEntity.toTrackableFood(): TrackedFood {
    return TrackedFood(
        name = name,
        carbs = carbs,
        protein = protein,
        fat = fat,
        imageUrl = imageUrl,
        mealType = MealType.fromString(type),
        amount = amount,
        date = LocalDate.of(year, month, dayOfMonth),
        calories = calories,
    )
}

fun TrackedFood.toTrackedFoodEntity(): TrackedFoodEntity {
    return TrackedFoodEntity(
        name = name,
        carbs = carbs,
        protein = protein,
        fat = fat,
        imageUrl = imageUrl,
        amount = amount,
        type = mealType.name,
        dayOfMonth = date.dayOfMonth,
        month = date.monthValue,
        year = date.year,
        calories = calories,
        id = id,
    )
}
