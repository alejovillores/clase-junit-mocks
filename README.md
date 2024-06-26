# Mocks

Un Mock es un tipo de doble de prueba que permite **examinar** las interacciones entre el sistema bajo prueba (SUT) y sus colaboradores. Para aislar el comportamiento del objeto que se desea probar, se reemplazan otros objetos por mocks que simulan el comportamiento de los objetos reales. Esto resulta útil cuando los objetos reales son difíciles de incorporar en la prueba unitaria. 🕵️‍♂️

![Mocks](https://github.com/alejovillores/clase-junit-mocks/assets/56161645/246f5812-2801-4dd2-a72c-04ed5958dded)

## Mocks vs Stubs

- Los mocks ayudan a emular y examinar las interacciones salientes. Estas interacciones son las llamadas que el SUT realiza a sus dependencias para cambiar su estado.
- Los stubs, por otro lado, emulan las interacciones entrantes. Estas interacciones son las llamadas que el SUT realiza a sus dependencias para obtener datos de entrada. Los mocks son un subconjunto de test doubles. 🔍

## Tipos de dobles de pruebas

Los dobles de pruebas se pueden clasificar en dos categorías principales: mocks (que emulan y examinan interacciones) y stubs (que emulan interacciones). La diferencia dentro de cada categoría radica en el grado de "inteligencia" que tiene el objeto. 🧠

### Mocks
- Mocks
- Spy

### Stubs
- Stub
- Dummy
- Fake

# Ejercicio 📚

El siguiente ejercicio es un modelo que posee dependencias externas, dificultando asi su realizacion de pruebas unitarias. Encontramos aqui dos branches, `main` y `mocks`.

Actualmente para el siguiente ejercicio, se realizo utilizando `Java 11`.

Para eso necesitaremos las siguientes dependencias que se encuentran en el archivo `pom.xml`
| Grupo          | Artefacto | Versión   | Ámbito |
|----------------|-----------|-----------|--------|
| junit          | junit     | 4.13.2    | Test   |
| org.json       | json      | 20231013  |        |

