//import android.text.Layout.Alignment
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.checkScrollableContainerConstraints
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.provider.FontsContractCompat.Columns
import com.erensaridag.composecomponents.R

/*
   Column : icerisine yerlestirilen her bir item'i yukaridan asagiya dikey bir sekilde hizalar-siralar diyebiliriz
   xml  deki verticalLinearLayouts"a karsilik gelir
   Y ekseninde siralama yapar
   */

/*
   Row :  icerisine yerlestirilen her bir item'i soldan saga dogru hizalar-siralar diyebiliriz
   xml deki horizantalLinearLayouts'a karsilik geliyor
   X ekseninde siralama yapar


   Box :   icerisine yerlestirilen her bir item'i ust uste bindirme yapar diyebilirz
   Z ekseninde siralama yapar
*/

@Composable
fun ColumnSamples() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text("Item One")
        Spacer(modifier = Modifier.height(16.dp))
        Text("Item Two")
        Spacer(modifier = Modifier.height(16.dp))
        Text("Item Threee")
    }
}

@Composable
fun RowSamples() {
    Row(
        modifier = Modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ) {
        Text("Item One")
        Spacer(modifier = Modifier.width(16.dp))
        Text("Item Two")
        Spacer(modifier = Modifier.width(16.dp))
        Text("Item Three")
    }
}

@Composable
fun BoxSamples() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "Launcher Background",
        )
        Text("Item One")
        Text("Item")

    }
}

@Composable
fun LayoutSample() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            modifier = Modifier.size(40.dp),
            painter = painterResource(id = R.drawable.ic_person),
            contentDescription = "Person",

            )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text("Name Surname")
            Text("Job Title")
        }
        Spacer(modifier = Modifier.weight(1f))
        Box(
            modifier = Modifier
                .background(
                    color = Color.Black,
                    shape = CircleShape,
                )
                .padding(4.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_delete),
                colorFilter = ColorFilter.tint(Color.White),
                contentDescription = "Delete",
            )
        }

    }
}


@Preview(showBackground = true)
@Composable
fun ColumnSamplesPreview() {
    ColumnSamples()
}

@Preview(showBackground = true)
@Composable
fun RowSamplesPreview() {
    RowSamples()
}

@Preview(showBackground = true)
@Composable
fun BoxSamplesPreview() {
    BoxSamples()
}

@Preview(showBackground = true)
@Composable
fun LayoutPreview() {
    LayoutSample()
}