El proyecto fue realizado con Java NeatBeans 23.
Carmen Dayanna Beltrán Flores
Chris Fitch López 
Henry Soto 
Paula García
Oscar Adrián Castán López 

Por cuestiones de seguridad, el aparta de Token de Hugging Face queda en blanco (esta en FiltroIA en el paquete de negocios_AdminCV). Para hacer uso del programa sigan los siguientes pasos:
Dirijanse a la pagina de Hugging Face:
https://huggingface.co/

Crean una cuenta, solo ocupan un correo, asi que es sencillo y no comprometen muchos datos. Es completamente segura.

Una vez creen su cuenta, diriganse a https://huggingface.co/settings/tokens

Aqui deben crear su token/API Key.

Es igual a con ChatGPT, crean un token y le ponen un nombre (no importa cual sea), asegurense de estar en la seccion "Read" al crearlo, ya que es el permiso que la IA necesita.

Pongan el nombre que quieran y copian su key y peguenla entre las comillas que dicen "hugging token", asegurense de pegarlo bien, ya que si no les dara error:
String apiKey = "hugging token"; //token de Hugging Face

Deberan hacer un Clean and Build de negocios_AdminCV, copiar el nuevo JAR que se creara en la carpeta "dist" de este proyecto y pegar el nuevo JAR en la carpeta lib de Presentacion_equipo1, reemplazando el anterior. Ya despues pueden hacer un Clean and Build por si acaso de Presentacion_equipo1 y correr el programa sin problema. Si les salta algun error su token no se copio bien o el servicio de la IA esta caido (que es algo fuera de nuestro alcance), solo esperen y vuelvan a intentarlo.
