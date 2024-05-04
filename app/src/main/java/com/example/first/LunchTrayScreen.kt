package com.example.first
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.first.data.DataSource
import com.example.first.ui.AccompanimentMenuScreen
import com.example.first.ui.CheckoutScreen
import com.example.first.ui.EntreeMenuScreen
import com.example.first.ui.NavOrderViewModel
import com.example.first.ui.NavStartOrderScreen
import com.example.first.ui.SideDishMenuScreen

// Screen enum
enum class MyNavScreen(@StringRes val title: Int) {
    Start(title = R.string.start_order),
    EntreeMenu(title = R.string.choose_entree),
    SideDishMenu(title = R.string.choose_side_dish),
    AccompanimentMenu(title = R.string.choose_accompaniment),
    Checkout(title = R.string.order_checkout)
}


/**
 * AppBar
 *
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavAppBar(
    currentScreen: MyNavScreen,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    androidx.compose.material3.TopAppBar(
        title = { Text(stringResource(currentScreen.title)) } ,
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ) ,
        modifier = modifier ,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack ,
                        contentDescription = stringResource(R.string.back_button)
                    )
                }
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LunchTrayApp(
    viewModel: NavOrderViewModel = viewModel() ,
    navController: NavHostController = rememberNavController()
) {
    // TODO: Create Controller and initialization
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = MyNavScreen.valueOf(
        backStackEntry?.destination?.route ?: MyNavScreen.Start.name
    )
    // Create ViewModel
//    val viewModel: OrderViewModel = viewModel()

    Scaffold(
        topBar = {
            // TODO: AppBar
            NavAppBar(
                currentScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() }
            )
        }
    ) { innerPadding ->
        val uiState by viewModel.uiState.collectAsState()
        // TODO: Navigation host
        NavHost(
            navController = navController,
            startDestination = MyNavScreen.Start.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = MyNavScreen.Start.name) {
                NavStartOrderScreen(
                    onStartOrderButtonClicked = {
                        navController.navigate(MyNavScreen.EntreeMenu.name)
                    },
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(dimensionResource(R.dimen.padding_medium))
                )

            }
            composable(route = MyNavScreen.EntreeMenu.name) {
                EntreeMenuScreen(
                    onNextButtonClicked = { navController.navigate(MyNavScreen.SideDishMenu.name) },
                    options = DataSource.entreeMenuItems,
                    onSelectionChanged = { viewModel.updateEntree(it) },
                    onCancelButtonClicked = {
                        viewModel.resetOrder()
                        navController.popBackStack(MyNavScreen.Start.name, inclusive = false) },
                    modifier = Modifier.fillMaxHeight()
                )
            }
            composable(route = MyNavScreen.SideDishMenu.name) {
                SideDishMenuScreen(
                    options = DataSource.sideDishMenuItems,
                    onNextButtonClicked = { navController.navigate(MyNavScreen.AccompanimentMenu.name) },
                    onCancelButtonClicked = {
                        viewModel.resetOrder()
                        navController.popBackStack(MyNavScreen.Start.name, inclusive = false)},
                    onSelectionChanged = { viewModel.updateSideDish(it)},
                    modifier = Modifier.fillMaxHeight()
                )
            }
            composable(route = MyNavScreen.AccompanimentMenu.name) {
                AccompanimentMenuScreen(
                    options = DataSource.accompanimentMenuItems,
                    onNextButtonClicked = { navController.navigate(MyNavScreen.Checkout.name) },
                    onCancelButtonClicked = {viewModel.resetOrder()
                        navController.popBackStack(MyNavScreen.Start.name, inclusive = false)},
                    onSelectionChanged = { viewModel.updateAccompaniment(it)},
                    modifier = Modifier.fillMaxHeight()
                )
            }
            composable(route = MyNavScreen.Checkout.name) {
                val context = LocalContext.current
                CheckoutScreen(
                    orderUiState = uiState,
                    onCancelButtonClicked = {viewModel.resetOrder()
                        navController.popBackStack(MyNavScreen.Start.name, inclusive = false)},
                    onNextButtonClicked = {
                        viewModel.resetOrder()
                        navController.popBackStack(MyNavScreen.Start.name, inclusive = false)
                    },
                    modifier = Modifier.fillMaxHeight()
                )
            }

        }
    }
}