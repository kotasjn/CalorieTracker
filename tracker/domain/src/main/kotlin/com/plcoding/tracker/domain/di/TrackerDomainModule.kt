package com.plcoding.tracker.domain.di

import com.plcoding.core.domain.preferences.Preferences
import com.plcoding.tracker.domain.repository.TrackerRepository
import com.plcoding.tracker.domain.usecase.CalculateMealNutrients
import com.plcoding.tracker.domain.usecase.DeleteTrackedFood
import com.plcoding.tracker.domain.usecase.GetFoodsForDate
import com.plcoding.tracker.domain.usecase.SearchFood
import com.plcoding.tracker.domain.usecase.TrackFood
import com.plcoding.tracker.domain.usecase.TrackerUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object TrackerDomainModule {

    @ViewModelScoped
    @Provides
    fun provideTrackerUseCases(
        repository: TrackerRepository,
        preferences: Preferences,
    ): TrackerUseCases {
        return TrackerUseCases(
            trackFood = TrackFood(repository),
            searchFood = SearchFood(repository),
            getFoodsForDate = GetFoodsForDate(repository),
            deleteTrackedFood = DeleteTrackedFood(repository),
            calculateMealNutrients = CalculateMealNutrients(preferences),
        )
    }
}
