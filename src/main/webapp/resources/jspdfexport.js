/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* global html2pdf */

//

var documentolisto = false;

function addScript(url) {
    var script = document.createElement('script');
    script.type = 'application/javascript';
    script.src = url;
    document.head.appendChild(script);
}

//addScript('resources/js/jsLibrary/html2pdf.bundle.js');
function reportebalanceactivosfijos(numero){
    //Export_HTMLtoPDF(document.querySelector('tr[data-ri="'+ numero +'"]'))
   // document.querySelector('tbody[id="periodos:listarperiodo_data"]')
    Export_HTMLtoPDF(document.querySelector('table'))
    
}
function Export_HTMLtoPDF($elementoParaConvertir, nombrepdf) {
    if (documentolisto && $elementoParaConvertir !== undefined)
    {
        html2pdf()
                .set({
                    margin: 0.25,
                    filename: (nombrepdf !== undefined) ? nombrepdf : 'documento.pdf',
                    pagebreak: {mode: 'legacy'},
                    image: {
                        type: 'jpeg',
                        quality: 0.98
                    },
                    html2canvas: {
                        scale: 1, // A mayor escala, mejores gráficos, pero más peso
                        letterRendering: true
                    },
                    jsPDF: {
                        unit: "in",
                        format: "a4",
                        orientation: 'portrait' // landscape o portrait
                    }
                })
                .from($elementoParaConvertir)
                .save()
                .catch(err => console.log(err));
    } else {
//        console.log("aun no");
    }
}

document.addEventListener("DOMContentLoaded", function () {
    documentolisto = true;
});