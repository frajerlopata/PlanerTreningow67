package com.example.planertreningow;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView imgCwiczenie;
    private TextView tvNazwaCwiczenia;
    private TextView tvLicznikSerii;
    private TextView tvLacznaLiczbaSerii;
    private Button btnLosuj, btnMinus, btnPlus, btnNastepne, btnReset;

    private int licznikSeriiAktualnego = 0;
    private int lacznaLiczbaSerii = 0;
    private int wylosowanyNumer = 0;

    private final int[] tablicaObrazow = {
            R.drawable.cwiczenie0,
            R.drawable.cwiczenie1,
            R.drawable.cwiczenie2,
            R.drawable.cwiczenie3,
            R.drawable.cwiczenie4,
            R.drawable.cwiczenie5,
            R.drawable.cwiczenie6
    };

    private final String[] tablicaNazw = {
            "Losuj ćwiczenie",
            "Przysiad",
            "Pompki",
            "Plank",
            "Wykroki",
            "Burpees",
            "Podciąganie"
    };

    private final Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgCwiczenie = findViewById(R.id.imgCwiczenie);
        tvNazwaCwiczenia = findViewById(R.id.tvNazwaCwiczenia);
        tvLicznikSerii = findViewById(R.id.tvLicznikSerii);
        tvLacznaLiczbaSerii = findViewById(R.id.tvLacznaLiczbaSerii);

        btnLosuj = findViewById(R.id.btnLosuj);
        btnMinus = findViewById(R.id.btnMinus);
        btnPlus = findViewById(R.id.btnPlus);
        btnNastepne = findViewById(R.id.btnNastepne);
        btnReset = findViewById(R.id.btnReset);

        btnLosuj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                losujNoweCwiczenie();
            }
        });

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                licznikSeriiAktualnego++;
                aktualizujWidokLicznika();
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (licznikSeriiAktualnego > 0) {
                    licznikSeriiAktualnego--;
                    aktualizujWidokLicznika();
                }
            }
        });

        btnNastepne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lacznaLiczbaSerii += licznikSeriiAktualnego;
                tvLacznaLiczbaSerii.setText("Łączna liczba serii: " + lacznaLiczbaSerii);
                losujNoweCwiczenie();
            }
        });


        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                licznikSeriiAktualnego = 0;
                lacznaLiczbaSerii = 0;
                wylosowanyNumer = 0;

                imgCwiczenie.setImageResource(tablicaObrazow[0]);
                tvNazwaCwiczenia.setText(tablicaNazw[0]);
                tvLicznikSerii.setText("0");
                tvLacznaLiczbaSerii.setText("Łączna liczba serii: 0");
            }
        });
    }

    private void losujNoweCwiczenie() {
        wylosowanyNumer = random.nextInt(6) + 1;
        imgCwiczenie.setImageResource(tablicaObrazow[wylosowanyNumer]);
        tvNazwaCwiczenia.setText(tablicaNazw[wylosowanyNumer]);

        licznikSeriiAktualnego = 0;
        aktualizujWidokLicznika();
    }

    private void aktualizujWidokLicznika() {
        tvLicznikSerii.setText(String.valueOf(licznikSeriiAktualnego));
    }
}