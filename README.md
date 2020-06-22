# iMovie - Perú Apps

![](https://i.imgur.com/ZYqKOvF.png)

[![Kotlin](https://img.shields.io/badge/kotlin-1.3.72-blue.svg)](http://kotlinlang.org) [![Gradle](https://img.shields.io/badge/gradle-6.1.1-%2366DCB8.svg)](https://developer.android.com/studio/releases/gradle-plugin)

Aplicación demo de películas para evaluación técnica en Perú Apps.

:white_check_mark: 100% en **Kotlin**

:white_check_mark: Uso de **Data Binding**

:white_check_mark: Consumo de web services con **Retrofit**

:white_check_mark: Clean **architecture**

:white_check_mark: Patrón de arquitectura **MVVM**

:white_check_mark: Inyección de dependencia con **Koin**

:white_check_mark: Clean **code**

[![](https://i.imgur.com/hqAmSG1.png)](https://youtu.be/zjANR00j2v0)

[![](https://i.imgur.com/hkwCACZ.png)](https://firebasestorage.googleapis.com/v0/b/davidbarbarandev.appspot.com/o/iMovie-PeruApps.apk?alt=media&token=a6670457-8ae7-445d-8554-0c3e05bcf9b9)

## Comenzando
  
Estas instrucciones le proporcionarán una copia del proyecto en funcionamiento en su máquina local para fines de desarrollo y pruebas.
  
### Pre requisitos 📋  
- [Android Studio](https://developer.android.com/studio/)  
- [Git](https://git-scm.com/downloads)  
  
### Instalación 🔧  
Después de descargar Android Studio y git en su máquina local, ejecute el comando: 

> git clone https://github.com/DavidBarbaran/Movies-PeruApps 

Abrir Android Studio y haga clic en la opción **Abrir un proyecto existente en Android Studio** y seleccione la carpeta donde se encuentra clonado el proyecto.

## Estructura del proyecto

![](https://i.imgur.com/rFphocL.png)

El proyecto esta desarrollado con **Clean Architecture** que consta de 3 capas que están estructuradas por paquetes según el feature.

### Capa de presentación :iphone:
La capa de presentación es la encargada de mostrar los datos e interactuar con la interfaz de usuario donde usamos el patrón de arquitectura Model-ViewModel-View (MVVM) usando los componentes de arquitectura de Android donde encontramos los siguientes elementos: 

- Activity
- ViewModel
- Model

### Capa de dominio :large_orange_diamond:
La capa de dominio es la que se encarga de ejecutar la logica de negocio e interactúa con las capas de data y presentación donde encontramos los siguientes elementos:

- Use Cases
- Domain Entity
- Interactors

### Capa de datos :open_file_folder:
La capa de datos es la que se encarga de gestionar los datos locales y remotos de la aplicación, usando **Retrofit** para el consumo de web Services y Shared Preference para guardar datos del usuario donde encontramos los siguientes elementos:

- Repository
- Data Entity
- RestApi
- Shared Preferences
  
## Bibliotecas usadas en el proyecto:

- Diseño
	- [Material components](https://material.io/develop/android/docs/getting-started)
	- [Lottie](https://github.com/airbnb/lottie-android)
	- [Shimmer](https://github.com/facebook/shimmer-android)
	- [Lottie](https://github.com/airbnb/lottie-android)

- Arquitectura:
	- [View Binding](https://developer.android.com/topic/libraries/view-binding)  
	- [LiveData](https://developer.android.com/topic/libraries/architecture/livedata)  
	- [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel)  

- Inyección de dependencia
	- [Koin](https://github.com/InsertKoinIO/koin)

 - Net
	- [Retrofit](https://github.com/square/retrofit)
	- [Glide](https://github.com/bumptech/glide)

- Serialización / Deserialización
	- [Gson](https://github.com/google/gson)
	 
- Programación asincrona:
	- [Coroutines](https://github.com/Kotlin/kotlinx.coroutines)
