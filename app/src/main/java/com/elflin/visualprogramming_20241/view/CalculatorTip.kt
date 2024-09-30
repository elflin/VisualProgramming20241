package com.elflin.visualprogramming_20241.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.ceil

@Composable
fun CalculatorTipView(){

    var billAmount by remember { mutableStateOf("") }
    var tipPercentage by remember { mutableStateOf("") }
    var roundUpTip by remember { mutableStateOf(false) }
    var tipAmount by remember { mutableStateOf(0.0) }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Text(
            text = "Calculate Tip",
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.Left,
            modifier = Modifier
                .fillMaxWidth()
        )

        TextField(
            value = billAmount,
            onValueChange = {billAmount = it},
            label = {Text("Bill Amount")},
            leadingIcon = { Icon(Icons.Default.Star, contentDescription = null) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            keyboardOptions = KeyboardOptions(keyboardType =  KeyboardType.Number)
        )

        TextField(
            value = tipPercentage,
            onValueChange = {tipPercentage = it},
            label = {Text("Tip Percentage")},
            leadingIcon = { Icon(Icons.Default.ShoppingCart, contentDescription = null) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            keyboardOptions = KeyboardOptions(keyboardType =  KeyboardType.Number)
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
        ) {
            Text(text = "Round up tip?")
            Spacer(modifier = Modifier.weight(1f))
            Switch(
                checked = roundUpTip,
                onCheckedChange = {
                    roundUpTip = it

                    val bill = billAmount.toDoubleOrNull() ?: 0.0
                    val tipPercent = tipPercentage.toDoubleOrNull() ?: 0.0
                    tipAmount = bill * (tipPercent / 100)

                    if (roundUpTip){
                        tipAmount = ceil(tipAmount)
                    }
                }
            )
        }

        Text(
            text = "Tip Amount : $${tipAmount}",
            fontSize = 24.sp,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun CalculatorTipPreview(){
    CalculatorTipView()
}