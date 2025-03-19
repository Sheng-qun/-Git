package com.example.quncopilot

import android.os.Bundle
import androidx.compose.ui.unit.dp
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.quncopilot.ui.theme.QuncopilotTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QuncopilotTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Greeting(name = "rolldicegamesqq")
                        Spacer(modifier = Modifier.height(16.dp))
                        DiceRoller()
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun DiceRoller() {
    var result by remember { mutableStateOf(1) }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Roll result: $result")
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { result = Random.nextInt(1, 7) }) {
            Text(text = "Roll Dice")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    QuncopilotTheme {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Greeting("Android")
            Spacer(modifier = Modifier.height(16.dp))
            DiceRoller()
        }
    }
}