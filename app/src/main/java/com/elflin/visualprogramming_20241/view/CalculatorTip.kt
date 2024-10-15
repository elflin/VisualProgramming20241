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
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.elflin.visualprogramming_20241.viewmodel.CalculatorTipViewModel

@Composable
fun CalculatorTipView(
    modifier: Modifier = Modifier,
    viewModel: CalculatorTipViewModel = viewModel()
){
    val calculatorUIState by viewModel.calculatorUIState.collectAsState()

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
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
            value = calculatorUIState.billAmount.toString(),
            onValueChange = {viewModel.setBillAmount(it)},
            label = {Text("Bill Amount")},
            leadingIcon = { Icon(Icons.Default.Star, contentDescription = null) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            keyboardOptions = KeyboardOptions(keyboardType =  KeyboardType.Number)
        )

        TextField(
            value = calculatorUIState.tipPercentage.toString(),
            onValueChange = {viewModel.setTipPercentage(it)},
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
                checked = calculatorUIState.roundUpTip,
                onCheckedChange = {viewModel.setRoundUpTip(it)}
            )
        }

        Text(
            text = "Tip Amount : $${calculatorUIState.tipAmount}",
            fontSize = 24.sp,
            style = MaterialTheme.typography.bodyLarge
        )

        Button(
            onClick = {viewModel.CalcTimAmount()},
            modifier = Modifier
                .padding(vertical = 16.dp)
                .fillMaxWidth()
        ) {
            Text(
                "Calculate",
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.bodyLarge)
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun CalculatorTipPreview(){
    CalculatorTipView()
}