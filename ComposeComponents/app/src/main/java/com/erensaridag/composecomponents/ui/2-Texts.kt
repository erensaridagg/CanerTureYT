import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
        /* Bu ornekte normal bir textin alabilecegi ozellikleri gorduk giris seviyesi icin yeterlidir bence. */
fun NormalText() {

    /* " BasicText() " <-- Egerki NormalTextdeki gibi fazla ozellikler kullanmak istemiyorsak bu arkadasi kullnamk performans acisindan daha iyi olur.
    BaseComponenet yaparken tercih edilir. */

    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        text = "Lorem Ipsum Dolor Consectetur Adipiscing Elit, Sed Do Eiusmod.",
        fontSize = 24.sp,
        lineHeight = 32.sp,
        color = Color.Red,
        maxLines = 4,
        letterSpacing = 1.sp,
        fontWeight = FontWeight.ExtraBold,
        fontStyle = FontStyle.Italic,
        fontFamily = FontFamily.Monospace,
        textAlign = TextAlign.Center,
    )
}

@Composable
        /* Bu ornekte ise yazilan bir textin belirli bir noktasini link seklinde nasil verilir onu gormus olduk.*/
fun AnnotatedText() {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        text = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    color = Color.Blue,
                    fontWeight = FontWeight.Bold,
                    textDecoration = TextDecoration.Underline,  /* altiCizili yapar*/

                )
            ) {
                append("Kullanim sartlarini")
            }
            append(" okudum,kabul ediyorum")
            "Kullanim sartlarini okudum , kabul ediyorum"
        }
    )
}

@Composable
        /*Burada ise yine textin ozellikeri var ama TextStyle ile ozellestirme yapiyoruz.*/
fun TextStyleText() {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        text = "Lorem Ipsum Dolor Consectetur Adipiscing Elit, Sed Do Eiusmod.",
        style = TextStyle(
            brush = Brush.horizontalGradient(colors = listOf(Color.Red, Color.Blue)),
            shadow = Shadow(
                color = Color.Gray,
                offset = Offset(10f, 10f),
                blurRadius = 10f,
            )
        )
    )
}

@Composable
        /*Buarada ise verilen textin devaminin oldugu bildirmek icin yazi sonuna ... nokta koyuyoruz*/
fun OverFlowText() {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        text = "Lorem Ipsum Dolor Consectetur Adipiscing Elit, Sed Do Eiusmod.",
        maxLines = 1,
        overflow = TextOverflow.Ellipsis   /*Elipsis yapiyor bu gorevi sigdirabildigini sigdirir.Geneldede bu kullanilir */
    )
}

@Composable
        /*Bu ornegimizde ise textin uzerini cizili yapiyoruz*/
fun TextDecorationText() {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        text = "Lorem Ipsum Dolor Consectetur Adipiscing Elit, Sed Do Eiusmod.",
        textDecoration = TextDecoration.LineThrough,  /* ustuCizili yapar*/
        /* Bunun birde altiCizili sekli vardir onuda yukaridaki AnnotatedTextte ornek olarak yazdik.
        * ve birde None hali var oda texti ayni birakir bi olayi yok yani
        * */


    )
}


@Preview(showBackground = true)
@Composable
private fun TextsPreview() {
    NormalText()
}

@Preview(showBackground = true)
@Composable
private fun AnnotatedTextPreview() {
    AnnotatedText()
}

@Preview(showBackground = true)
@Composable
private fun TextStyleTextPreview() {
    TextStyleText()
}

@Preview(showBackground = true)
@Composable
private fun OverFlowTextPreview() {
    OverFlowText()
}

@Preview(showBackground = true)
@Composable
private fun TextDecorationTextPreview() {
    TextDecorationText()
}
