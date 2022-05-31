package com.iremgurgen.project

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class InformationData(
    //Kayıt Bilgisi verileri
    val fileName : String,
    val merkezFrekans : String,
    val orneklemeHizi : String,
    val bandGenisligiKayitBilgisi : String,
    val dosyaBoyutu : String,
    val tarih : String,

    //Spectrum-Spectrogram Opsiyon verileri
    val ofset : String,
    val bandGenisligiSpektrum : String,
    val pencereUzunlugu : String,
    val windowingTip : Int,          //Selectable
    val frekansCoz : Int,            //Selectable
    val selaleZAraligi : Int,        //Selectable
    val sinyalStat : Int,            //Selectable

    //Sembol Hızı Opsiyon verileri
    val minBaud : String,
    val maxBaud : String,
    val tesEsikDeger : String,
    val ikinciEsik : String,

    //Göz Çizelgesi Yıldız Kümesi Opsiyon verileri
    val modType : Int,               //Selectable
    val sembolHizi : String,
    val dalgaSekli : Int             //Selectable
)
