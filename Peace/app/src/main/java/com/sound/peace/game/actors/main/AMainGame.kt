package com.sound.peace.game.actors.main

import com.badlogic.gdx.math.Interpolation
import com.badlogic.gdx.scenes.scene2d.actions.Actions
import com.badlogic.gdx.utils.Align
import com.sound.peace.game.actors.button.AButton
import com.sound.peace.game.screens.GameScreen
import com.sound.peace.game.utils.TIME_ANIM
import com.sound.peace.game.utils.actor.animDelay
import com.sound.peace.game.utils.actor.animHide
import com.sound.peace.game.utils.actor.animShow
import com.sound.peace.game.utils.actor.setBounds
import com.sound.peace.game.utils.actor.setOnClickListener
import com.sound.peace.game.utils.advanced.AdvancedMainGroup
import com.sound.peace.game.utils.gdxGame

class AMainGame(override val screen: GameScreen): AdvancedMainGroup() {

    private val btnYra = AButton(screen, AButton.Type.YRA)
    private val btnMir = AButton(screen, AButton.Type.MIR)
    private val btnTak = AButton(screen, AButton.Type.TAK)

    override fun addActorsOnGroup() {
        addBtns()
    }

    override fun animShowMain(blockEnd: Runnable) {
        children.onEach { it.clearActions() }

        this.animShow(TIME_ANIM)
        this.animDelay(TIME_ANIM) { blockEnd.run() }
    }

    override fun animHideMain(blockEnd: Runnable) {
        children.onEach { it.clearActions() }

        this.animHide(TIME_ANIM)
        this.animDelay(TIME_ANIM) { blockEnd.run() }
    }

    // Actors ------------------------------------------------------------------------

    private fun addBtns() {
        addActors(btnYra, btnMir, btnTak)
        btnYra.apply {
            setBounds(248f, 668f, 584f, 584f)
            setOnClickListener(gdxGame.soundUtil.YRA) {}
        }
        btnMir.apply {
            setBounds(92f, 355f, 313f, 313f)
            setOnClickListener(gdxGame.soundUtil.MIR) {}
        }
        btnTak.apply {
            setBounds(676f, 355f, 313f, 313f)
            setOnClickListener(gdxGame.soundUtil.TAK) {}
        }
    }

}