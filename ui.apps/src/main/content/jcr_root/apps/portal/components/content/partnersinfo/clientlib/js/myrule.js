(function(document, $, ns) {
    "use strict";
    
    var currentAddr = $('textarea[name="./pCurrentAddress"]').val();
	var permanentAddr = $('textarea[name="./pPmntAddress"]').val();

    $(document).on("keyup", 'textarea[name="./pCurrentAddress"]', function(e) {


        if ($('input[name="./isCurrentAndPermanentSame"]').is(':checked')) {
				permanentAddr = currentAddr;
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