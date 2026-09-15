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

                    LayoutScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun LayoutScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
        .fillMaxSize()
        .background(Color.Black)

    ){
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "SCORE: 0050",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                fontFamily = FontFamily.Serif,
                textAlign = TextAlign.Start
            )
            Row(
                modifier = Modifier,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "LIVES: ",
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                AndroidEnemy(
                    color = Color.Green,
                    modifier = Modifier.size(30.dp)
                )
                AndroidEnemy(
                    color = Color.Green,
                    modifier = Modifier.size(30.dp)
                )
                AndroidEnemy(
                    color = Color.Green,
                    modifier = Modifier.size(30.dp)
                )
            }

        }
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
fun AndroidEnemy(
    color: Color,
    modifier: Modifier = Modifier
){
    Image(
        painter = painterResource(R.drawable.ic_launcher_foreground),
        colorFilter = ColorFilter.tint(color),
        contentDescription = "Android Enemy",
        modifier = modifier
    )
}
