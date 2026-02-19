package mx.edu.itesca.practica4

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)

        var btnAntojitos: Button = findViewById(R.id.button_antojitos) as Button
        var btnEspecialidades: Button = findViewById(R.id.button_especialidades) as Button
        var btnCombination: Button = findViewById(R.id.button_combinations) as Button
        var btnTortas: Button = findViewById(R.id.button_tortas) as Button
        var btnSopas: Button = findViewById(R.id.button_sopas) as Button
        var btnDrinks: Button = findViewById(R.id.button_drinks) as Button

        btnAntojitos.setOnClickListener {
            val intent: Intent = Intent(this, ProductosActivity::class.java)
            intent.putExtra("menuType", "Antojitos")
            startActivity(intent)
        }
        btnEspecialidades.setOnClickListener {
            val intent: Intent = Intent(this, ProductosActivity::class.java)
            intent.putExtra("menuType", "Especialidades")
            startActivity(intent)
        }
        btnCombination.setOnClickListener {
            val intent: Intent = Intent(this, ProductosActivity::class.java)
            intent.putExtra("menuType", "Combinations")
            startActivity(intent)
        }
        btnTortas.setOnClickListener {
            val intent: Intent = Intent(this, ProductosActivity::class.java)
            intent.putExtra("menuType", "Tortas")
            startActivity(intent)
        }
        btnSopas.setOnClickListener {
            val intent: Intent = Intent(this, ProductosActivity::class.java)
            intent.putExtra("menuType", "Sopas")
            startActivity(intent)
        }
        btnDrinks.setOnClickListener {
            val intent: Intent = Intent(this, ProductosActivity::class.java)
            intent.putExtra("menuType", "Drinks")
            startActivity(intent)
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}