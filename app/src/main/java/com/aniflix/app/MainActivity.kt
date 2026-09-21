package com.aniflix.app
import android.os.Bundle
import android.graphics.Color
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
class MainActivity: AppCompatActivity(){
 private val bg=Color.rgb(11,7,16); private val card=Color.rgb(28,20,35); private val accent=Color.rgb(205,88,255)
 private fun t(s:String,z:Float,b:Boolean=false)=TextView(this).apply{text=s;textSize=z;setTextColor(Color.WHITE);if(b)setTypeface(typeface,1);setPadding(0,8,0,8)}
 private fun b(s:String,a:()->Unit)=Button(this).apply{text=s;setTextColor(Color.WHITE);setBackgroundColor(accent);setOnClickListener{a()}}
 private fun base()=LinearLayout(this).apply{orientation=LinearLayout.VERTICAL;setPadding(24,28,24,28);setBackgroundColor(bg)}
 override fun onCreate(x:Bundle?){super.onCreate(x);home()}
 private fun home(){val sv=ScrollView(this);val r=base();sv.addView(r);r.addView(t("AniFlix",30f,true));r.addView(t("Streaming anime favoritmu",15f));val e=EditText(this).apply{hint="Cari anime...";setHintTextColor(Color.LTGRAY);setTextColor(Color.WHITE);setBackgroundColor(card)};r.addView(e,LinearLayout.LayoutParams(-1,60));r.addView(t("🔥 Trending",21f,true));listOf("One Piece • Episode terbaru","Jujutsu Kaisen • Season terbaru","Demon Slayer • Arc pilihan").forEach{r.addView(t("▶  $it",16f))};r.addView(t("✨ Rekomendasi",21f,true));listOf("Anime Action","Anime Fantasy","Anime Adventure").forEach{r.addView(t("🎬  $it",16f))};r.addView(t("👤 Profil",21f,true));r.addView(t("Level 1  •  0 EXP",16f));r.addView(b("💎 Premium",::premium));r.addView(b("💬 Komentar Episode",::comments));setContentView(sv)}
 private fun premium(){val r=base();r.addView(t("AniFlix Premium",28f,true));r.addView(t("Nikmati pengalaman tanpa iklan.",16f));listOf("7 Hari — Rp5.000","1 Bulan — Rp10.000","3 Bulan — Rp30.000","6 Bulan — Rp60.000","1 Tahun — Rp110.000","3 Tahun — Rp253.000").forEach{r.addView(t("💎  $it",17f))};r.addView(t("Premium: +10 EXP/episode • Non-Premium: +5 EXP/episode",14f));r.addView(b("← Kembali",::home));setContentView(r)}
 private fun comments(){val r=base();r.addView(t("Komentar Episode",28f,true));r.addView(t("Episode 1 • Diskusi komunitas",16f));r.addView(t("Belum ada komentar. Jadilah yang pertama!",15f));val e=EditText(this).apply{hint="Tulis komentar...";setHintTextColor(Color.LTGRAY);setTextColor(Color.WHITE);setBackgroundColor(card)};r.addView(e);r.addView(b("Kirim Komentar"){Toast.makeText(this,"Komentar disimpan di demo.",Toast.LENGTH_SHORT).show()});r.addView(b("← Kembali",::home));setContentView(r)}
}
