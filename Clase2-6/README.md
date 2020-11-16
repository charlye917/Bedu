# Retrofit
### Empleo basico de Retrofit

```kotlin
//Config Retrofit
val URL_BASE = "https://es.wikipedia.org/w/"

var retrofitQuery = Retrofit.Builder()
                .baseUrl(URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            var apiWeb = retrofitQuery.create(ApiWeb::class.java)
            var callRespuesta = when(tag){
                "xbox"->apiWeb.datosXbox()
                "wii"->apiWeb.datosWii()
                "nintendo"->apiWeb.datosNintendo()

                else->apiWeb.datosXbox()
            }
            callRespuesta.enqueue(object: Callback<Querys>{
                override fun onFailure(call: Call<Querys>, t: Throwable) {
                    Toast.makeText(applicationContext, "Ocurrio un error al consultar", Toast.LENGTH_LONG).show()
                }

                override fun onResponse(call: Call<Querys>, response: Response<Querys>) {
                    var dato = response.body()
                    if (dato != null) {
                        var encabezado = when(tag){
                            "xbox" -> dato.query.pages.xbox.extract
                            "wii" -> dato.query.pages.wii.extract
                            "nintendo" -> dato.query.pages.nintendo.extract
                            else -> dato.query.pages.xbox.extract
                        }
                        miWebView.loadData(encabezado,"text/html","UFT-8")
                    }
                }
            })
```

```kotlin
//ApiWeb
interface ApiWeb {
    @GET("api.php?action=query&prop=extracts&format=json&exintro=&titles=xbox")
    fun datosXbox():Call<Querys>

    @GET("api.php?action=query&prop=extracts&format=json&exintro=&titles=wii")
    fun datosWii():Call<Querys>

    @GET("api.php?action=query&prop=extracts&format=json&exintro=&titles=nintendo")
    fun datosNintendo():Call<Querys>
}
```

```kotlin
//Data Class
data class Querys(
    @SerializedName("query") var query:Pages
)

data class Pages(
    @SerializedName("pages") var pages:TipoPage
)

data class TipoPage(
    @SerializedName("58676") var xbox:Datos,
    @SerializedName("364001") var wii:Datos,
    @SerializedName("23599") var nintendo:Datos

)

data class Datos(
    @SerializedName("pageid") var pageid:Int,
    @SerializedName("ns") var ns:Int,
    @SerializedName("title") var title:String,
    @SerializedName("extract") var extract:String
)
```



