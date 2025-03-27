async function fetchAndSetBackgroundImages() {
    try {
        const response = await fetch('http://localhost:8080/wwp/webapi/service/getLandingPageImages'); // Replace with your actual URL

        const data = await response.json();

        // Check if the response has the imageList array
        if (data && data.imageList && Array.isArray(data.imageList)) {
            const imageList = data.imageList;

            // Check if there are enough images in the list
            if (imageList.length >= 3) {
                document.getElementById('slide1').style.backgroundImage = "url('images/turf_booking.png')";
                document.getElementById('slide2').style.backgroundImage = "url('images/champions_turf.png')";
                document.getElementById('slide3').style.backgroundImage = "url('images/RMD_turf.png')";
                //document.getElementById('slide3').style.backgroundImage = `url(${imageList[2].imageUrl})`;
            } else {
                console.error('Not enough images in the response.');
            }
        } else {
            console.error('Invalid JSON response format.');
        }

    } catch (error) {
        console.error('Error fetching images:', error);
    }
}