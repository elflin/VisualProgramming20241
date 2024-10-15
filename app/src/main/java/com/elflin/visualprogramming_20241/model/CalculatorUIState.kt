package com.elflin.visualprogramming_20241.model

data class CalculatorUIState(
    var billAmount: Int = 0,
    var tipPercentage: Int = 0,
    var roundUpTip: Boolean = false,
    var tipAmount: Float = 0.0f
)