import android.os.Bundle
import android.speech.RecognizerIntent
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var userInput: EditText
    private lateinit var sendButton: Button
    private lateinit var voiceButton: ImageView
    private lateinit var chatBox: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userInput = findViewById(R.id.userInput)
        sendButton = findViewById(R.id.sendButton)
        voiceButton = findViewById(R.id.voiceButton)
        chatBox = findViewById(R.id.chatBox)

        sendButton.setOnClickListener {
            val message = userInput.text.toString()
            handleTextMessage(message)
        }

        voiceButton.setOnClickListener {
            startVoiceRecognition()
        }
    }

    private fun handleTextMessage(message: String) {
        // ... lógica para manejar el mensaje de texto ...
        if (message.contains("Abre Google", ignoreCase = true)) {
            chatBox.append("\n@AI-TEXTO: Entendido, ya te abrire Google Chrome.")
            // Aquí se abriría Google Chrome
        } else if (message.contains("Que hora es", ignoreCase = true)) {
            val currentTime = Calendar.getInstance()
            val time = "${currentTime.get(Calendar.HOUR_OF_DAY)}:${currentTime.get(Calendar.MINUTE)}:${currentTime.get(Calendar.SECOND)}"
            val date = "${currentTime.get(Calendar.DAY_OF_MONTH)}/${currentTime.get(Calendar.MONTH) + 1}/${currentTime.get(Calendar.YEAR)}"
            chatBox.append("\n@AI-TEXTO: Entendido, ya te dire la hora y la fecha: $time, $date.")
        }
        userInput.text.clear()
    }

    private fun startVoiceRecognition() {
        // ... lógica para iniciar el reconocimiento de voz ...
        val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault())
        startActivityForResult(intent, REQUEST_CODE_VOICE_RECOGNITION)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_VOICE_RECOGNITION && resultCode == RESULT_OK) {
            val results = data?.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)
            results?.let {
                handleTextMessage(it[0]) // Procesar el primer resultado
            }
        }
    }

    companion object {
        private const val REQUEST_CODE_VOICE_RECOGNITION = 100
    }
}