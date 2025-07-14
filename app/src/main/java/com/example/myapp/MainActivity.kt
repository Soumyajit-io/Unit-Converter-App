package com.example.myapp

 import android.R
 import java.util.Locale
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
    var Btn2txt by remember { mutableStateOf("To") }

    var inputValue by remember { mutableStateOf("") }

    var resultt by remember { mutableStateOf("")}

    val iconversionFactor = remember { mutableStateOf(1.00)}
    val oconversionFactor = remember { mutableStateOf(1.00)}

    var iexpanded by remember { mutableStateOf(false) }
    var oexpanded by remember { mutableStateOf(false)}

    fun convertUnit(){
        val inputValueDouble = inputValue.toDoubleOrNull()?:0.0
        val result = (inputValueDouble*iconversionFactor.value*oconversionFactor.value)
        resultt = result.toString()
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
            onValueChange ={inputValue= it},
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
                        text = {Text("Millimeter")},
                        onClick = {
                            iexpanded=false
                            Btn1txt = "Millimeter"
                            iconversionFactor.value=0.001



                        }
                    )
                    DropdownMenuItem(
                        text = {Text("Centimeter")},
                        onClick = {
                            iexpanded=false
                            Btn1txt = "Centimeter"
                            iconversionFactor.value=0.01

                        }
                    )
                    DropdownMenuItem(
                        text = {Text("Meter")},
                        onClick = {
                            iexpanded=false
                            Btn1txt = "Meter"
                            iconversionFactor.value=1.00

                        }
                    )
                    DropdownMenuItem(
                        text = {Text("Kilometer")},
                        onClick = {
                            iexpanded=false
                            Btn1txt = "Kilometer"
                            iconversionFactor.value=1000.00



                        }
                    )
                    DropdownMenuItem(
                        text = {Text("Inch")},
                        onClick = {
                            iexpanded=false
                            Btn1txt = "Inch"
                            iconversionFactor.value=0.0254



                        }
                    )
                    DropdownMenuItem(
                        text = {Text("Foot")},
                        onClick = {
                            iexpanded=false
                            Btn1txt = "Foot"
                            iconversionFactor.value=0.3048



                        }
                    )
                    DropdownMenuItem(
                        text = {Text("Yard")},
                        onClick = {
                            iexpanded=false
                            Btn1txt = "Yard"
                            iconversionFactor.value=0.9144



                        }
                    )

                    DropdownMenuItem(
                        text = {Text("Mile")},
                        onClick = {
                            iexpanded=false
                            Btn1txt = "Mile"
                            iconversionFactor.value=1609.34



                        }
                    )



                }
            }
            Spacer(modifier = Modifier.width(8.dp))
            Box(){
                Button(onClick = {
                    convertUnit()


                }){

                    Text("Convert")
                }
            }
            Spacer(modifier = Modifier.width(8.dp))
            //output
            Box{
                Button(onClick = {oexpanded=true}) {
                    Text(Btn2txt)
                    Icon(Icons.Default.ArrowDropDown,
                        contentDescription = "")
                }
                DropdownMenu(expanded = oexpanded, onDismissRequest = {oexpanded=false}) {

                    DropdownMenuItem(
                        text = {Text("Millimeter")},
                        onClick = {
                            oexpanded=false
                            Btn2txt = "Millimeter"
                            oconversionFactor.value=1000.00



                        }
                    )
                    DropdownMenuItem(
                        text = {Text("Centimeter")},
                        onClick = {
                            oexpanded=false
                            Btn2txt = "Centimeter"
                            oconversionFactor.value=100.00

                        }
                    )
                    DropdownMenuItem(
                        text = {Text("Meter")},
                        onClick = {
                            oexpanded=false
                            Btn2txt = "Meter"
                            oconversionFactor.value=1.00

                        }
                    )
                    DropdownMenuItem(
                        text = {Text("Kilometer")},
                        onClick = {
                            oexpanded=false
                            Btn2txt = "Kilometer"
                            oconversionFactor.value=0.001



                        }
                    )
                    DropdownMenuItem(
                        text = {Text("Inch")},
                        onClick = {
                            oexpanded=false
                            Btn2txt = "Inch"
                            oconversionFactor.value=39.3701



                        }
                    )
                    DropdownMenuItem(
                        text = {Text("Foot")},
                        onClick = {
                            oexpanded=false
                            Btn2txt = "Foot"
                            oconversionFactor.value=3.28084



                        }
                    )
                    DropdownMenuItem(
                        text = {Text("Yard")},
                        onClick = {
                            oexpanded=false
                            Btn2txt = "Yard"
                            oconversionFactor.value=1.09361



                        }
                    )

                    DropdownMenuItem(
                        text = {Text("Mile")},
                        onClick = {
                            oexpanded=false
                            Btn2txt = "Mile"
                            oconversionFactor.value=0.000621371



                        }
                    )





                }
            }

        }
        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Result: $resultt")

    }
}


@Preview(showBackground = true)
@Composable
fun UnitConverterPreview() {

        UnitConverter()

}
