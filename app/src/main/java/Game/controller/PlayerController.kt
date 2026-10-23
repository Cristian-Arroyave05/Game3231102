package Game.controller

import Game.model.Player

class PlayerController {
    fun moveTo(
        player: Player,
        x: Float,
        y: Float
    ): Player{
        return player.copy(
            x=x,
            y=y
        )
    }
}