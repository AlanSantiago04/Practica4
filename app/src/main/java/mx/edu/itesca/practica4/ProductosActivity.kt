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
        var imagen: ImageView = findViewById(R.id.imageView)
        when(option){
            "Antojitos"->{
                menu.add(Product(name = "Quesadillas", R.drawable.quesadillas, description = "Rellenas con su carne favorita, servidas con ensalada. Filled with your choice of meat, served with salad.", price = 5.69))
                menu.add(Product(name = "Huaraches", R.drawable.huaraches, description = "Tortilla gruesa con frijoles, tu carne favorita, lechuga, queso fresco y crema. Big thick tortilla with beans, your choice of meat, lettuce, fresh cheese and cream.", price = 7.99))
                menu.add(Product(name = "Gringas", R.drawable.gringas, description = "Tortilla de harina con queso, carne al pastor y piña. Flour tortilla with cheese marinated pork and pineapple.", price = 7.99))
                menu.add(Product(name = "Sincronizadas", R.drawable.sincronizadas, description = "Tortilla de harina rellena con queso y jamón. Se sirve con lechuga, crema y guacamole. Sandwich of two flour tortillas with ham and cheese.", price = 6.99))
                menu.add(Product(name = "Sopes", R.drawable.sopes, description = "Tortilla gruesa cubierta de frijoles, tu carne favorita, lechuga, queso fresco y crema. Fried thick tortilla with beans, your choice of meat.", price = 6.99))
                menu.add(Product(name = "Tostadas", R.drawable.tostadas, description = "Tortilla frita con frijoles, tu carne favorita, lechuga, queso fresco, crema y jitomate. Fried tortilla with beans, your choice of meat.", price = 6.99))
                imagen.setImageResource(R.drawable.antojitos)
            }
            "Especialidades"->{
                menu.add(Product(name = "Mojarra Frita", R.drawable.mojarra, description = "Tilapia frita servida con lechuga, cebolla, jitomate, aguacate y tortillas. Fried tilapia served with lettuce, onions, tomatoes, avocado and tortillas.", price = 17.99))
                menu.add(Product(name = "Ceviche", R.drawable.ceviche, description = "Tilapia, camarones, aguacate y pico de gallo servido con chips. Tilapia, shrimp, avocado and pico de gallo, served with chips.", price = 6.99))
                menu.add(Product(name = "Botana De Camarones Al Mojo De Ajo", R.drawable.quesadillas, description = "", price = 19.99))
                imagen.setImageResource(R.drawable.especialidades)
            }
            "Combinations"->{
                menu.add(Product(name = "Traditional Taco Combo", R.drawable.taco, description = "Tortilla de maíz y tu carne favorita. Servido con arroz y frijoles. Corn taco, your choice of meat, served with rice and beans.", price = 6.99))
                menu.add(Product(name = "Mexican Burritos", R.drawable.burritos, description = "Tu carne favorita en una tortilla grande de harina rellena con cebolla frita, pico de gallo, sour cream, frijoles y acompañado de arroz. Your choice of meat on a big burrito made of flour tortilla with rice, beans, lettuce, grilled onions, pico de gallo,", price = 12.99))
                menu.add(Product(name = "Los Portales Burrito", R.drawable.burritosportales, description = "Large flour tortilla filled with grilled cactus, steak, pastor (seasoned pork), grilled onions, rice and beans. Served with a side of lettuce salad, tomatoes, sour cream and guacamole.", price = 14.59))
                menu.add(Product(name = "Cinco", R.drawable.cinco, description = "One hard sell taco with your choice of meat, lettuce and cheese. One burrito with your choice of meat, pico de gallo, sour cream, and beans. Served with rice and beans.", price = 10.99))
                menu.add(Product(name = "Dos Amigos", R.drawable.dosamigos, description = "Two hard shell tacos with your choice of meat topped with lettuce and shredded cheese. Served with a side of rice and beans.", price = 10.99))
                menu.add(Product(name = "Burritos Pepe", R.drawable.burritopepe, description = "Flour tortilla filled with your choice of meat with beans, lettuce, sour cream, guacamole and pico de gallo. Served with a side of rice.", price = 10.99))
                menu.add(Product(name = "Fajita Quesadilla", R.drawable.fajitaquesadilla, description = "Quesadilla extra grande (10 inches), rellena con tu carne favorita, cebolla asada, chile morron. Servida con arroz, frijoles, lechuga, crema y pico de gallo. 10 inches quesadilla filled with your", price = 14.59))
                imagen.setImageResource(R.drawable.combinations)
            }
            "Tortas"->{
                menu.add(Product(name = "Torta", R.drawable.tortas, description = "All tortas come with lettuce, onions, tomatoes, avocado, sour cream, jalapeno pepper and your choice of meat.", price = 13.39))
                menu.add(Product(name = "Milanesa De Pollo Torta", R.drawable.tortamilanesa, description = "Chiken", price = 13.99))
                menu.add(Product(name = "Torta Cubana", R.drawable.tortacubana, description = "Chorizo, asada, jamon, pastor y queso. Mexican sausage, steak, marinated pork, ham, and cheese", price = 14.49))
                menu.add(Product(name = "Torta Mixta", R.drawable.tortamixta, description = "Chorizo, asada y pastor. Mexican sausage, steak and marinated por.", price = 13.99))
                menu.add(Product(name = "Small Mexican Torta", R.drawable.smallmexican, description = "Bolillo bread sandwich with your of meat, shredded lettuce, avocado, tomato, onion and sour cream.", price = 11.99))
                imagen.setImageResource(R.drawable.tortas)
            }
            "Sopas"->{
                menu.add(Product(name = "Caldo De Res", R.drawable.caldores, description = "Beef ribs and chuck stew with corn, potato, chayote (squash family), cabage, cilantro, onion, zuccini, carrots, lime, and tortillas. ", price = 8.39))
                menu.add(Product(name = "Pozole", R.drawable.pozole, description = "WEDNSDAY - SUNDAY Pork ribs and bonston butt stew with homminy and oregano. DO NOT FORGET OUR SALSA BAR TO MAKE IT MORE FLAVORFULL.", price = 7.99))
                menu.add(Product(name = "menudo", R.drawable.menudo, description = "MENUDO Ancestral broth, silky tripe, come together in a bowl that tastes like Sunday mornings, family kitchens, and stories passed down through generations.", price = 13.99))
                menu.add(Product(name = "Caldo De Camarón", R.drawable.caldocamaron, description = "Shrimp soup.", price = 13.99))
                menu.add(Product(name = "Sopa De Mariscos", R.drawable.sopamariscos, description = "Seafood soup", price = 21.99))
                imagen.setImageResource(R.drawable.sopas)
            }
            "Drinks"->{
                menu.add(Product(name = "Michelada.", R.drawable.michelada, description = "", price = 3.75))
                menu.add(Product(name = "Jarritos", R.drawable.jarritos, description = "", price = 2.75))
                menu.add(Product(name = "Caguarnas", R.drawable.caguama, description = "", price = 5.75))
                menu.add(Product(name = "Caguamas Micheladas", R.drawable.caguamamichelada, description = "", price = 2.75))
                menu.add(Product(name = "Charolazo", R.drawable.charolazo, description = "", price = 9.75))
                menu.add(Product(name = "Cubeta Six", R.drawable.cubetasix, description = "", price = 9.75))
                menu.add(Product(name = "Mexican Beer", R.drawable.mexicanbeer, description = ".", price = 2.75))
                menu.add(Product(name = "Sodas", R.drawable.sodas, description = "", price = 2.75))
                imagen.setImageResource(R.drawable.drinks)
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