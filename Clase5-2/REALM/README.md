# Persistencia de datos con REALM

### Es necesario poner la clase como open 
```kotlin
open class Usuario:RealmObject() {
    @PrimaryKey
    var id:Int = 0
    var nombre:String = ""
    var telefono:String = ""
}
```

### CRUD
```kotlin
class ServiciosUsuario(val realm:Realm) {
    //Obtener usuarios
    fun obtenerUsuarios():List<Usuario>{
        var usuarios = realm.where(Usuario::class.java).findAll()
        return usuarios
    }

    //Crear usuario
    fun crearUsuario(id:Int, nombre:String, telefono:String){
        realm.beginTransaction()

        val user:Usuario = realm.createObject(Usuario::class.java, id)
        user.nombre = nombre
        user.telefono = telefono

        realm.commitTransaction()

    }

    fun obtenerUltimoid():Int{
       val id = realm.where(Usuario::class.java).max("id")
       val ultimoId = id?.toInt()?.plus(1) ?: 1
        //if(id == null) 1 else (id.toInt().plus(1))
        return ultimoId
    }

    fun actualizaDatosUsuario(usuario:Usuario, nombre:String, telefono: String){
        realm.beginTransaction()
        usuario.nombre = nombre
        usuario.telefono = telefono
        realm.commitTransaction()
    }

    fun obtenerUsuarioPorId(id:Int):Usuario?{
        val usuario = realm.where(Usuario::class.java).equalTo("id",id).findFirst()
        return usuario
    }

    fun eliminarUsuario(id:Int){
        val usuario = obtenerUsuarioPorId(id)
        if(usuario != null){
            realm.beginTransaction()
            usuario.deleteFromRealm()
            realm.commitTransaction()
        }
    }
}
```
### Iniciar configuracion
```kotlin
Realm.init(this)

val config:RealmConfiguration = RealmConfiguration.Builder()
    .name(getString(R.string.db_name))
    .deleteRealmIfMigrationNeeded()
    .schemaVersion(1)
    .build()

Realm.setDefaultConfiguration(config)
serviciosUsuario = ServiciosUsuario(Realm.getDefaultInstance())
val obtenerUltimoId = serviciosUsuario.obtenerUltimoid()

serviciosUsuario.crearUsuario(obtenerUltimoId, "Carlos", "123123123")
```

