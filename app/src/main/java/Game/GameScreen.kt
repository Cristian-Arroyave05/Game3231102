package Game

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import Game.model.Player

@Composable
fun GameScreen(
    modifier: Modifier = Modifier
){
    var player by remember {mutableStateOf<Player?>(null)}
    Box(modifier=Modifier.fillMaxSize()){
        val currentPlayer=player
        if(currentPlayer!=null){
            GameCanvas(
                player = currentPlayer,
                onCanvasSizeChanged={ width,height->
                    if(player==null) {
                        val shipWidth = 60f
                        val shipHeight = 50f
                        player = Player(
                            x = (width - shipWidth) / 2f,
                            y = (height - shipHeight) / 2f
                        )
                    }
                },
                modifier = Modifier.fillMaxSize()
            )
            Text(
                text = "Space Shooter",
                modifier = Modifier.align(Alignment.TopCenter),
                color = Color.White
            )
        }
    }
}
