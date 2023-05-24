package com.plcoding.core.util

sealed class UIEvent {
    object Success : UIEvent()

    object NavigateUp : UIEvent()

    data class ShowSnackBar(val message: UIText) : UIEvent()
}
