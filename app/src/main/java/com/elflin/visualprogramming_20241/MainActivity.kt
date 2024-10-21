package com.elflin.visualprogramming_20241

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.elflin.visualprogramming_20241.route.AppRouting
import com.elflin.visualprogramming_20241.ui.theme.VisualProgramming20241Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VisualProgramming20241Theme {
                AppRouting()
            }
        }
    }
}