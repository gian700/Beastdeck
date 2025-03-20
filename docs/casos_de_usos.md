# Especificaciones del Sistema

![Diagrama de Casos de Uso](/Imagenes/casos_de_uso.png)

## Actores

### Administrador

| Actor | Usuario |
|---|---|
| Descripción | Persona que utiliza la aplicacion |
| Características | Puede hacer cualquier accion relacionada con preparar el equipo, e ir al siguiente combate. |
| Autor | Giancarlo |
| Fecha | 20/03/2025 |

---

### Sistema

| Actor | Sistema |
|---|---|
| Descripción | Sistema que lleva la aplicacion. |
| Características | Realiza todas las acciones que tengan que ver con los calculos, y preparar las batallas. |
| Autor | Giancarlo |
| Fecha | 20/03/2025 |

---

### Batalla

| Actor | Usuario |
|---|---|
| Descripción | Realizacion del combate. |
| Características | Realiza los combates, y permite todas las acciones dentro de este. |
| Autor | Giancarlo |
| Fecha | 20/03/2025 |

---

### Casos de uso
#### Usuario
* **Sacrificar bestia**: Eliminar bestia del equipo acambio de posibilidad de ganar otra bestia.
* **Comprar objetos**: Conseguir objetos que puedes usar en el combate.
* **Cambiar combate**: Ir al siguiente combate. 
* **Agregar bestia**: Agregar bestia al equipo.
* **Ver contenido**: Puede ver el contenido creado por usuarios, ya sea publicaciones, guias o listas.

#### Sistema
* **Crear un clan**: Crea un clan al que el resto de usuarios pueden entrar.
* **Crear un torneo**: Crea un torneo en el que pueden participar otros usuarios.
* **Crear guia**: Puede crear guias sin limites para ayudar a otros usuarios.
* **Crear listas:**: Puede crear listas de ejercito sin limite, donde se ve como haría los distintos ejercito del juego de mesa.
* **Premiar contenido**: Da me gustas y premios simbolicos especiales a las publicaciones de otros usuarios.

#### Batalla
* **Gestionar contenido**: Puede borrar o recuperar publicaciones.
* **Banear cuentas**: Borra o bloqua una cuenta que ya haya subido muchas publicaciones que sean hirientes sensibles o por haber tenido un mal comportamiento de forma continuada.
* **Cancelar torneo**: Si un torneo esta teniendo un comportamiento inadecuado o toxico puede cancelarlo en el acto.
* **Dar roles**: Si hay un usuario destacado puede darle un roll como premio.
| Requerimientos | Base de datos que relacione usuarios con sus favoritos, funcionalidad para agregar y eliminar elementos de favoritos. |
| Notas | Se debe considerar un manejo adecuado de las listas de favoritos en la base de datos para que se actualicen correctamente. |
