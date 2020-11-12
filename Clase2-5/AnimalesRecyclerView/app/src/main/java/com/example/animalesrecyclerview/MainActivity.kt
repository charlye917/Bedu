package com.example.animalesrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_categoria.*

class MainActivity: AppCompatActivity(), Animal{

    private val categorias = arrayOf("TERRESTRES","ACUATICOS","VOLADORES")
    private val catergoriaImagen = arrayOf(R.drawable.terrestres,R.drawable.acuaticos,R.drawable.voladores)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        llenarCategoria()
    }

    fun llenarCategoria(){
        var listdatoAnimal = ArrayList<datosAnimal>()

        for(i in categorias.indices)
            listdatoAnimal.add(datosAnimal(categorias[i],catergoriaImagen[i]))

        miRecycler.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = MiAdaptador(listdatoAnimal, this@MainActivity)
        }
    }

    override fun llenarAnimales(categoria:datosAnimal){
        var lista = ArrayList<datosAnimal>()
        imagen2.visibility

        for(i in animales(categoria.nombre).indices)
            lista.add(datosAnimal(animales(categoria.nombre).get(i),imagenes(categoria.nombre).get(i)))

        miRecycler2.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = MiAdaptador(lista, this@MainActivity)
        }

        Toast.makeText(this,"${categoria.nombre}, ${categoria.imagen}", Toast.LENGTH_LONG).show()

    }

    fun animales(categoria:String):Array<String>{
        when(categoria){
            "TERRESTRES" -> return arrayOf("PERRO","GATO","LEON","TIGRE","PUERQUITO","CHANGUITO")
            "ACUATICOS" -> return arrayOf("TIBURON","DELFIN","AXOLOTl","TORTUGA","PEZ ESPADA","BALLENA")
            "VOLADORES" -> return arrayOf("AGUILA","HALCON","GORRION","PALOMA","COTORRO","QUETZAL")
            else -> return arrayOf("")
        }
    }

    fun imagenes(categoria: String):Array<Int>{
        when(categoria){
            "TERRESTRES" ->return arrayOf(R.drawable.perro,R.drawable.gato,R.drawable.leon,R.drawable.tigre,R.drawable.puerquito,R.drawable.changuito)
            "ACUATICOS" -> return arrayOf(R.drawable.tiburon,R.drawable.delfin,R.drawable.axolotl,R.drawable.tortuga,R.drawable.pezespada,R.drawable.ballena)
            "VOLADORES" -> return arrayOf(R.drawable.aguila,R.drawable.halcon,R.drawable.gorrion,R.drawable.paloma,R.drawable.cotorro,R.drawable.quetzal)
            else -> return arrayOf(0)
        }
    }
}
