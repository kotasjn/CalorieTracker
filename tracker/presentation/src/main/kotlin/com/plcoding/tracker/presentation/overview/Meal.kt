package com.plcoding.tracker.presentation.overview

import androidx.annotation.DrawableRes
import com.plcoding.core.util.UIText
import com.plcoding.tracker.domain.model.MealType
import com.plcoding.tracker.presentation.R

data class Meal(
    val name: UIText,
    @DrawableRes val drawableRes: Int,
    val mealType: MealType,
    val carbs: Int = 0,
    val protein: Int = 0,
    val fat: Int = 0,
    val calories: Int = 0,
    val isExpanded: Boolean = false,
)

val defaultMeals = listOf(
    Meal(
        name = UIText.StringResource(R.string.breakfast),
        drawableRes = R.drawable.ic_breakfast,
        mealType = MealType.Breakfast,
    ),
    Meal(
        name = UIText.StringResource(R.string.lunch),
        drawableRes = R.drawable.ic_lunch,
        mealType = MealType.Lunch,
    ),
    Meal(
        name = UIText.StringResource(R.string.dinner),
        drawableRes = R.drawable.ic_dinner,
        mealType = MealType.Dinner,
    ),
    Meal(
        name = UIText.StringResource(R.string.snacks),
        drawableRes = R.drawable.ic_snack,
        mealType = MealType.Snack,
    ),
)
