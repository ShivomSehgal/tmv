package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Enigma extends AppCompatActivity {

    Button button;
    TextView text1;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enigma);

        button = findViewById(R.id.enigmaButtonPasswordGenerator);
//        generateButton.setBackgroundResource(000000);
        button=findViewById(R.id.enigmaButtonPasswordGenerator);
        button.setBackgroundResource(000000);
        text1=findViewById(R.id.generatedPasswordEnigma);
        editText=findViewById(R.id.enigmaEnterKeyword);
//         listView=findViewById(R.id.)

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String str = editText.getText().toString();
                if (str.isEmpty()) {
//                    Toast.makeText(Enigma.this, editText.setError(), Toast.LENGTH_SHORT).show();
                    editText.setError("Enter Keyword ");
                } else {
                    String result = caesarCypherEncryptor(str, 5);
                    text1.setText("@#" + runLengthEncoding(result) + "5$%&");
                    Toast.makeText(Enigma.this, "Password Generated", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public static String caesarCypherEncryptor(String string, int key) {
        char[] letters=new char[string.length()];
        String alphabets="a!b@c#d$e%f^g&h*i-j+k<l>m?n/o;p:q{r}s[t]u`v|w~x,y.z";
        int shift=key%alphabets.length();


        for(int i=0; i<string.length(); i++){
            letters[i] = shifter(string.charAt(i),alphabets,shift);
        }
        return new String(letters) + runLengthEncoding(new String(letters));
    }

    public static char shifter(char letter, String alphabets, int shift){
        int Idx=alphabets.indexOf(letter)+shift;
        return alphabets.charAt(Idx % 26);
    }
    public static String runLengthEncoding(String string) {
        StringBuilder sb=new StringBuilder();
        int counter=1;

        for(int i=1;i<string.length();i++){
            char currentcharacter=string.charAt(i);
            char previouscharacter=string.charAt(i-1);

            if(currentcharacter!=previouscharacter || counter==9){
                sb.append(Integer.toString(counter));
                sb.append(previouscharacter);
                counter=0;
            }
            counter++;
        }
        sb.append(Integer.toString(counter));
        sb.append(string.charAt(string.length()-1));
        return sb.toString();
    }
//    public void openActivity(View view){
//        Intent intent=new Intent(this,MainActivity2.class);
//        startActivity(intent);
//    }
//    }
}