package com.plcoding.onboarding.domain.usecase

import com.plcoding.core.util.UIText
import com.plcoding.onboarding.domain.R

class ValidateNutrients {

    operator fun invoke(
        carbsRationText: String,
        proteinRatioText: String,
        fatRatioText: String,
    ): Result {
        val carbsRation = carbsRationText.toIntOrNull()
        val proteinRatio = proteinRatioText.toIntOrNull()
        val fatRatio = fatRatioText.toIntOrNull()

        if (carbsRation == null || proteinRatio == null || fatRatio == null) {
            return Result.Error(UIText.StringResource(R.string.error_invalid_values))
        }
        if (carbsRation + proteinRatio + fatRatio != 100) {
            return Result.Error(UIText.StringResource(R.string.error_not_100_percent))
        }
        return Result.Success(
            carbsRation / 100f,
            proteinRatio / 100f,
            fatRatio / 100f,
        )
    }

    sealed class Result {
        data class Success(
            val carbsRation: Float,
            val proteinRatio: Float,
            val fatRatio: Float,
        ) : Result()

        data class Error(
            val message: UIText,
        ) : Result()
    }
}
