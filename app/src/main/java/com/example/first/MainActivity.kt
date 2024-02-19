package com.example.first

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign.Companion.Justify
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.first.ui.theme.FirstTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
//                    TaskManger()
                    MyQuadrant()
                }
            }
        }
    }
}
//********************
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val image = painterResource(id = R.drawable.ic_launcher_background)
    Column() {
        Image(painter = image,
            contentDescription = null,
            contentScale = ContentScale.FillWidth)
        Text(
            text = "Title",
            modifier = modifier.padding(16.dp),
            fontSize = 24.sp
        )
        Text(
            text = "first paragraph",
            modifier = modifier.padding(16.dp,0.dp,16.dp,0.dp),
            textAlign = Justify
        )
        Text(
            text = "second paragraph",
            modifier = modifier.padding(16.dp),
            textAlign = Justify
        )
        
    }
}
//****************
@Composable
fun TaskManger(modifier: Modifier = Modifier) {
    val image = painterResource(id = R.drawable.ic_task_completed)
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        Image(painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop)
        Text(text = "All Task Complete",
            Modifier.padding(0.dp,24.dp,0.dp,8.dp),
            fontWeight = FontWeight.Bold
        )
        Text(text = "Nice Work!",fontSize = 16.sp)
    }

}
//*********************
@Composable
fun MyQuadrant() {
    Column(Modifier.fillMaxWidth()) {
        Row(Modifier.weight(1f)) {
            ComposableInfoCard(
                title = stringResource(R.string.first_title),
                description = stringResource(R.string.first_description),
                backgroundColor = Color(0xFFEADDFF),
                modifier = Modifier.weight(1f)
            )
            ComposableInfoCard(
                title = stringResource(R.string.second_title),
                description = stringResource(R.string.second_description),
                backgroundColor = Color(0xFFD0BCFF),
                modifier = Modifier.weight(1f)
            )
        }
        Row(Modifier.weight(1f)) {
            ComposableInfoCard(
                title = stringResource(R.string.third_title),
                description = stringResource(R.string.third_description),
                backgroundColor = Color(0xFFB69DF8),
                modifier = Modifier.weight(1f)
            )
            ComposableInfoCard(
                title = stringResource(R.string.fourth_title),
                description = stringResource(R.string.fourth_description),
                backgroundColor = Color(0xFFF6EDFF),
                modifier = Modifier.weight(1f)
            )
        }
    }
}
@Composable
fun ComposableInfoCard(modifier: Modifier = Modifier, backgroundColor: Color,title: String, description: String) {
    Column(
        modifier = modifier
            .background(backgroundColor)
            .padding(16.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = title,
            Modifier.padding(16.dp),
            fontWeight = FontWeight.Bold
        )
        Text(
            text = description,
            textAlign = Justify
        )

    }
}

///////////////////////
@Composable
fun MyProfileCompose(modifier: Modifier=Modifier,image: Int,string: String,name: String){
    Column(modifier = modifier.fillMaxWidth(),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painter = painterResource(id = image)
            , contentDescription = null
            ,Modifier.width(100.dp))
        Text(text = string,
        fontSize = 26.sp)
        Text(text = name,
            fontSize = 20.sp)

    }
}
@Composable
fun MyContactCompose(modifier: Modifier=Modifier,info: String){
    Column(modifier = modifier.fillMaxWidth(),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(painter = painterResource(id = R.drawable.ic_launcher_foreground)
            ,contentDescription = null,Modifier.width(30.dp))
            Text(text = info, fontSize = 16.sp)
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(painter = painterResource(id = R.drawable.ic_launcher_foreground)
                ,contentDescription = null,Modifier.width(30.dp))
            Text(text = info, fontSize = 16.sp)
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(painter = painterResource(id = R.drawable.ic_launcher_foreground)
                ,contentDescription = null,Modifier.width(30.dp))
            Text(text = info, fontSize = 16.sp)
        }

    }

}
@Composable
fun MyCard(){
    Column(Modifier.fillMaxSize(),
    verticalArrangement = Arrangement.Center) {
        MyProfileCompose(Modifier,R.drawable.hello,"FULL NAME","Yan")
        Spacer(Modifier.height(50.dp))
        MyContactCompose(info = "+44 07529209272")
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FirstTheme {
//        Greeting("Android")
//        TaskManger()
//        MyQuadrant()
//        MyProfileCompose(Modifier,R.drawable.hello,"FULL NAME","Yan")
//        MyContactCompose(info = "+44 07529209272")
        MyCard()
    }
}