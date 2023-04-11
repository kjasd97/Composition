package com.ulyanenko.composition.domain.usecases

import com.ulyanenko.composition.domain.entity.GameSettings
import com.ulyanenko.composition.domain.entity.Level
import com.ulyanenko.composition.domain.repository.GameRepository

class GetGameSettingsUseCase(
    private val repository: GameRepository
) {

    operator fun invoke(level: Level): GameSettings {
        return repository.getGameSettings(level)
    }
}