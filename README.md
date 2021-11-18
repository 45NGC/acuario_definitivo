# Acuario  Definitivo
Union de 3 proyectos de acuario conjuntos
Grupos
  - Grupo 1
    - Miguel Díaz Hernández
    - Adrián Brey Becerra
    - Jose Samuel Calvo Vázquez
    - Miguel Alejandro Pita Prieto
  - Grupo 2
    - Javier Miralles Rancaño
    - Enrique Rivas Fernández
    - Adrián Carneiro Diz
    - Nicolás Gómez Castro
  - Grupo 3
    - Jacobo Rodríguez Rial
    - Daniel Rego Calvo
    - Javier Ceballos Mateo
    - Alejandro Rey Fernández
#_______
#Clases
Hay dos clases principales y otras 12 agrupadas por las funciónes que desempeñan.

- Afundidos: Le corresponden la administración de peces, peceras y eventos.
- MundoMarino: Gestiona los clientes, empleados y la tienda con sus productos.
- ventaEntradas (AcuarioBinario): Lleva la venta de entradas para las diferentes visitas y eventos.


#Pez y Pecera
Estas dos clases guardan relación. 
Mientras que se pueden crear instancias de peces individualmente al crear una pecera llamara para crear sus peces o los de otras (esta funcionalidad esta implementada en la clase principal main).

- Atributos Pez
  - ID -- Identidad única que presenta cada pez
  - especie -- Indica el tipo de pez del que se trata
  - tipoDeAgua -- Booleano que indica si el agua en la que vive es dulce o no.
  - codigoDePiscina -- Identidad individual de la pecera a la que es asignado el pez.
- Atributos Pecera
    - ID -- Identidad única que presenta cada pecera.
    - tipoDeAgua -- Booleando que indica si el agua de la pecera es dulce o no.
    - descripcion -- Breve descripción de la propia pecera (esto se muestra al pública para facilitarles sus busquedas, así como información sobre sus peces u otros).
    - temperatura -- Temperatura a la que se encuentra la pecera.
    - tamaño -- Tamaño en metros de la pecera.
    - peces [] -- Array que contiene los peces asignados a la pecera.

- Métodos Pez
    - mostrarPecera() -- Muestra a que ID de pecera está asignada la ID del pez (sin uso).
    - mostrarDatos() -- Muesta todos los atributos del pez.
- Métodos Pecera
    - listarPeces() -- Muestra todos los peces que están contenidos en la pecera.
    - mostrarCaracteristicas() -- Muestra los atributos de la pecera (salvo el array de peces).
- Más sobre las clases: Estás dos clases, ya que son con las que mayor cantidad de datos trabajan, sus datos solo son asignados en el momento y borrados tras volver a llamarlos. Esto es debido a que se pretende irlos asignando a la base de datos del acuario.
#Evento
La clase evento permite la creación y visualización de los eventos que se llevaran a cabo en el acuario.
- Atributos
    - nombre -- Como el evento es llamado
    - fecha -- Cuando tendrá lugar el evento (día-mes-año).
    - precio -- El precio de la entrada
    - duracion -- Cuanto durara el evento (horas).
    - requisitoEdad -- Edad mínima para poder comprar la entrada y asistir.
    - contadorEntradas -- El número de entradas que se venderán
    - aforo -- La máxima cantidad de personas permitidas (contando a empleados o gente que se le permitió la entrada de otras maneras).
  
- Métodos
    - Los métodos de esta clase están actualmente en desuso.


#Cliente
Ya con un acceso a archivos la clase cliente administra los datos de aquellos registrados en el acuario.
- Atributos
    - Strings básicos: nombre, apellidos, dni, correoElectronico, nombreResponsable, horaEntrada, horaSalida.
    - ints básicos: edad, valoracion, numVisitante.
- Métodos
    - getNumVisitante() y getValoracion() -- Ambos obtienen atributos a los que mencionan.
    - tamano() -- metodo necesario para acceder a los archivos, devuelve la longitud de las entradas.
    - leerDeArchivo(RandomAccesFile f) -- Lee una entrada, todos los atributos registrados, que corresponde a un único cliente.
    - mostrarDatos* -- Existen cuatro métodos que muestran los siguientes datos.
        - Datos del cliente, muestra los datos del cliente
        - Datos de salida, a que hora salió el cliente.
        - Datos de entrada, a que hora entro el cliente
        - Datos de valoración, valoración personal del cliente.
    
#Empleado
Varios atributos son los mismos que en clientes.
- Atributos
    - Strings básicos: nombre y apellidos, dni, tipoTrabajo.
    - vacaciones -- las vacaciones del empleado
    - id
    - sueldo
    - horasTrabajo
    - valoración
- Métodos
    - No dispone de métodos.

#GestionTienda
Gestiona una tienda dentro del propio acuario para los clientes registrados (esto no lo lleva la tienda sino el propio acuario).
- Atributos
    - productos -- Un array de todos los productos creados
    - caja -- Atributo double con la cantidad de dinero en caja.
- Métodos
    - mostrarProductos(productos) -- Recorre el array mostrando los datos de los productos.
    - mostrarNombreProductos(productos) -- En este solo muestra los nombres de los productos que recorre.
    - venderProductos(productos, num, cantidadUnidades) --Compara que haya menos productos pedidos (num) que el total en stock (cantidadUnidades) y devuelve el precio a caja para sumar la cantidad obtenida.
    - mostrarCaja() -- Muestra la cantidad actual de la caja. 
#Producto
Esta clase abstracta contiene los datos del producto y la cantidad de productos que contiene en el array.
- Atributos
    - nombre -- Nombre del producto.
    - precioUnit -- Precio de cada unidad.
    - cantStock -- Cantidad del producto que hay en el stock actualmente.
    - disponible -- Indica si el producto está disponible o no para la compra (si hay suficiente cantidad de productos).
    - dimensionArray -- Cuenta el número de productos para trabajar con el array que los contiene.
  
- Métodos
    - toString() -- Devuelve el nombre, precio y cantidad del stock mediante gets a modo de String.
    - isDisponible() -- Retorna el valor booleano del atributo disponible.
  
#VentaDeEntradas
En ventaEntradas hay cinco clases fuertemente relacionadas. Estas juntas permiten la venta de entradas, gestionar un historial de ventas y ver los beneficios.
- Menu: Da pie a las funciones de las demás clases, dejando al usuario seleccionar la opción que quiera.
Dispone de un único método Venta() que lo iniciaría y dos variables para moverse por el menu según indique el usuario.
- VentaEntrada: Gestiona la compra de entradas (es decir su venta). Muestra las diferentes entradas a vender y añade grupos de gente a la entrada vendida.
- Cálculos: Esta facilita hacer cálculos rápidos en las otras clases ventaEntradas.
- ArchivosRead: Contiene métodos de lectura de datos que son llamados en el menu.
- ArchivosLec: Contiene Sets y un método de escritura en el archivo también llamado desde el menu.

#_______
#ClasesPrincipales
Existen dos clases aquí, el main y el teclado, este último es una clase auxiliar para la escritura de datos desde el teclado.
#Main
La clase principal sin contar la auxiliar hace llamadas al resto de clases en base a un conjunto de menus mostrados al usuario.
- Los conjuntos de menus esta compuesto por los siguientes.
    - menuPrincipal, da acceso al resto de menus y funcionalidades. Este se muestra nada más iniciar el programa.
    - menuClientes, da acceso a cuatro métodos de la propia clase que muestran datos de clientes.
        - entradaCliente()
        - salidaCliente()
        - valoracionCliente() Valoración cliente contiene su propio sub_menus.
            - valoracionIndividual()
            - valoracionTotal()
        - mostrarCliente()
    - ventaDeEntradas() -- Da acceso al menu de la clase Menu en ventaEntradas.
    - eventos() -- Comienza la creación de un nuevo evento.
    - menuPrincipalEmpleados, da acceso a métodos para mostrar datos de empleados (también en el main).
        - listaEmpleados() 
        - anadirEmpleado()
        - cambiarDatosEmpleado()
