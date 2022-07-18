package com.example.weighttrackingapp.data.repository

import com.example.weighttrackingapp.data.local.WeightDao
import javax.inject.Inject

class WeightRepository @Inject constructor(
    private val dbDao: WeightDao
) {
    fun getAllWeights() = dbDao.getAllWeights()
}