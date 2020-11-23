(function() {
    
    // get references to select list and display text box
    var sel = document.getElementById('scripts');

    function getSelectedOption(sel) {
        var opt;
        for ( var i = 0, len = sel.options.length; i < len; i++ ) {
            opt = sel.options[i];
            if ( opt.selected === true ) {
                break;
            }
        }
        return opt;
    }

    document.getElementById('showLimitrophes').onclick = function () {
        var toRemove = document.querySelector("#limitrophes");
        if(toRemove !=undefined && toRemove !=null)
            toRemove.parentNode.removeChild(toRemove);

        var opt = getSelectedOption(sel);
        var baseUrl = "http://localhost:8081/limitrophes/";

        var xmlhttp = new XMLHttpRequest();
        xmlhttp.open("GET",baseUrl+opt.value);
        xmlhttp.send();


        xmlhttp.onreadystatechange = function() {
            if (xmlhttp.readyState == 4) {
                if (xmlhttp.status == 200) {
                    var result = JSON.parse(xmlhttp.response);
                    var fieldset = document.createElement("fieldset");
                                fieldset.setAttribute("id","limitrophes");
                                document.body.appendChild(fieldset);
                                var legend = document.createElement("legend");
                                legend.innerHTML = "Lsite des pays limitrophes de "+opt.value;
                                fieldset.appendChild(legend);

                                for(var key in result){
                                    if (result.hasOwnProperty(key)) {
                                        var p = document.createElement("p");
                                        p.innerHTML = result[key];
                                        fieldset.appendChild(p);
                                    }
                                }
                }
            }
        }
    }
}());
// immediate function to preserve global namespace