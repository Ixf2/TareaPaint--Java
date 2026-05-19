# Paint - Aplicación de dibujo en Java

## Descripción
Paint es una aplicación de escritorio desarrollada en **Java Swing** que permite realizar dibujos mediante diferentes herramientas gráficas. El usuario puede crear figuras, seleccionar colores, configurar rellenos y gestionar dibujos mediante almacenamiento en base de datos.

El proyecto sigue una arquitectura **MVC (Modelo - Vista - Controlador)** para separar la interfaz gráfica, la lógica del programa y la gestión de datos.

---

## Funcionalidades

La aplicación permite:

- Dibujar puntos
- Dibujar rectas
- Dibujar círculos
- Crear polígonos regulares
- Crear polígonos irregulares
- Dibujar libremente con lápiz
- Seleccionar colores
- Aplicar relleno a figuras
- Configurar lados de polígonos
- Guardar dibujos
- Cargar dibujos
- Modificar dibujos
- Eliminar dibujos
- Exportar la base de datos

---

## Tecnologías utilizadas

- Java
- Java Swing
- JDBC
- MariaDB
- NetBeans
- GitHub

---

## Estructura del proyecto

```text
Proyecto/
│
├── Modelo/
│      Modelo.java
│
├── Vista/
│      VentanaPrincipal.java
│      Lienzo.java
│      Lapiz.java
│      Punto.java
│      Recta.java
│      Circulo.java
│      PoligonoRegular.java
│      PoligonoIrregular.java
│      Herramienta.java
│
├── Controlador/
│      Controlador.java
│
└── Main.java
```

---

## Base de datos

La aplicación crea automáticamente la base de datos:

```text
Paint
```

Tablas:

- dibujos
- figuras
- puntos
- rectas
- circulos
- poligonos_regulares
- vertices_poligonos

---

## Instalación

### 1. Clonar repositorio

```bash
git clone https://github.com/Ixf2/TareaPaint--Java
```

### 2. Abrir proyecto

Abrir el proyecto desde **NetBeans**.

### 3. Iniciar MariaDB o XAMPP

Activar:

- Apache
- MySQL

### 4. Ejecutar aplicación

Ejecutar:

```text
VentanaPrincipal.java
```

o el archivo principal del proyecto.

---

## Autor

Proyecto desarrollado por:

**Joana del Pino Ramírez García**

1º DAM

---

## Mejoras futuras

- Exportación a SVG/PDF
- Deshacer/Rehacer
- Más figuras
- Mejor interfaz gráfica
- Importación de dibujos completos
