package com.example.composeanimation1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandIn
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideIn
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.composeanimation1.ui.theme.ComposeAnimation1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeAnimation1Theme {
                Column(modifier = Modifier.fillMaxSize()) {
                    var isVisible by remember{
                        mutableStateOf(false)
                    }
                    
                    Button(onClick = { isVisible = !isVisible }) {
                        Text(text = "Toggle")
                    }
                    
                    AnimatedVisibility(
                        visible = isVisible,
                        modifier = Modifier.fillMaxWidth().weight(1f),
                        enter = fadeIn() +
//                                slideInHorizontally() +
                                expandVertically(),
                        exit = fadeOut() +
//                                slideOutHorizontally() +
                                shrinkVertically()
                    ) {
                        Box(modifier = Modifier.background(Color.Red))
                    }
                }
            }
        }
    }
}