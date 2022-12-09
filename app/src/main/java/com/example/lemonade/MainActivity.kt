package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    LemonadeApp()
                }
            }
        }
    }
}

@Preview
@Composable
fun LemonadeApp(){
    LemonadePreparation()
}

@Composable
fun LemonadePreparation(){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {

        LemonCard(
            stringRes = R.string.lemon_tree,
            imageRes = R.drawable.lemon_tree
        )
    }
}

@Composable
fun LemonCard(stringRes: Int,imageRes: Int){
    var phase by remember {
        mutableStateOf(0)
    } // current phase of lemonade preparation

    var stringRes: Int = 0
    var imageRes: Int = 0

    when(phase){
        1->{
            stringRes = R.string.lemon
            imageRes = R.drawable.lemon_squeeze
        }
        2->{
            stringRes = R.string.glass_of_lemon
            imageRes = R.drawable.lemon_drink
        }
        3 ->{
            stringRes = R.string.empty_glass
            imageRes = R.drawable.lemon_restart
        }
        else->{
            stringRes = R.string.lemon_tree
            imageRes = R.drawable.lemon_tree
        }
    }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = stringResource(id = stringRes),
            fontSize = 18.sp
        )

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        OutlinedButton(
            onClick = { if(phase == 3) phase = 0 else phase++ },
            Modifier
                .background(Color.Transparent)
                .border(
                    width = 2.dp,
                    color = Color(105,205,216),
                    shape = RoundedCornerShape(4)
                )
        ) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = imageRes.toString()
            )
        }
    }
}
