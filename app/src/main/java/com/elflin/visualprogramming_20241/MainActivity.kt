package com.elflin.visualprogramming_20241

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.elflin.visualprogramming_20241.ui.theme.VisualProgramming20241Theme
import com.elflin.visualprogramming_20241.view.CalculatorTipView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VisualProgramming20241Theme {
                Surface (modifier = Modifier.fillMaxSize()) {
                    CalculatorTipView()
                }
            }
        }
    }
}