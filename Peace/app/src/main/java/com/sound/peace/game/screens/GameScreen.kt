package com.sound.peace.game.screens

import com.sound.peace.game.actors.main.AMainGame
import com.sound.peace.game.utils.Block
import com.sound.peace.game.utils.advanced.AdvancedMainScreen
import com.sound.peace.game.utils.advanced.AdvancedStage
import com.sound.peace.game.utils.gdxGame
import com.sound.peace.game.utils.region

class GameScreen(): AdvancedMainScreen() {

    override val aMain = AMainGame(this)

    override fun show() {
        setBackBackground(gdxGame.assetsLoader.BACKGROUND.region)
        super.show()
    }

    override fun AdvancedStage.addActorsOnStageUI() {
        addMain()
    }

    override fun hideScreen(block: Block) {
        aMain.animHideMain { block() }
    }

    override fun AdvancedStage.addMain() {
        addAndFillActor(aMain)
    }

}