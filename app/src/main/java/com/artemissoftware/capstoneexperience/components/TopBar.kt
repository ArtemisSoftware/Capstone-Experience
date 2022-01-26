package com.artemissoftware.capstoneexperience.components

import android.content.Context
import android.view.MotionEvent
import android.widget.Toast
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter

@Composable
fun ReaderAppBar(
    title: String,
    icon: ImageVector? = null,
    showProfile: Boolean = true,
    navController: NavController? =null,
    onBackArrowClicked:() -> Unit = {}
) {

    TopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ){
                if (showProfile) {
                    Icon(
                        imageVector = Icons.Default.Favorite,
                        contentDescription = "Logo Icon",
                        modifier = Modifier
                            .clip(RoundedCornerShape(12.dp))
                            .scale(0.9f)
                    )
                }

                if (icon != null) {
                    Icon(
                        imageVector = icon,
                        contentDescription = "arrow back",
                        tint = Color.Red.copy(alpha = 0.7f),
                        modifier = Modifier
                            .clickable { onBackArrowClicked.invoke() }
                    )
                }

                Spacer(modifier = Modifier.width(40.dp))

                Text(
                    text = title,
                    color = Color.Red.copy(alpha = 0.7f),
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp)
                )


        }


    },
        actions = {
            IconButton(onClick = {
                //TODO: Firebase
//                FirebaseAuth.getInstance()
//                    .signOut().run {
//                        navController.navigate(ReaderScreens.LoginScreen.name)
//                    }
            }) {
                if (showProfile) Row() {
                    Icon(
                        imageVector = Icons.Filled.Logout ,
                        contentDescription = "Logout" ,
                        tint = Color.Green.copy(alpha = 0.4f)
                    )
                }else Box {}



            }
        },
        backgroundColor = Color.Transparent,
        elevation = 0.dp)

}