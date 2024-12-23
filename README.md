
<body>
    <h1 style="text-align: center;">🚀 API de Criptomonedas con Spring Boot</h1>
    <h2>📖 Descripción del Proyecto</h2>
    <p>
        Este proyecto es una API desarrollada con Spring Boot que se conecta a la API de Binance para obtener información actualizada sobre criptomonedas.
        Permite a los usuarios configurar alertas personalizadas para recibir notificaciones cuando el porcentaje de cambio de una criptomoneda alcanza un valor
        específico.
    </p>
    <h2>🌟 Características</h2>
    <ul>
        <li>Conexión a la API pública de Binance para obtener datos en tiempo real.</li>
        <li>Endpoints para gestionar alertas personalizadas.</li>
        <li>Verificación periódica de las condiciones configuradas por el usuario.</li>
        <li>Notificación automática si una alerta se cumple.</li>
    </ul>
    <h2>🛠️ Tecnologías Utilizadas</h2>
    <ul>
        <li>Java 17</li>
        <li>Spring Boot 3.x</li>
        <li>Spring Web</li>
        <li>Spring Scheduler</li>
        <li>RestTemplate</li>
        <li>API pública de Binance</li>
    </ul>
    <h2>📂 Estructura del Proyecto</h2>
    <pre>
    src/
    ├── main/
    │   ├── java/
    │   │   └── com.binance.ScrapBin/
    │   │       ├── Controller/
    │   │       │   └── AlertaController.java
    │   │       ├── Model/
    │   │       │   └── CryptoInfo.java
    │   │       ├── Service/
    │   │       │   ├── BinanceService.java
    │   │       │   └── NotificacionAlertaService.java
    │   │       └── Application.java
    │   ├── resources/
    │       └── application.properties
    </pre>
    <h2>🕒 Tareas Programadas</h2>
    <p>
        El servicio <code>NotificacionAlertaService</code> verifica periódicamente (cada 60 segundos) si las condiciones de las alertas configuradas por el usuario
        se cumplen. Si se cumple una condición, genera una notificación en la consola.
    </p>
    <h3>Ejemplo de Notificación</h3>
    <pre>
ALERTA: La criptomoneda BTC ha bajado más del -5.0%. Último precio: 28345.12
    </pre>

   
</body>

