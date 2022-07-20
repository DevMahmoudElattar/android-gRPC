package com.example.kotlin_grpc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.kotlin_grpc.client.GreeterService
import com.example.kotlin_grpc.ui.theme.Kotlin_gRPCTheme
import grpc.HelloRequest

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val newHR = HelloRequest.newBuilder().setName("70Daaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa").build()

        val retrievals1 = GreeterService.greet1(newHR)
        val retrievals = GreeterService.greet(newHR)
        val ret3 = GreeterService.greetCoroutine()
        setContent {
            Kotlin_gRPCTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    Column() {
                        Greeting(retrievals1.message)
                    }

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello -> $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Kotlin_gRPCTheme {
        Greeting("Android")
    }
}