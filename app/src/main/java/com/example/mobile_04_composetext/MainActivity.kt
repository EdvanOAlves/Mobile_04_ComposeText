package com.example.mobile_04_composetext

import android.R.attr.checked
import android.R.attr.contentDescription
import android.R.attr.label
import android.R.attr.text
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mobile_04_composetext.ui.theme.MOBILE_04_ComposeTextTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MOBILE_04_ComposeTextTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BasicComponentScreen(modifier = Modifier.padding(innerPadding))
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
            .fillMaxSize(),
//        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
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
        var nameField by remember {
            mutableStateOf("")
        }
        var ageField by remember {
            mutableStateOf("")
        }
        var emailField by remember {
            mutableStateOf("")
        }

        var jCompose by remember {
            mutableStateOf(false)
        }

        var xml by remember {
            mutableStateOf(false)
        }

        var sOperacional by remember {
            mutableStateOf("")
        }

        var buttonCol by remember {
            mutableStateOf(Color(130, 20, 180))
        }
        var click by remember {
            mutableStateOf(false)
        }

        TextField(
            value = nameField,
            onValueChange = { newInput ->
//                Log.i("Teste", newInput) // Log é um baita recurso para observar mudanças de estado
                nameField = newInput
            },
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.Sentences
            ),
            //Label é um titulo do campo, ele vai diminuir e virar o header do campo quando esse entrar em foco
            label = {
                Text(text = "Nome Completo")
            },
            //Placeholder é o texto que fica de exemplo no campo, some assim que o campo recebe o primeiro input
            //extra: quando tem um label o placeholder fica escondido até o campo ficar em foco
            placeholder = {
                Text(text = "Digite seu nome e sobrenome")
            },

            //Icone que fica no inicio do textField
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "person icon",
                    tint = Color(123, 123, 123)
                )
            },
            //Icone que fica no fim do textField
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.AddCircle,
                    contentDescription = "add icon",
                    tint = Color(123, 123, 123)
                )
            },
            singleLine = true

        )

        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = ageField,
            onValueChange = { newInput ->
//                Log.i("Teste", newInput) // Log é um baita recurso para observar mudanças de estado
                ageField = newInput
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            label = {
                Text(text = "Idade")
            },
            placeholder = {
                Text(text = "Digite sua idade")
            },
            leadingIcon = {
//                Icon(imageVector = Icons.Default.DateRange)
            },
            //mudando cores dos textos em TextField
            colors = TextFieldDefaults.colors(
                //Quando o texto do campo estiver em foco
                focusedTextColor = Color(100, 85, 200),
                //Quando o texto do campo sair do foco
                unfocusedTextColor = Color(200, 100, 85),
                //Para o placeholder no momento sem foco
                unfocusedPlaceholderColor = Color(85, 200, 200),

                //tem muita coisa que dá pra mexer nesse .colors, se quiser conferir é só passar o mouse em cima
            ),
            singleLine = true

        )
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = emailField,
            //Quando a callback recebe só um campo usamos o it
            onValueChange = { emailField = it },
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "Email")
            },
            placeholder = {
                Text("Insira o seu email")
            },
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = Color(100, 85, 200),
                unfocusedTextColor = Color(200, 100, 85),
                unfocusedPlaceholderColor = Color(85, 200, 200),

                focusedBorderColor = Color(160, 8, 120),
                unfocusedBorderColor = Color(120, 8, 160)
                //tem muita coisa que dá pra mexer nesse .colors, se quiser conferir é só passar o mouse em cima
            ),
            shape = RoundedCornerShape(topEnd = 20.dp, bottomStart = 20.dp)
        )

        Row(
            modifier = modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = jCompose,
                onCheckedChange = { jCompose = it },
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.Green,
                    Color.Red
                )
            )
            Text(text = "Jetpack Compose")

        }
        Row(
            modifier = modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = xml,
                onCheckedChange = { xml = it }
            )
            Text(text = "Jetpack XML")

        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            RadioButton(
                selected = sOperacional == "android",
                onClick = {
                    sOperacional = "android"
                }
            )
            Text(text = "Android")

        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            RadioButton(
                selected = sOperacional == "ios",
                onClick = {
                    sOperacional = "ios"
                }
            )
            Text(text = "IOS")
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Button(
                onClick = {
                    //Brincadeira de troca de cores, em essencia é mudar uma variavel
                    //com remember que é utilizada por outras coisas, se colocar o buttonCol
                    //em outra variavel ele vai funcionar, bacana para controlar outros elementos
                    if (click){
                        click = false
                        buttonCol = Color(130, 20, 180)
                    }else{
                        buttonCol = Color(20, 60, 180)
                        click = true
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = buttonCol,
                    contentColor = Color.White
                ),
                border = BorderStroke(4.dp, color = Color(80, 12, 120)),
                shape = RoundedCornerShape(topEnd = 10.dp, bottomStart = 10.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "delete icon"
                )
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "delete icon"
                )
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "delete icon"
                )
                Text(text = "Duvido tu clicar")
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "delete icon"
                )
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "delete icon"
                )
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "delete icon"
                )
            }
        }
        Row(
            Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center) { }
        OutlinedButton(
            onClick = {
                buttonCol = Color.White
            }
        ){
            Text(text = "Outro botuAUm")
        }

        Row(
            Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ){
            var favorite by remember {
                mutableStateOf(false)
            }

            if (favorite){
                Icon(
                    modifier = Modifier.clickable{favorite = false},
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "Favorite Icon",
                )
            }else{
                Icon(
                    modifier = Modifier.clickable{favorite = true},
                    imageVector = Icons.Default.FavoriteBorder,
                    contentDescription = "Favorite Border Icon"
                )
            }




        }
    }
}