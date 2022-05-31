package com.iremgurgen.project;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    PreferenceHelper preferenceHelper;

    //Kayıt Bilgileri Type
    EditText edtFolder;
    EditText edtMerkezFrekans;
    EditText edtOrneklemeHizi;
    EditText edtBantGenisligi;
    EditText edtDosyaBoyutu;
    EditText edtTarih;

    //Spektrum-Spektrogram Opsiyon Type
    EditText edtOfSet;
    EditText edtBantGenisligiSpektrum;
    EditText edtPencereUz;
    Spinner spinnerWindowingTip;            //Selectable!!!!!!!!!!!!!!!!!!!
    Spinner spinnerFrekCoz;                 //Selectable!!!!!!!!!!!!!!!!!!!
    Spinner spinnerSelaleZAraligi;          //Selectable!!!!!!!!!!!!!!!!!!!
    Spinner spinnerSinyalStat;              //Selectable!!!!!!!!!!!!!!!!!!!

    //Sembol Hızı Opsiyon Type
    EditText edtMinBaud;
    EditText edtMaxBaud;
    EditText edtEsikDegeri;
    EditText edtIkinciEsik;

    //Göz Çizelgesi Yıldız Kümesi Opsiyon Type
    Spinner spinnerModTip;                 //Selectable!!!!!!!!!!!!!!!!!!!
    EditText edtSembolHizi;
    Spinner spinnerDalgaSekli;             //Selectable!!!!!!!!!!!!!!!!!!!

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferenceHelper = new PreferenceHelper(this);

        //Text Girişlerimizin idlerini alıyor.
        //Kayıt Bilgisi IDleri
        edtFolder = findViewById(R.id.edtFolderName);
        edtMerkezFrekans = findViewById(R.id.edtMerkezFrekans);
        edtOrneklemeHizi = findViewById(R.id.edtOrneklemeHizi);
        edtBantGenisligi = findViewById(R.id.edtBandGenisligi);
        edtDosyaBoyutu = findViewById(R.id.edtDosyaBoyutu);
        edtTarih = findViewById(R.id.edtDate);

        //Spektrum-Spektrogram Opsiyon IDleri
        edtOfSet = findViewById(R.id.edtOfset);
        edtBantGenisligiSpektrum = findViewById(R.id.edtBandGenisligiSpektrum);
        edtPencereUz = findViewById(R.id.edtPencereUz);

        spinnerWindowingTip = findViewById(R.id.spinnerWindowingTip);       //Selectable!!!!!!!!!!!!!!!!!!!
        ArrayAdapter<CharSequence> adapterWindowingTip = ArrayAdapter.createFromResource(this,R.array.windowing_tip_values,androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        spinnerWindowingTip.setAdapter(adapterWindowingTip);

        spinnerFrekCoz = findViewById(R.id.spinnerFrekCoz);                 //Selectable!!!!!!!!!!!!!!!!!!!
        ArrayAdapter<CharSequence> adapterFrekCoz = ArrayAdapter.createFromResource(this,R.array.frekans_coz_values,androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        spinnerFrekCoz.setAdapter(adapterFrekCoz);

        spinnerSelaleZAraligi = findViewById(R.id.spinnerSelaleZAraligi);   //Selectable!!!!!!!!!!!!!!!!!!!
        ArrayAdapter<CharSequence> adapterSelaleZAraligi = ArrayAdapter.createFromResource(this,R.array.selale_z_araligi_values,androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        spinnerSelaleZAraligi.setAdapter(adapterSelaleZAraligi);

        spinnerSinyalStat = findViewById(R.id.spinnerSinyalIstat);          //Selectable!!!!!!!!!!!!!!!!!!!
        ArrayAdapter<CharSequence> adapterSinyalStat = ArrayAdapter.createFromResource(this,R.array.sinyal_stat_values,androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        spinnerSinyalStat.setAdapter(adapterSinyalStat);

        //Sembol Hızı Opsiyon IDleri
        edtMinBaud = findViewById(R.id.edtMinBaud);
        edtMaxBaud = findViewById(R.id.edtMaxBaud);
        edtEsikDegeri = findViewById(R.id.edtTesEsikDegeri);
        edtIkinciEsik = findViewById(R.id.edtIkinciEsik);

        //Göz Çizelgesi Yıldız Kümesi Opsiyon IDleri
        spinnerModTip = findViewById(R.id.spinnerModTip);           //Selectable!!!!!!!!!!!!!!!!!!!
        ArrayAdapter<CharSequence> adapterModTip = ArrayAdapter.createFromResource(this,R.array.mod_type_values,androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        spinnerModTip.setAdapter(adapterModTip);

        edtSembolHizi = findViewById(R.id.edtSembolHizi);

        spinnerDalgaSekli = findViewById(R.id.spinnerDalgaSekli);   //Selectable!!!!!!!!!!!!!!!!!!!
        ArrayAdapter<CharSequence> adapterDalgaSekli = ArrayAdapter.createFromResource(this,R.array.dalga_sekli_values,androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        spinnerDalgaSekli.setAdapter(adapterDalgaSekli);


        //Json dosyası okunup veriler yerine konuluyor.
        fetchDataFromJson();

        //Butona basıldı mı veri içerikleri kaydediliyor Json dosyası olarak kaydediliyor.
        Button saveButton = findViewById(R.id.btnSave);
        saveButton.setOnClickListener(view -> {
            InformationData data = new InformationData(
                    //Kayıt Bilgisi
                    edtFolder.getText().toString(),
                    edtMerkezFrekans.getText().toString(),
                    edtOrneklemeHizi.getText().toString(),
                    edtBantGenisligi.getText().toString(),
                    edtDosyaBoyutu.getText().toString(),
                    edtTarih.getText().toString(),

                    //Spektrum-Spektrogram Opsiyon
                    edtOfSet.getText().toString(),
                    edtBantGenisligiSpektrum.getText().toString(),
                    edtPencereUz.getText().toString(),
                    spinnerWindowingTip.getSelectedItemPosition(),           //Selectable!!!!!!!!!!!!!!!!!!!
                    spinnerFrekCoz.getSelectedItemPosition(),                //Selectable!!!!!!!!!!!!!!!!!!!
                    spinnerSelaleZAraligi.getSelectedItemPosition(),         //Selectable!!!!!!!!!!!!!!!!!!!
                    spinnerSinyalStat.getSelectedItemPosition(),             //Selectable!!!!!!!!!!!!!!!!!!!

                    //Sembol Hızı Opsiyon
                    edtMinBaud.getText().toString(),
                    edtMaxBaud.getText().toString(),
                    edtEsikDegeri.getText().toString(),
                    edtIkinciEsik.getText().toString(),

                    //Göz Çizelgesi Yıldız Kümesi Opsiyon
                    spinnerModTip.getSelectedItemPosition(),         //Selectable!!!!!!!!!!!!!!!!!!!
                    edtSembolHizi.getText().toString(),
                    spinnerDalgaSekli.getSelectedItemPosition()      //Selectable!!!!!!!!!!!!!!!!!!!

            );
            preferenceHelper.setInformationData(data);
        });

    }


    /*
     * App çalışıcakken dosyaları jsondan alıyor ve hazır bir şekilde eski verileri sunuyor.
     * */
    private void fetchDataFromJson() {
        InformationData data = preferenceHelper.getInformationData();
        if (data != null) {
            //Bu Kayıt Bilgisi bilgilerini Jsondan Çekiyor.
            edtFolder.setText(data.getFileName());
            edtMerkezFrekans.setText(data.getMerkezFrekans());
            edtOrneklemeHizi.setText(data.getOrneklemeHizi());
            edtBantGenisligi.setText(data.getBandGenisligiKayitBilgisi());
            edtDosyaBoyutu.setText(data.getDosyaBoyutu());
            edtTarih.setText(data.getTarih());

            //Spektrum Opsiyon bilgilerini Jsondan Çekiyor.
            edtOfSet.setText(data.getOfset());
            edtBantGenisligiSpektrum.setText(data.getBandGenisligiSpektrum());
            edtPencereUz.setText(data.getPencereUzunlugu());
            spinnerWindowingTip.setSelection(data.getWindowingTip());          //Selectable!!!!!!!!!!!!!!!!!!!
            spinnerFrekCoz.setSelection(data.getFrekansCoz());                 //Selectable!!!!!!!!!!!!!!!!!!!
            spinnerSelaleZAraligi.setSelection(data.getSelaleZAraligi());      //Selectable!!!!!!!!!!!!!!!!!!!
            spinnerSinyalStat.setSelection(data.getSinyalStat());              //Selectable!!!!!!!!!!!!!!!!!!!

            //Sembol Hızı Opsiyon
            edtMinBaud.setText(data.getMinBaud());
            edtMaxBaud.setText(data.getMaxBaud());
            edtEsikDegeri.setText(data.getTesEsikDeger());
            edtIkinciEsik.setText(data.getIkinciEsik());

            //Göz Çizelgesi Yıldız Kümesi Opsiyon
            spinnerModTip.setSelection(data.getModType());              //Selectable!!!!!!!!!!!!!!!!!!!
            edtSembolHizi.setText(data.getSembolHizi());
            spinnerDalgaSekli.setSelection(data.getDalgaSekli());       //Selectable!!!!!!!!!!!!!!!!!!!

        }
    }
}