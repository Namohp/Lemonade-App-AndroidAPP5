package com.example.lemoanade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemoanade.ui.theme.LemoanadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemoanadeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    LemonApp()
                }
            }
        }
    }
}

@Composable
fun LemonApp(modifier: Modifier = Modifier) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        var home by remember { mutableStateOf(1) }
        var clickCount by remember { mutableStateOf(0) }
        Box(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Yellow)
                    .padding(vertical = 16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Lemonade",
                    fontSize = 24.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
            }


            var nimbu = when (home) {
                1 -> {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.lemon_tree),
                            contentDescription = "Lemon Tree",
                            modifier = Modifier
                                .wrapContentSize()
                                .clickable { home = 2 }
                                .background(
                                    color = Color.Green,
                                    shape = AbsoluteRoundedCornerShape(10.dp)
                                ))
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(text = stringResource(id = R.string.first), fontSize = 18.sp)

                    }

                }
                2 -> {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.lemon_squeeze),
                            contentDescription = "Lemon",
                            modifier = Modifier
                                .wrapContentSize()
                                .clickable {
                                    val randomClicks = (1..5).random()
                                    repeat(randomClicks) {
                                        clickCount++
                                    }
                                    if (clickCount >= 5) {
                                        home = 3
                                    }
                                }
                                .background(
                                    color = Color.Green,
                                    shape = AbsoluteRoundedCornerShape(10.dp)
                                )
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(text = stringResource(id = R.string.second), fontSize = 18.sp)


                    }
                }
                3 -> {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.lemon_drink),
                            contentDescription = "Lemonade",
                            modifier = Modifier
                                .wrapContentSize()
                                .clickable { home = 4 }
                                .background(
                                    color = Color.Green,
                                    shape = AbsoluteRoundedCornerShape(10.dp)
                                ))
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(text = stringResource(id = R.string.third), fontSize = 18.sp)
                    }
                }
                4 -> {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.lemon_restart),
                            contentDescription = "Lemonade empty",
                            modifier = Modifier
                                .wrapContentSize()
                                .clickable { home = 1 }
                                .background(color = Color.Green,shape = AbsoluteRoundedCornerShape(10.dp)))
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(text = stringResource(id = R.string.fourth), fontSize = 18.sp)
                    }
                }
                else -> 10
            }

        }
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LemoanadeTheme {
        LemonApp()
    }
}