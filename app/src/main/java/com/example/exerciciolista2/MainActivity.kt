package com.example.exerciciolista2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.exerciciolista2.ui.theme.ExercicioLista2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ExercicioLista2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    PlayGameScreen(
                        modifier = Modifier.padding(innerPadding)
                    )

//                    GameOverScreen(
//                        modifier = Modifier.padding(innerPadding)
//                    )
                }
            }
        }
    }
}

@Composable
fun PlayGameScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            //ocupa a tela toda
        .fillMaxSize()
            //colocar o background nesta ordem para nao alterar o resultado final
        .background(Color.Black)

    ){
        //Status do jogo
        //row favorece a orientaçao dos elementos filhos
        Row(
                                 //Ocupa toda a largura da tela
            modifier = Modifier.fillMaxWidth(),
            //Distribuiçao do conteudo, usando o space between para separar entre os elementos
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            //score
            Text(text = "SCORE: 0050",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                fontFamily = FontFamily.Serif
            )

            //container para o lives e as tres imagens
            Row() {
                Text(text = "LIVES: ",
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    fontSize = 20.sp,
                )
                //Serve para repetir uma ação uma quantidade determinada de vezes.
                repeat(3){
                    AndroidEnemy(
                        color = Color.Green,
                        modifier = Modifier.size(30.dp)
                    )
                }
            }

        }
        //Inimigos
        Row(
            modifier = Modifier,
            horizontalArrangement = Arrangement.spacedBy((-50).dp)
        ){
            AndroidEnemy(
                color = Color.Green,
                modifier = Modifier.size(120.dp)
            )
            AndroidEnemy(
                color = Color.Red,
                modifier = Modifier.size(120.dp)
            )
            AndroidEnemy(
                color = Color.Blue,
                modifier = Modifier.size(120.dp)
            )
            AndroidEnemy(
                color = Color.Yellow,
                modifier = Modifier.size(120.dp)
            )
            AndroidEnemy(
                color = Color.Green,
                modifier = Modifier.size(120.dp)
            )
        }

        //personagem
        Box(
            modifier = modifier
        ){
            AndroidEnemy(
                color = Color.Green,
                modifier = Modifier.size(120.dp)
            )
        }

        Box(
            modifier = modifier
                .background(Color.Gray)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center

        ){
            Text(text = "PRESS START",
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                color = Color.White

            )
        }
    }
}

@Composable
fun GameOverScreen(modifier: Modifier = Modifier){

}



@Composable
fun AndroidEnemy(
    color: Color,
    modifier: Modifier = Modifier
){
    Image(
        //serve para desenhar um recurso que ja tem dentro do projeto
        //R. é o id da imagem
        painter = painterResource(R.drawable.ic_launcher_foreground),
        colorFilter = ColorFilter.tint(color),
        contentDescription = "Android Enemy",
        modifier = modifier
    )
}
