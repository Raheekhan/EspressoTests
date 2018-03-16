package rahee.experitest.com.espressotask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText inputField;
    Button button;
    TextView textViewField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputField = findViewById(R.id.inputField);
        button = findViewById(R.id.button);
        textViewField = findViewById(R.id.textViewField);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textViewField.setText(inputField.getText());

                if (inputField.getText().equals("") || inputField.getText().length() <= 0) {
                    textViewField.setText("Empty Input");
                }
            }
        });
    }
}
