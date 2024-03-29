package com.example.weighttrackingapp.ui.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weighttrackingapp.utils.Constants
import com.orhanobut.hawk.Hawk
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel.Factory.BUFFERED
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor() : ViewModel() {
    sealed class Event {
        object NavigateToHome : Event()
        object NavigateToOnBoardingScreen : Event()
    }

    private val eventChannel = Channel<Event>(Channel.BUFFERED)
    val eventsFlow = eventChannel.receiveAsFlow()

    fun startSplash() = viewModelScope.launch {
        delay(1000)
        val shouldShowOnBoardingScreen = Hawk.get(Constants.Prefs.KEY_SHOULD_SHOW_ON_BOARDING, true)
        eventChannel.send(Event.NavigateToHome)
        /*
        if (shouldShowOnBoardingScreen) {
            eventChannel.send(Event.NavigateToOnBoardingScreen)
        } else {
            eventChannel.send(Event.NavigateToHome)
        }

         */
    }
}