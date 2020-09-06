package com.example.jetpackbasiccodelab

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.example.jetpackbasiccodelab.ui.JetpackBasicCodelabTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                screenContent()
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(
        text = "Hello $name!",
        modifier = Modifier.padding(24.dp),
        style = MaterialTheme.typography.h4
    )
}

@Composable
fun screenContent() {
    Column(modifier = Modifier.fillMaxHeight().padding(24.dp)) {
        Column(modifier = Modifier.padding(24.dp).weight(1f)) {
            Greeting(name = "Android")
            Divider(color = Color.Red)
            Greeting(name = "Android 11")
            Divider(
                color = Color.Red,
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }
        Counter()
    }
}

@Composable
fun Counter() {
    val count = remember { mutableStateOf(0) }
    Button(
        onClick = { count.value++ },
    ) {
        Text(text = "Counter is ${count.value}")
    }
}

@Composable
fun MyApp(content: @Composable () -> Unit) {
    JetpackBasicCodelabTheme() {
        Surface(color = Color.Yellow) {
            content()
        }
    }

}

@Preview(showBackground = true, name = "Preview 1")
@Composable
fun DefaultPreview() {
    MyApp {
        screenContent()
    }
}