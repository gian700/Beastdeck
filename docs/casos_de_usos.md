# Especificaciones del Sistema

![Diagrama de Casos de Uso](/Imagenes/casos_de_uso.png)

## Actores

### Administrador

| Actor | Usuario |
|---|---|
| Descripción | Persona que utiliza la aplicacion |
| Características | Puede crear, editar, actualizar y eliminar contenido. |
| Relaciones | Relación directa con el contenido gestionado en la base de datos. |
| Referencias | Relacionado con los casos de uso CU2, CU4 y CU5. |
| Notas | Los administradores tienen acceso exclusivo a las funciones de gestión. |
| Autor | Giancarlo |
| Fecha | 20/03/2025 |

---

### Sistema

| Actor | Usuario |
|---|---|
| Descripción | Persona que utiliza la aplicación para explorar y consultar información sobre mitologías. |
| Características | Puede autenticarse, visualizar contenido y marcar elementos como favoritos. |
| Relaciones | Relación directa con el contenido de la aplicación. |
| Referencias | Relacionado con los casos de uso CU1, CU3 y CU6. |
| Notas | Los usuarios tienen acceso limitado al contenido y no pueden modificarlo. |
| Autor | Giancarlo |
| Fecha | 20/03/2025 |

---

### Batalla

| Actor | Usuario |
|---|---|
| Descripción | Persona que utiliza la aplicación para explorar y consultar información sobre mitologías. |
| Características | Puede autenticarse, visualizar contenido y marcar elementos como favoritos. |
| Relaciones | Relación directa con el contenido de la aplicación. |
| Referencias | Relacionado con los casos de uso CU1, CU3 y CU6. |
| Notas | Los usuarios tienen acceso limitado al contenido y no pueden modificarlo. |
| Autor | Giancarlo |
| Fecha | 20/03/2025 |

---

### Casos de uso
#### Usuario común
* **Subir contenido a el muro de la plataforma**: El usuario sube una publicacion a la plataforma, puede ser texto, foto o video.
* **Participar en torneo**: El usuario participa en los torneos creados.
* **Reportar contenido**: Avisa a los administradores de que una publicación no podria ser adecuada. 
* **Comentar publicacion**: Puede comentar en el contenido subido por otros usuarios.
* **Ver contenido**: Puede ver el contenido creado por usuarios, ya sea publicaciones, guias o listas.

#### Usuario premium
* **Crear un clan**: Crea un clan al que el resto de usuarios pueden entrar.
* **Crear un torneo**: Crea un torneo en el que pueden participar otros usuarios.
* **Crear guia**: Puede crear guias sin limites para ayudar a otros usuarios.
* **Crear listas:**: Puede crear listas de ejercito sin limite, donde se ve como haría los distintos ejercito del juego de mesa.
* **Premiar contenido**: Da me gustas y premios simbolicos especiales a las publicaciones de otros usuarios.

#### Administrador
* **Gestionar contenido**: Puede borrar o recuperar publicaciones.
* **Banear cuentas**: Borra o bloqua una cuenta que ya haya subido muchas publicaciones que sean hirientes sensibles o por haber tenido un mal comportamiento de forma continuada.
* **Cancelar torneo**: Si un torneo esta teniendo un comportamiento inadecuado o toxico puede cancelarlo en el acto.
* **Dar roles**: Si hay un usuario destacado puede darle un roll como premio.
| Requerimientos | Base de datos que relacione usuarios con sus favoritos, funcionalidad para agregar y eliminar elementos de favoritos. |
| Notas | Se debe considerar un manejo adecuado de las listas de favoritos en la base de datos para que se actualicen correctamente. |
