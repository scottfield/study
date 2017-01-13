define(["jquery","app/shirt", "jquery.alpha", "jquery.beta"], function($,shirt) {
    //the jquery.alpha.js and jquery.beta.js plugins have been loaded.
    $(function() {
        $('body').alpha().beta();
    });
    console.log(shirt);
});
