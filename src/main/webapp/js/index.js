async function fetchAndSetBackgroundImages() {
    try {
        const response = await fetch('http://localhost:8080/wwp/webapi/service/getLandingPageImages'); // Replace with your actual URL

        const data = await response.json();

        document.getElementById('slide1').style.backgroundImage = `url(${data.imageUrl1})`;
        document.getElementById('slide2').style.backgroundImage = `url(${data.imageUrl2})`;
        document.getElementById('slide3').style.backgroundImage = `url(${data.imageUrl3})`;

    } catch (error) {
        console.error('Error fetching images:', error);
    }
}