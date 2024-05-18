package com.example.burgerkingmenu

import com.example.burgerkingmenu.ui.theme.BurgerkingmenuTheme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

class SubActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BurgerkingmenuTheme {
                MainScreen()
            }
        }
    }


    @Composable
    fun MainScreen() {
        val name = intent.getStringExtra("BurgerType")

        when (name) {
            name -> Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {

                Text(text = "$name Large meal")
                Text(text = "$name Meal")
                Text(text = "$name Single")

                Button(onClick = { finish() }) {
                    Text(text = "BACK")
                }
            }


        }
    }
}

@Preview
@Composable
fun SubPreview() {
    BurgerkingmenuTheme {
        MainScreen()
    }
}