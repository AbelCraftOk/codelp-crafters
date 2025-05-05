# Crea un codeigo de una aplicacion que funcione como un protector de pantalla.

**Configuracion de la pestaña: "*protector*"** {
    De fondo se usara la funcion: "*fondo(auto-camb)*"
    En la parte inferior derecha se mostrara la funcion: "*fondo(info)*"
}
=============================================================
**Configuracion de la funcion: "*fondo(auto-camb)*"** {

    Al iniciar se seleccionara aleatoriamente una imagen de las 15 disponibles y se pondra de fondo (dependiendo el tamaño de la pantalla, se ajustara el tamaño de la imagen). Cada *1 minuto y 30 segundos* se volvera a seleccionar una imagen aleatoriamente y se pondra de fondo (dependiendo el tamaño de la pantalla, se ajustara el tamaño de la imagen). Asi consecutivamente hasta que se cierre la aplicacion.

    La imagenes para el fondo disponibles son: {
      **|    ARCHIVO    |    NOMBRE     |**
        |/f-img1.png    |IMAGEN 1       |
        |/f-img2.png    |IMAGEN 2       |
        |/f-img3.png    |IMAGEN 3       |
        |/f-img4.png    |IMAGEN 4       |
        |/f-img5.png    |IMAGEN 5       |
        |/f-img6.png    |IMAGEN 6       |
        |/f-img7.png    |IMAGEN 7       |
        |/f-img8.png    |IMAGEN 8       |
        |/f-img9.png    |IMAGEN 9       |
        |/f-img10.png   |IMAGEN 10      |
        |/f-img11.png   |IMAGEN 11      |
        |/f-img12.png   |IMAGEN 12      |
        |/f-img13.png   |IMAGEN 13      |
        |/f-img14.png   |IMAGEN 14      |
        |/f-img15.png   |IMAGEN 15      |
    }
}
=============================================================
**Configuracion de la funcion: *fondo(info)*** {
    El html sacara la sigueinte informacion de algun sitio de confianza: {"*time-actual*" (hora, minuto y segundo), "*temp-actual*" (temperatura)} La informacion se actualizara cada 0,1 segundo.
    Esta informacion se pondra en la parte inferior derecha de la pantalla, y va a estar ordenada de la siguiente manera: {
        *"temp-actual"*
        *"time-actual"*
        ===============
        Esto muestra que la temperatura va a estar en la parte superior, y la hora va a estar en la parte inferior.
    }
}
