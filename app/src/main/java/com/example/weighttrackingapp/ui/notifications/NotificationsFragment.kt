package com.example.weighttrackingapp.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.weighttrackingapp.databinding.FragmentDashboardBinding
import com.example.weighttrackingapp.databinding.FragmentNotificationsBinding
import com.example.weighttrackingapp.ui.dashboard.DashboardViewModel
import com.example.weighttrackingapp.utils.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NotificationsFragment : Fragment() {

    private val binding by viewBinding(FragmentNotificationsBinding::bind)
    private val viewModel: NotificationsViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}