package com.example.first.ui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.annotation.VisibleForTesting
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.first.R
import java.text.NumberFormat

/**
 * @className: first
 * @desc: tip calculation
 * @version:
 * @author: blossom
 * @email:
 * @date: 2024/9/24 01:14 Tue
 * @copyright: Copyright (c) 2024 Yxy Inc. All Rights Reserved.
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
