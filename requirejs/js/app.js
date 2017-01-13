// Place third party dependencies in the lib folder
//
// Configure loading modules from the lib directory,
// except 'app' ones, 
requirejs.config({
    // "baseUrl": "../js/lib",
    "paths": {
        // "app": "app",
        "jquery.alpha": "lib/jquery.alpha",
        "jquery.beta": "lib/jquery.beta",
        "jquery": "http://cdn.bootcss.com/jquery/3.1.1/jquery"
        // "compute":"lib/compute/main"

    }
});

// Load the main app module to start the app
require(["app/main"]);
