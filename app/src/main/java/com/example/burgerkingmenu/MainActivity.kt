package com.example.burgerkingmenu

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.burgerkingmenu.ui.theme.BurgerkingmenuTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BurgerkingmenuTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        BurgerMenu("Cheese Whopper", 7700, R.drawable.cheesewhopper_image)
        BurgerMenu("Garlic Whopper", 7800, R.drawable.cheesewhopper_image)
        BurgerMenu("Whopper", 7900, R.drawable.cheesewhopper_image)
        BurgerMenu("Bulgogi Whopper", 8000, R.drawable.cheesewhopper_image)
        BurgerMenu("Hot Chilli Whopper", 8100, R.drawable.cheesewhopper_image)
    }
}

@Composable
fun BurgerMenu(name: String, int: Int, imageID: Int) {
    Divider(color = Color.Black)
    val context = LocalContext.current
    Button(
        onClick = {
            val intent = Intent(context, SubActivity::class.java)
            intent.putExtra("BurgerType", name)
            context.startActivity(intent)
        },
        shape = RoundedCornerShape(0.dp),
        modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(containerColor = Color.White),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            androidx.compose.foundation.Image(
                painter = painterResource(id = imageID), contentDescription = null,
                modifier = Modifier.weight(2f)
            )
            Column(modifier = Modifier.weight(4f)) {
                Text(text = name, color = Color.Black)
                Text(text = "$int~", color = Color.Red)
            }
            androidx.compose.foundation.Image(
                painter = painterResource(id = R.drawable.arrow_image),
                contentDescription = null
            )
        }
    }
    Divider(color = Color.Black)
}

@Preview
@Composable
fun GreetingPreview() {
    BurgerkingmenuTheme {
        MainScreen()
    }
}

