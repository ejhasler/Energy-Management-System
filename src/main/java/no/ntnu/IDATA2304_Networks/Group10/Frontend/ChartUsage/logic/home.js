
var ctx = document.getElementById('myChart').getContext('2d');
var chart = new Chart(ctx, {
    // The type of chart we want to create
    type: 'line',

    // The data for our dataset
    data: {
        labels: ["00:00", "01:00", "02:00", "03:00", "04:00", "05:00", "06:00", "07:00", "08:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00", "23:00"],
        datasets: [{
            label:"Nyborgveien 13",
            backgroundColor: 'rgb(255, 99, 132)',
            borderColor: 'rgb(255, 99, 132)',
            data: [3.78, 4.18, 7.46, 4.36, 2.52, 2.51, 2.59, 2.32, 1.58, 2.06, 2.01, 2.28, 2.14, 2.38, 2.44, 2.44, 2.79, 2.06, 1.46, 2.01, 2.88, 2.81, 3.84, 3.21],
        }]
    },

    // Configuration options go here
    options: {}
});