package com.artemissoftware.capstoneexperience.screens

import android.annotation.SuppressLint
import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationVector1D
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.artemissoftware.capstoneexperience.components.ReaderLogo
import com.artemissoftware.capstoneexperience.navigation.CapstoneScreens
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {

    val scale = remember {
        Animatable(0f)
    }

    LaunchedEffect(key1 = true) {

        scale.animateTo(
            targetValue = 0.9f,
            animationSpec = tween(
                durationMillis = 800,
                easing = {
                    OvershootInterpolator(8f)
                        .getInterpolation(it)
                }
            )
        )

        delay(2000L)

        //navController.navigate(route = CapstoneScreens.LoginScreen.name)
        navController.navigate(route = CapstoneScreens.HomeScreen.name)
    }

    SplashContent(scale)


}

@Composable
private fun SplashContent(scale: Animatable<Float, AnimationVector1D>) {

    Surface(
        modifier = Modifier
            .padding(15.dp)
            .size(330.dp)
        .scale(scale.value),
        shape = CircleShape,
        color = Color.White,
        border = BorderStroke(
            width = 2.dp,
            color = Color.LightGray
        )
    ) {
        Column(
            modifier = Modifier.padding(1.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            ReaderLogo()
            Spacer(modifier = Modifier.height(15.dp))
            Text(
                text = "\"Read. Change. Yourself \"",
                style = MaterialTheme.typography.h5,
                color = Color.LightGray
            )



        }


    }

}

@SuppressLint("UnrememberedAnimatable")
@Preview(showBackground = false)
@Composable
private fun DefaultPreview() {

}