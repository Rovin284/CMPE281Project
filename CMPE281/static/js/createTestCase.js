/**
 * Created by rovinpatwal on 5/14/17.
 */

$(function() {
    $('#btnCreateTestCase').click(function() {
    console.log("This is working so far");
        $.ajax({
            url: '/createTestCase',
            data: $('form').serialize(),
            type: 'POST',
            success: function(response) {
                console.log(response);
            },
            error: function(error) {
                console.log(error);
            }
        });
    });
});
