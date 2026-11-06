package Game

import  androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.material3.Button
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
import Game.controller.PlayerController
import android.icu.text.ListFormatter
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.text.style.LineHeightStyle

@Composable
fun GameScreen(
    modifier: Modifier = Modifier
){
    val playerController = remember { PlayerController() }
    var canvasWidth by remember { mutableStateOf(0f) }
    var canvasHeight by remember { mutableStateOf(0f) }

    var player by remember {mutableStateOf<Player?>(null)}
    Box(modifier=Modifier.fillMaxSize()){
        GameCanvas(
            player =player,
            onCanvasSizeChanged={ width,height->
                canvasWidth=width
                canvasHeight=height
                if(player==null) {
                    player = playerController.moveTo(
                        player = Player(),
                            x = (width - 60f) / 2f,
                            y = (height - 50f) -100f,
                            canvasWidth = width,
                            canvasHeight = height
                        )
                    }
                },
                onPlayerDrag = {dragX,dragY->
                    player?.let{currentPlayer->
                        player=playerController.moveTo(
                            player=currentPlayer,
                            x=currentPlayer.x+(dragX*2.8f),
                            y=currentPlayer.y+(dragY*2.8f),
                            canvasWidth = canvasWidth,
                            canvasHeight = canvasHeight
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
        Column(modifier = Modifier.align(Alignment.BottomCenter)
            .padding(bottom = 40.dp)){

        }

    }
}
