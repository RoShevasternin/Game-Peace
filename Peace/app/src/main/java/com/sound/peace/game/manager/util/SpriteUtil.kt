package com.sound.peace.game.manager.util

import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.sound.peace.game.manager.SpriteManager

class SpriteUtil {

    class Loader {
        private fun getRegion(name: String): TextureRegion = SpriteManager.EnumAtlas.LOADER.data.atlas.findRegion(name)

        val loader = getRegion("loader")

        val BACKGROUND = SpriteManager.EnumTexture.BACKGROUND.data.texture
    }

    class All {
        private fun getAllRegion(name: String): TextureRegion = SpriteManager.EnumAtlas.ALL.data.atlas.findRegion(name)

        // atlas All ------------------------------------------------------------------------------
        val mir_def   = getAllRegion("mir_def")
        val mir_press = getAllRegion("mir_press")
        val tak_def   = getAllRegion("tak_def")
        val tak_press = getAllRegion("tak_press")
        val yra_def   = getAllRegion("yra_def")
        val yra_press = getAllRegion("yra_press")

    }

}