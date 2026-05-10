# SITIO ADMINCES

El sitio "ADMINCES" contiene funcionalidades relacionadas con la autenticación y gestión de cuentas de administrador.

## Página principal previa a autenticarse con login y contraseña

### Menú lateral
Ubicado a la izquierda de la interfaz, contiene opciones de navegación.

#### Funcionalidades observadas
- Iniciar sesión
- Registrarse
- Reiniciar contraseña
- Flecha para reducir el tamaño del menú lateral

---

### Contenido principal
Ubicado en el centro de la pantalla.

#### Funcionalidades observadas
- Muestra las mismas opciones presentes en el menú lateral
- Contiene información visible de usuarios administradores y contraseñas

---

### Barra superior
Ubicada en la parte superior derecha de la interfaz.

#### Funcionalidades observadas
- Botón desplegable “Iniciar sesión”
- Acceso rápido a autenticación


## Páginas secundarias luego de hacer click en distintos botones

### Menú de inicio de sesión

#### Datos solicitados
- Email
- Contraseña

#### Funcionalidades observadas
- Iniciar sesión
- Olvidé mi contraseña
- Crear cuenta administrador
- Botón flecha que dirige a “Crear cuenta administrador”

---

### Menú de registro administrador

#### Datos solicitados
- Nombre
- Apellido
- Email
- Contraseña
- Repetir contraseña
- País de nacimiento

#### Funcionalidades observadas
- Registrarse
- Olvidé mi contraseña
- Ya tengo cuenta
- Botón flecha que dirige nuevamente a la página principal

---

### Menú de reinicio de contraseña

#### Datos solicitados
- Email
- Contraseña
- Repetir contraseña

#### Funcionalidades observadas
- Reiniciar contraseña
- Crear cuenta
- Ya tengo cuenta
- Botón flecha que dirige nuevamente a la página principal


## Página principal luego de autenticarse en el sistema

Cabe destacar que, al iniciar sesión correctamente, se muestra un mensaje de confirmación notificando el acceso exitoso al sistema.

### Menú lateral
Ubicado a la izquierda de la interfaz, contiene opciones de navegación.

#### Funcionalidades observadas
- Crear usuario
- Reiniciar contraseña
- Ver usuarios
- Flecha para reducir el tamaño del menú lateral

---

### Contenido principal
Ubicado en el centro de la pantalla.

#### Funcionalidades observadas
- Muestra las mismas opciones presentes en el menú lateral
- Contiene información visible de usuarios administradores y contraseñas

---

### Barra superior
Ubicada en la parte superior derecha de la interfaz. Muestra el nombre del usuario autenticado.

#### Funcionalidades observadas
- Botón desplegable
- Acceso al perfil
- Opción de cerrar sesión


## Páginas secundarias luego de hacer click en distintos botones

### Menú de registro (alta de cuenta para tester)

#### Datos solicitados
- Nombre
- Apellido
- Email
- País de nacimiento
- Contraseña por defecto
- Seniority del tester (Junior, Senior o Lider)

#### Funcionalidades observadas
- Crear cuenta
- Botón flecha que dirige nuevamente a la página principal

---

### Menú de reinicio de contraseña

#### Datos solicitados
- Email
- Contraseña
- Repetir contraseña

#### Funcionalidades observadas
- Reiniciar contraseña
- Crear cuenta
- Ya tengo cuenta
- Botón flecha que dirige nuevamente a la página principal

---

### Menú Ver Usuarios
Muestra un listado de usuarios con sus respectivos datos:
- Nombre
- Apellido
- Email
- País
- Perfil

#### Funcionalidades observadas
- Acción para eliminar usuario
- Botón de eliminación con mensaje de confirmación y opción de cancelación

---

### Menú Perfil
(Desplegable luego de presionar el botón ubicado en la barra superior)

Muestra los datos del usuario autenticado, los cuales pueden modificarse a excepción del tipo de perfil.

#### Datos visualizados
- Nombre
- Apellido
- Email
- País
- Perfil

#### Funcionalidades observadas
- Confirmar cambios (moficiación de los datos del usuario)
Al hacer click sobre el botoón de confimación se muestra mensaje notificando los cambios.

---

### Cerrar sesión
(Opción desplegable luego de presionar el botón ubicado en la barra superior)

Al seleccionar la opción “Cerrar sesión”, el sistema muestra una ventana modal de confirmación consultando al usuario si desea abandonar la sesión actual.

#### Funcionalidades observadas
- Confirmación de cierre de sesión
- Opción “Sí”
- Opción “Cancelar”




