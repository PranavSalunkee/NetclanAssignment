package com.example.netclanassignment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.netclanassignment.screens.explore.ExploreScreenContent
import com.example.netclanassignment.screens.refine.RefineScreen
import com.example.netclanassignment.ui.theme.NetclanAssignmentTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NetclanAssignmentTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    var nav by remember { mutableStateOf(true) }
                    if(nav ){
                        ExploreScreenContent(onButtonClick = {nav = !nav})
                    }
                    else RefineScreen(onButtonClick = {nav = !nav})

                }
            }
        }
    }
}

