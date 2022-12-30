var { initializeApp } = require('firebase/app');

const firebaseConfig = {
    apiKey: "AIzaSyDzI7yK2SVp6k2yN7DqEOf5XmvzBrcyNGk",
    authDomain: "ex10-aa838.firebaseapp.com",
    databaseURL: "https://ex10-aa838-default-rtdb.firebaseio.com",
    projectId: "ex10-aa838",
    storageBucket: "ex10-aa838.appspot.com",
    messagingSenderId: "336492579078",
    appId: "1:336492579078:android:13195ed9e32b2449fcf687",
    measurementId: "G-9VP01NDSXJ"
};

firebase = initializeApp(firebaseConfig);

module.exports = firebase;