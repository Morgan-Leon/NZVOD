var HREF = window.location.href;
var SERVER = HREF.substring(0,HREF.indexOf('/prototype/'));
// console.log(SERVER);
angular.module('nourConfig', [])
    .constant('config', {
        HOST: SERVER + "/api/",
        // IMAGESERVER: "http://images.pdreading.com",
        // NOTEPIC: "/api/upload/notepic",
        // USERICON: "/api/upload/usericon",
        // BOOKPIC: "/api/upload/bookpic"
    }
);
