package mx.edu.itesca.practica4

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.ArrayList

class ProductosActivity : AppCompatActivity() {
    var menu: ArrayList<Product> = ArrayList<Product>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_productos)

        var menuOption: String? = intent.getStringExtra("menuType")
        agregarProductos(menuOption)

        var listview: ListView = findViewById(R.id.listview) as ListView

        var adaptador: AdaptadorProductos = AdaptadorProductos(this, menu)
        listview.adapter = adaptador
    }
    fun agregarProductos(option:String?) {
        when(option){
            "Antojitos"->{
                menu.add(Product(name = "Quesadillas", R.drawable.quesadillas, description = "Rellenas con su carne favorita, servidas con ensalada. Filled with your choice of meat, served with salad.", price = 5.69))
                menu.add(Product(name = "Huaraches", R.drawable.huaraches, description = "Tortilla gruesa con frijoles, tu carne favorita, lechuga, queso fresco y crema. Big thick tortilla with beans, your choice of meat, lettuce, fresh cheese and cream.", price = 7.99))
                menu.add(Product(name = "Gringas", R.drawable.gringas, description = "Tortilla de harina con queso, carne al pastor y piña. Flour tortilla with cheese marinated pork and pineapple.", price = 7.99))
                menu.add(Product(name = "Sincronizadas", R.drawable.sincronizadas, description = "Tortilla de harina rellena con queso y jamón. Se sirve con lechuga, crema y guacamole. Sandwich of two flour tortillas with ham and cheese.", price = 6.99))
                menu.add(Product(name = "Sopes", R.drawable.sopes, description = "Tortilla gruesa cubierta de frijoles, tu carne favorita, lechuga, queso fresco y crema. Fried thick tortilla with beans, your choice of meat.", price = 6.99))
                menu.add(Product(name = "Tostadas", R.drawable.tostadas, description = "Tortilla frita con frijoles, tu carne favorita, lechuga, queso fresco, crema y jitomate. Fried tortilla with beans, your choice of meat.", price = 6.99))
            }
        }
    }

    private class AdaptadorProductos : BaseAdapter {
        var productos = ArrayList<Product>()
        var contexto: Context? = null
        constructor(contexto: Context, productos: ArrayList<Product>) {
            this.productos = productos
            this.contexto = contexto
        }

        override fun getCount(): Int {
            return productos.size
        }

        override fun getItem(position: Int): Any {
            return productos[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val prod = productos[position]
            val inflador = LayoutInflater.from(contexto!!)
            val vista = inflador.inflate(R.layout.producto_view, parent, false)
            val imagen = vista.findViewById<ImageView>(R.id.producto_img)
            val nombre = vista.findViewById<TextView>(R.id.producto_nombre)
            val desc = vista.findViewById<TextView>(R.id.producto_desc)
            val precio = vista.findViewById<TextView>(R.id.producto_precio)
            imagen.setImageResource(prod.image)
            nombre.text = prod.name
            desc.text = prod.description
            precio.text = "$${prod.price}"
            return vista
        }
    }
}