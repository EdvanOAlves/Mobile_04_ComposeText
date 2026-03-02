package com.example.mobile_04_composetext

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.mobile_04_composetext.ui.theme.MOBILE_04_ComposeTextTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MOBILE_04_ComposeTextTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BasicComponentScreen( modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun BasicComponentScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .background(Color(137, 200, 255, 255))
            .fillMaxSize()
    ){
        Text(
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Start,
            text = "Aulas android",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Serif,
            letterSpacing = 2.sp,
            color = Color(223, 111, 75),
        )
        Text(
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            text = "Com Jetpack Compose",
            fontSize = 24.sp,
            fontWeight = FontWeight.SemiBold,
//            fontFamily = patrickFont,
            color = Color(80, 67, 89, 255)
        )
        //Estrutura para mudar o estado e lembrar da mudança
        val nameField = remember {
            mutableStateOf("Android")
        }
        TextField(
            value = nameField.value,
            onValueChange = { newInput ->
//                Log.i("Teste", newInput) // Log é um baita recurso para observar mudanças de estado
                nameField.value = newInput
            }
        )

        var ageField = remember {
            mutableStateOf("80085")
        }
        TextField(
            value = ageField.value,
            onValueChange = { newInput ->
//                Log.i("Teste", newInput) // Log é um baita recurso para observar mudanças de estado
                ageField.value = newInput
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
    }
}