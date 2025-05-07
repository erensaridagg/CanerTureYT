import android.media.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.erensaridag.composecomponents.R

@Composable
fun TextFields() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 72.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically)
    ) {
        Defualt()
        Outlined()
        TextFieldWithLeadingIcon()
        TextFieldWithTrailingIcon()
        TextFieldWithLeadingandTrailingIcon()
        Prefix()
        Suffix()
        SupportingText()
        PasswordTextField()
    }
}

@Composable
fun Defualt() {
    var value by rememberSaveable { mutableStateOf("") }
    TextField(
        value = value,
        onValueChange = { value = it },
        label = { Text("Default") },
        placeholder = { Text("Placeholder") },
    )
}

@Composable
private fun Outlined() {
    var value by rememberSaveable { mutableStateOf("") }
    OutlinedTextField(
        value = value,
        onValueChange = { value = it },
        label = { Text("Outlined") },
        placeholder = { Text("Placeholder") },
        enabled = true,
        readOnly = false,
        // textStyle = TextStyle(color = Color.Red),
        isError = false,
        keyboardOptions = KeyboardOptions(
            capitalization = KeyboardCapitalization.Words,
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Search,
        ),
        keyboardActions = KeyboardActions(
            onSearch = {},
            onNext = {},
        ),
        singleLine = false,
        maxLines = 2,
        minLines = 1,
        colors = OutlinedTextFieldDefaults.colors()
    )
}

@Composable
fun TextFieldWithLeadingIcon() {
    var value by rememberSaveable { mutableStateOf("") }

    OutlinedTextField(
        value = value,
        onValueChange = { value = it },
        label = { Text("Leading Icon") },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Email,
                contentDescription = "Email icon"
            )
        }

    )
}

@Composable
fun TextFieldWithTrailingIcon() {
    var value by rememberSaveable { mutableStateOf("") }

    OutlinedTextField(
        value = value,
        onValueChange = { value = it },
        label = { Text("Leading Icon") },
        trailingIcon = {
            Icon(
                imageVector = Icons.Default.Clear,
                contentDescription = "Clear icon"
            )
        }

    )
}

@Composable
fun TextFieldWithLeadingandTrailingIcon() {
    var value by rememberSaveable { mutableStateOf("") }
    OutlinedTextField(
        value = value,
        onValueChange = { value = it },
        label = { Text("Leading Icon") },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Email,
                contentDescription = "Email icon"
            )
        },
        trailingIcon = {
            Icon(
                imageVector = Icons.Default.Clear,
                contentDescription = "Clear icon"
            )
        }

    )

}

@Composable
fun Prefix() {
    var value by rememberSaveable { mutableStateOf("") }
    OutlinedTextField(
        value = value,
        onValueChange = { value = it },
        prefix = {
            Text("https://")
        }
    )
}

@Composable
fun Suffix() {
    var value by rememberSaveable { mutableStateOf("") }
    OutlinedTextField(
        value = value,
        onValueChange = { value = it },
        suffix = {
            Text("@gmail.com")
        }
    )
}

@Composable
fun SupportingText() {
    var value by rememberSaveable { mutableStateOf("") }
    OutlinedTextField(
        value = value,
        onValueChange = { value = it },
        label = { Text("Supporting Text") },
        supportingText = {
            Text(
                text = "*Required",
                color = Color.Red,
            )
        }
    )
}

@Composable
fun PasswordTextField() {
    var password by remember { mutableStateOf("") }
    var visibility by remember { mutableStateOf(false) }

    val icon = painterResource(if (visibility) R.drawable.ic_visibility_on else R.drawable.ic_visibility_off)

    val visualTransformation = if (visibility) VisualTransformation.None else PasswordVisualTransformation()

    OutlinedTextField(
        value = password,
        onValueChange = { password = it },
        label = { Text("Password") },
        trailingIcon = {
            IconButton(onClick = { visibility = !visibility }) {
                Icon(
                    painter = icon,
                    contentDescription = "Visibility Toggle",
                )
            }
        },
        visualTransformation = visualTransformation
    )
}



@Preview(showBackground = true)
@Composable
fun TextFieldsPreview() {
    TextFields()
}