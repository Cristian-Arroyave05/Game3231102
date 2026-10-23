package Game

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import Game.model.Player
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.vector.PathNode

@Composable
fun GameCanvas(
    player: Player,
    modifier: Modifier = Modifier,
    onCanvasSizeChanged: (Width: Float, height: Float) -> Unit
){
    Canvas(
        modifier = modifier
            .fillMaxSize()

    ) {
        // Dibujar el fondo del area de juego
        drawRect(
            color = Color.White,
            size = size
        )
        // Dibujar la nave como un rectangulo provisional
        val shipWidth=60f
        val shipHeight=40f
        val shipPath = Path().apply {
            moveTo(
                x = player.x + shipWidth / 2f,
                y = player.y
            )
            lineTo(
                x = player.x + shipWidth,
                y = player.y +shipHeight
            )
            lineTo(
                x = player.x ,
                y = player.y +shipHeight
            )
            close()


        }
        drawPath(
            path = shipPath,
            color = Color.Blue
        )
    }
}