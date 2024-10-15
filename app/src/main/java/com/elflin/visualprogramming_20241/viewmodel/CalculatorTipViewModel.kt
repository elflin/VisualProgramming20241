package com.elflin.visualprogramming_20241.viewmodel

import androidx.lifecycle.ViewModel
import com.elflin.visualprogramming_20241.model.CalculatorUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlin.math.ceil

class CalculatorTipViewModel(): ViewModel(){

    private val _calculatorUIState = MutableStateFlow<CalculatorUIState>(CalculatorUIState())
    val calculatorUIState: StateFlow<CalculatorUIState> = _calculatorUIState

    fun setBillAmount(it: String){
        _calculatorUIState.value = _calculatorUIState.value.copy(billAmount = it.toIntOrNull() ?: 0)
        CalcTimAmount()
    }

    fun setTipPercentage(it: String){
        _calculatorUIState.value = _calculatorUIState.value.copy(tipPercentage = it.toIntOrNull() ?: 0)
        CalcTimAmount()
    }

    fun setRoundUpTip(it: Boolean){
        _calculatorUIState.value = _calculatorUIState.value.copy(roundUpTip = it)
        CalcTimAmount()
    }

    fun CalcTimAmount(){
        val bill = calculatorUIState.value.billAmount.toFloat()
        val tipPercent = calculatorUIState.value.tipPercentage.toFloat()
        var tipAmount = bill * (tipPercent / 100)

        if (calculatorUIState.value.roundUpTip){
            tipAmount = ceil(tipAmount)
        }

        _calculatorUIState.value = _calculatorUIState.value.copy(tipAmount = tipAmount)
    }

}