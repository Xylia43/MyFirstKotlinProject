package com.example.first


import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
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
            FirstTheme { //这个theme估计就是包名+theme
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    Greeting("Android")
//                    TaskManger()
//                    MyQuadrant()
//                    DiceWithButtonAndImage()
//                    Lemonade()
                    LemonadeApp()
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
            , contentDescription = "mememe"
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

/************roll dice*************
 * roll dice
 */
@Composable
fun DiceWithButtonAndImage(modifier: Modifier= Modifier
    .fillMaxSize()
    .wrapContentSize(Alignment.Center)) {
// pass the modifer to make efficial, because the composable function may re composition
// again so create one inside it is not efficiency
    var result by remember { mutableStateOf(1) }
    val imageResource = when (result) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }
    Column(modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(id = imageResource),
            contentDescription = result.toString()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { result=(1..6).random() },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(red = 180, green = 100, blue = 100)
            )) {
            Text(stringResource(id = R.string.roll))

        }

    }

}

/**
 * Lemonade
 * button click practice
 */
@Composable
fun Lemonade(modifier: Modifier= Modifier
    .fillMaxSize()
    .wrapContentSize(Alignment.Center)){
    var currentStep by remember { mutableStateOf(1) }
    when(currentStep) {
        1 -> {
            Column(modifier = modifier,
                horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(id = R.drawable.lemon_tree) ,
                    contentDescription = stringResource(id = R.string.lemonTree),
                    modifier = Modifier.wrapContentSize()
                        .clickable {
                            currentStep = 2
                    }
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(stringResource(id = R.string.selectLemon))
            }
        }
        2->{
            val squeezetimes= (1..5).random()
            var clicktimes=0
            Column(modifier = modifier,
                horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(id = R.drawable.lemon_squeeze) ,
                    contentDescription = stringResource(id = R.string.lemon),
                    modifier = Modifier.wrapContentSize()
                        .clickable {
                            clicktimes++
                            if( clicktimes>= squeezetimes){
                                currentStep = 3
                            }
                        }
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(stringResource(id = R.string.squeezeLemon))
            }
        }
        3->{
            Column(modifier = modifier,
                horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(id = R.drawable.lemon_drink) ,
                    contentDescription = stringResource(id = R.string.glassOfLemonade),
                    modifier = Modifier.wrapContentSize()
                        .clickable {
                            currentStep = 4
                        }
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(stringResource(id = R.string.tap2Drink))
            }
        }
        4->{
            Column(modifier = modifier,
                horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(id = R.drawable.lemon_restart) ,
                    contentDescription = stringResource(id = R.string.emptyGlass),
                    modifier = Modifier.wrapContentSize()
                        .clickable {
                            currentStep = 1
                        }
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(stringResource(id = R.string.tap2Restart))
            }
        }
    }
}

/**
 * lemonade app by official
 */
@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun LemonadeApp() {

    var currentStep by remember { mutableStateOf(1) }

    var squeezeCount by remember { mutableStateOf(0) }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Lemonade",
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    actionIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        }
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(MaterialTheme.colorScheme.tertiaryContainer),
            color = MaterialTheme.colorScheme.background
        ) {
            when (currentStep) {
                1 -> {
                    LemonTextAndImage(
                        textLabelResourceId = R.string.selectLemon,
                        drawableResourceId = R.drawable.lemon_tree,
                        contentDescriptionResourceId = R.string.lemonTree,
                        onImageClick = {
                            currentStep = 2
                            squeezeCount = (2..4).random()
                        }
                    )
                }
                2 -> {
                    LemonTextAndImage(
                        textLabelResourceId = R.string.squeezeLemon,
                        drawableResourceId = R.drawable.lemon_squeeze,
                        contentDescriptionResourceId = R.string.lemon,
                        onImageClick = {
                            squeezeCount--
                            if (squeezeCount == 0) {
                                currentStep = 3
                            }
                        }
                    )
                }

                3 -> {
                    LemonTextAndImage(
                        textLabelResourceId = R.string.tap2Drink,
                        drawableResourceId = R.drawable.lemon_drink,
                        contentDescriptionResourceId = R.string.glassOfLemonade,
                        onImageClick = {
                            currentStep = 4
                        }
                    )
                }
                4 -> {
                    LemonTextAndImage(
                        textLabelResourceId = R.string.tap2Restart,
                        drawableResourceId = R.drawable.lemon_restart,
                        contentDescriptionResourceId = R.string.emptyGlass,
                        onImageClick = {
                            currentStep = 1
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun LemonTextAndImage(
    textLabelResourceId: Int,
    drawableResourceId: Int,
    contentDescriptionResourceId: Int,
    onImageClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Button(
                onClick = onImageClick,
                shape = RoundedCornerShape(dimensionResource(R.dimen.button_corner_radius)) ,
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.tertiaryContainer)
            ) {
                Image(
                    painter = painterResource(drawableResourceId),
                    contentDescription = stringResource(contentDescriptionResourceId),
                    modifier = Modifier
                        .width(dimensionResource(R.dimen.button_image_width))
                        .height(dimensionResource(R.dimen.button_image_height))
                        .padding(dimensionResource(R.dimen.button_interior_padding))
                )
            }
            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_vertical)))
            Text(
                text = stringResource(textLabelResourceId),
                style = MaterialTheme.typography.bodyLarge
            )
        }
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
//        MyCard()
//        DiceWithButtonAndImage()
        Lemonade()
//        LemonadeApp()
    }
}