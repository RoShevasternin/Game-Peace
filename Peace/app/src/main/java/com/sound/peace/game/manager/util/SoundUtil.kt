package com.sound.peace.game.manager.util

import com.badlogic.gdx.audio.Sound
import com.sound.peace.game.manager.AudioManager
import com.sound.peace.game.utils.runGDX
import com.sound.peace.game.manager.SoundManager
import kotlin.compareTo
import kotlin.div
import kotlin.times

class SoundUtil {

    val click = AdvancedSound(SoundManager.EnumSound.click.data.sound, 1f)
    val MIR   = AdvancedSound(SoundManager.EnumSound.MIR.data.sound, 1f)
    val TAK   = AdvancedSound(SoundManager.EnumSound.TAK.data.sound, 1f)
    val YRA   = AdvancedSound(SoundManager.EnumSound.YRA.data.sound, 1f)

    // 0..100
    var volumeLevel = AudioManager.volumeLevelPercent

    var isPause = (volumeLevel <= 0f)

    fun play(advancedSound: AdvancedSound) {
        if (isPause.not()) {
            advancedSound.apply {
                sound.play((volumeLevel / 100f) * coff)
            }
        }
    }

    data class AdvancedSound(val sound: Sound, val coff: Float)
}