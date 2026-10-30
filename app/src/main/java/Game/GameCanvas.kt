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
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.unit.IntSize

@Composable
fun GameCanvas(
    player: Player?,
    modifier: Modifier = Modifier,
    onCanvasSizeChanged: (width: Float, height: Float) -> Unit
) {
    Canvas(
        modifier = modifier
            .fillMaxSize()
            .onSizeChanged{size: IntSize->
                onCanvasSizeChanged(size.width.toFloat(),
                    size.height.toFloat())
            }
    ) {
        // Dibujar el fondo del area de juego
        drawRect(
            color = Color.Black ,
            size = size
        )
        //Dibujar la nave como un rectangulo  provisional
        player?.let {
                ship ->
            val shipWidth=60f
            val shipHeight=50f
            val shipPath = Path().apply {
                moveTo(
                    x = ship.x + shipWidth / 2f,
                    y = ship.y
                )
                lineTo(
                    x = ship.x + shipWidth,
                    y = ship.y + shipHeight
                )
                lineTo(
                    x = ship.x,
                    y = ship.y + shipHeight
                )
                close()
            }
            drawPath(
                path = shipPath,
                color = Color.Blue
            )
        }



    }
}