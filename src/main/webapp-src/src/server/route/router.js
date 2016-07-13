var router = require('express').Router();
var data = require("./data");

module.exports = router;


router.get("/sidebar", function(req, res, next) {
   res.render("public/admin-sidebar");
});

function buildResponse(res, result) {
    res.status(200)
        .send(result)
        .end();
}

function buildSuccessResponse(result) {
    return {
        status: 'SUCCESS',
        result: result
    };
}

function buildErrorResponse(result, args) {
    args = args || [];
    return {
        status: 'ERROR',
        result: {
            code: result,
            arguments: args
        }
    };
}