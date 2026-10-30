package Game.controller

import Game.model.Player

class PlayerController {
    fun moveTo(
        player: Player,
        x: Float,
        y: Float,
        canvasWidth: Float,
        canvasHeight: Float
    ): Player{
        val shipWidth = 60f
        val shipHeight = 50f
        //Ajustar la posocion de la nave dentro de los limites del area de juego
        val maxX = (canvasWidth - shipWidth).coerceAtLeast(minimumValue = 0f)
        val maxY = (canvasHeight - shipHeight).coerceAtLeast(minimumValue = 0f)
        //Restringir la posicion de la nave dentro del area de juego
        val limitedx = x.coerceIn(0f, maxX)
        val limitedy = y.coerceIn(0f, maxY)
        return player.copy(
            x=limitedx,
            y=limitedy
        )
    }
}