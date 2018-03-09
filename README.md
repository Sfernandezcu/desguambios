# DESGUAMBIOS
Practica De Desarrollo de aplicaciones distribuidas
 
# EQUIPO
El equipo de trabajo lo componen: 
- Sergio Fernández Cuadrado: 
    - MAIL: s.fernandezcu@alumnos.urjc.es.
    - GITHUB: Sfernandezcu     
- Daniel Bruña Diéguez: 
     - MAIL: d.bruna@alumnos.urjc.es.
     - GITHUB: di3guez
- Guillermo Muñoz Sanz: 
     - MAIL: g.munozs@alumnos.urjc.es.
     - GITHUB: Guilleermo10
 
# FUNCIONALIDADES DEL SERVICIO
Buscador de piezas de desguace donde añades la pieza que deseas, y aparecen los diferentes desguaces que poseen esa pieza con precios, contacto del desguace, redirección a la página oficial del desguace y información variada sobre los diferentes desguaces.
 
- Servicio privado: puede añadir nuevos productos, y poder utilizar todos los servicios ofrecidos por la página. 
- Servicio público: puede utilizar todos los servicios ofrecidos por la página, excepto poder añadir productos.


# ENTIDADES PRINCIPALES
- Desguace: Desguaces que contienen piezas que los clientes buscan.Pueden registrarse, hacer login, deslogarse, subir piezas, eliminarlas y editarlas.
- Producto: Lo que está buscando el cliente.(Literal del producto, id del producto, nombre del desguace.usuario, direccion del desguace.direccion e id de la marca(renault, citroën, etc)  )
- Comentarios: comentarios acerca de la pieza.
- Usuario: Un usuario, sin logarse, puede buscar piezas filtrando por sus necesidades, además puede crear un listado de piezas favoritas.
  
# SERVICIO INTERNO
- PDF: El usuario puede crear un pdf donde le aparezcan las piezas que busca, con su información correspondiente (Desguace,antigüedad de la pieza, estado de la pieza).

# FASE 2
- DIAGRAMA DE NAVEGACION

 ![Texto alternativo](https://github.com/di3guez/desguambios/blob/master/Desguambios/src/main/resources/static/diagramaNavegacion.jpg)
 
- DIAGRAMA E/R

![Texto alternativo](https://github.com/di3guez/desguambios/blob/master/Desguambios/src/main/resources/static/entidadRelacion.png)
 
# CAPTURAS 
- INDEX

![Texto alternativo](https://github.com/di3guez/desguambios/blob/master/Desguambios/src/main/resources/static/index.PNG)
- PRODUCTOS BUSCADOS

![Texto alternativo](https://github.com/di3guez/desguambios/blob/master/Desguambios/src/main/resources/static/ProductosBuscados.PNG)

- LISTA PRODUCTOS FAVORITOS

![Texto alternativo](https://github.com/di3guez/desguambios/blob/master/Desguambios/src/main/resources/static/ProductosFavoritos.PNG)

- REGISTRO

![Texto alternativo](https://github.com/di3guez/desguambios/blob/master/Desguambios/src/main/resources/static/Registro.PNG)

- LOGIN

![Texto alternativo](https://github.com/di3guez/desguambios/blob/master/Desguambios/src/main/resources/static/Login.PNG)

- SUBIR/ELIMINAR/EDITAR/VER

![Texto alternativo](https://github.com/di3guez/desguambios/blob/master/Desguambios/src/main/resources/static/SubirEliminarEditar.PNG)

- SUBIR PRODUCTO

![Texto alternativo](https://github.com/di3guez/desguambios/blob/master/Desguambios/src/main/resources/static/SubirNuevoProducto.PNG)

- ELIMINAR PRODUCTO

![Texto alternativo](https://github.com/di3guez/desguambios/blob/master/Desguambios/src/main/resources/static/EliminarProductoPorId.PNG)

- SUBIR PRODUCTO EDITADO

![Texto alternativo]()

- PRODUCTOS DEL DESGUACE

![Texto alternativo](https://github.com/di3guez/desguambios/blob/master/Desguambios/src/main/resources/static/ProductosDeUnDesguace.PNG)

# FASE 3

- EXPORTAR PDF

![Texto alternativo](https://github.com/di3guez/desguambios/blob/master/Desguambios/src/main/resources/static/recortePDF.PNG)

- NUEVO DIAGRAMA DE NAVEGACIÓN (Actualizado Fase 3)

![Texto alternativo](https://github.com/di3guez/desguambios/blob/master/Desguambios/src/main/resources/static/diagramaNavegacionFase3.png)

- DIAGRAMA E/R (Actualizado Fase 3)

![Texto alternativo](https://github.com/di3guez/desguambios/blob/master/Desguambios/src/main/resources/static/diagramaERFase3.jpeg)
