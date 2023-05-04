function handleClick(id, action) {
    var url = "/api/data/" + id;

    $.ajax({
        url: url,
        type: "GET",
        success: function (data) {
            if (action == "retrieve") {
                // Display the data in a popup window
                alert(JSON.stringify(data));
            } else if (action == "delete") {
                // Make a DELETE request to delete the data from the database
                $.ajax({
                    url: url,
                    type: "DELETE",
                    success: function () {
                        // Reload the page to reflect the updated data
                        location.reload();
                    },
                    error: function () {
                        alert("Failed to delete data");
                    }
                });
            }
        },
        error: function () {
            alert("Failed to retrieve data");
        }
    });
}
