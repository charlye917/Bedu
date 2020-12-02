# Uso de FrameLayout y SharePreferences 

### Ejemplo del uso de visibility para cambiar imagen
```kotlin
fun cambiarImagen(view:View){
        if(img1.isVisible){
            img1.setVisibility(View.INVISIBLE)
            img2.setVisibility(View.VISIBLE)
        }else{
            img1.setVisibility(View.VISIBLE)
            img2.setVisibility(View.INVISIBLE)
        }
    }
```

### Ejemplo del uso de sharepreferences

```kotlin
val sharePreferences:SharedPreferences = applicationContext.getSharedPreferences("archivo", Context.MODE_PRIVATE)
```
```kotlin
//Verificar si ya se guardarib los datos
fun leerPreferencias(sharedPreferences: SharedPreferences ): Boolean {
    var nombres = sharedPreferences.getString("nombre", null)
    return nombres != null
}
```
```kotlin
//Funcion para guardar los datos
fun guardar(sharedPreferences: SharedPreferences){
    var nombre = txtNombre.text.toString()
    var pass = txtPass.text.toString()
    if(!nombre.isEmpty() && !pass.isEmpty()){
        var objEditor = sharedPreferences.edit()
        objEditor.putString("nombre", nombre)
        objEditor.commit()
        Toast.makeText(applicationContext, "Se guardaron correctamente los datos", Toast.LENGTH_SHORT).show()
        cambiarPagina()
    }else{
        Toast.makeText(applicationContext, "Se deben de llenar los campos", Toast.LENGTH_SHORT).show()
    }
}
```
```kotlin
//Recuperar datos desde otro activity
var sharedPreferences = applicationContext.getSharedPreferences("archivo",Context.MODE_PRIVATE)
var nombre = sharedPreferences.getString("nombre","")
```
```kotlin
//Borrar datos 
var sharedPreferences:SharedPreferences = applicationContext.getSharedPreferences("archivo",Context.MODE_PRIVATE)
sharedPreferences.edit().clear().commit()
```


## Imagenes del proyecto PruebaFrame
<img src="imagenes/Frame1.png" alt="drawing" width="300"/>
<img src="imagenes/Frame2.png" alt="drawing" width="300"/>

## Imagenes del proyecto SharePreferences
<img src="imagenes/share1.png" alt="drawing" width="300"/>
<img src="imagenes/share2.png" alt="drawing" width="300"/>
<img src="imagenes/share3.png" alt="drawing" width="300"/>
<img src="imagenes/share4.png" alt="drawing" width="300"/>

## Ligas para mas información

### SharedPreferences
https://developer.android.com/reference/android/content/SharedPreferences

### SharedPreferences.Editor
https://developer.android.com/reference/android/content/SharedPreferences.Editor

### SharedPreferences.OnSharedPreferenceChangeListener
https://developer.android.com/reference/android/content/SharedPreferences.OnSharedPreferenceChangeListener

### FrameLayout
https://developer.android.com/reference/android/widget/FrameLayout

### FrameLayout.LayoutParams
https://developer.android.com/reference/android/widget/FrameLayout.LayoutParams

