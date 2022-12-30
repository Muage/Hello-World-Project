var firebase = require('./firebase');
require('firebase/auth');

module.exports.getEmail = () => {
    const user = firebase.auth().currentUser;
    var email = "";
    if(user != null) email = user.email;
    return email;
}