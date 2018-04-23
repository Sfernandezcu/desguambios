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


- INSTRUCCIONES PRECISAS PARA DESPLEGAR LA APLICACIÓN:
Compilación, cómo subir el jar, quéhace falta instalar en la máquina

1º Añadimos las dependencias al pom.xml

<build>
	<plugins>
		<plugin>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-maven-plugin</artifactId>
		</plugin>
	</plugins>
</build>

2º Cambiamos los application.properties del servidor APi donde añadimos la url del servidor de bbdd. En nuestro caso el servidor bbdd esta ubicado dentro del entorno donde esta alojada la web.
3º Cambiamos el post para enviar el objeto desde la web a la API, a la url de la web.

4º hacemos RUN AS build... y en goals añadimos package. Con esto creamos el JAR de WEB y API.

5º Nos creamos dos maquinas virtuales con adaptador puente , el cual una actuará de servidor y la otra de servidor de BBDD y web.

6º En el servidor de BBDD añadimos en my.cnf "bind-address=ip_API_REST" para permitir la conexión remota desde el servidor API a la bbdd.

7º Nos creamos un usuario en mysql para que pueda acceder remotamente con la siguiente sentencia
GRANT ALL PRIVILEGES ON desguambios.* TO 'root'@'ip_API_REST' IDENTIFIED BY PASSWORD 'root';


8º hacemos telnet desguambios 3306 para ver si tenemos conexión. Aplicamos reglas iptables para permitir escuchar por el puerto 3306 en el servidorBBDD:
iptables -A INPUT -p tcp -m tcp --sport 3306 -m state --state NEW,ESTABLISHED -j ACCEPT

y tambien para permitir salida de trafico desde el servidorAPI
iptables -A OUTPUT -p tcp -m tcp --dport 3306 -m state --state NEW,ESTABLISHED -j ACCEPT


9º hacemos telnet desguambios 8080 para ver si escucha desde ese puerto ya que lo necesitamos para poder hacer los post desde el servidor web. No nos hace porque el firewall lo tiene capado. Por lo que vamos aplicar unas reglas para que nos permita.

en la parte del servidorAPI añadimos esta iptable para permitir la entrada por el puerto 8080:
iptables -A INPUT -p tcp -m tcp --sport 8080 -j ACCEPT

en la parte del servidorWEB añadimos esta iptable para permitir la salida puerto 8080:
iptables -A OUTPUT -p tcp -m tcp --dport 8080 -j ACCEPT 

10ª Nos instalamos java con apt-get install openjdk y ya podemos inciar los jar.

11º iniciamos en cada maquina el jar  "java -jar desguambios.jar" y "java -jar desguambiosAPI.jar"

# FASE 4

- INFRAESTRUCTURA

Cada una de ellas estará alojada en una maquina virtual distinta.

![Texto alternativo](https://github.com/di3guez/desguambios/blob/master/Desguambios/src/main/resources/static/Captura.PNG)

- CACHÉ

La caché funciona para los usuarios sin loguearse, guardará sus productos favoritos. La caché se borra cuando un usuario hace login.

![Texto alternativo](https://github.com/di3guez/desguambios/blob/master/Desguambios/src/main/resources/static/CapturaCach%C3%A9.PNG)

- VIDEO EXPLICATIVO DESGUAMBIOS

https://www.youtube.com/watch?v=kT6SStZbCyE&feature=youtu.be

