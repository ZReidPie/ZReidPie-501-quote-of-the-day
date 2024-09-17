package com.example.quoteofthedayapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quoteofthedayapp.ui.theme.QuoteOfTheDayAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuoteOfTheDayAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    QuoteScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun QuoteScreen(modifier: Modifier = Modifier) {
    // Default state of current quote
    var currentQuote by remember { mutableStateOf("Believe in yourself and all that you are. — Christian D. Larson") }

    // List of motivational quotes
    val quotes = listOf(
        "Just Do it — Shia LaBeouf",
        "There's a snake in my boot — Sheriff Woody",
        "It always seems impossible until its done — Nelson Mandela",
        "To bring about change, you must not be afraid to take the first step. We will fail when we fail to try. — Rosa Parks",
        "Champions keep playing until they get it right. — Billie Jean King",
        "You see, sometimes friends have to go away, but a part of them stays behind with you.— Ash Ketchum, Pokémon",
        "It is during our darkest moments that we must focus to see the light. — Aristotle",
        "Life shrinks or expands in proportion to one’s courage. — Anaïs Nin",
        "All dreams are within reach. All you have to do is keep moving towards them. — Viola Davis",
        "When it comes to luck, you make your own. — Bruce Springsteen",
        "You just gotta keep going and fighting for everything, and one day you’ll get to where you want. — Naomi Osaka",
        "It’s a toxic desire to try to be perfect. I realized later in life that the challenge is not to be perfect. It’s to be whole. — Jane Fonda"

    )

    // Making Column to center text(quote) and Button
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Text displaying the quote with styling
        Text(
            text = currentQuote,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Blue,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(16.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Button to change the quote
        Button(onClick = {
            // Randomly select a quote from the list
            currentQuote = quotes.random()
        }) {
            Text("Change Quote")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun QuoteScreenPreview() {
    QuoteOfTheDayAppTheme {
        QuoteScreen()
    }
}
