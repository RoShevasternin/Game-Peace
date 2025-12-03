package com.sound.peace.game.actors.main

import com.badlogic.gdx.math.Interpolation
import com.badlogic.gdx.scenes.scene2d.actions.Actions
import com.badlogic.gdx.scenes.scene2d.ui.Image
import com.badlogic.gdx.utils.Align
import com.sound.peace.game.screens.LoaderScreen
import com.sound.peace.game.utils.TIME_ANIM
import com.sound.peace.game.utils.actor.animDelay
import com.sound.peace.game.utils.actor.animHide
import com.sound.peace.game.utils.actor.animShow
import com.sound.peace.game.utils.advanced.AdvancedMainGroup
import com.sound.peace.game.utils.gdxGame

class AMainLoader(override val screen: LoaderScreen): AdvancedMainGroup() {

    private val imgLoader = Image(gdxGame.assetsLoader.loader)

    override fun addActorsOnGroup() {
        addLoader()
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

    private fun addLoader() {
        addActor(imgLoader)
        imgLoader.apply {
            setBounds(365f, 784f, 349f, 349f)
            setOrigin(Align.center)
            addAction(Actions.forever(Actions.rotateBy(-360f, 1f, Interpolation.linear)))
        }
    }

}