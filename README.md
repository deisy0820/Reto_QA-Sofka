Este proyecto automatiza el flujo de la funcionalidad \*\*Contact Us\*\* del sitio \*\*Automation Exercise\*\* utilizando \*\*SerenityBDD\*\* con el patrón \*\*Screenplay\*\* en \*\*Java\*\*.  





\# **Automatización API - Product API lifecycle**



\## Descripción



Este proyecto automatiza el ciclo de vida de un \*\*producto\*\* usando \*\*SerenityBDD + Screenplay + RestAssured\*\* en \*\*Java\*\*.



Flujo automatizado:



1\. Crear un producto vía POST.

2\. Validar código de respuesta (200/201).

3\. Extraer el ID del producto creado.

4\. Consultar el producto por ID vía GET.

5\. Validar que la información del producto coincida con lo enviado.



El proyecto utiliza un \*\*mock\*\* de la API para permitir la ejecución independiente del entorno local.





**El flujo automatizado web incluye:**  



1\. Navegar a la URL del sitio y verificar que el título sea visible.  

2\. Acceder al formulario \*\*Contact Us\*\*.  

3\. Llenar los campos obligatorios: Nombre, Email, Subject, Mensaje.  

4\. Adjuntar un archivo (Upload File).  

5\. Enviar el formulario y aceptar alertas del navegador.  

6\. Validar el mensaje de éxito: `"Success! Your details have been submitted successfully."`.  

7\. Regresar al Home.

El proyecto está configurado para ejecutarse \*\*localmente\*\* y en \*\*BrowserStack\*\*, generando reportes de ejecución y logs de errores.



**## Tecnologías y Herramientas**



\- \*\*Lenguaje:\*\* Java 11  

\- \*\*Framework:\*\* SerenityBDD + Screenplay  + RestAssured  

\- \*\*Gestión de Dependencias:\*\* Maven  

\- \*\*Pruebas BDD:\*\* Cucumber  

\- \*\*Automatización Remota:\*\* BrowserStack  

\- \*\*Navegador:\*\* Chrome (versión 117.0)  

\- \*\*Gestión de Versiones:\*\* Git  

\- \*\*IDE recomendado:\*\* IntelliJ IDEA  



**## Estructura del Proyecto**



RetoSofka/

│

├─ src/test/java/org/config

│ └─ BrowserStackDriver.java # Configuración WebDriver remoto

│

├─ src/test/java/stepdefinitions

│ └─ ContactUsStepDefinitions.java # Step Definitions de Cucumber

│

├─ src/test/java/org/tasks

│ ├─ FillContactForm.java # Task para llenar el formulario

│ ├─ SubmitForm.java # Task para enviar el formulario

│ └─ OpenHome.java # Task para abrir la página inicial

│ └─ AcceptAlert.java # clic en la alerta



│

├─ src/test/java/org/userinterface

│ └─ ContactUsPage.java # Localizadores de la página Contact Us

│

├─ src/test/resources/features

│ └─ contact\_us.feature # Feature de Cucumber

│

├─ src/test/resources/files

│ └─ test.txt # Archivo de prueba para upload

│

└─ pom.xml # Configuración Maven y dependencias



RetoApi/

│

├─ src/main/java/actors

│ └─ ApiActor.java # Actor para interactuar con la API

│

├─ src/main/java/questions

│ ├─ LastCreatedProductId.java # Extrae ID del último producto

│ ├─ LastResponseStatus.java # Valida código de respuesta

│ ├─ ProductName.java

│ ├─ ProductPrice.java

│ └─ ResponseCode.java

│

├─ src/main/java/task

│ ├─ CreateProduct.java # Task para crear producto

│ └─ GetProduct.java # Task para consultar producto

│

├─ src/test/java/utils

│ └─ ApiMockServer.java # ejecutar mock

│

├─ src/test/java/runners

│ └─ ProductApiRunner.java # Runner de Cucumber



├─ src/test/java/stepdefinitions

│ └─ ProductApiSteps.java # Step Definitions

│

├─ src/test/resources/feature

│ └─ product\_api.feature # Feature BDD

│

├─ src/test/resources/mappings

│ ├─ create-product.json # Mock de creación

│ └─ get-product.json # Mock de consulta

│

└─ serenity.properties # Configuración de base URL





**## Configuración de BrowserStack**



1\. Abre el archivo `BrowserStackDriver.java`.  

2\. Configura tu usuario y clave de BrowserStack:  



```java

bstackOptions.put("userName", "TU\_USERNAME");

bstackOptions.put("accessKey", "TU\_ACCESS\_KEY");

El flujo está listo para ejecutar pruebas en la nube usando RemoteWebDriver.



Para pruebas locales, basta con configurar WebDriver normal en tu máquina.



**## Cómo ejecutar las pruebas**



**1 Ejecución local**

mvn clean verify

Esto ejecutará todos los escenarios de Cucumber.

Los reportes se generarán en target/site/serenity/index.html.



**2  Ejecución en BrowserStack**



Asegúrate de que tu BrowserStackDriver.java tenga las credenciales correctas.



Ejecuta el Runner o:



mvn clean verify -Dhttps.protocols=TLSv1.2



Los resultados aparecerán en BrowserStack y en los reportes locales de Serenity.









**Reportes**



Ubicación: target/site/serenity/index.html



Contenido: resumen de escenarios, pasos ejecutados, errores y capturas de pantalla.



Para compartir el reporte, comprime la carpeta target/site/serenity y envíala.



**Bugs conocidos / Limitaciones**



Mensaje de éxito tras alertas del navegador:



Contexto: El mensaje .status.alert-success solo aparece después de aceptar la alerta y realizar una interacción manual.

Impacto: En pruebas automatizadas, la verificación del mensaje puede fallar si no se maneja correctamente la alerta.

Solución temporal: Se recomienda usar ExpectedConditions.alertIsPresent() y aceptar la alerta antes de validar el mensaje de éxito.

Upload de archivos en BrowserStack:

Contexto: Los archivos locales no se pueden subir directamente; BrowserStack requiere LocalFileDetector.



Actualmente se usa un mock de la API, por lo que los tests no interactúan con un backend real.

Para pruebas con backend real, actualizar serenity.rest.base.url a la URL del servidor que responda correctamente.



**Consideraciones**



Recomendado usar Chrome versión 117.0 para compatibilidad total.

Siempre limpiar la carpeta de reportes (mvn clean) antes de nuevas ejecuciones para evitar conflictos.



**Autor**

Daisy Mosquera Perea

Ingeniera de Sistemas | Automatización de Pruebas







