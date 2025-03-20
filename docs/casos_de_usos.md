# Especificaciones del Sistema

<img src="Imagenes/Casos de uso.png">

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
* **canjear bestia**: Permite agregar una nueva bestia al equipo.
* **trucar bestia**: El sistema da una bestia basado en el nivel que deberias tener.

#### Sistema
* **Dar recompensa**: Darle al usuario las recompensas por ganar una batalla.
* **guardar partida**: Guarda la informacion de tu equipo, y tus progresos.
* **Buscar partida**: Buscar partidas validas para enfrentar al usuario.
* **Desbloquear bestias:**: Permite ganar la posibilidad de conseguir bestias nuevas a usar, segun tus progresos.
* **Adaptar dificultad**: calcular la fuerza del usuario, para poder darle batallas con su nivel.
* **Activar efectos**: Realiza los calculos de las distintas habilidades.
* **Calcular puntos**: Realiza los calculos de los puntos ganados en cada ronda

#### Batalla
* **Activar pasivas**: Activar pasivas desactivadas.
* **Desactivar pasivas**: Desactiva pasivas activadas.
* **Cambiar criaturas**: Permite cambiar la bestia activa.
* **Usar objetos**: Permite usar objetos, y resuelve la ventaja que da.
