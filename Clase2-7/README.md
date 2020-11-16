# Arquitectura MVP

El Modelo Vista Presentador (En español) es uno de los patrones de arquitectura de desarrollo más comunes y usados en el desarrollo nativo de Android. 
La necesidad de utilizar este patrón surge debido a lo complicado que puede llegar a ser el mantenimiento y escalamiento de un proyecto que va creciendo 
a lo largo del tiempo y líneas de código.
El uso de esta arquitectura lleva a que cualquier persona pueda fácilmente mejorar, actualizar, modificar o arreglar cualquier parte de la aplicación. 
Si bien aunque el patrón MVP establece una serie de lineamientos, debemos tener en cuenta que cada proyecto puede llegar a implementarlo con algunas variaciones,
por lo que no es una solución absoluta.

Cada parte de la arquitectura la acomodaremos en paquetes con su respectivo nombre y en general tienen los siguientes propósitos:

### Model: 
  Paquete donde se incluyen todas las clases relacionadas al acceso de datos, reglas de negocio u obtención de información. Es muy común que al implementar MVP en un proyecto de Android se haga de la mano con la arquitectura Clean, que implica el uso de Interactors. Tanto un Model como un Interactor proporcionan información de datos, la diferencia radica en que el Model proporciona funcionalidades generales a diferencia de un Interactor que debe tener funcionalidades específicas.

### Vista: 
  Paquete donde se incluyen todas las clases relacionadas directamente con la interfaz gráfica, usualmente Activities y Fragments (Las vistas XML son parte de la vista pero de una forma más abstracta debido a que forman parte de los recursos del proyecto pero están muy acopladas con estas clases).

### Presentador: 
  Paquete donde se incluyen todas las clases Presenter que se encargará de comunicar a los Interactores (Modelos) y las vistas.
  
## Liga de otro ejemplo:
https://medium.com/@carloslopez_19744/%EF%B8%8F-arquitectura-mvp-en-android-para-principiantes-30b5675ff7b6 
