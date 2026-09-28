# Sistema de Facturación

### Características Principales

- **Autenticación de Usuarios:** Sistema de login seguro con validación de credenciales.
- **Gestión de Categorías:** Crear, leer, actualizar y eliminar categorías de productos.
- **Gestión de Productos:** Administración completa del inventario con asociación a categorías.
- **Interfaz Gráfica Intuitiva:** Diseño profesional con FXML y estilos CSS personalizados.
- **Persistencia de Datos:** Almacenamiento robusto en base de datos PostgreSQL.

## Información del Proyecto Académico

| Aspecto | Detalle |
|--------|--------|
| **Asignatura** | Programación de Aplicaciones de Escritorio |
| **Institución** | Universidad Americana (UAM) |
| **Docente** | Profesor José Durán |
| **Creadores** | Diego Silva y Claudia Lira |


## Requisitos del Sistema

- **Java:** JDK 21 o superior
- **PostgreSQL:** Versión 12 o superior
- **Maven:** Versión 3.6 o superior

### Dependencias Principales

- JavaFX 21.0.6
- PostgreSQL JDBC Driver 42.7.8
- Project Lombok 1.18.46

## Credenciales de Acceso

| Campo | Valor |
|-------|-------|
| **Usuario** | `admin` |
| **Contraseña** | `admin123` |

## Estructura del Proyecto

```
src/
├── main/
│   ├── java/
│   │   └── ni/edu/uam/facturacion/
│   │       ├── application/       # Punto de entrada de la aplicación
│   │       ├── controller/        # Controladores FXML
│   │       ├── model/             # Clases de modelo
│   │       ├── dao/               # Data Access Objects
│   │       └── util/              # Utilidades (conexión BD, manejo de escenas)
│   └── resources/
│       └── ni/edu/uam/facturacion/
│         ├── fxml/              # Archivos FXML de vistas
│         └── styles/            # Estilos CSS
│      
```

## Funcionalidades

### Login
- Autenticación con validación de usuario y contraseña.
- Alertas personalizadas para cada tipo de error (usuario vacío, contraseña incorrecta, usuario desactivado, etc.).
- Registro de último acceso en la base de datos.

### Gestión de Categorías
- Crear nuevas categorías de productos.
- Listar todas las categorías registradas.
- Actualizar información de categorías existentes.
- Eliminar categorías (con validación de productos asociados).

### Gestión de Productos
- Crear nuevos productos y asignarles una categoría.
- Listar productos con información de categoría.
- Actualizar detalles de productos.
- Eliminar productos del inventario.

## Notas de Desarrollo

- La aplicación implementa el patrón DAO para la capa de acceso a datos.
- El control de escenas se centraliza en `SceneManager` para facilitar la navegación.
- Las validaciones de entrada incluyen verificación de nulos y espacios en blanco.
- La interfaz utiliza `Alert` para proporcionar retroalimentación específica al usuario.

## Realizado por:
- **Diego Silva**
- **Claudia Lira**
