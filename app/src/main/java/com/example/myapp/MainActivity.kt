package com.example.myapp

 import android.R
 import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
 import androidx.compose.material3.DropdownMenu
 import androidx.compose.material3.DropdownMenuItem
 import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
 import androidx.compose.runtime.getValue
 import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
 import androidx.compose.runtime.setValue
 import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapp.ui.theme.MYAPPTheme
 import kotlin.math.roundToInt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MYAPPTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    UnitConverter()
                }
            }
        }
    }
}

@Composable
fun UnitConverter() {
    var Btn1txt by remember { mutableStateOf("From") }
    var inputValue by remember { mutableStateOf("") }
    var outputValue by remember { mutableStateOf("")}
    var inputunit by remember { mutableStateOf("Meters") }
    var outputunit by remember { mutableStateOf("Meters")}

    var iexpanded by remember { mutableStateOf(false) }
    var oexpanded by remember { mutableStateOf(false)}
    val conversionFactor = remember { mutableStateOf(1.00)}

    fun convertUnit(){
        val inputValueDouble = inputValue.toDoubleOrNull()?:0.0
        val result = (inputValueDouble * conversionFactor.value*100.0).roundToInt()/100.0
        outputValue = result.toString()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
        ) {
        Text(text = "Unit Converter")
        Spacer(modifier = Modifier.height(32.dp))


        OutlinedTextField(
            value = inputValue,
            onValueChange =
                {
                inputValue= it
                            },
            label = {Text("Enter Value")})


        Spacer(modifier = Modifier.height(16.dp))
        Row {
            //input
            Box{
                Button(onClick = {iexpanded =true}){
                    Text(Btn1txt)

                    Icon(Icons.Default.ArrowDropDown,
                        contentDescription = " ")
                }
                DropdownMenu(expanded = iexpanded, onDismissRequest = {iexpanded=false}) {
                    DropdownMenuItem(
                        text = {Text("Centimeters")},
                        onClick = {
                            iexpanded=false
                            Btn1txt = "Centimeters"
                            inputunit = "Centimeter"
                            conversionFactor.value=0.01

                            convertUnit()
                        }
                    )
                    DropdownMenuItem(
                        text = {Text("Meter")},
                        onClick = {
                            iexpanded=false
                            Btn1txt = "Meter"
                            inputunit = "Meter"
                            conversionFactor.value=1.0
                            convertUnit()
                        }
                    )
                    DropdownMenuItem(
                        text = {Text("Feet")},
                        onClick = {
                            iexpanded=false
                            Btn1txt = "Feet"
                            inputunit = "Feet"
                            conversionFactor.value=0.3048
                            convertUnit()
                        }
                    )



                }
            }
            Spacer(modifier = Modifier.width(8.dp))
            Box(){
                Button(onClick = {}){

                    Text("Convert")
                }
            }
            Spacer(modifier = Modifier.width(8.dp))
            //output
            Box{
                Button(onClick = {oexpanded=true}) {
                    Text("Select")
                    Icon(Icons.Default.ArrowDropDown,
                        contentDescription = "")
                }
                DropdownMenu(expanded = oexpanded, onDismissRequest = {oexpanded=false}) {
                    DropdownMenuItem(
                        text = {Text("Centimeters")},
                        onClick = {}
                    )
                    DropdownMenuItem(
                        text = {Text("meter")},
                        onClick = {},
                    )
                    DropdownMenuItem(
                        text = {Text("feet")},
                        onClick = {}
                    )



                }
            }

        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Result: ")
    }
}


@Preview(showBackground = true)
@Composable
fun UnitConverterPreview() {

        UnitConverter()

}
