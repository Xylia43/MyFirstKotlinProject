package com.example.first


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.annotation.VisibleForTesting
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
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign.Companion.Justify
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.first.data.Dog
import com.example.first.data.dogs
import com.example.first.ui.theme.FirstTheme
import java.text.NumberFormat

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstTheme { //这个theme估计就是包名+theme
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize() ,
                    color = MaterialTheme.colorScheme.background
                ) {
//                    Greeting("Android")
//                    TaskManger()
//                    MyQuadrant()
//                    DiceWithButtonAndImage()
//                    Lemonade()
//                    LemonadeApp()
//                    TipTimeLayout()
//                    ArtSpace()
//                    CourseList(
//                        couritemList = CourseDataSource.topics
//                    )
                    WoofApp()
                }
            }
        }
    }
}

//********************
@Composable
fun Greeting(name: String , modifier: Modifier = Modifier) {
    val image = painterResource(id = R.drawable.ic_launcher_background)
    Column() {
        Image(
            painter = image ,
            contentDescription = null ,
            contentScale = ContentScale.FillWidth
        )
        Text(
            text = "Title" ,
            modifier = modifier.padding(16.dp) ,
            fontSize = 24.sp
        )
        Text(
            text = "first paragraph" ,
            modifier = modifier.padding(16.dp , 0.dp , 16.dp , 0.dp) ,
            textAlign = Justify
        )
        Text(
            text = "second paragraph" ,
            modifier = modifier.padding(16.dp) ,
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
            .fillMaxHeight() ,
        horizontalAlignment = Alignment.CenterHorizontally ,
        verticalArrangement = Arrangement.Center

    ) {
        Image(
            painter = image ,
            contentDescription = null ,
            contentScale = ContentScale.Crop
        )
        Text(
            text = "All Task Complete" ,
            Modifier.padding(0.dp , 24.dp , 0.dp , 8.dp) ,
            fontWeight = FontWeight.Bold
        )
        Text(text = "Nice Work!" , fontSize = 16.sp)
    }

}

//*********************
@Composable
fun MyQuadrant() {
    Column(Modifier.fillMaxWidth()) {
        Row(Modifier.weight(1f)) {
            ComposableInfoCard(
                title = stringResource(R.string.third_title) ,
                description = stringResource(R.string.third_description) ,
                backgroundColor = Color(0xFFB69DF8) ,
                modifier = Modifier.weight(1f)
            )
            ComposableInfoCard(
                title = stringResource(R.string.fourth_title) ,
                description = stringResource(R.string.fourth_description) ,
                backgroundColor = Color(0xFFF6EDFF) ,
                modifier = Modifier.weight(1f)
            )
        }
        Row(Modifier.weight(1f)) {
            ComposableInfoCard(
                title = stringResource(R.string.first_title) ,
                description = stringResource(R.string.first_description) ,
                backgroundColor = Color(0xFFEADDFF) ,
                modifier = Modifier.weight(1f)
            )
            ComposableInfoCard(
                title = stringResource(R.string.second_title) ,
                description = stringResource(R.string.second_description) ,
                backgroundColor = Color(0xFFD0BCFF) ,
                modifier = Modifier.weight(1f)
            )
        }
        Row(Modifier.weight(1f)) {
            ComposableInfoCard(
                title = stringResource(R.string.third_title) ,
                description = stringResource(R.string.third_description) ,
                backgroundColor = Color(0xFFB69DF8) ,
                modifier = Modifier.weight(1f)
            )
            ComposableInfoCard(
                title = stringResource(R.string.fourth_title) ,
                description = stringResource(R.string.fourth_description) ,
                backgroundColor = Color(0xFFF6EDFF) ,
                modifier = Modifier.weight(1f)
            )
        }

    }
}

@Composable
fun ComposableInfoCard(
    modifier: Modifier = Modifier ,
    backgroundColor: Color ,
    title: String ,
    description: String
) {
    Column(
        modifier = modifier
            .background(backgroundColor)
            .padding(16.dp)
            .fillMaxSize() ,
        horizontalAlignment = Alignment.CenterHorizontally ,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = title ,
            Modifier.padding(16.dp) ,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = description ,
            textAlign = Justify
        )

    }
}

///////////////////////
@Composable
fun MyProfileCompose(modifier: Modifier = Modifier , image: Int , string: String , name: String) {
    Column(
        modifier = modifier.fillMaxWidth() ,
        verticalArrangement = Arrangement.Center ,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = image) ,
            contentDescription = "mememe" ,
            Modifier.width(100.dp)
        )
        Text(
            text = string ,
            fontSize = 26.sp
        )
        Text(
            text = name ,
            fontSize = 20.sp
        )

    }
}

@Composable
fun MyContactCompose(modifier: Modifier = Modifier , info: String) {
    Column(
        modifier = modifier.fillMaxWidth() ,
        verticalArrangement = Arrangement.Center ,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(id = R.drawable.ic_launcher_foreground) ,
                contentDescription = null ,
                Modifier.width(30.dp)
            )
            Text(text = info , fontSize = 16.sp)
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(id = R.drawable.ic_launcher_foreground) ,
                contentDescription = null ,
                Modifier.width(30.dp)
            )
            Text(text = info , fontSize = 16.sp)
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(id = R.drawable.ic_launcher_foreground) ,
                contentDescription = null ,
                Modifier.width(30.dp)
            )
            Text(text = info , fontSize = 16.sp)
        }

    }

}

@Composable
fun MyCard() {
    Column(
        Modifier.fillMaxSize() ,
        verticalArrangement = Arrangement.Center
    ) {
        MyProfileCompose(Modifier , R.drawable.hello , "FULL NAME" , "Yan")
        Spacer(Modifier.height(50.dp))
        MyContactCompose(info = "+44 07529209272")
    }

}

/************roll dice*************
 * roll dice
 */
@Composable
fun DiceWithButtonAndImage(
    modifier: Modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center)
) {
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
    Column(
        modifier = modifier ,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = imageResource) ,
            contentDescription = result.toString()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { result = (1..6).random() } ,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(red = 180 , green = 100 , blue = 100)
            )
        ) {
            Text(stringResource(id = R.string.roll))

        }

    }

}

/**
 * Lemonade
 * button click practice
 */
@Composable
fun Lemonade(
    modifier: Modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center)
) {
    var currentStep by remember { mutableStateOf(1) }
    when (currentStep) {
        1 -> {
            Column(
                modifier = modifier ,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.lemon_tree) ,
                    contentDescription = stringResource(id = R.string.lemonTree) ,
                    modifier = Modifier
                        .wrapContentSize()
                        .clickable {
                            currentStep = 2
                        }
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(stringResource(id = R.string.selectLemon))
            }
        }

        2 -> {
            val squeezetimes = (1..5).random()
            var clicktimes = 0
            Column(
                modifier = modifier ,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.lemon_squeeze) ,
                    contentDescription = stringResource(id = R.string.lemon) ,
                    modifier = Modifier
                        .wrapContentSize()
                        .clickable {
                            clicktimes++
                            if (clicktimes >= squeezetimes) {
                                currentStep = 3
                            }
                        }
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(stringResource(id = R.string.squeezeLemon))
            }
        }

        3 -> {
            Column(
                modifier = modifier ,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.lemon_drink) ,
                    contentDescription = stringResource(id = R.string.glassOfLemonade) ,
                    modifier = Modifier
                        .wrapContentSize()
                        .clickable {
                            currentStep = 4
                        }
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(stringResource(id = R.string.tap2Drink))
            }
        }

        4 -> {
            Column(
                modifier = modifier ,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.lemon_restart) ,
                    contentDescription = stringResource(id = R.string.emptyGlass) ,
                    modifier = Modifier
                        .wrapContentSize()
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
                        text = "Lemonade" ,
                        fontWeight = FontWeight.Bold
                    )
                } ,
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer ,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer ,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer ,
                    actionIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        }
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(MaterialTheme.colorScheme.tertiaryContainer) ,
            color = MaterialTheme.colorScheme.background
        ) {
            when (currentStep) {
                1 -> {
                    LemonTextAndImage(
                        textLabelResourceId = R.string.selectLemon ,
                        drawableResourceId = R.drawable.lemon_tree ,
                        contentDescriptionResourceId = R.string.lemonTree ,
                        onImageClick = {
                            currentStep = 2
                            squeezeCount = (2..4).random()
                        }
                    )
                }

                2 -> {
                    LemonTextAndImage(
                        textLabelResourceId = R.string.squeezeLemon ,
                        drawableResourceId = R.drawable.lemon_squeeze ,
                        contentDescriptionResourceId = R.string.lemon ,
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
                        textLabelResourceId = R.string.tap2Drink ,
                        drawableResourceId = R.drawable.lemon_drink ,
                        contentDescriptionResourceId = R.string.glassOfLemonade ,
                        onImageClick = {
                            currentStep = 4
                        }
                    )
                }

                4 -> {
                    LemonTextAndImage(
                        textLabelResourceId = R.string.tap2Restart ,
                        drawableResourceId = R.drawable.lemon_restart ,
                        contentDescriptionResourceId = R.string.emptyGlass ,
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
    textLabelResourceId: Int ,
    drawableResourceId: Int ,
    contentDescriptionResourceId: Int ,
    onImageClick: () -> Unit ,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally ,
            verticalArrangement = Arrangement.Center ,
            modifier = Modifier.fillMaxSize()
        ) {
            Button(
                onClick = onImageClick ,
                shape = RoundedCornerShape(dimensionResource(R.dimen.button_corner_radius)) ,
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.tertiaryContainer)
            ) {
                Image(
                    painter = painterResource(drawableResourceId) ,
                    contentDescription = stringResource(contentDescriptionResourceId) ,
                    modifier = Modifier
                        .width(dimensionResource(R.dimen.button_image_width))
                        .height(dimensionResource(R.dimen.button_image_height))
                        .padding(dimensionResource(R.dimen.button_interior_padding))
                )
            }
            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_vertical)))
            Text(
                text = stringResource(textLabelResourceId) ,
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}

/**
 * tip calculation
 */
@Composable
fun TipTimeLayout() {
    var amountInput by remember { mutableStateOf("") }

    val amount = amountInput.toDoubleOrNull() ?: 0.0
//    val tip = calculateTip(amount)
    var tipInput by remember { mutableStateOf("") }
    val tipPercent = tipInput.toDoubleOrNull() ?: 0.0

    var roundUp by remember { mutableStateOf(false) }
    val tip = calculateTip(amount , tipPercent , roundUp)
    Column(
        modifier = Modifier
            .statusBarsPadding()
            .padding(horizontal = 40.dp)
            .verticalScroll(rememberScrollState())
            .safeDrawingPadding() ,
        horizontalAlignment = Alignment.CenterHorizontally ,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(R.string.calculate_tip) ,
            modifier = Modifier
                .padding(bottom = 16.dp , top = 40.dp)
                .align(alignment = Alignment.Start)
        )
//        EditNumberField(modifier = Modifier.padding( bottom =32.dp).fillMaxWidth())
        EditNumberField(
            label = R.string.bill_amount ,
            value = amountInput ,
            leadingIcon = R.drawable.money ,
            onValueChanged = { amountInput = it } ,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number ,
                imeAction = ImeAction.Next
            ) ,
            modifier = Modifier
                .padding(bottom = 32.dp)
                .fillMaxWidth()
        )
        EditNumberField(
            label = R.string.how_was_the_service ,
            value = tipInput ,
            leadingIcon = R.drawable.percent ,
            onValueChanged = { tipInput = it } ,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number ,
                imeAction = ImeAction.Done
            ) ,
            modifier = Modifier
                .padding(bottom = 32.dp)
                .fillMaxWidth()
        )
        RoundTheTipRow(
            roundUp = roundUp ,
            onRoundUpChanged = { roundUp = it } ,
            modifier = Modifier.padding(bottom = 32.dp)
        )
        Text(
            text = stringResource(R.string.tip_amount , tip) ,
            style = MaterialTheme.typography.displaySmall
        )
        Spacer(modifier = Modifier.height(150.dp))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
//@SuppressLint("UnrememberedMutableState")
@Composable
fun EditNumberField(
    value: String ,
    onValueChange: (String) -> Unit ,
    modifier: Modifier = Modifier
) {
//    val amountInput = "0"
//    var amountInput: MutableState<String> = mutableStateOf("0")

//    val tip = calculateTip(amount)
    TextField(
//        value = amountInput,
//        In the lambda expression, the it variable contains the new value.
//        onValueChange = {amountInput = it},
        value = value ,
        onValueChange = onValueChange ,
        modifier = modifier ,
        singleLine = true ,
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Number ,
            imeAction = ImeAction.Next
        ) ,
        label = { Text(stringResource(R.string.bill_amount)) } ,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditNumberField(
    @StringRes label: Int ,
    @DrawableRes leadingIcon: Int ,
    value: String ,
    onValueChanged: (String) -> Unit ,
    keyboardOptions: KeyboardOptions ,
    modifier: Modifier = Modifier
) {
    TextField(
        value = value ,
        leadingIcon = { Icon(painter = painterResource(id = leadingIcon) , null) } ,
        onValueChange = onValueChanged ,
        modifier = modifier ,
        singleLine = true ,
        keyboardOptions = keyboardOptions ,
        label = { Text(stringResource(label)) } ,
    )
}

@VisibleForTesting
internal fun calculateTip(amount: Double , tipPercent: Double = 15.0 , roundUp: Boolean): String {
    var tip = tipPercent / 100 * amount
    if (roundUp) {
        tip = kotlin.math.ceil(tip)
    }
    return NumberFormat.getCurrencyInstance().format(tip)
}

@Composable
fun RoundTheTipRow(
    roundUp: Boolean ,
    onRoundUpChanged: (Boolean) -> Unit ,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .size(48.dp) ,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = stringResource(R.string.round_up_tip))
        Switch(
            checked = roundUp ,
            onCheckedChange = onRoundUpChanged ,
            modifier = modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.End)
        )
    }
}

/**
 * art space app
 */
@Composable
fun ArtSpace(modifier: Modifier = Modifier) {
    var currentStep by remember { mutableStateOf(1) }
    Column(
        modifier = Modifier
            .statusBarsPadding()
            .padding(horizontal = 40.dp , vertical = 50.dp)
            .verticalScroll(rememberScrollState()) ,
        horizontalAlignment = Alignment.CenterHorizontally ,
        verticalArrangement = Arrangement.Center
    ) {
        when (currentStep) {
            1 -> {
                ArtTextAndImage(
                    titleId = R.string.pic_title ,
                    desId = R.string.pic_des ,
                    drawableResourceId = R.drawable.gopr0074 ,
                    contentDescriptionResourceId = R.string.lemonTree ,
                    modifier = modifier
                )
            }

            2 -> {
                ArtTextAndImage(
                    titleId = R.string.selectLemon ,
                    desId = R.string.tap2Restart ,
                    drawableResourceId = R.drawable.lemon_tree ,
                    contentDescriptionResourceId = R.string.lemonTree ,
                    modifier = modifier
                )
            }

            3 -> {
                ArtTextAndImage(
                    titleId = R.string.selectLemon ,
                    desId = R.string.selectLemon ,
                    drawableResourceId = R.drawable.hello ,
                    contentDescriptionResourceId = R.string.lemonTree ,
                    modifier = modifier
                )
            }
        }

        Box(
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 20.dp)
                .size(48.dp)
        ) {
            Button(
                onClick = { currentStep = 1 } ,
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.art_btn)
                )

            ) {
                Text(stringResource(id = R.string.pic_previous))

            }
            Button(
                onClick = { currentStep = 2 } ,
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.art_btn)
                ) , modifier = Modifier.align(alignment = Alignment.CenterEnd)
            ) {
                Text(stringResource(id = R.string.pic_next))

            }

        }
    }
}

@Composable
fun ArtTextAndImage(
    @StringRes titleId: Int ,
    @StringRes desId: Int ,
    @DrawableRes drawableResourceId: Int ,
    @StringRes contentDescriptionResourceId: Int ,
    modifier: Modifier
) {
    Image(
        painter = painterResource(id = drawableResourceId) ,
        contentDescription = stringResource(id = contentDescriptionResourceId) ,
        modifier = Modifier
            .height(200.dp)
            .fillMaxWidth() ,
        contentScale = ContentScale.FillBounds
    )
    Spacer(modifier = Modifier.height(30.dp))
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = colorResource(id = R.color.art_text_background))
            .padding(20.dp)
    ) {
        Text(
            text = stringResource(id = titleId) ,
            modifier = Modifier
                .padding(bottom = 10.dp)
                .align(alignment = Alignment.Start) ,
            fontSize = 20.sp
        )
        Text(
            text = stringResource(id = desId) ,
            modifier = Modifier
                .align(alignment = Alignment.Start) ,
            fontWeight = FontWeight.Bold
        )
    }
}

/**
 * Kotlin fundamentals task 1
 */
data class Event(
    val title: String,
    val description: String?,
//    val daypart: String,
    val daypart: DAYPART, //Notice, official solution
    val duration: Int
)
enum class DAYPART{
    MORNING, AFTERNOON, EVENING
}
//val events = listOf(
val events = mutableListOf(// official solution
    Event(
        title = "Study Kotlin",
        description = "Commit to studying Kotlin at least 15 minutes per day.",
        daypart = DAYPART.MORNING,
        duration = 15
    ),
    Event(
        title = "runing",
        description = "Commit to studying Kotlin at least 15 minutes per day.",
        daypart = DAYPART.EVENING,
        duration = 30
    ),
    Event(
        title = "Climbing",
        description = "Commit to studying Kotlin at least 15 minutes per day.",
        daypart = DAYPART.AFTERNOON,
        duration = 72
    )
)
// extention property, new property
val Event.durationOfEvent: String
    get() = if(this.duration < 60){
        "short"
    } else {
        "long"
    }

fun main() {
    events.forEach {
        println("Event:${it.toString()}")
    }
    // **********filter short event**************
    val (shortE, longE) = events.partition { it.duration < 60 }
    println("ShortEvent: $shortE")
    println("LongEvent: $longE")
    // official below
    val shortEvents = events.filter { it.duration < 60 }
    println("You have ${shortEvents.size} short events.")
    // ********** groupby daypart **************
    val groupEvent = events.groupBy { it.daypart }
    //my wrong
//    val morningE = groupEvent.get(DAYPART.MORNING)?: emptyList()
//    val afternoonE = groupEvent[DAYPART.AFTERNOON]?: emptyList()
//    val evenE = groupEvent[DAYPART.EVENING]?: emptyList()
//    println("Morning Event: $morningE")
//    println("Afternoon Event: $afternoonE")
//    println("Evening Event: $evenE")
    // official
    groupEvent.forEach{ (DAYPART,events) ->
        println("$DAYPART,${events.size} events")

    }
//***** print last event name
    println("Last event of the day: ${events.last().title}")

    println("Duration of first event of the day: ${events[0].durationOfEvent}")

}

/**
 * build a scrollable list
 */

data class Affirmation(
    @StringRes val stringResourceId: Int,
    @DrawableRes val imageResourceId: Int
)

class Datasource() {
    fun loadAffirmations(): List<Affirmation> {
        return listOf<Affirmation>(
            Affirmation(R.string.affirmation1, R.drawable.image1),
            Affirmation(R.string.affirmation2, R.drawable.image2),
            Affirmation(R.string.affirmation3, R.drawable.image3),
            Affirmation(R.string.affirmation4, R.drawable.image4),
            Affirmation(R.string.affirmation5, R.drawable.image5),
            Affirmation(R.string.affirmation6, R.drawable.image6),
            Affirmation(R.string.affirmation7, R.drawable.image7),
            Affirmation(R.string.affirmation8, R.drawable.image8),
            Affirmation(R.string.affirmation9, R.drawable.image9),
            Affirmation(R.string.affirmation10, R.drawable.image10))
    }
}
@Composable
fun AffirmationList(affirmationList: List<Affirmation>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(affirmationList) {
            //For each affirmation in the list, call the AffirmationCard() composable.
            // Pass it the affirmation and a Modifier object with the padding attribute set to 8.dp.
            affirmation -> AffirmationCard(
            affirmation = affirmation,
            modifier = Modifier.padding(8.dp)
        )
        }
    }
}

@Composable
fun AffirmationCard(affirmation: Affirmation, modifier: Modifier = Modifier) {
    Card(modifier = modifier) {
        Column {
            Image(
                painter = painterResource(affirmation.imageResourceId),
                contentDescription = stringResource(affirmation.stringResourceId),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(194.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = LocalContext.current.getString(affirmation.stringResourceId),
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.headlineSmall
            )
        }
    }
}

/**
 * Build a course app
 */
data class Topic(
    @StringRes val courseNameId: Int,
    val courseComNum: Int,
    @DrawableRes val coursePicId: Int,

)
object CourseDataSource {
    val topics = listOf(
        Topic(R.string.architecture, 58, R.drawable.architecture),
        Topic(R.string.crafts, 121, R.drawable.crafts),
        Topic(R.string.business, 78, R.drawable.business),
        Topic(R.string.culinary, 118, R.drawable.culinary),
        Topic(R.string.design, 423, R.drawable.design),
        Topic(R.string.fashion, 92, R.drawable.fashion),
        Topic(R.string.film, 165, R.drawable.film),
        Topic(R.string.gaming, 164, R.drawable.gaming),
        Topic(R.string.drawing, 326, R.drawable.drawing),
        Topic(R.string.lifestyle, 305, R.drawable.lifestyle),
        Topic(R.string.music, 212, R.drawable.music),
        Topic(R.string.painting, 172, R.drawable.painting),
        Topic(R.string.photography, 321, R.drawable.photography),
        Topic(R.string.tech, 118, R.drawable.tech)
    )
}
@Composable
fun CourseCard(courseitem: Topic, modifier: Modifier = Modifier) {
    Card(modifier = modifier.height(68.dp)) {
        Row {
            Image(
                painter = painterResource(courseitem.coursePicId),
                contentDescription = stringResource(courseitem.courseNameId),
                modifier = Modifier
                    .width(68.dp)
                    .height(68.dp),
                contentScale = ContentScale.FillBounds
            )
            Column {
                Text(
                    text = LocalContext.current.getString(courseitem.courseNameId),
                    modifier = Modifier.padding(start = 16.dp, top = 16.dp, end = 16.dp),
                    style = MaterialTheme.typography.bodyMedium
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(R.drawable.ic_grain),
                        contentDescription = "",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.padding(start = 16.dp, top = 8.dp)
                    )
                    Text(
                        text = courseitem.courseComNum.toString(),
                        modifier = Modifier.padding(start = 8.dp, top = 8.dp, end = 16.dp),
                        style = MaterialTheme.typography.labelMedium
                    )
                }
            }

        }
    }
}
@Composable
fun CourseList(couritemList: List<Topic>, modifier: Modifier = Modifier) {
       LazyVerticalGrid(columns = GridCells.Fixed(2)) {
        items(couritemList) {
            //For each affirmation in the list, call the AffirmationCard() composable.
            // Pass it the affirmation and a Modifier object with the padding attribute set to 8.dp.
                topicItem -> CourseCard(
            courseitem = topicItem,
            modifier = Modifier.padding(8.dp)
        )
        }
    }
}

/**
 * Dog App
 *//**
 * Composable that displays an app bar and a list of dogs.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WoofApp() {
    Scaffold(
        topBar = {
        WoofTopAppBar()
    }) { it ->
    LazyColumn(contentPadding = it) {
        items(dogs) {
            DogItem(dog = it,
                modifier = Modifier.padding(dimensionResource(R.dimen.padding_small)))
        }
    }
    }
}

/**
 * Composable that displays a list item containing a dog icon and their information.
 *
 * @param dog contains the data that populates the list item
 * @param modifier modifiers to set to this composable
 */
@Composable
fun DogItem(
    dog: Dog ,
    modifier: Modifier = Modifier
) {
    Card(modifier = modifier) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.padding_small))
        ) {
            DogIcon(dog.imageResourceId)
            DogInformation(dog.name , dog.age)
        }
    }
}

/**
 * Composable that displays a photo of a dog.
 *
 * @param dogIcon is the resource ID for the image of the dog
 * @param modifier modifiers to set to this composable
 */
@Composable
fun DogIcon(
    @DrawableRes dogIcon: Int,
    modifier: Modifier = Modifier
) {
    Image(
        modifier = modifier
            .size(dimensionResource(R.dimen.image_size))
            .padding(dimensionResource(R.dimen.padding_small))
            .clip(MaterialTheme.shapes.small),
        painter = painterResource(dogIcon),
        contentScale = ContentScale.Crop,

        // Content Description is not needed here - image is decorative, and setting a null content
        // description allows accessibility services to skip this element during navigation.

        contentDescription = null
    )
}

/**
 * Composable that displays a dog's name and age.
 *
 * @param dogName is the resource ID for the string of the dog's name
 * @param dogAge is the Int that represents the dog's age
 * @param modifier modifiers to set to this composable
 */
@Composable
fun DogInformation(
    @StringRes dogName: Int,
    dogAge: Int,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(dogName),
            style = MaterialTheme.typography.displayMedium,
            modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_small))
        )
        Text(
            text = stringResource(R.string.years_old, dogAge),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WoofTopAppBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier
                        .size(dimensionResource(id = R.dimen.image_size))
                        .padding(dimensionResource(id = R.dimen.padding_small)),
                    painter = painterResource(R.drawable.ic_woof_logo),

                    contentDescription = null
                )
                Text(
                    text = stringResource(R.string.app_name),
                    style = MaterialTheme.typography.displayLarge
                )
            }
        },
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FirstTheme(darkTheme = true) {
//        Greeting("Android")
//        TaskManger()
//        MyQuadrant()
//        MyProfileCompose(Modifier,R.drawable.hello,"FULL NAME","Yan")
//        MyContactCompose(info = "+44 07529209272")
//        MyCard()
//        DiceWithButtonAndImage()
//        Lemonade()
//        LemonadeApp()
//        TipTimeLayout()
//        RoundTheTipRow()
//        ArtSpace()
//        AffirmationCard(Affirmation(R.string.affirmation1, R.drawable.image1))
//        AffirmationList(
//            affirmationList = Datasource().loadAffirmations(),
//        )

//        CourseCard(Topic(R.string.architecture, 58, R.drawable.architecture))

//        CourseList(
//            couritemList = CourseDataSource.topics
//        )
        WoofApp()

    }
}