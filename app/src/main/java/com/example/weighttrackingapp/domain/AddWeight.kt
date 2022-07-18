package com.example.weighttrackingapp.domain

import com.example.weighttrackingapp.data.local.WeightDao
import com.example.weighttrackingapp.data.local.WeightEntity
import com.example.weighttrackingapp.utils.extensions.endOfDay
import com.example.weighttrackingapp.utils.extensions.startOfDay
import java.util.*
import javax.inject.Inject

class AddWeight @Inject constructor(private val dao: WeightDao) {

    suspend operator fun invoke(weight: String,date: Date) {
        val weightList = dao.fetchBy(
            startDate = date.startOfDay(),
            endDate = date.endOfDay()
        )
        if (weightList.isEmpty()) {
            dao.save(
                WeightEntity(
                    timestamp = date,
                    value = weight.toFloat(),
                )
            )
        } else {
            dao.update(
                WeightEntity(
                    uid = weightList.first().uid,
                    timestamp = date,
                    value = weight.toFloat(),
                )
            )
        }
    }
}