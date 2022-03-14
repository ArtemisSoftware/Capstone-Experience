package com.artemissoftware.capstoneexperience.screens.home

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
import com.artemissoftware.capstoneexperience.CapstoneExperienceApp
import com.artemissoftware.capstoneexperience.components.FABContent
import com.artemissoftware.capstoneexperience.components.ReaderAppBar
import com.artemissoftware.capstoneexperience.components.TitleSection
import com.artemissoftware.capstoneexperience.model.MBook
import com.artemissoftware.capstoneexperience.navigation.CapstoneScreens
import com.artemissoftware.capstoneexperience.ui.theme.CapstoneExperienceTheme

@Composable
fun HomeScreen(
    navController: NavController
) {

    Scaffold(

        topBar = {
            ReaderAppBar(
                title = "A.Reader",
                navController = navController
            )
        },
        floatingActionButton = {
            FABContent{
                navController?.navigate(CapstoneScreens.SearchScreen.name)
            }

        }
    ) {
        //content
        Surface(modifier = Modifier.fillMaxSize()) {
            //home content
            HomeContent(
                navController = navController,
                //viewModel = viewModel
            )

        }

    }
}



@Composable
fun HomeContent(
    navController: NavController,
    //--viewModel: HomeScreenViewModel
) {

    var listOfBooks = emptyList<MBook>()

    //TODO: Firebase
    val currentUser = "FirebaseAuth.getInstance().currentUser"
//
//    if (!viewModel.data.value.data.isNullOrEmpty()) {
//        listOfBooks = viewModel.data.value.data!!.toList().filter { mBook ->
//            mBook.userId == currentUser?.uid.toString()
//        }
//
//        Log.d("Books", "HomeContent: ${listOfBooks.toString()}")
//    }

//    val listOfBooks = listOf(
//          MBook(id = "dadfa", title = "Hello Again", authors = "All of us", notes = null),
//        MBook(id = "dadfa", title = " Again", authors = "All of us", notes = null),
//        MBook(id = "dadfa", title = "Hello ", authors = "The world us", notes = null),
//        MBook(id = "dadfa", title = "Hello Again", authors = "All of us", notes = null),
//        MBook(id = "dadfa", title = "Hello Again", authors = "All of us", notes = null)
//                            )

    //me @gmail.com
    //TODO: Firebase
//    val email = FirebaseAuth.getInstance().currentUser?.email
//    val currentUserName = if (!email.isNullOrEmpty())
//        FirebaseAuth.getInstance().currentUser?.email?.split("@")
//            ?.get(0)else
//        "N/A"

    Column(
        modifier = Modifier.padding(2.dp),
        verticalArrangement = Arrangement.Top
    ) {

        Row(
            modifier = Modifier
                .align(alignment = Alignment.Start)
        ) {

            TitleSection(label = "Your reading \n " + " activity right now...")

            Spacer(modifier = Modifier.fillMaxWidth(0.7f))

            Column {

                Icon(
                    imageVector = Icons.Filled.AccountCircle,
                    contentDescription = "Profile",
                    modifier = Modifier
                        .clickable {
                            navController.navigate(CapstoneScreens.StatsScreen.name)
                        }
                        .size(45.dp),
                    tint = MaterialTheme.colors.secondaryVariant
                )

                Text(
                    text = currentUser!!,
                    modifier = Modifier.padding(2.dp),
                    style = MaterialTheme.typography.overline,
                    color = Color.Red,
                    fontSize = 15.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Clip
                )

                Divider()
            }


        }

        ReadingRightNowArea(
            listOfBooks = listOfBooks,
            navController = navController
        )

        TitleSection(label = "Reading List")

//        BookListArea(
//            listOfBooks = listOfBooks,
//            navController = navController
//        )



    }

}



@Composable
fun ReadingRightNowArea(
    listOfBooks: List<MBook>,
    navController: NavController
) {

    //Filter books by reading now
//    val readingNowList = listOfBooks.filter { mBook ->
//        mBook.startedReading != null && mBook.finishedReading == null
//    }
//
//    HorizontalScrollableComponent(readingNowList){
//        Log.d("TAG", "BoolListArea: $it")
//        navController.navigate(ReaderScreens.UpdateScreen.name + "/$it")
//    }



}


@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    CapstoneExperienceTheme {
        //HomeScreen()
    }
}
