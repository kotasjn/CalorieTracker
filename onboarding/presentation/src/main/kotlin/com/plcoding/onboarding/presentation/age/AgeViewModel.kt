package com.plcoding.onboarding.presentation.age

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.plcoding.core.R
import com.plcoding.core.domain.preferences.Preferences
import com.plcoding.core.domain.usecase.FilterOutDigits
import com.plcoding.core.navigation.Route
import com.plcoding.core.util.UIEvent
import com.plcoding.core.util.UiText
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AgeViewModel @Inject constructor(
    private val preferences: Preferences,
    private val filterOutDigits: FilterOutDigits,
) : ViewModel() {
    var age by mutableStateOf("20")
        private set

    private val _uiEvent = Channel<UIEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onAgeEnter(age: String) {
        if (age.length <= 3) {
            this.age = filterOutDigits(age)
        }
    }

    fun onNextClick() {
        viewModelScope.launch {
            val ageNumber = age.toIntOrNull() ?: kotlin.run {
                _uiEvent.send(
                    UIEvent.ShowSnackBar(UiText.StringResource(R.string.error_age_cant_be_empty)),
                )
                return@launch
            }
            preferences.saveAge(ageNumber)
            _uiEvent.send(UIEvent.Navigate(Route.HEIGHT))
        }
    }
}
