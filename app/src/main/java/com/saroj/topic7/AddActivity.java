package com.saroj.topic7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.io.PrintStream;

public class AddActivity extends AppCompatActivity {
    EditText etWord, etDefinition;
    Button btnAddWord;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        etWord =findViewById(R.id.etWord);
        etDefinition =findViewById(R.id.etMeaning);
        btnAddWord =findViewById(R.id.btnAddWord);

        btnAddWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Save();
            }
        });
    }

    private void Save(){
        try {
            PrintStream printStream = new PrintStream(openFileOutput("word.txt",MODE_PRIVATE));
            printStream.println((etWord.getText().toString() + "->" + etDefinition.getText().toString()));
            Toast.makeText(this,"Saved to" + getFilesDir(),Toast.LENGTH_LONG).show();
        }catch (IOException e){
            Log.d("Dictionary app","Error" + e.toString());
            e.printStackTrace();
        }
    }

}
