package com.example.tempapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Slider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.runtime.*
import com.example.tempapp.ui.theme.TempAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TempAppTheme {
                Surface(
                modifier = Modifier.fillMaxSize(),
                color = Color.Magenta
            ){
                Column (
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment  = Alignment.CenterHorizontally
                )
                {
                    SliderMinimalExample()
                }
            } }
                }
            }
        }



@Composable
fun SliderMinimalExample() {
    Text("Celsius")
    var Celsius by remember { mutableStateOf(0f) }
    var fahrenheitValue by remember { mutableStateOf(32f) }

    Column {
        Slider(
            value = Celsius,
            valueRange = 0f..100f,
            onValueChange = { newValue ->
                Celsius = newValue
                fahrenheitValue = (newValue * 9 / 5) + 32
            }
        )
        Text(text = Celsius.toString())

        Slider(
            value = fahrenheitValue,
            onValueChange = {newValue ->
                if (newValue < 32f) {
                    fahrenheitValue = 32f
                    Celsius = 0f
                } else {
                    fahrenheitValue = newValue
                    Celsius = (newValue - 32) * 5 / 9
                }
            },
            valueRange = 0f..212f
        )
        Text(text = fahrenheitValue.toString())

        if (Celsius < 20f) {
            Text(text = "Interesting Message: I wish it were warmer")
        } else {
            Text("Interesting Message: I wish it were colder")
        }
    }
}

