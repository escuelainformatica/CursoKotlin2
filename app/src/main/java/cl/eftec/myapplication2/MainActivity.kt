package cl.eftec.myapplication2

import android.os.Bundle
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import cl.eftec.myapplication2.ui.theme.MyApplication2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        var valorcomponente = "hola";
        super.onCreate(savedInstanceState)
        setContent {
            MyApplication2Theme {
                var mutable1: MutableState<String> = remember { mutableStateOf("cambiado") }
                // escribir: mutable1.value="aaaa"   leer:mutable1.value

                var mutable2: String by remember { mutableStateOf("cambiado2") }
                var num1: Int by remember { mutableStateOf(0) }
                var num2: Int by remember { mutableStateOf(0) }
                // escribir: multable2="haaaa"    leer: mutable2
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Greeting("Android dfidfidfidfi")
                    Column {
                        Hijo1(mutable1.value, click = { mutable1.value = "hola" })
                        Hijo1(mutable2, click = { mutable2 = "hola" })
                        TextField(
                            value = mutable2,
                            onValueChange = { mutable2 = it; mutable1.value = it })
                        TextField(
                            value = num1.toString(),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                            onValueChange = { num1 = it.toInt(); mutable2=(num1+num2).toString()})
                        TextField(
                            value = num2.toString(),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                            onValueChange = { num2 = it.toInt(); mutable2=(num1+num2).toString()})
                    }
                }
            }
        }
    }
}

@Composable
fun Hijo1(valor: String, click: () -> Unit) {
    var local="hola mundo";
    Hijo2(valor)
    ElevatedButton(onClick = click) {
        Text("click")
    }
}

@Composable
fun Hijo2(valor: String) {
    Text(valor)

}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplication2Theme {
        Greeting("Android")
    }
}