const images = [
    'f-img1.png', 'f-img2.png', 'f-img3.png', 'f-img4.png', 'f-img5.png',
    'f-img6.png', 'f-img7.png', 'f-img8.png', 'f-img9.png', 'f-img10.png',
    'f-img11.png', 'f-img12.png', 'f-img13.png', 'f-img14.png', 'f-img15.png',
    'f-img16.png', 'f-img17.png', 'f-img18.png', 'f-img19.png', 'f-img20.png'
];

function changeBackground() {
    const randomImage = images[Math.floor(Math.random() * images.length)];
    document.getElementById('protector').style.backgroundImage = `url(${randomImage})`;
}

changeBackground();
setInterval(changeBackground, 30000);

async function fetchInfo() {
    try {
        // Fetch temperature data
        const tempResponse = await fetch('https://api.open-meteo.com/v1/forecast?latitude=-34.91&longitude=-57.89&current_weather=true');
        const tempData = await tempResponse.json();
        const temperature = tempData.current_weather.temperature;
        document.getElementById('temp-actual').textContent = `${temperature}°C`;

        // Fetch time data
        const timeResponse = await fetch('http://worldtimeapi.org/api/timezone/America/Argentina/Buenos_Aires');
        const timeData = await timeResponse.json();
        const time = new Date(timeData.datetime).toLocaleTimeString('es-AR', { hour: '2-digit', minute: '2-digit' });
        document.getElementById('time-actual').textContent = time;
    } catch (error) {
        console.error('Error al obtener la información:', error);
    }
}

// Actualizar la información cada 0.1 segundos
fetchInfo();
setInterval(fetchInfo, 1000);
