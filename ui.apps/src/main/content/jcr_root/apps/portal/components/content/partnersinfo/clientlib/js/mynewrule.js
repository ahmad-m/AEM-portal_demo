
var $field1 = $("#field_1");
var $field2 = $("#field_2");

$field1.on("keydown",function(){
   setTimeout(checkValue,0); 
});

var v2 = $field2.val();
var checkValue = function(){
    var v1 = $field1.val();
    if (v1 != v2){
        $field2.val(v1);
        v2 = v1;
    }
};


(function(document, $, ns) {
    "use strict";

    $(document).on("keypress", 'textarea[name="./pCurrentAddress"]', function(e) {
        if ($('input[name="./isCurrentAndPermanentSame"]').is(':checked')) {
            $('textarea[name="./pPmntAddress"]').val($('textarea[name="./pCurrentAddress"]').val());
			$('textarea[name="./pPmntAddress"]').val($('textarea[name="./pCurrentAddress"]').val()).prop('disabled', true);

        } else {
            $('textarea[name="./pPmntAddress"]').val($('textarea[name="./pPmntAddress"]').val());
            $('textarea[name="./pPmntAddress"]').val($('textarea[name="./pPmntAddress"]').val()).prop('disabled', false);
        }
    });

    $(document).on("click", "input[name='./isCurrentAndPermanentSame']", function(e) {
        if ($('input[name="./isCurrentAndPermanentSame"]').is(':checked')) {
            $('textarea[name="./pPmntAddress"]').val($('textarea[name="./pCurrentAddress"]').val());
            $('textarea[name="./pPmntAddress"]').val($('textarea[name="./pCurrentAddress"]').val()).prop('disabled', true);
        } else {
            $('textarea[name="./pPmntAddress"]').val($('textarea[name="./pPmntAddress"]').val());
            $('textarea[name="./pPmntAddress"]').val($('textarea[name="./pPmntAddress"]').val()).prop('disabled', false);
        }
    });

     $(document).on("click", "input[name='./isCurrentAndPermanentSame']", function(e) {
         if ($('input[name="./isCurrentAndPermanentSame"]').is(':not(:checked)')) {
			$('textarea[name="./pCurrentAddress"]').val($('textarea[name="./pCurrentAddress"]').val());
            $('textarea[name="./pPmntAddress"]').val('');
            $('textarea[name="./pPmntAddress"]').val($('textarea[name="./pPmntAddress"]').val()).prop('disabled', false);
         }
    });

    $(document).on("foundation-contentloaded", function(e) {
        if ($('input[name="./isCurrentAndPermanentSame"]').is(':checked')) {
            $('textarea[name="./pPmntAddress"]').val($('textarea[name="./pCurrentAddress"]').val());
            $('textarea[name="./pPmntAddress"]').val($('textarea[name="./pCurrentAddress"]').val()).prop('disabled', true);
        } else {
            $('textarea[name="./pPmntAddress"]').val($('textarea[name="./pPmntAddress"]').val());
            $('textarea[name="./pPmntAddress"]').val($('textarea[name="./pPmntAddress"]').val()).prop('disabled', false)
        }
    });
})(document, Granite.$, Granite.author);

