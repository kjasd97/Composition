package com.ulyanenko.composition.domain.repository

import com.ulyanenko.composition.domain.entity.GameSettings
import com.ulyanenko.composition.domain.entity.Level
import com.ulyanenko.composition.domain.entity.Question

interface GameRepository {

    fun generateQuestion(
        maxSumValue: Int,
        countOfOptions: Int
    ): Question

    fun getGameSettings(level: Level): GameSettings
}