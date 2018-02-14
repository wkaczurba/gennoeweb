$(document).ready(function() {
    $.ajax({
        url: "http://127.0.0.1:8080/api/generate"
    }).then(function(data) {
        //alert('got something');
        $('.generated-value').append(data.value);
    });
});
