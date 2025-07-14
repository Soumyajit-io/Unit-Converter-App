package com.example.myapp


 import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
 import androidx.compose.foundation.layout.padding
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
 import androidx.compose.ui.text.font.FontWeight
 import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
 import androidx.compose.ui.unit.sp
 import com.example.myapp.ui.theme.MYAPPTheme

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

    var unit by remember { mutableStateOf("") }
    var unitshow by remember { mutableStateOf("") }

    var resultt by remember { mutableStateOf("")}

    val iconversionFactor = remember { mutableStateOf(1.00)}
    val oconversionFactor = remember { mutableStateOf(1.00)}

    var iexpanded by remember { mutableStateOf(false) }
    var oexpanded by remember { mutableStateOf(false)}

    val context = LocalContext.current

    fun error(){
        Toast.makeText(context,"Invalid Value", Toast.LENGTH_LONG).show()
    }
    fun convertUnit(){

        val inputValueDouble = inputValue.toDoubleOrNull()
        if(inputValueDouble==null){
            error()
            return
        }
        val result = (inputValueDouble*iconversionFactor.value*oconversionFactor.value).toFloat()
        resultt = result.toString()
        unitshow= unit
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
        ) {

        Text(
            text = "Unit Converter",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF1E88E5),
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

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
            Box{
                Button(onClick = {

                    convertUnit()
                    Toast.makeText(context,"Converted Successfully", Toast.LENGTH_LONG).show()


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
                            unit = "mm"



                        }
                    )
                    DropdownMenuItem(
                        text = {Text("Centimeter")},
                        onClick = {
                            oexpanded=false
                            Btn2txt = "Centimeter"
                            oconversionFactor.value=100.00
                            unit = "cm"

                        }
                    )
                    DropdownMenuItem(
                        text = {Text("Meter")},
                        onClick = {
                            oexpanded=false
                            Btn2txt = "Meter"
                            oconversionFactor.value=1.00
                            unit = "m"

                        }
                    )
                    DropdownMenuItem(
                        text = {Text("Kilometer")},
                        onClick = {
                            oexpanded=false
                            Btn2txt = "Kilometer"
                            oconversionFactor.value=0.001
                            unit = "km"



                        }
                    )
                    DropdownMenuItem(
                        text = {Text("Inch")},
                        onClick = {
                            oexpanded=false
                            Btn2txt = "Inch"
                            oconversionFactor.value=39.3701
                            unit = "in"



                        }
                    )
                    DropdownMenuItem(
                        text = {Text("Foot")},
                        onClick = {
                            oexpanded=false
                            Btn2txt = "Foot"
                            oconversionFactor.value=3.28084
                            unit = "ft"



                        }
                    )
                    DropdownMenuItem(
                        text = {Text("Yard")},
                        onClick = {
                            oexpanded=false
                            Btn2txt = "Yard"
                            oconversionFactor.value=1.09361
                            unit = "yd"



                        }
                    )

                    DropdownMenuItem(
                        text = {Text("Mile")},
                        onClick = {
                            oexpanded=false
                            Btn2txt = "Mile"
                            oconversionFactor.value=0.000621371
                            unit = "mi"



                        }
                    )





                }
            }

        }
        Spacer(modifier = Modifier.height(16.dp))



        Text(text = "Result: $resultt $unitshow",
            fontSize = 24.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color(0xFF388E3C), // A nice green shade
            modifier = Modifier
                .padding(top = 16.dp)
                .align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.height(50.dp))
        Text(
            text = "Made with ❤️ by SoumyajiT",
            fontSize = 14.sp,
            color = Color.Gray,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 32.dp, bottom = 16.dp)
        )

    }

}



@Preview(showBackground = true)
@Composable
fun UnitConverterPreview() {

        UnitConverter()

}
