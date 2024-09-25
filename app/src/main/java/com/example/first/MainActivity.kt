package com.example.first



import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.first.ui.AffirmationsApp
import com.example.first.ui.ArtSpace
import com.example.first.ui.CourseCard
import com.example.first.ui.CourseDataSource
import com.example.first.ui.CourseList
import com.example.first.ui.DiceWithButtonAndImage
import com.example.first.ui.GreetingScreen
import com.example.first.ui.Lemonade
import com.example.first.ui.MyBusinessCard
import com.example.first.ui.MyQuadrantScreen
import com.example.first.ui.ReplyApp
import com.example.first.ui.SportsApp
import com.example.first.ui.TaskMangerScreen
import com.example.first.ui.TipTimeLayout
import com.example.first.ui.Topic
import com.example.first.ui.WoofApp
import com.example.first.ui.WordGameScreen
import com.example.first.ui.theme.FirstTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstTheme { //这个theme估计就是包名+theme
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize() ,
                    color = MaterialTheme.colorScheme.background
                ) {
                    val windowSize = calculateWindowSizeClass(this)
                    MyApp(windowSize.widthSizeClass)
//                    MyAppList()
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
//                    WoofApp()
//                    GameScreen()
//                    CupcakeScreen()
//                    CupcakeApp()
//                    LunchTrayApp()
//                    ReplyApp()
                }
            }
        }
    }
}
enum class MyAppScreen() {
    MyAppList,
    Greeting,
    MyTask,
    MyQuadrant,
    MyBusinessCard,
    DiceGame,
    Lemonade,
    TipCalculate,
    ArtSpace,
    AffirmationsApp,
    CourseApp,
    DogApp,
    LunchTrayApp,
    CupcakeApp,
    WordGame,
    ReplyApp,
    SportsApp
}
@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MyApp(
    windowWidthSize: WindowWidthSizeClass ,
//    viewModel: OrderViewModel = viewModel() ,
    navController: NavHostController = rememberNavController()
) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = MyAppScreen.valueOf(
        backStackEntry?.destination?.route ?: MyAppScreen.MyAppList.name
    )
    Scaffold(
        topBar = {
//            CupcakeAppBar(
//                currentScreen = currentScreen,
//                canNavigateBack = navController.previousBackStackEntry != null,
//                navigateUp = { navController.navigateUp() }
//            )
        }
    ) {innerPadding ->
//        val uiState by viewModel.uiState.collectAsState()
        NavHost(
            navController = navController,
            startDestination = MyAppScreen.MyAppList.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = MyAppScreen.MyAppList.name) {
                MyAppList(navController=navController)
            }
            composable(route = MyAppScreen.Greeting.name) {
                GreetingScreen(name = "Dear Hedd")
            }
            composable(route = MyAppScreen.MyTask.name) {
                TaskMangerScreen()
            }
            composable(route = MyAppScreen.MyQuadrant.name) {
                MyQuadrantScreen()
            }
            composable(route = MyAppScreen.MyBusinessCard.name) {
                MyBusinessCard()
            }
            composable(route = MyAppScreen.DiceGame.name) {
                DiceWithButtonAndImage()
            }
            composable(route = MyAppScreen.Lemonade.name) {
//                LemonadeApp()
                Lemonade()
            }
            composable(route = MyAppScreen.TipCalculate.name) {
                TipTimeLayout()
            }
            composable(route = MyAppScreen.ArtSpace.name) {
                ArtSpace()
            }
            composable(route = MyAppScreen.AffirmationsApp.name) {
                AffirmationsApp()
//                AffirmationCard(Affirmation(R.string.affirmation1, R.drawable.image1))
//                AffirmationList(
//                    affirmationList = Datasource().loadAffirmations(),
//                    )
            }
            composable(route = MyAppScreen.CourseApp.name) {
                CourseCard(Topic(R.string.architecture, 58, R.drawable.architecture))

                CourseList(
                    couritemList = CourseDataSource.topics
                )

            }
            composable(route = MyAppScreen.DogApp.name) {
                WoofApp()
            }
            composable(route = MyAppScreen.LunchTrayApp.name) {
                LunchTrayApp()
            }
            composable(route = MyAppScreen.CupcakeApp.name) {
                CupcakeApp()
            }
            composable(route = MyAppScreen.WordGame.name) {
                WordGameScreen()
            }
            composable(route = MyAppScreen.ReplyApp.name) {
                ReplyApp(windowWidthSize)
            }
            composable(route = MyAppScreen.SportsApp.name) {
                SportsApp(windowWidthSize)
            }

        }

    }
}
@Composable
fun MyAppList(modifier: Modifier = Modifier,navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(20.dp)
    ) {
        Row (modifier = Modifier
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Button(
                onClick = { // go to a new page
                    navController.navigate(MyAppScreen.Greeting.name)
                     } ,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(red = 180 , green = 100 , blue = 100)
                )
            ) {
                Text(stringResource(id = R.string.greeting))

            }
            Button(
                onClick = { // go to a new page
                    navController.navigate(MyAppScreen.MyTask.name)
                } ,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(red = 180 , green = 100 , blue = 100)
                )
            ) {
                Text(stringResource(id = R.string.task_manager))

            }
            Button(
                onClick = { // go to a new page
                    navController.navigate(MyAppScreen.MyQuadrant.name)
                } ,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(red = 180 , green = 100 , blue = 100)
                )
            ) {
                Text(stringResource(id = R.string.my_quadrant))

            }

        }
        Row (modifier = Modifier
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Button(
                onClick = { // go to a new page
                    navController.navigate(MyAppScreen.MyBusinessCard.name)
                } ,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(red = 180 , green = 100 , blue = 100)
                )
            ) {
                Text(stringResource(id = R.string.my_business_card))

            }
            Button(
                onClick = { // go to a new page
                    navController.navigate(MyAppScreen.DiceGame.name)
                } ,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(red = 180 , green = 100 , blue = 100)
                )
            ) {
                Text(stringResource(id = R.string.dice))

            }
            Button(
                onClick = { // go to a new page
                    navController.navigate(MyAppScreen.Lemonade.name)
                } ,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(red = 180 , green = 100 , blue = 100)
                )
            ) {
                Text(stringResource(id = R.string.lemonade))

            }

        }
        Row (modifier = Modifier
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Button(
                onClick = { // go to a new page
                    navController.navigate(MyAppScreen.TipCalculate.name)
                } ,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(red = 180 , green = 100 , blue = 100)
                )
            ) {
                Text(stringResource(id = R.string.calculate_tip))

            }
            Button(
                onClick = { // go to a new page
                    navController.navigate(MyAppScreen.ArtSpace.name)
                } ,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(red = 180 , green = 100 , blue = 100)
                )
            ) {
                Text(stringResource(id = R.string.art_space))

            }
            Button(
                onClick = { // go to a new page
                    navController.navigate(MyAppScreen.AffirmationsApp.name)
                } ,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(red = 180 , green = 100 , blue = 100)
                )
            ) {
                Text(stringResource(id = R.string.affirmation_app))

            }

        }
        Row (modifier = Modifier
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Button(
                onClick = { // go to a new page
                    navController.navigate(MyAppScreen.CourseApp.name)
                } ,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(red = 180 , green = 100 , blue = 100)
                )
            ) {
                Text(stringResource(id = R.string.course_app))

            }
            Button(
                onClick = { // go to a new page
                    navController.navigate(MyAppScreen.DogApp.name)
                } ,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(red = 180 , green = 100 , blue = 100)
                )
            ) {
                Text(stringResource(id = R.string.dog_app))

            }
            Button(
                onClick = { // go to a new page
                    navController.navigate(MyAppScreen.LunchTrayApp.name)
                } ,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(red = 180 , green = 100 , blue = 100)
                )
            ) {
                Text(stringResource(id = R.string.lunch_tray_app))

            }

        }
        Row (modifier = Modifier
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Button(
                onClick = { // go to a new page
                    navController.navigate(MyAppScreen.CupcakeApp.name)
                } ,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(red = 180 , green = 100 , blue = 100)
                )
            ) {
                Text(stringResource(id = R.string.cupcake_app))

            }
            Button(
                onClick = { // go to a new page
                    navController.navigate(MyAppScreen.WordGame.name)
                } ,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(red = 180 , green = 100 , blue = 100)
                )
            ) {
                Text(stringResource(id = R.string.scramble_game))

            }
            Button(
                onClick = { // go to a new page
                    navController.navigate(MyAppScreen.ReplyApp.name)
                } ,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(red = 180 , green = 100 , blue = 100)
                )
            ) {
                Text(stringResource(id = R.string.reply_app))

            }

        }
        Row (modifier = Modifier
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = { // go to a new page
                    navController.navigate(MyAppScreen.SportsApp.name)
                } ,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(red = 180 , green = 100 , blue = 100)
                )
            ) {
                Text(stringResource(id = R.string.sports_app))

            }

        }
    }
}


///////////////////////
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

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FirstTheme(darkTheme = true) {
        MyApp(WindowWidthSizeClass.Expanded)
//        MyAppList()
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
//        WoofApp()
// navigation practice
//        LunchTrayApp()
//        Surface {
//            ReplyApp()
//        }
    }
}
