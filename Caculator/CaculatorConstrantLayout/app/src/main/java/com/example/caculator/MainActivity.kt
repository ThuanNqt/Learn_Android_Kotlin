package com.example.caculator

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import com.example.caculator.ui.theme.CaculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CaculatorTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    DisplayXmlLayout(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun DisplayXmlLayout(modifier: Modifier = Modifier){
    val context = LocalContext.current
    AndroidView (
        factory = {context ->
            LayoutInflater.from(context).inflate(R.layout.activity_main, null)
        },
        modifier=modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CaculatorTheme {
    }
}